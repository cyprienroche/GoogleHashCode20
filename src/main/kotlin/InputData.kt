import java.util.Scanner

class InputData(private val scanner: Scanner) {
    val totalBooks: Int = scanner.nextInt()
    private val totalLibraries: Int = scanner.nextInt()
    val totalDaysGiven: Day = Day(scanner.nextInt())
    val scores: List<Int> = List(totalBooks) { scanner.nextInt() }
    val libraries: Map<Library, List<Book>>

    val orderedBookIndexByScore = scores.withIndex().sortedBy { it.value }

    val bookIndexToScore = (0 until totalBooks).zip(scores).toMap()

    init {
        val libs = mutableMapOf<Library, List<Book>>()
        for (i in 0 until totalLibraries) {
            val numBooksInLibrary = scanner.nextInt()
            val lib = Library(i, Day(scanner.nextInt()), Day(scanner.nextInt()), 0)
            val xs = List(numBooksInLibrary) { scanner.nextInt() }
            val books = xs.map { Book(it, lib, bookIndexToScore[it]?:0) }
            lib.maxScore = books.map { it.score }.max()?:0
            libs[lib] = books
        }
        libraries = libs
    }

    val libsByTime = libraries.keys.sortedBy { it.signUp.size }

    val libsByNumBooksScan = libraries.keys.sortedBy { it.booksPerDay.size }

    val libsSorted = libraries.keys.sortedWith(LibComparator())


    // val orderedBooksByScore = libraries.values.sortedWith()

    // fun orderLibraryByScore() = orderedBooksByScore.map {  }
}

class LibComparator() : Comparator<Library> {
    override fun compare(o1: Library?, o2: Library?): Int {
        return if (o2 == null) 1
               else o1?.compareTo(o2)?:-1
    }
}

data class Library(val id: Int, val signUp: Day, val booksPerDay: Day, var maxScore: Int): Comparable<Library> {
    override fun compareTo(other: Library): Int = when {
            maxScore != other.maxScore -> -1 * maxScore.compareTo(other.maxScore)
            signUp != other.signUp -> signUp.compareTo(other.signUp)
            else -> -1 * booksPerDay.compareTo(other.booksPerDay)
        }
}

data class Day(val size: Int): Comparable<Day> {
    override fun compareTo(other: Day): Int = size.compareTo(other.size)
}

data class Book(val id: Int, val lib: Library, val score: Int)

