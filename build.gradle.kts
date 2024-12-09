tasks.register("dev") {
    dependsOn(":database:prepareDb")
    dependsOn(":app:bootRun")
    dependsOn(":ui:dev")
    finalizedBy(":database:stopEmbeddedMysql")
}

tasks.register("deploy") {
    dependsOn(":app:bootRun")
    dependsOn(":ui:server")
}

//tasks.register("docker") {
//
//}
