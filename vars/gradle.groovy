/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  
	echo "ejecuta stage: ${params.STAGE}"
	STAGE = ${params.STAGE}
	
	 if (STAGE == "build") {
		stage('build'){
			bat "./gradlew.bat clean build"  
		}
	} else {
		echo "ejecuta maven"
	}

}
return this;