package uk.co.mruoc.mysql

import com.wix.mysql.EmbeddedMysql
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject

class StopEmbeddedMysqlTask extends DefaultTask {
    private final Project project
    private static final def MYSQL_PROCESS_PROPERTY_NAME = "mysqlProcess"

    @Inject
    StopEmbeddedMysqlTask(Project project) {
        this.project = project
        description 'stops an embedded mysql process'
    }

    @TaskAction
    def run() {
        if (hasMysqlProcessProperty()) {
            def mysql = getMysqlProcessProperty()
            mysql.stop()
        }
    }

    def hasMysqlProcessProperty() {
        return extraProperties.has(MYSQL_PROCESS_PROPERTY_NAME)
    }

    @Internal
    def getMysqlProcessProperty() {
        return (EmbeddedMysql) extraProperties.get(MYSQL_PROCESS_PROPERTY_NAME)
    }

    @Internal
    def getExtraProperties() {
        def extensions = project.extensions
        return extensions.extraProperties
    }

}