import ey.samarin.composabletemplates.Config
import ey.samarin.composabletemplates.Config.Project


plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "ey.samarin.composables"
    compileSdk = Project.COMPILE_SDK

    defaultConfig {
        minSdk = Project.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        @Suppress("UnstableApiUsage")
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
        jvmTarget = Project.JVM_TARGET
    }

    @Suppress("UnstableApiUsage")
    buildFeatures {
        compose = true
    }

    @Suppress("UnstableApiUsage")
    composeOptions {
        kotlinCompilerExtensionVersion = Config.Versions.COMPOSE
    }
}

dependencies {
    Config.Libs.implementationsCommon.forEach(::implementation)
    Config.Libs.debugImplementations.forEach(::debugImplementation)
    Config.Libs.testImplementations.forEach(::testImplementation)
}