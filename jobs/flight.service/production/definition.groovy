folder("flight.service") {
}
pipelineJob("flight.service/flight.service.production") {
    description("Build and deploy flight service from main branch on production environment.")
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
                        url('......')
                    }
                }
            }
            scriptPath('CI/jenkins/production.Jenkinsfile')
        }
    }
}