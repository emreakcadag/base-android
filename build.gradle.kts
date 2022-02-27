plugins {
    id("com.android.application") version Version.androidApplication apply false
    id("com.android.library") version Version.androidLibrary apply false
    id("org.jetbrains.kotlin.android") version Version.kotlin apply false
    id("org.jetbrains.kotlin.jvm") version Version.kotlin apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}