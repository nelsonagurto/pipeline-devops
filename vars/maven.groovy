/*
	forma de invocación de método call:
	def ejecucion = load 'maven.groovy'
	ejecucion.call()
*/

def call(){

  stage('Compile') {
    STAGE = env.STAGE_NAME
    bat "./mvnw.cmd clean compile -e"
  }

  stage('Test') {
    STAGE = env.STAGE_NAME
    bat "./mvnw.cmd clean test -e"
  }

  stage('Jar') {
    STAGE = env.STAGE_NAME
    bat "./mvnw.cmd clean package -e"
  }

  stage('Run') {
    STAGE = env.STAGE_NAME
		bat "start /min mvnw.cmd spring-boot:run &"
		sleep 20
  }  
}

return this;