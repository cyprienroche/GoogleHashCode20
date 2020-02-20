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

        // val outputFile = "$outputPath/${it.name.replace(".in", ".out")}"
        // writeToOutput(File(outputFile), data.n, data.xs)
    }
}

fun writeToOutput(outputFile: File, size: Int, output: List<Int>) {
    outputFile.writeText("$size\n")
    output.forEach{outputFile.appendText("$it ")}
}


