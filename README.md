# Prueba técnica Backend 👩‍💻
##  *Objetivo* :telescope:
Localizar la posición de un vehículo e identificar si se encuentra en peligro. 

## *Solución* :microscope: 
- Algoritmo matemático de trilateración para localizar la posición de un vehículo a partir de la posición de 3 satélites.
- Algoritmo que permite descifrar un mensaje codificado enviado por un vehículo. 
---

## Herramientas y dependencias utilizadas :hammer:

Spring Boot, Java, Heroku, OrgJSON. 

## Funcionamiento de la API 🛰️

Para la ejecución de la API se realizará la correspondiente petición HTTP a través de Postman (programa que permite realizar peticiones a APIs), accediendo a la URL: https://prueba-teclogi-backend.herokuapp.com/tracking/, seleccionando el método POST, Body y raw, de esta forma aparecerá una sección para añadir la información (en formato JSON) del payload: las distancias de cada satélite, indicando su nombre y el mensaje codificado, como se observa a continuación:

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/1.png" >
 </div>

Cuando es posible localizar al vehículo y el mensaje descifrado indica que está en peligro, la petición retorna las coordenadas de su ubicación, como se observa anteriormente. Cabe mencionar que si se desea un alto indice de precisión es pertinente ingresar datos con mayor cantidad de decimales. 

El funcionamiento del algoritmo se puede visualizar geométricamente, en donde las tres circunferencias se intersecan en un único punto. Para comprender el desarrollo matemático se puede consultar la [documentación](https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/documentacion/Prueba%20t%C3%A9cnica%20Documentacion.pdf) :bulb:. 

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/2-1.png" >
 </div>
