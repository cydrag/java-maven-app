pipeline {

    agent any

    tools {
        maven 'maven-3.6'
    }

    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo "building docker image..."
                    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        sh 'docker build -t 64.227.126.25:8083/my-app:2.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin 64.227.126.25:8083"
                        sh 'docker push 64.227.126.25:8083/my-app:2.0'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "deploying the application..."
                }
            }
        }

    }
}