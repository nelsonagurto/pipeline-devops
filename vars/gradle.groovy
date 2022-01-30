/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  			
	echo "ejecuta stage: ${params.STAGE}"
	
			stage('build'){
			bat "./gradlew.bat clean build"  
		}

}
return this;