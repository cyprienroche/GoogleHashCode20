import java.io.File

class OutputData(val libOrder: List<Library>, val booksToSend: Map<Library, List<Book>>) {

    fun writeToOutput(outputFile: File) {
        outputFile.writeText("${libOrder.size}\n")
        libOrder.forEach{outputFile.appendText(
            "${it.id} ${booksToSend[it]?.size}\n${booksToSend[it]?.fold("", {acc, book -> acc + "${book.id} "})}\n"
        )}
    }
}