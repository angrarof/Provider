pipeline{
  agent any

  tools{
    maven 'MAVEN_LAP'
  }

  stages{
    stage('Create Selenium Grid'){
      steps{
        sh "docker-compose up"
      }
    }
    stage('Run tests'){
      steps{
        sh "mvn test -DsuiteXmlFiles=${xmlFile}"
      }  
    }
  }

  post{
    always{
      junit 'target/**/*.xml'
      junit 'target/surefire-reports/**/*.xml'
    }
  }

}
