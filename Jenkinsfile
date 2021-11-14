#!/usr/bin/env groovy

@Library('jenkins-shared-library')_

pipeline {

    agent any

    tools {
        maven 'maven-3.6'
    }

    stages {
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    buildImage()
                }
            }
        }
    }
}