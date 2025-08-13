import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()

    exclusiveContent {
        forRepository {
            maven {
                name = "FabricMC's Maven"
                url = uri("https://maven.fabricmc.net/")
            }
        }
        filter {
            includeGroupAndSubgroups("net.fabricmc")
        }
    }
}

java.toolchain {
    languageVersion = JavaLanguageVersion.of(21)
    vendor = JvmVendorSpec.MICROSOFT
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 21
}

kotlin {
    compilerOptions {
        languageVersion = KotlinVersion.KOTLIN_2_1
        apiVersion = KotlinVersion.KOTLIN_2_1
    }
}

dependencies {
    implementation(group = "me.modmuss50.mod-publish-plugin", name = "me.modmuss50.mod-publish-plugin.gradle.plugin", version = "0.8.4")

    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation(group = "com.google.code.gson", name = "gson", version = "2.13.1")

    implementation(project(":sculptor"))
}