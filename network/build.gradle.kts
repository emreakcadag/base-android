plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(ProjectModule.LIBS.path))

    implementation(Dependency.retrofit2)
    implementation(Dependency.retrofit2GsonConverter)
    implementation(Dependency.okhttp3)
    implementation(Dependency.okhttp3LoggingInterceptor)
}