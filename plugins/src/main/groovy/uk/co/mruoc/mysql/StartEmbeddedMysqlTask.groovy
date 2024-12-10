package uk.co.mruoc.mysql

import com.wix.mysql.EmbeddedMysql
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

class StartEmbeddedMysqlTask extends DefaultTask {

    private static final def MYSQL_PROCESS_PROPERTY_NAME = "mysqlProcess"
    private static final def MYSQL_EXTENSION_NAME = "embeddedMysql"
    private final Project project

    @Inject
    StartEmbeddedMysqlTask(Project project) {
        this.project = project
        description 'starts an embedded mysql process'
    }

    @TaskAction
    def run() {
        def mysql = extension.buildMysql()
        setMysqlProcessProperty(mysql)
    }

    @Internal
    def getExtension() {
        def extensions = project.extensions
        return extensions.findByName(MYSQL_EXTENSION_NAME) as EmbeddedMysqlExtension
    }

    def setMysqlProcessProperty(EmbeddedMysql embeddedMysql) {
        return (EmbeddedMysql) extraProperties.set(MYSQL_PROCESS_PROPERTY_NAME, embeddedMysql)
    }

    @Internal
    def getExtraProperties() {
        def extensions = project.extensions
        return extensions.extraProperties
    }

}