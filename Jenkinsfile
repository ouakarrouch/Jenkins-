pipeline {
    agent any
    environment {
        EUREKA_SERVER = "eureka-server"
        GATEWAY_SERVICE = "gateway-service"
        CAR_SERVICE = "car-service"
        CLIENT_SERVICE = "client-service"
        NETWORK = "spring-network"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ouakarrouch/Jenkins-'  // L'URL de votre dépôt Git
            }
        }
        stage('Build Docker Images') {
            steps {
                script {
                    sh 'docker-compose -f docker-compose.yml build'
                }
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    // Ajouter les tests ici si nécessaire
                }
            }
        }
        stage('Push to Docker Registry') {
            steps {
                script {
                    sh 'docker-compose -f docker-compose.yml push'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Ajouter les étapes de déploiement ici
                }
            }
        }
    }
    post {
        always {
            // Nettoyage après l'exécution
            sh 'docker-compose down'
        }
    }
}
