pipeline {
    agent any
    tools{
        maven '3.8.4'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/vishalkumar392392/end-to-deployment']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t vishalkumar392/devops-integration .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u vishalkumar392 -p ${dockerhubpwd}'
                        
                        sh 'docker push vishalkumar392/devops-integration'
                    }
                }
            }
        }
    }
}