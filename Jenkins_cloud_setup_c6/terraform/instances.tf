resource "aws_instance" "jenkins" {
  ami                    = data.aws_ami.ubuntu_server.id # Ubuntu server 22.04
  instance_type          = "c6a.large" # Do not forget to turn off the instance after the test (56$ per month)
  vpc_security_group_ids = [aws_security_group.web-sg.id]
  key_name               = local.my_key_name# Change to your key name
  iam_instance_profile = aws_iam_instance_profile.jenkins_profile_devops_en.name
  
  root_block_device {
    volume_size = 25
  }

  tags = {
    Name = "Jenkins_DevOps Instance"
  }
}

