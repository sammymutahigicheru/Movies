plugins{
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion (30)
    buildToolsVersion ="30.0.0"

    defaultConfig {
        minSdkVersion (24)
        targetSdkVersion (30)
        versionCode = 1
        versionName ="1.0"

        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles ("consumer-rules.pro")
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    api ("com.squareup.retrofit2:retrofit:2.5.0")

    api ("com.squareup.retrofit2:converter-gson:2.5.0")
    api ("com.squareup.okhttp3:okhttp:4.8.1")
    api ("com.squareup.okhttp3:logging-interceptor:4.8.1")



    implementation ("androidx.room:room-runtime:2.1.0-rc01")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    kapt ("androidx.room:room-compiler:2.1.0-rc01" )// For Kotlin use kapt instead of annotationProcessor


    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

}
