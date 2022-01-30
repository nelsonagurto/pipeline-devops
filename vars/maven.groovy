/*
	forma de invocación de método call:
	def ejecucion = load 'maven.groovy'
	ejecucion.call()
*/

def call(){

  stage('compile') {
    STAGE = env.STAGE_NAME
    bat "./mvnw.cmd clean compile -e"
  }

  stage('test') {
    STAGE = env.STAGE_NAME
    bat "./mvnw.cmd clean test -e"
  }

  stage('jar') {
    STAGE = env.STAGE_NAME
    bat "./mvnw.cmd clean package -e"
  }

  stage('run') {
    STAGE = env.STAGE_NAME
		bat "start /min mvnw.cmd spring-boot:run &"
		sleep 20
  }  
}

return this;