def buildJar() {
    echo "building the application..."
    sh 'mvn package'
}

def buildImage() {
    echo "building docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t 64.227.126.25:8083/my-app:2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin 64.227.126.25:8083"
        sh 'docker push 64.227.126.25:8083/my-app:2.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this