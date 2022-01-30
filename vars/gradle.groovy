/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  
	if (${params.STAGE} == "build") {
		echo "ejecuta stage: ${params.STAGE}"
		//gradle()
	} else {
		//figlet 'Pipeline   Maven'
		//echo "stage escrito: ${params.STAGE}"
		//maven()
	}	
}
return this;