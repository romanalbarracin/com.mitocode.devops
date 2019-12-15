pipeline {
	agent any
	
	tools {
		docker { image 'maven:3.6-jdk-8-alpine' }
	}
	
	enviromnet {
		TUNNEL_SAUCECONNECT = 'devops'
	}
	
	stages {

		stage ('Build Backend') {
			steps {
				sh 'mvn --bacth-mode package -Dmaven.test.skip=true'
			}
		}
	}
}