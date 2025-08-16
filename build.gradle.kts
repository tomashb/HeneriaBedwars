plugins {
    java
}

group = "fr.heneria"
version = "0.0.1"
description = "HeneriaBedwars plugin (Spigot 1.21) — étape 1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Spigot API snapshots
    maven("https://oss.sonatype.org/content/repositories/snapshots/")       // transitives
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks {
    withType<JavaCompile> {
        options.release.set(21)
        options.encoding = "UTF-8"
    }
    test {
        useJUnitPlatform()
    }
    processResources {
        filesMatching("plugin.yml") {
            // injecte version depuis Gradle
            expand("version" to project.version)
        }
    }
    jar {
        archiveBaseName.set("HeneriaBedwars")
        archiveVersion.set(project.version.toString())
    }
}
