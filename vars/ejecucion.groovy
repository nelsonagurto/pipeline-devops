/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
 pipeline {

	agent any
	
	environment {
		
	    STAGE = ''
		DISABLE_AUTH = 'true'
	}

	parameters {
		choice(name: 'buildTool', choices: ['gradle', 'maven'], description: 'Indicar herramienta de construccion')
		string(name:'stage', description:'Ingrese Stage a Ejecutar', defaultValue:'')
	}

	stages{
		stage('Pipeline'){
		//STAGE = env.STAGE_NAME
		//println "Stage: ${env.STAGE_NAME}"
			steps{
				script{
										
	                if (params.buildTool == "gradle") {
						figlet 'Pipeline   Gradle'
						echo "escribio stage, ${stage}"
	                    gradle()
	                } else {
						figlet 'Pipeline   Maven'
	                    maven()
	                }
				}
			}
		}
	}

	post {
		success {
			slackSend color: 'good', message: "[${DISABLE_AUTH}][${env.JOB_NAME}][${params.buildTool}] Ejecucion exitosa."
		}

		failure {
			slackSend color: 'danger', message: "[${env.USER}][${env.JOB_NAME}][${params.buildTool}] Ejecucion fallida en stage ${STAGE}."
			error "Ejecución fallida en stage ${STAGE}"
		}
	}
}


}

return this;