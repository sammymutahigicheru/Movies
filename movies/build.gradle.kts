plugins{
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion (30)
    buildToolsVersion = "30.0.0"

    defaultConfig {
        minSdkVersion (24)
        targetSdkVersion (30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    //datasource library
    implementation (project(":datasource"))

    implementation ("androidx.navigation:navigation-fragment:2.1.0-alpha03") // For Kotlin use navigation-fragment-ktx
    implementation ("androidx.navigation:navigation-ui:2.1.0-alpha03" )// For Kotlin use navigation-ui-ktx



    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation ("androidx.lifecycle:lifecycle-runtime:2.0.0")

    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.0.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01")


    // dagger
    implementation ("com.google.dagger:dagger:2.22.1")
    kapt ("com.google.dagger:dagger-compiler:2.22.1")
    // dagger android
    implementation ("com.google.dagger:dagger-android:2.22.1")
    implementation ("com.google.dagger:dagger-android-support:2.22.1") // if you use the support libraries
    kapt ("com.google.dagger:dagger-android-processor:2.22.1")

    //picasso
    implementation ("com.squareup.picasso:picasso:2.71828")

    //glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")

}