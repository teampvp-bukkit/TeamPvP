tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "5.5.1"
}

subprojects {
    apply(plugin="java-library")
    apply(plugin="maven")

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