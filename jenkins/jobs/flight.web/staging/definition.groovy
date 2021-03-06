folder("flight.web") {
}
pipelineJob("flight.web/flight.web.staging") {
    description("Build and deploy flight web app from main branch on staging environment.")
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
            scriptPath('infrastructure/jenkins/staging.Jenkinsfile')
        }
    }
}