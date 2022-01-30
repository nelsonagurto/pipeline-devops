/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  			
	echo "ejecuta stage: ${params.STAGE}"
	
	 if (${params.STAGE} == "build") {
		stage('build'){
			bat "./gradlew.bat clean build"  
		}
	} else {
		echo "ejecuta maven"
	}

}
return this;