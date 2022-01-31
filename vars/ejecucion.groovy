void call() {
    pipeline {
        agent any
        environment {
            CURRENT_STAGE = ''
        }

        parameters {
            choice choices: ['maven', 'gradle'], description: 'indicar la herramienta de construccion', name: 'buildTool'
            string defaultValue: '', description: 'Stages a ejecutar', name: 'stage'
        }
        stages {
            stage('pipeline') {
                steps {
                    script {
                        String[] mySteps = params.stage.split(';')

                        if (params.buildTool == 'maven') {
                            maven.call(mySteps)
                        } else {
                            gradle.call(mySteps)
                        }
                    }
                }
            }
        }
        post {
            success {
                slackSend(color: '#00FF00', message: '[Nelson Agurto][' + env.JOB_NAME + '][' + params.buildTool + '] Ejecucion Exitosa.')
            }
            failure {
                slackSend(color: '#FF0000', message: '[Nelson Agurto][' + env.JOB_NAME + '][' + params.buildTool + '] Ejecucion Fallida en Stage [' + CURRENT_STAGE + '].')
            }
        }
    }
}

return this