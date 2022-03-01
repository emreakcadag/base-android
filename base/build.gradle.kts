plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    productFlavors {
        flavorDimensions.add(AppConfig.defaultDimension)

        create(AppConfig.productDev) {
            dimension = AppConfig.defaultDimension
        }

        create(AppConfig.productProd) {
            dimension = AppConfig.defaultDimension
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(ProjectModule.LIBS.path))
    implementation(project(ProjectModule.NETWORK.path))
    implementation(project(ProjectModule.EXTENSION.path))

    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)
}