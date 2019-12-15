pipeline {

	agent {
		docker { image 'maven:3.6-jdk-8-alpine' }
	}
	
	environment {
		SONAR_HOST = 'http://localhost:9000/'
	}
	
	stages {
		
		stage ('Build') {
			steps {
				sh 'mvn --batch-mode package -Dmaven.test.skip=true'
			}
		}

		stage ('Unit Test') {
			steps {
				sh 'mvn test'
			}
		}
		
		stage ('Scan sonar') {
			steps {
				sh 'mvn --batch-mode sonar:sonar -Dsonar.host.url=${SONAR_HOST}'
			}
		}
		
		stage ('Deploy') {

		}
	}
}