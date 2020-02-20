import java.util.Scanner

class InputData(private val scanner: Scanner) {
    val totalBooks: Int = scanner.nextInt()
    private val totalLibraries: Int = scanner.nextInt()
    val totalDaysGiven: Day = Day(scanner.nextInt())
    val scores: List<Int> = List(6) { scanner.nextInt() }
    val libraries: Map<Library, List<Book>>

    init {
        val libs = mutableMapOf<Library, List<Book>>()
        for (i in 0 until totalLibraries) {
            val numBooksInLibrary = scanner.nextInt()
            val lib = Library(i, Day(scanner.nextInt()), Day(scanner.nextInt()))
            val books = List(numBooksInLibrary) { Book(scanner.nextInt(), lib) }
            libs[lib] = books
        }
        libraries = libs
    }

    val sortedLibsByTime = libraries.keys.sortedBy { it.signUp.size }

    val orderedBookIndexByScore = scores.withIndex().sortedBy { it.value }

    // val orderedBooksByScore = libraries.values.sortedWith()

    // fun orderLibraryByScore() = orderedBooksByScore.map {  }
}

class Library(val id: Int, val signUp: Day, val ship: Day)

data class Day(val size: Int)

data class Book(val id: Int, val lib: Library)

