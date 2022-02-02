#! /bin/sh
# Pull latest dockerHub image from mysql
# docker pull mysql
# Runs mysql docker with 'Tknika1' as root password and 'my-sql' as server name
# docker run --name mysql-server -e MYSQL_ROOT_PASSWORD=Tknika1 -d mysql
# Conect to mysql server with root user from command line
# docker exec -it mysql-server mysql -uroot -p

 docker run --detach --name=nombre_container -p 3306:3306 --env="MYSQL_ROOT_PASSWORD=1234" mysql

 # Iniciar docker a posterior

 docker start nombre_container