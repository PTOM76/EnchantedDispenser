import net.fabricmc.loom.api.LoomGradleExtensionAPI

plugins {
    java
    kotlin("jvm") version "2.0.20"
    id("dev.architectury.loom") version "1.7-SNAPSHOT" apply false
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false
}

architectury {
    minecraft = rootProject.property("minecraft_version").toString()
}

allprojects {
    group = rootProject.property("maven_group").toString()
    version = rootProject.property("mod_version").toString()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "architectury-plugin")
    apply(plugin = "maven-publish")

    val loom = project.extensions.getByName<LoomGradleExtensionAPI>("loom")

    base.archivesName.set("${rootProject.property("archives_base_name")}-${project.name}")

    repositories {
        maven("https://maven.pitan76.net/")
    }

    dependencies {
        "minecraft"("net.minecraft:minecraft:${project.property("minecraft_version")}")

        "mappings"(
            loom.layered {
                this.mappings ("net.fabricmc:yarn:${project.property("yarn_mappings")}:v2")
                this.mappings (file("../mappings/121-1fix.tiny"))
            }
        )

        "modApi"("net.pitan76:mcpitanlib-common${rootProject.property("mcpitanlib_version")}")
    }

    java {
        withSourcesJar()

        // neoforgeのときは21にする
        if (project.name == "neoforge") {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        } else {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    tasks.withType<JavaCompile> {
        this.options.encoding = "UTF-8"
        if (project.name == "neoforge") {
            this.options.release = 21
        } else {
            this.options.release = 17
        }
    }

    kotlin.target.compilations.all {
        if (project.name == "neoforge") {
            this.kotlinOptions.jvmTarget = "21"
        } else {
            this.kotlinOptions.jvmTarget = "17"
        }
    }
}
