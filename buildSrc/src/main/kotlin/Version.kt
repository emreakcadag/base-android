import org.gradle.api.JavaVersion

/**
 * Created by Emre Akçadağ on 25.02.2022
 */
object Version {

    const val kotlin = "1.6.10"
    const val jvmTarget = "11"
    val sourceCompatibility = JavaVersion.VERSION_11
    val targetCompatibility = JavaVersion.VERSION_11

    const val androidApplication = "7.1.2"
    const val androidLibrary = "7.1.2"
    const val googleServices = "4.3.10"

    const val androidxCoreKtx = "1.7.0"
    const val androidxActivityKtx = "1.4.0"
    const val androidxFragmentKtx = "1.4.1"

    const val androidxAppCompat = "1.4.1"
    const val androidMaterial = "1.5.0"
    const val junit = "4.13.2"
    const val androidxTestExtJunit = "1.1.3"
    const val androidxTestEspressoCore = "3.4.0"

    const val retrofit2 = "2.9.0"
    const val okhttp3 = "5.0.0-alpha.2"

    const val hilt = "2.41"
    const val androidxHiltCompiler = "1.0.0"
    const val androidxHiltLifecycleViewModel = "1.0.0-alpha03"

    const val firebaseBom = "29.1.0"

    const val navigation = "2.4.1"
}