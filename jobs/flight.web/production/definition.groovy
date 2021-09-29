folder("flight.web") {
}
pipelineJob("flight.web/flight.web.production") {
    description("Build and deploy flight web app from main branch on production environment.")
    keepDependencies(false)
    disabled(false)
    concurrentBuild(false)
    logRotator {
        numToKeep(500)
        daysToKeep(30)
    }
    definition {
        cpsScm {
            scm {
                git  {
                    branch('*/main')
                    remote {
                        url('https://github.com/hanusiakl/flight.web.git')
                    }
                }
            }
            scriptPath('CI/jenkins/production.Jenkinsfile')
        }
    }
    triggers {
        cron('H/5 * * * *')
    }
}