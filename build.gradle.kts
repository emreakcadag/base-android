plugins {
    id("com.android.application") version Version.androidApplication apply false
    id("com.android.library") version Version.androidLibrary apply false
    id("org.jetbrains.kotlin.android") version Version.kotlin apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}