# spring-boot-demo

Reference from  https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

Installed softwares:

MySql
Docker for desktop Docker version 19.03.5, build 633a0ea

==========================================================================================================
############################################### Commands ###############################################
==========================================================================================================

# See the docker version  
docker --version


# See the docker containers  
docker container ls

# Download the docker image from docker hub 
docker pull imageName


# Run the Mysql in Docker container
docker run -d -p 6033:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=notes_app" mysql


# Run the MySql terminal in Docker container
docker exec -it docker-mysql bash
mysql -uroot -proot ===> Where root/root are credentials


# Build the docker image from Docker File
docker build -f Dockerfile -t demo .


# Run the docker image 'demo' with running mysql docker
docker run -t --link docker-mysql:mysql -p 8080:8080 demo


# Stop the running container with container Id
docker container stop containerId

# List the images
docker images

# Remove the docker image
docker image rm -f imageId

or 

docker rmi -f imageName


# Start or stop the docker container
docker container start containerName/Id

# Publishing the image to a docker registry Hub
docker push yourusername/password



========================================================
################### HOW TO RUN ################### 
========================================================

1) Start the Docker

2) Run mvn spring-boot:run

POST 

localhost:8080/api/notes

Content-Type : application/json

{"title":"SECOND", "content":"This is Second comment"}