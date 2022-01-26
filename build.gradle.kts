plugins {
    kotlin("multiplatform") version com.yesferal.hornsapp.plugin.dependency.ThirdParty.kotlin
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.20.0"
}

val thirdPartyVersions = com.yesferal.hornsapp.plugin.dependency.ThirdParty
val hornsAppVersions = com.yesferal.hornsapp.plugin.dependency.HornsApp
val testVersions = com.yesferal.hornsapp.plugin.dependency.Test
val groupId = "com.yesferal.hornsapp.plugin"

group = groupId
version = hornsAppVersions.plugin

gradlePlugin {
    plugins {
        create(groupId) {
            id = groupId
            implementationClass= "${groupId}.HornsAppPlugin"
            displayName = "Plugin for HornsApp application"
            description = "A plugin that provides the HornsApp common library versions"
        }
    }
}

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = thirdPartyVersions.jvmTarget
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
}

pluginBundle {
    website = "https://github.com/Yesferal/HornsApp-Gradle-Plugin"
    vcsUrl = "https://github.com/Yesferal/HornsApp-Gradle-Plugin.git"
    tags = listOf("gradle", "testing", "compatibility")
}
