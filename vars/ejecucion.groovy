def call(){
  
 pipeline {

	agent any
	
	environment {
		
	    //STAGE = ''
		//DISABLE_AUTH = 'true'
		CURRENT_STAGE = ''
	}

	parameters {
		//choice(name: 'buildTool', choices: ['gradle', 'maven'], description: 'Indicar herramienta de construccion')
		//string(name: 'stage', defaultValue: '', description: 'Ingrese Stage a Ejecutar')
		
		 choice choices: ['maven', 'gradle'], description: 'indicar la herramienta de construccion', name: 'buildTool'
         string defaultValue: '', description: 'Ingrese Stage a Ejecutar', name: 'stage'
	}

	stages{
		stage('Pipeline'){
		//println ${env.STAGE}
		//println "Stage: ${env.STAGE_NAME}"
			steps{
				script{										
	                if (params.buildTool == "gradle") {
						figlet 'Pipeline   Gradle'
						//echo  ${params.STAGE}   //${env.STAGE}
						//echo "stage escrito: " + ${env.STAGE}
						//println ${params.env.STAGE}
	                    gradle()
	                } else {
						figlet 'Pipeline   Maven'
						//echo "stage escrito: ${params.STAGE}"
	                    maven()
	                }
				}
			}
		}
	}

	post {
		success {
			slackSend color: 'good', message: "[Nelson Agurto][${env.JOB_NAME}][${params.buildTool}] Ejecucion exitosa."
		}

		failure {
			slackSend color: 'danger', message: "[Nelson Agurto][${env.JOB_NAME}][${params.buildTool}] Ejecucion fallida en stage [' + ${env.STAGE_NAME} + ']."
		}
	}
 }
}

return this;
