plugins {
    id("com.github.johnrengelman.shadow")
}

architectury {
    platformSetupLoomIde()
    neoForge()
}

val common: Configuration by configurations.creating
val shadowBundle: Configuration by configurations.creating
val developmentNeoForge: Configuration by configurations.getting

configurations {
    compileOnly.configure { extendsFrom(common) }
    runtimeOnly.configure { extendsFrom(common) }
    developmentNeoForge.extendsFrom(common)
}

repositories {
    maven("https://maven.neoforged.net/releases")
    maven("https://thedarkcolour.github.io/KotlinForForge/")
}

dependencies {
    neoForge("net.neoforged:neoforge:${rootProject.property("neoforge_version")}")

    common(project(":common", "namedElements")) {
        isTransitive = false
    }
    shadowBundle(project(":common", "transformProductionNeoForge"))

    implementation("thedarkcolour:kotlinforforge-neoforge:${rootProject.property("forge_kotlin_version")}")
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("META-INF/neoforge.mods.toml") {
        "version" to project.version
    }
}

tasks.shadowJar {
    configurations = listOf(shadowBundle)
    archiveClassifier = "dev-shadow"
}

tasks.remapJar {
    inputFile.set(tasks.shadowJar.get().archiveFile)
}
