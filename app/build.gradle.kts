plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    productFlavors {
        flavorDimensions.add(AppConfig.defaultDimension)
        create(AppConfig.productDev) {
            dimension = AppConfig.defaultDimension

            applicationIdSuffix = AppConfig.devApplicationIdSuffix
            versionNameSuffix = AppConfig.devApplicationIdSuffix
        }
        create(AppConfig.productProd) {
            dimension = AppConfig.defaultDimension
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = AppConfig.debugApplicationIdSuffix
        }

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
    implementation(project(ProjectModule.BASE.path))
    implementation(project(ProjectModule.EXTENSION.path))
    implementation(project(ProjectModule.NETWORK.path))

    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)
}