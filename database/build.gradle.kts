plugins {
    id("mysql.plugin") version "2.1.11"
}

embeddedMysql {
    setUrl("jdbc:mysql://localhost:3306/lifeline")
    username = "test"
    password = "Qwerty12345"
    setVersion("v8_0_17")
}

tasks.register("prepareTheDb") {
    dependsOn("startEmbeddedMysql")
}
