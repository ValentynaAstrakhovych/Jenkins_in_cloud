pipeline {
    agent any
    tools {
     terraform 'tf1.9'
    }
    environment {
        AWS_REGION = 'us-east-1' // Set the AWS region
    }
    options {
        ansiColor('xterm')
    }
    stages {
        stage('Clone Git repo') {
            steps {
                git(branch: 'main', url: 'git@github.com:ValentynaAstrakhovych/Jenkins_in_cloud.git', credentialsId: 'git_new_access_jenkins_cloud_setup')            }
        }
        stage('Plan') {
            steps {
                sh '''
                cd ./simple_instance_setup_in_jenkins/terraform/
                terraform init
                terraform plan -out=terraform.tfplan
                '''
            }
        }
        stage('Plan verification and user input') {
            steps {
                input message: 'proceed or abort?', ok: 'ok'
            }
        }
        stage('Apply') {
            steps {
                sh '''
                cd ./simple_instance_setup_in_jenkins/terraform/
                terraform apply terraform.tfplan
                '''
            }
        }
        stage('Plan verification and user input destroy') {
            steps {
                input message: 'proceed or abort?', ok: 'ok'
            }
        }
        stage('Destroy') {
            steps {
                sh '''
                cd ./simple_instance_setup_in_jenkins/terraform/
                terraform plan -destroy -out=terraform-destroy.tfplan
                terraform apply terraform-destroy.tfplan
                '''
            }
        }
    }
}
