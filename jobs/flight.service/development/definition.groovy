folder("flight.service") {
}
pipelineJob("flight.service/flight.service.development") {
    description("Build and deploy flight service from develop branch on development environment.")
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
                    branch('*/develop')
                    remote {
                        url('https://github.com/hanusiakl/flight.service.git')
                    }
                }
            }
            scriptPath('infrastructure/jenkins/development.Jenkinsfile')
        }
    }
}
