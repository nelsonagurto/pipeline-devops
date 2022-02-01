def call(){
  	stage('build'){
		figlet env.STAGE_NAME
		//STAGE = env.STAGE_NAME
		//println "Stage: ${env.STAGE_NAME}"
		//echo "stage escrito: ${params.STAGE}"
		//bat "./gradlew.bat clean build"  
	}
	
	stage('sonar'){
		figlet env.STAGE_NAME
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('run'){
		figlet env.STAGE_NAME
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('test'){
		figlet env.STAGE_NAME
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}

	stage('nexus'){
		figlet env.STAGE_NAME
		//STAGE = env.STAGE_NAME
		println "Stage: ${env.STAGE_NAME}"
	}
}
return this;