import java.io.File

class OutputData(val libOrder: List<Int>, val booksToSend: Map<Int, List<Book>>) {

    fun writeToOutput(outputFile: File) {
        outputFile.writeText("${libOrder.size}\n")
        libOrder.forEach{outputFile.appendText(
            "$it ${booksToSend[it]?.size}\n${booksToSend[it]?.fold("", {acc, book -> acc + "${book.id} "})}\n"
        )}
    }
}