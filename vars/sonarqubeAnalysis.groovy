def call() {
    withSonarQubeEnv('sonar-server') {
        sh '''
            $SCANNER_HOME/bin/sonar-scanner \
            -Dsonar.projectKey=YouTube \
            -Dsonar.sources=. \
            -Dsonar.host.url=http://13.250.9.138:9000 \
            -Dsonar.login=squ_12826907c29f5f324dba94e7726dd0605dc30270
        '''
    }
}
