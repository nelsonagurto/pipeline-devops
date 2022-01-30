/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  			
	//echo "ejecuta stage: " + ${params.STAGE}
	stage('build'){
		STAGE = env.STAGE
		println "Stage: ${env.STAGE}"
		//echo "stage escrito: ${params.STAGE}"
		//bat "./gradlew.bat clean build"  
	}

}
return this;