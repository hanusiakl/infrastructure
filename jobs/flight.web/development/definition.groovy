pipelineJob("flight.web/flight.web.development") {
    description("Build and deploy flight web app from develop branch on development environment.")
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
                        url('......')
                    }
                }
            }
            scriptPath('CI/jenkins/development.Jenkinsfile')
        }
    }
}