plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        compose = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    lint.setDefaults()
}

dependencies {
    implementation(project(ProjectModule.EXTENSION.path))
    implementation(project(ProjectModule.NETWORK.path))

    implementation(Dependency.androidxCoreKtx)
    implementation(Dependency.androidxAppCompat)
    implementation(Dependency.androidMaterial)
    testImplementation(Dependency.junit)
    androidTestImplementation(Dependency.androidxTestExtJunit)
    androidTestImplementation(Dependency.androidxTestEspressoCore)
}