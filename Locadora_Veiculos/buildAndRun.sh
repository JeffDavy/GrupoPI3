#!/bin/sh
mvn clean package && docker build -t br.sp.senac.tads/Locadora_Veiculos .
docker rm -f Locadora_Veiculos || true && docker run -d -p 9080:9080 -p 9443:9443 --name Locadora_Veiculos br.sp.senac.tads/Locadora_Veiculos