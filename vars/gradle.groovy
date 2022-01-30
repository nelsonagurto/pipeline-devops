/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  
   environment {
                STAGE = ${params.STAGE}
            }
			
	//echo "ejecuta stage: ${params.STAGE}"
	echo "ejecuta stage: env.STAGE"
	
	 if (env.STAGE == "build") {
		stage('build'){
			bat "./gradlew.bat clean build"  
		}
	} else {
		echo "ejecuta maven"
	}

}
return this;