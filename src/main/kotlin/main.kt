import java.io.File
import java.util.Scanner

fun main() {
    val inputPath = "src/main/resources/input"
    val outputPath = "src/main/resources/output"

    File(inputPath).mkdir()
    File(outputPath).mkdir()

    val input = File(inputPath)

    input.listFiles()?.forEach {
        if (it.name.startsWith("e")) {
            val inputData = InputData(Scanner(it))

      /*      inputData.libsByTime.forEach{print("${it.id} ")}
            println()
            inputData.libsByNumBooksScan.forEach{print("${it.id} ")}
            println()
            inputData.libsSorted.forEach{print("${it.id} ")}
            println()*/

            val outputData = OutputData(
                inputData.libsByTime,
                inputData.libraries
            )
            val outputFile = "$outputPath/${it.name.replace(".txt", ".out")}"
            outputData.writeToOutput(File(outputFile))
        }
    }
}


