pipeline {
    agent any
    environment {
        // The MY_KUBECONFIG environment variable will be assigned
        MY_KUBECONFIG = credentials('my-kubeconfig')
    }
    stages {     
        stage('git clone and Build') {
            steps {
                echo 'git repo checkout'
                git url: 'https://github.com/sureshreddy77/devops-coding-challenge'
                echo 'Building.. Docker file'
                sh 'docker build -f Dockerfile -t python-assesment-app07 .'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'pip install -q pylint && pip install -q pytest'
                sh 'pylint src -r n --msg-template="{path}:{line}: [{msg_id}({symbol}), {obj}] {msg}" --exit-zero >> pylint-report.txt'
            }
        }
        stage('publish') {
            steps {
                echo 'Deploying....'
                sh 'docker image tag python-assesment-app07:latest registry-host:5000/myadmin/python-assesment-app07:latest'
                sh 'docker image push registry-host:5000/myadmin/python-assesment-app07:latest'
            }
        }
        stage('Deploy to minikube') {
            steps {
                sh("kubectl --kubeconfig $MY_KUBECONFIG -f deployment.yaml")
            }
        }
    }
}