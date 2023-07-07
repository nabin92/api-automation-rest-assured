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
        bat "mvn test -Dorganization=nabinghosh11 -Dpat=jzuaiubphh76uxzjsf4axknzu62fom4n72hw7irjkh3wiblfz5oq"
      }
    }
    stage('Test') {
      steps {
        testNG failureOnFailedTestConfig: true, showFailedBuilds: true
      }
    }
  }
}