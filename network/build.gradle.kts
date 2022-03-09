plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
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
            buildConfigField("String", Environment.BASE_URL, Environment.Dev.baseUrl)
        }
        create(AppConfig.productProd) {
            dimension = AppConfig.defaultDimension
            buildConfigField("String", Environment.BASE_URL, Environment.Prod.baseUrl)
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

    implementation(Dependency.androidxCoreKtx)
    implementation(Dependency.androidxActivityKtx)

    api(Dependency.retrofit2)
    api(Dependency.retrofit2GsonConverter)
    implementation(Dependency.okhttp3)
    implementation(Dependency.okhttp3LoggingInterceptor)

    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)
}