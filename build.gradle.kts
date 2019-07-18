plugins {
    idea
    java
    `java-library`
    maven
    kotlin("jvm") version "1.3.41"
}

allprojects {
    group = "org.k9rosie.teampvp"
    version = "1.0-SNAPSHOT"
    repositories {
        maven {
            url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        }
        mavenCentral()

    }

    dependencies {
        "core"("org.bukkit:bukkit:1.14.3-pre4-SNAPSHOT")
        "implementation"(kotlin("stdlib"))
    }
}
