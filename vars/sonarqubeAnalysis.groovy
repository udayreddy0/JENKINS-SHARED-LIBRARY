def call() {
    withSonarQubeEnv('sonar-server') {
        sh '''
            $SCANNER_HOME/bin/sonar-scanner \
  -Dsonar.projectKey=youtube \
  -Dsonar.sources=. \
  -Dsonar.host.url=http://34.207.217.252:9000 \
  -Dsonar.token=squ_9dea07319ad5853919897751e06e3570d1cee9d3
        '''
    }
}
