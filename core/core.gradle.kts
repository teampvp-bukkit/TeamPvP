
project(":core") {
    dependencies {
        "core"(project(":core"))
    }

    tasks{
        withType<ProcessResources> {
            filter { line: String ->
                line.replace("test", project.name)
                    .replace("test3", project.version)

            }
        }
    }
}