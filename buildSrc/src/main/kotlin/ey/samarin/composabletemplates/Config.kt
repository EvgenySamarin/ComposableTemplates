package ey.samarin.composabletemplates

object Config {

    object Project {
        val COMPILE_SDK = 33
        val MIN_SDK = 24
        val TARGET_SDK = 33

        val VERSION_CODE = 1
        val VERSION_NAME = "1.0"

        val JVM_TARGET = "1.8"
    }

    object Versions {
        val COMPOSE = "1.4.1"
        val CORE_KTX = "1.10.0"

        val COMPOSE_ACTIVITY = "1.7.0"
        val COMPOSE_MATERIAL = "1.1.0-beta02"
        val JUNIT = "4.13.2"
    }

    object Plugins {
        object Versions {
            val ANDROID = "7.4.2"
            val KOTLIN = "1.8.0"
        }

        val plugins = listOf(
            "com.android.application" to Versions.ANDROID,
            "com.android.library" to Versions.ANDROID,
            "org.jetbrains.kotlin.android" to Versions.KOTLIN,
            "org.jetbrains.kotlin.jvm" to Versions.KOTLIN,
        )
    }

    object Libs {
        val implementationsCommon = listOf(
            "androidx.core:core-ktx:${Config.Versions.CORE_KTX}",
        )

        val testImplementations = listOf(
            "junit:junit:${Config.Versions.JUNIT}",
        )

        val implementationsAppModule = listOf(
            "androidx.activity:activity-compose:${Config.Versions.COMPOSE_ACTIVITY}",
            "androidx.compose.ui:ui:${Config.Versions.COMPOSE}",
            "androidx.compose.ui:ui-tooling-preview:${Config.Versions.COMPOSE}",
            "androidx.compose.material3:material3:${Config.Versions.COMPOSE_MATERIAL}",
        )

        val androidTestImplemetations = listOf(
            "androidx.compose.ui:ui-test-junit4:${Config.Versions.COMPOSE}",
        )

        val debugImplementations = listOf(
            "androidx.compose.ui:ui-tooling:${Config.Versions.COMPOSE}",
            "androidx.compose.ui:ui-test-manifest:${Config.Versions.COMPOSE}",
        )
    }

}