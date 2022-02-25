import com.android.build.api.dsl.Lint
import java.io.File

fun Lint.setDefaults(lintFilePath: String = "lint.xml") {
    abortOnError = false
    warningsAsErrors = true
    checkDependencies = true
    ignoreTestSources = true
    lintConfig = File(lintFilePath)
    disable.add("GradleDeprecated")
    disable.add("OldTargetApi")
    disable.add("GradleDependency")
}