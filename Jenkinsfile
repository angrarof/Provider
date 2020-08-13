pipeline{
  agent any

  tools{
    maven 'maven3'
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
