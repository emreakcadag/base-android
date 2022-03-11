plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("androidx.navigation.safeargs.kotlin")
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
        sourceCompatibility = Version.sourceCompatibility
        targetCompatibility = Version.targetCompatibility
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = Version.jvmTarget
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(ProjectModule.BASE.path))
    implementation(project(ProjectModule.DOMAIN.path))
    implementation(project(ProjectModule.DATA.path))

    implementation(Dependency.androidxCoreKtx)
    implementation(Dependency.androidxActivityKtx)
    implementation(Dependency.androidxFragmentKtx)

    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)
}