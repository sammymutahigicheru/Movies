plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.0"

    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    //datasource library
    implementation(project(":datasource"))

    implementation("androidx.navigation:navigation-fragment:2.1.0-alpha03") // For Kotlin use navigation-fragment-ktx
    implementation("androidx.navigation:navigation-ui:2.1.0-alpha03")// For Kotlin use navigation-ui-ktx


    // ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime:2.0.0")

    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation("androidx.lifecycle:lifecycle-common-java8:2.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01")
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.28-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")

    //Activity ktx
    implementation ("androidx.activity:activity-ktx:1.1.0")

    //Fragment ktx
    implementation ("androidx.fragment:fragment-ktx:1.2.5")
    /*
    * Hilt viewmodels
    * */
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")

    //picasso
    implementation("com.squareup.picasso:picasso:2.71828")

    //glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")

}