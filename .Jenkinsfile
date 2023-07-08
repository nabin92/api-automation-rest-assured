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
        bat "mvn test -Dorganization=nabinghosh11 -Dpat=uj4ispsy55wtbraf6vy2ognm6ec66qtzbtk7vvkw264rdyenhc6a"
      }
    }
    stage('Publish') {
      steps {
        testNG failureOnFailedTestConfig: true, showFailedBuilds: true
      }
    }
    stage('Server') {
      steps {
        rtServer(
            id: 'Artifactory',
            url: 'https://apiautomation.jfrog.io/artifactory',
            username: 'nabin',
            password: 'Capita@123',
            bypassProxy: true,
            timeout: 300
            )
        }
    }
  }
}