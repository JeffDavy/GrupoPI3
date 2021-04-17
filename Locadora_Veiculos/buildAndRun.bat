@echo off
call mvn clean package
call docker build -t br.sp.senac.tads/Locadora_Veiculos .
call docker rm -f Locadora_Veiculos
call docker run -d -p 9080:9080 -p 9443:9443 --name Locadora_Veiculos br.sp.senac.tads/Locadora_Veiculos