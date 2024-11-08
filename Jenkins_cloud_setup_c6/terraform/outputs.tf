
output "web-address_jenkins" {
  value = aws_instance.jenkins.public_ip
}