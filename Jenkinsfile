pipeline {
  agent any
  stages {
    stage('Preparation') {
        git 'https://github.com/jglick/simple-maven-project-with-tests.git'
        mvnHome = tool 'M3'
    }
    stage('Build') {
        if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
    }
    stage('Email') {
      steps {
       emailext body: 'Dummy Message', subject: 'Running Jenkins Test', to: 'ibrahimkhan0894@gmail.com'
      }
    }
  }
}
