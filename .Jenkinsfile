pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat "mvn clean"
      }
    }
    stage('Test') {
      steps {
        echo 'Running the test'
        bat "mvn test -Dorganization=nabinghosh11 -Dpat=jjjy26rboufnv45l52spxcbtw2csrxhnz5wrhfgdgvqw2osy37oq"
      }
    }
    stage('Publish') {
      steps {
        testNG failureOnFailedTestConfig: true, showFailedBuilds: true
      }
    }
  }
}