#! /bin/sh
# PRECONDITION(1): next command must be executed before this .sh YOUR_TOKEN is the OAuth token of github
# export CR_PAT=YOUR_TOKEN
# PRECONTION(2): A docker image with the tag name provided on push must be created previously
#Next command log-in us to GitHub registry
echo $CR_PAT | docker login ghcr.io -u USERNAME --password-stdin 
#Next command pushes our docker to the registry, remember PRECONDITION(2)
docker push ghcr.io/prubioamzubiri/springdemo:latest