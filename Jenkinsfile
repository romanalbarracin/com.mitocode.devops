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
		
		stage ('Deployment') {
			steps {
				sh 'cp /var/jenkins_home/workspace/java_devops_mitocode_master@2/target/devops.war /tomcat/webapps/'
			}
		}
	}
}