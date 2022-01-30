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
		//choice(name: 'buildTool', choices: ['gradle', 'maven'], description: 'Indicar herramienta de construccion')
		//choice(name: 'buildTool')
		string(name:'stage', description:'Ingrese Stage a Ejecutar', defaultValue:'')
	}

	stages{
		stage('Pipeline'){
			steps{
				script{
					figlet 'Pipeline'
					
	                if (params.buildTool == "gradle") {
	                   gradle()
	                } else {
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