def call(){
  	stage('build'){
		figlet CURRENT_STAGE
		//STAGE = env.STAGE_NAME
		//println "Stage: ${env.STAGE_NAME}"
		//echo "stage escrito: ${params.STAGE}"
		//bat "./gradlew.bat clean build"  
	}
	
	stage('sonar'){
		figlet CURRENT_STAGE
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('run'){
		figlet CURRENT_STAGE
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('test'){
		figlet CURRENT_STAGE
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('nexus'){
		figlet CURRENT_STAGE
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}
}
return this;