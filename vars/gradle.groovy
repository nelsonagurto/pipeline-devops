/*
	forma de invocación de método call:
	def ejecucion = load 'gradle.groovy'
	ejecucion.call()
*/

def call(){
  
	switch (${params.STAGE}) 
        {
            case build: echo "ejecuta stage: ${params.STAGE}" 
                     break
        }
}
return this;