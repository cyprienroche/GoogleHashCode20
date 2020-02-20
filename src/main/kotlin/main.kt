import java.io.File
import java.util.Scanner

fun main() {
    val inputPath = "src/main/resources/input"
    val outputPath = "src/main/resources/output"

    File(inputPath).mkdir()
    File(outputPath).mkdir()

    File(inputPath).listFiles()?.forEach {
        val data = getData(Scanner(it))

        val outputFile = "$outputPath/${it.name.replace(".in", ".out")}"
        writeToOutput(File(outputFile), data.n, data.xs)
    }
}

fun writeToOutput(outputFile: File, size: Int, output: List<Int>) {
    outputFile.writeText("$size\n")
    output.forEach{outputFile.appendText("$it ")}
}

fun getData(scanner: Scanner): InputData {
    val m = scanner.nextInt();
    val n = scanner.nextInt();
    return InputData(m, n, List(n) { scanner.nextInt() })
}

data class InputData(val m: Int, val n: Int, val xs: List<Int>)