void call(String[] stagesToRun) {
    String stageBuild = 'build'
    String stageSonar = 'sonar'
    String stageRun = 'run'
    String stageTestRun = 'test run'
    String stageNexus = 'nexus'

    String[] stages = [
        stageBuild,
        stageSonar,
        stageRun,
        stageTestRun,
        stageNexus
    ]

    String[] currentStages = []

    if (stagesToRun.size() == 1 && stagesToRun[0] == '') {
        currentStages = stages
    } else {
        currentStages = stagesToRun
    }

    if (stages.findAll { e -> currentStages.contains( e ) }.size() == 0) {
        throw new Exception('Al menos una stage es invalida. Stages validas: ' + stages.join(', ') + '. Recibe: ' + currentStages.join(', '))
    }

    if (currentStages.contains(stageBuild)) {
        stage(stageBuild) {
            CURRENT_STAGE = stageBuild
            bat "./gradlew.cmd clean build"
        }
    }
/*
    if (currentStages.contains(stageSonar)) {
        stage(stageSonar) {
            CURRENT_STAGE = stageSonar
            String scannerHome = tool 'sonar-scanner'
            withSonarQubeEnv('sonarqube-server') {
                bt "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.sources=src -Dsonar.java.binaries=build"
            }
        }
    }

    if (currentStages.contains(stageRun)) {
        stage(stageRun) {
            CURRENT_STAGE = stageRun
            bat "./gradlew.cmd bootRun &"
            sleep 20
        }
    }

	
    if (currentStages.contains(stageTestRun)) {
        stage(stageTestRun) {
            CURRENT_STAGE = stageTestRun
            sh 'curl -X GET http://localhost:8081/rest/mscovid/test?msg=testing'
        }
    }

	
	
    if (currentStages.contains(stageNexus)) {
        stage(stageNexus) {
            CURRENT_STAGE = stageNexus
            nexusPublisher nexusInstanceId: 'nexus3-docker',
        nexusRepositoryId: 'ejemplo-gradle',
        packages: [
            [
                $class: 'MavenPackage',
                mavenAssetList: [
                    [classifier: '', extension: '', filePath: 'build/libs/DevOpsUsach2020-0.0.1.jar']
                ],
                mavenCoordinate: [
                    artifactId: 'DevOpsUsach2020',
                    groupId: 'com.devopsusach2020',
                    packaging: 'jar',
                    version: '0.0.1'
                ]
            ]
        ]
        }
    }
*/
}

return this