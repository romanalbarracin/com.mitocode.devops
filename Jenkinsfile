pipeline {

	agent {
		docker { image 'maven:3.6-jdk-8-alpine' }
	}
	
	environment {
		TUNNEL_SAUCECONNECT = 'devops'
	}
	
	stages {

		stage ('Build Backend') {
			steps {
				sh 'mvn --batch-mode package -Dmaven.test.skip=true'
			}
		}
	}
}