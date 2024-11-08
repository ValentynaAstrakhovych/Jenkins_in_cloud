How to run Jenkins on AWS

Sing in like a user in terminal aws configuration 
Check aws s3 ls
Create special s3 bucket in aws s3 and specify in main.tf
Create a key and add in locals.tf
Chose a subnet and assosiate public ip address 

Open folder -> terraform 
Terraform init
Terraform plan
Terraform apply
Cd ansible 
Ansible-playbook -i hosts playbook.yaml


Connect 
ssh ubuntu@ip -i shh path
(ssh ubuntu@44.222.63.211 -i /Users/valentyna/Desktop/Jenkins_cloud_setup/)Jenkins_cloud_setup.pem
Sudo cat /var/lib/jenkins/sexrets/initialAdminPassword
Create user 
Change url to 127.0.0.1:8080

Installed plugins terraform and ansiColor
Add tools terraform name tf1.6
Version terraform 1.7.3 Linux (arm64)

Add credential to connect Jenkins with GitHub
ssh-keygen -t ed25519 -C "yourmail@gmail.com"
Add in Jenkins private 
In GitHub public

Full access 

{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": [
				"ec2:*"
			],
			"Effect": "Allow",
			"Resource": "*"
		},
		{
			"Action": [
				"autoscaling:*"
			],
			"Effect": "Allow",
			"Resource": "*"
		},
		{
			"Action": [
				"s3:*"
			],
			"Effect": "Allow",
			"Resource": "*"
		},
		{
			"Action": [
				"iam:PassRole",
				"iam:ListRoles",
				"iam:GetRole",
				"iam:*"
			],
			"Effect": "Allow",
			"Resource": "*"
		}
	]
}# Jenkins_in_cloud
