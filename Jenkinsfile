pipeline {
	agent any
	
	tools {
		maven 'mvn'
		java 'jdk8'
	}
	
	stages {

		stage ('build') {
			steps {
				sh 'mvn clean package -Dmaven.test.skip=true'
			}
		}
		
		stage ('build') {
			steps {
				sh 'mvn test'
			}
		}
	}
}