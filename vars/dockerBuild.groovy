def call(String dockerHubUsername, String imageName, String dockerfilePath = '.') {
    // Build the Docker image
    sh """
    docker build --build-arg REACT_APP_RAPID_API_KEY=59be1b8a0bmsh2df895722292ad8p1366aajsn4d7893fbcde8 \
                 -t ${imageName} -f ${dockerfilePath}/Dockerfile ${dockerfilePath}
    """
    // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"

    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
