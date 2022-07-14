import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.d3s34"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.7.10"
    antlr
    idea
}

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.10.1")
    implementation("org.antlr:antlr4-runtime:4.10.1")
    testImplementation(kotlin("test"))
}

sourceSets {
    main {
        java.srcDir("src/generated-src/main/java")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.generateGrammarSource {
    maxHeapSize = "128m"

    arguments = listOf(
        "-visitor",
        "-listener",
        "-package",
        "me.d3s34.parser"
    )

    outputDirectory = file("src/generated-src/main/java")
}

tasks.compileKotlin {
    dependsOn("generateGrammarSource")
}

idea {
    module {
        generatedSourceDirs.plusAssign(file("src/generated-src/main/java"))
    }
}
