pipeline{
  agent any

  tools{
    maven 'MAVEN_LAP'
  }

  stages{
    stage('Create Selenium Grid'){
      steps{
        bat "docker-compose up"
      }
    }
    stage('Run tests'){
      steps{
        bat "mvn test -DsuiteXmlFiles=Testing.xml"
      }  
    }
  }

}
