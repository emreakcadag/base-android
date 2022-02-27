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
    api(Dependency.androidxCoreKtx)
    api(Dependency.androidxAppCompat)
    api(Dependency.androidMaterial)
    testApi(Dependency.junit)
    androidTestApi(Dependency.androidxTestExtJunit)
    androidTestApi(Dependency.androidxTestEspressoCore)

    api(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)

    /*api(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltCompiler)

    annotationProcessor(Dependency.daggerHiltCompiler)

    androidTestApi(Dependency.daggerHiltAndroidTesting)
    androidTestAnnotationProcessor(Dependency.daggerHiltCompiler)
    testApi(Dependency.daggerHiltAndroidTesting)
    testAnnotationProcessor(Dependency.daggerHiltCompiler)
    api(Dependency.androidxHiltNavigationCompose)
    kapt(Dependency.androidxHiltCompiler)
    kapt(Dependency.daggerHiltAndroidCompiler)
    implementation(Dependency.androidxHiltLifecycleViewModel)*/
}