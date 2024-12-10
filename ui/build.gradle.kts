import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node") version "7.1.0"
}

tasks.register<NpmTask>("dev") {
    dependsOn("npmInstall")
    args = listOf("run", "dev")
}

tasks.register<NpmTask>("build") {
    dependsOn("npmInstall")
    args = listOf("run", "build")
}

tasks.register<NpmTask>("server") {
    dependsOn("build")
    args = listOf("run", "start")
}
