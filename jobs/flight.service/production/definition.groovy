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
                        url('https://github.com/hanusiakl/flight.service.git')
                    }
                }
            }
            scriptPath('infrastructure/jenkins/production.Jenkinsfile')
        }
    }
}