plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "org.healthscience.healthcues"
    compileSdk = 35

    defaultConfig {
        applicationId = "org.healthscience.healthcues"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { viewBinding = true }

    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("src/main/addons", "libs/bare-kit/jni")
            assets.srcDirs("src/main/assets")
        }
    }
}


// bare-link and bare-pack integration

tasks.register("link", org.gradle.api.tasks.Exec::class) {
    workingDir = rootDir
    commandLine("node_modules/.bin/bare-link", "--preset", "android", "--needs", "libbare-kit.so", "--out", "app/src/main/addons")
}

tasks.register("packApp", org.gradle.api.tasks.Exec::class) {
    workingDir = rootDir
    commandLine("node_modules/.bin/bare-pack", "--preset", "android", "--out", "app/src/main/assets/app.bundle", "app/src/main/js/app.js")
}

tasks.register("pack") { dependsOn("packApp") }

tasks.named("preBuild") { dependsOn("link", "pack") }

dependencies {
    implementation(files("libs/bare-kit/classes.jar"))
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
}
