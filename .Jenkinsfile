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
    stage('Server'){
      steps{
     id: 'Artifactory-1',
         url: 'http://my-artifactory-domain/artifactory',
             // If you're using username and password:
         username: 'user',
         password: 'password',
             // If you're using Credentials ID:
             credentialsId: 'ccrreeddeennttiiaall',
             // If Jenkins is configured to use an http proxy, you can bypass the proxy when using this Artifactory server:
             bypassProxy: true,
             // Configure the connection timeout (in seconds).
             // The default value (if not configured) is 300 seconds:
             timeout: 300
      }
    }
   }
  }
}