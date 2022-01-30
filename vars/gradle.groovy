/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  
	stage('Build'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
		bat "./gradlew.bat clean build"   
	}

	stage('Sonar'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('Run'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('Test'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('Nexus'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}
}
return this;