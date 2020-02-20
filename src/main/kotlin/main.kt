import java.io.File
import java.util.Scanner

fun main() {
    val inputPath = "src/main/resources/input"
    val outputPath = "src/main/resources/output"

    File(inputPath).mkdir()
    File(outputPath).mkdir()

    val input = File(inputPath)

    input.listFiles()?.forEach {
        val scanner = Scanner(it)
        val data = InputData(Scanner(it))

        val outputData = OutputData(
            listOf(1,0),
            mapOf(0 to listOf(Book(0),Book(1),Book(2), Book(3),Book(4)),
                1 to listOf(Book(5),Book(2),Book(3)))
        )
        val outputFile = "$outputPath/${it.name.replace(".in", ".out")}"
        outputData.writeToOutput(File(outputFile))
    }
}

fun writeToOutput(outputFile: File, size: Int, output: List<Int>) {
    outputFile.writeText("$size\n")
    output.forEach{outputFile.appendText("$it ")}
}


