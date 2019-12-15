pipeline {

	agent {
		docker { image 'maven:3.6-jdk-8-alpine' }
	}
	
	environment {
		TUNNEL_SAUCECONNECT = 'devops'
	}
	
	stages {
		
		stage ('clean') {
			steps {
				sh 'mvn clean package -Dmaven.test.skip=true'
			}
		}
		
		stage ('test') {
			steps {
				sh 'mvn test'
			}
		}

		stage ('Build') {
			steps {
				sh 'mvn --batch-mode package -Dmaven.test.skip=true'
			}
		}
	}
}