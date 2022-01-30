/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  
	stage('build'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
		echo "stage escrito: ${params.STAGE}"
		bat "./gradlew.bat clean build"   
	}

	stage('sonar'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('run'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('test'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('nexus'){
		STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}
}
return this;