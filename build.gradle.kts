import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
}

allprojects {
    apply(plugin="java-library")
    apply(plugin="maven")

    group = "com.k9rosie.teampvp"
    version = "1.0-SNAPSHOT"

    repositories {
        maven {
            url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        }
        mavenCentral()
    }

    dependencies {
        "api"("org.bukkit:bukkit:1.14.3-pre4-SNAPSHOT")
    }
}

dependencies {
    "implementation"(kotlin("stdlib-jdk8"))
    "api"(project(":api"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}