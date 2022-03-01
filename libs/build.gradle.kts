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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    api(Dependency.androidxAppCompat)
    api(Dependency.androidMaterial)
    testApi(Dependency.junit)
    androidTestApi(Dependency.androidxTestExtJunit)
    androidTestApi(Dependency.androidxTestEspressoCore)

    // region Hilt
    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)
    // endregion

    // region ktx
    api(Dependency.androidxCoreKtx)
    api(Dependency.androidxActivityKtx)
    // endregion
}