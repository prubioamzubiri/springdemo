#! /bin/sh
java -Dserver.port=$PORT -Ddbuser=$DBUSER -Ddbpassword=$DBPASSWORD -Ddbport=$DBPORT -Ddbhost=$DBHOST -Ddbdatabase=$DATABASE -jar app.jar 