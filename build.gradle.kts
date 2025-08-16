plugins {
  java
}

group = "gg.heneria"
version = "0.0.1"

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }
}

repositories {
  mavenLocal()
  maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
  maven("https://oss.sonatype.org/content/repositories/snapshots/")
  mavenCentral()
}

dependencies {
  // Spigot API 1.21 snapshots
  compileOnly("org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT")

  // Tests: JUnit Jupiter + launcher required with Gradle 9
  testImplementation(platform("org.junit:junit-bom:5.10.2"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  useJUnitPlatform()
}

// Interdire la production de JAR par défaut (CI compile-only)
tasks.jar {
  enabled = false
}
tasks.assemble {
  enabled = false
}

// Option: garder les modules "changing" frais (snapshots)
configurations.all {
  resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}
