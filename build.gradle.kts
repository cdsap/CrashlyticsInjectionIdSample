// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    id("com.google.firebase.crashlytics") version "3.0.6" apply false
    id("com.google.gms.google-services") version "4.4.4" apply false
    id("io.github.cdsap.gradleprocess") version "0.3.0"
    id("org.gradle.android.cache-fix") version "3.0.3" apply false

}
subprojects {
    plugins.withType<com.android.build.gradle.api.AndroidBasePlugin>() {
        apply(plugin = "org.gradle.android.cache-fix")
    }
}
//
//
