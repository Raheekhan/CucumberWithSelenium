pipeline {
  agent any
  stages {
    stage('Preparation') {
      steps {
        git 'https://github.com/jglick/simple-maven-project-with-tests.git'
      }
    }
    stage('Build') {
      steps {
        sh '${mvnHome}/bin/mvn\' -Dmaven.test.failure.ignore clean package'
      }
    }
    stage('Email') {
      steps {
        emailext(subject: 'Dummy Message', body: 'Dummy Message', to: 'ibrahimkhan0894@gmail.com')
      }
    }
  }
}