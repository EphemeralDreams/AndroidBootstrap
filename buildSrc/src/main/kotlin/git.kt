import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

object Git {
    fun ref(): String = System.getenv("GITHUB_REF") ?: "git rev-parse --abbrev-ref HEAD".cmd()
    fun sha(): String = System.getenv("GITHUB_SHA") ?: "git rev-parse HEAD".cmd()
}

/**
 * Execute a shell command.
 * @param workingDir The working directory where to run the shell command.
 * @param timeout The timeout represented in seconds.
 */
private fun String.cmd(workingDir: File = File("."), timeout: Long = 60 * 10): String {
    return try {
        val cmdParts = this.split("\\s".toRegex()).toTypedArray()
        val process = ProcessBuilder(*cmdParts)
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()
        process.waitFor(timeout, TimeUnit.SECONDS)
        process.inputStream.bufferedReader().readText().trim()
    } catch (e: IOException) {
        e.printStackTrace()
        ""
    }
}
