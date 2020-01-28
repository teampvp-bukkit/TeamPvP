import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    maven
    kotlin("jvm") version "1.3.41"
    id("com.github.johnrengelman.shadow") version "5.1.0"
    id("org.jlleitschuh.gradle.ktlint") version "8.2.0"
}

version = "1.0-SNAPSHOT"

repositories {
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    mavenCentral()
    jcenter()
}

dependencies {
    "api"("org.bukkit:bukkit:1.15.2-R0.1-SNAPSHOT")
    "api"("com.zaxxer:HikariCP:3.3.1")
    "api"("org.jetbrains.exposed:exposed:0.16.1")
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