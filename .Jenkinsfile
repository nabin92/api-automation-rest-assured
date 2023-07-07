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
        bat "mvn test -Dorganization=nabinghosh1 -Dpat=jzuaiubphh76uxzjsf4axknzu62fom4n72hw7irjkh3wiblfz5oq"
      }
    }
  }
}