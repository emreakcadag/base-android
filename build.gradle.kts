plugins {
    id("com.android.application") version Version.androidApplication apply false
    id("com.android.library") version Version.androidLibrary apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("org.jetbrains.kotlin.jvm") version Version.kotlin apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependency.hiltAndroidGradlePlugin)
        classpath(Dependency.googlePlayServices)
        classpath(Dependency.safeArgsGradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}