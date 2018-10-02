pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'JDK 8'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                sh "ls -lat"
            }
        }
        stage ('Compile') {
            steps {
                sh 'mvn --version'
                sh 'mvn -U clean compile'
            }
        }
        stage ('Unit Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage ('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage ('Integration Test') {
            steps {
                sh 'mvn verify -Dcontainer.imageName="${imageName}"'
            }
        }
        stage ('Deploy') {
            steps {
                sh 'echo "Deploying solution to UAT...."'
            }
        }
    }
}