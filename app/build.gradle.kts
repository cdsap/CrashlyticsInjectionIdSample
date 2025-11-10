import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension

plugins {
    alias(libs.plugins.android.application)
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
    //  id("kotlin-android")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 36

    buildFeatures {

    }
    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            configure<CrashlyticsExtension> {
                mappingFileUploadEnabled = false
            }

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // implementation(project(":mylibrary"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of("17"))
    }
}


androidComponents {
    onVariants(selector = selector().all()) {
        it.configureJavaCompileTask { compileTask ->
            println("main configureJavaCompileTask " + compileTask.path)
        }

        it.nestedComponents.forEach {
            it.configureJavaCompileTask {
                println("nested " + it.path)
            }
        }
    }
}
