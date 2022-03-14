/**
 * Created by Emre Akçadağ on 25.02.2022
 */
object Dependency {

    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    const val googlePlayServices = "com.google.gms:google-services:${Version.googleServices}"
    const val safeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"

    const val androidxCoreKtx = "androidx.core:core-ktx:${Version.androidxCoreKtx}"
    const val androidxActivityKtx = "androidx.activity:activity-ktx:${Version.androidxActivityKtx}"
    const val androidxFragmentKtx = "androidx.fragment:fragment-ktx:${Version.androidxFragmentKtx}"

    const val androidxAppCompat = "androidx.appcompat:appcompat:${Version.androidxAppCompat}"
    const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
    const val junit = "junit:junit:${Version.junit}"
    const val androidxTestExtJunit = "androidx.test.ext:junit:${Version.androidxTestExtJunit}"
    const val androidxTestEspressoCore = "androidx.test.espresso:espresso-core:${Version.androidxTestEspressoCore}"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Version.retrofit2}"
    const val retrofit2GsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit2}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Version.okhttp3}"
    const val okhttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3}"

    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
    const val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"

    const val firebaseBom = "com.google.firebase:firebase-bom:${Version.firebaseBom}"
    const val firebaseConfig = "com.google.firebase:firebase-config-ktx"
    const val firebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseCommonKtx = "com.google.firebase:firebase-common-ktx"

    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"

    const val androidxDataStore = "androidx.datastore:datastore:${Version.dataStore}"
    const val androidxDataStorePreferences = "androidx.datastore:datastore-preferences:${Version.dataStore}"

    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"

    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
}