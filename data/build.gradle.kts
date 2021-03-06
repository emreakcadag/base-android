plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    kotlin("kapt")
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
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = Version.sourceCompatibility
        targetCompatibility = Version.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Version.jvmTarget
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(ProjectModule.COMMON.path))

    api(Dependency.retrofit2GsonConverter)

    implementation(Dependency.androidxCoreKtx)
    implementation(Dependency.androidxActivityKtx)

    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)

    api(Dependency.androidxDataStore)
    api(Dependency.androidxDataStorePreferences)

    api(Dependency.retrofit2)
    implementation(Dependency.retrofit2GsonConverter)
    implementation(Dependency.okhttp3)
    implementation(Dependency.okhttp3LoggingInterceptor)

    implementation(Dependency.roomRuntime)
    implementation(Dependency.roomKtx)
    kapt(Dependency.roomCompiler)
}