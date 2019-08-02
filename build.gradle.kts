import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    maven
    kotlin("jvm") version "1.3.41"
}

    
version = "1.0-SNAPSHOT"

repositories {
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    mavenCentral()
}

dependencies {
    "api"("org.bukkit:bukkit:1.14.3-pre4-SNAPSHOT")
    "implementation"(kotlin("stdlib-jdk8"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}