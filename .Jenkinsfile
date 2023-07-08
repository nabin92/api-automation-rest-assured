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
        bat "mvn package -DskipTests"
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
    stage('Upload'){
      steps{
         rtUpload(
           serverId:'Artifactory',
           spec: '''{
                     "files": [
                       {
                         "pattern": ".jar",
                         "target": "libs-release"
                       }
                    ]
               }''',
        )
    }
   }
  }
}