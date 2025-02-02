plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlinx-serialization")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.player.presentation"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    /*Material 3 Dependency*/
    implementation(libs.androidx.material3)

    /*Google Font*/
    implementation(libs.androidx.ui.text.google.fonts)

    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")


    /*
  * Serialization
  * */

    // JSON serialization library, works with the Kotlin serialization plugin
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)

    /*Coil Library*/
    implementation(libs.coil.compose)

    /*Exo Player*/
    implementation("androidx.media3:media3-exoplayer:1.5.1")
    implementation("androidx.media3:media3-exoplayer-dash:1.5.1")
    implementation("androidx.media3:media3-ui:1.5.1")

    /*
* Icons
* */

    implementation(libs.androidx.material.icons.extended)

    /*Dependency Injection*/

    implementation(libs.hilt.android)
//    implementation(project(":app:presentation"))
    implementation(project(":datasource"))
    implementation(project(":core"))
//    implementation(project(":datasource"))
    kapt(libs.hilt.android.compiler)
    kapt(libs.kotlinx.metadata.jvm)



    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}