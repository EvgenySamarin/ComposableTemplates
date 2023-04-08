import ey.samarin.composabletemplates.Config
import ey.samarin.composabletemplates.Config.Project


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ey.samarin.composabletemplates"
    compileSdk = Project.COMPILE_SDK

    defaultConfig {
        applicationId = "ey.samarin.composabletemplates"
        minSdk = Project.MIN_SDK
        targetSdk = Project.TARGET_SDK
        versionCode = Project.VERSION_CODE
        versionName = Project.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            @Suppress("UnstableApiUsage")
            useSupportLibrary = true
        }
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

    @Suppress("UnstableApiUsage")
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    Config.Libs.implementationsCommon.forEach(::implementation)
    Config.Libs.implementationsAppModule.forEach(::implementation)
    Config.Libs.testImplementations.forEach(::testImplementation)
    Config.Libs.androidTestImplemetations.forEach(::androidTestImplementation)
    Config.Libs.debugImplementations.forEach(::debugImplementation)
}