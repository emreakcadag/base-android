plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    lint.setDefaults()
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(ProjectModule.LIBS.path))
    implementation(project(ProjectModule.EXTENSION.path))
    implementation(project(ProjectModule.NETWORK.path))

    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)

    /*annotationProcessor(Dependency.daggerHiltCompiler)
    androidTestImplementation(Dependency.daggerHiltAndroidTesting)

    androidTestAnnotationProcessor(Dependency.daggerHiltCompiler)
    testImplementation(Dependency.daggerHiltAndroidTesting)

    testAnnotationProcessor(Dependency.daggerHiltCompiler)
    implementation(Dependency.androidxHiltNavigationCompose)

    kapt(Dependency.androidxHiltCompiler)
    kapt(Dependency.daggerHiltAndroidCompiler)
    implementation(Dependency.androidxHiltLifecycleViewModel)*/
}