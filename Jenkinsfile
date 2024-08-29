pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials-id')
        DOCKER_HUB_REPO = 'the-dockerhub-username'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-repo/employee-management-system.git'
            }
        }

        stage('Build and Test Microservices') {
            parallel {
                stage('Build and Test Discovery Service') {
                    steps {
                        dir('discovery-service') {
                            sh './mvnw clean install'
                        }
                    }
                }

                stage('Build and Test API Gateway') {
                    steps {
                        dir('api-gateway') {
                            sh './mvnw clean install'
                        }
                    }
                }

                stage('Build and Test Config Server') {
                    steps {
                        dir('shared-config-server') {
                            sh './mvnw clean install'
                        }
                    }
                }


                stage('Build and Test Alliance') {
                    steps {
                        dir('alliance') {
                            sh './mvnw clean install'
                        }
                    }
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    def services = ['discovery-service', 'api-gateway', 'config-server', 'alliance']
                    for (service in services) {
                        dir(service) {
                            sh """
                            docker build -t $DOCKER_HUB_REPO/${service}:latest .
                            """
                        }
                    }
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script {
                    sh "echo $DOCKER_HUB_CREDENTIALS_PSW | docker login -u $DOCKER_HUB_CREDENTIALS_USR --password-stdin"
                    
                    def services = ['discovery-service', 'api-gateway', 'config-server', 'alliance']
                    for (service in services) {
                        sh "docker push $DOCKER_HUB_REPO/${service}:latest"
                    }
                }
            }
        }

        stage('Deploy to Staging Environment') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }

        stage('Integration Tests') {
            steps {
                sh './integration-tests/run-tests.sh'
            }
        }

    

    post {
        always {
            sh 'docker rmi $(docker images -f "dangling=true" -q) || true'
        }
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
