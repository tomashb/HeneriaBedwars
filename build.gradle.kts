plugins {
    java
    checkstyle
    jacoco
}

group = "fr.heneria"
version = "0.0.1"
description = "HeneriaBedwars plugin (Spigot 1.21) — étape 1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21.8-R0.1-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(21)) }
}

checkstyle {
    toolVersion = "10.17.0"
    configFile = file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
}

tasks {
    withType<JavaCompile> {
        options.release.set(21)
        options.encoding = "UTF-8"
    }
    test {
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
    }
    jacocoTestReport {
        reports {
            xml.required.set(true)
            html.required.set(true)
            csv.required.set(false)
        }
    }
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }
    jar {
        archiveBaseName.set("HeneriaBedwars")
        archiveVersion.set(project.version.toString())
    }
}
