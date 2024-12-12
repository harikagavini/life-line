import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("mysql.plugin") version "2.1.11"
    id("com.github.node-gradle.node") version "7.1.0"
}

embeddedMysql {
    setUrl("jdbc:mysql://localhost:3306/lifeline")
    username = "test"
    password = "Qwerty12345"
    setVersion("v8_0_17")
}

tasks.register<NpmTask>("prepareDb") {
    dependsOn("npmInstall")
    args = listOf("run", "prepareDb")
}

tasks.register("buildDatabase") {
    dependsOn("startEmbeddedMysql")
    finalizedBy("prepareDb")
}
