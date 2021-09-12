folder("flight.service") {
}
pipelineJob("flight.service/flight.service.staging") {
    description("Build and deploy flight service from main branch on staging environment.")
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
            scriptPath('CI/jenkins/staging.Jenkinsfile')
        }
    }
}