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
    implementation(project(ProjectModule.COMMON.path))

    api(Dependency.androidxAppCompat)
    api(Dependency.androidMaterial)
    testApi(Dependency.junit)
    androidTestApi(Dependency.androidxTestExtJunit)
    androidTestApi(Dependency.androidxTestEspressoCore)

    implementation(Dependency.androidxCoreKtx)
    implementation(Dependency.androidxActivityKtx)

    implementation(Dependency.daggerHiltAndroid)
    kapt(Dependency.daggerHiltAndroidCompiler)

    implementation(platform(Dependency.firebaseBom))
    implementation(Dependency.firebaseConfig)
    implementation(Dependency.firebaseAnalyticsKtx)
    api(Dependency.firebaseCommonKtx)

    api(Dependency.navigationFragmentKtx)
    api(Dependency.navigationUiKtx)

    api(Dependency.glide)
    kapt(Dependency.glideCompiler)
}