terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~>5"
    }
    random = {
      source  = "hashicorp/random"
      version = "~>3.5"
    }
  }
  required_version = ">= 1.9"

  backend "s3" {
    bucket = "terra-jenkins-test-cloudsetup"           # setup your s3 bucket name
    key    = "terra-jenkins-test-cloudsetup/terraform2.tfstate" # setup your s3 bucket name
    region = "us-east-1"
  }
}

provider "aws" {
  region = "us-east-1"
}
