import java.io.File
import java.util.Scanner

fun main() {
    val inputPath = "src/main/resources/input"
    val outputPath = "src/main/resources/output"

    File(inputPath).mkdir()
    File(outputPath).mkdir()

    val input = File(inputPath)

    input.listFiles()?.forEach {
        if (it.name.startsWith("f")) {
            val inputData = InputData(Scanner(it))

            val outputData = OutputData(
                inputData.libsSorted,
                inputData.libraries
            )
            val outputFile = "$outputPath/${it.name.replace(".txt", ".out")}"
            outputData.writeToOutput(File(outputFile))
        }
    }
}


