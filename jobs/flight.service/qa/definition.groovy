pipelineJob("flight.service.qa") {
    description("Build and deploy flight service from develop branch on qa environment.")
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
            scriptPath('CI/jenkins/qa.Jenkinsfile')
        }
    }
}