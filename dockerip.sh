
#! /bin/bash
# Know dokcer ip
# https://dockerlabs.collabnix.com/intermediate/networking/FindingIPaddressofContainer.html
# Example (pt1): docker run --rm -dit  --name no-net-alpine alpine:latest ash
# Exmple (pt2): docker inspect -f '' no-net-alpine

# start mysql-server docker with db as name
docker start db
# know mysql-servers ip with db as name
# docker inspect -f '' bd
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' db