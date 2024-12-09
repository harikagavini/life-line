import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node") version "7.1.0"
}

tasks.register<NpmTask>("web") {
    dependsOn("npmInstall")
    args = listOf("run", "dev")
}