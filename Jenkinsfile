pipeline{
  agent any

  tools{
    maven 'maven3'
  }

  stages{
    stage('Create Selenium Grid'){
      steps{
        sh "docker-compose up -d"
      }
    }
    stage('Run tests'){
      steps{
        sh "mvn test -DsuiteXmlFiles=Testing.xml"
      }  
    }
  }
  
  post {
    // If Maven was able to run the tests, even if some of the test
    // failed, record the test results and archive the jar file.
    always{
      sh 'docker-compose down'
    success {
      junit '**/target/surefire-reports/TEST-*.xml'
    }
  }

}
