plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
android {
    flavorDimensions ("environment")
    compileSdkVersion (30)
    buildToolsVersion ="30.0.0"

    defaultConfig {
        applicationId ="com.sammy.movies"
        minSdkVersion (24)
        targetSdkVersion (30)
        versionCode = 1
        versionName ="1.0"

        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    productFlavors{
        create("production"){
            setDimension("environment")
            versionCode = 1
            versionName = "1.0"
        }
    }
}

dependencies {
    implementation (fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation ("androidx.core:core-ktx:1.3.1")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.1")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
    implementation (project(":datasource"))
    implementation (project(":movies"))
    implementation ("androidx.navigation:navigation-fragment:2.1.0-alpha03") // For Kotlin use navigation-fragment-ktx
    implementation ("androidx.navigation:navigation-ui:2.1.0-alpha03") // For Kotlin use navigation-ui-ktx


    implementation ("org.koin:koin-android:2.0.0-GA4")

    /*
    * Hilt
    * */
    implementation ("com.google.dagger:hilt-android:2.28-alpha")
    kapt ("com.google.dagger:hilt-android-compiler:2.28-alpha")




    // dagger
    implementation ("com.google.dagger:dagger:2.22.1")
    kapt ("com.google.dagger:dagger-compiler:2.22.1")
    // dagger android
    implementation ("com.google.dagger:dagger-android:2.22.1")
    implementation ("com.google.dagger:dagger-android-support:2.22.1") // if you use the support libraries
    kapt ("com.google.dagger:dagger-android-processor:2.22.1")

}