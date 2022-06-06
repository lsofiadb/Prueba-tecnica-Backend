# Prueba técnica Backend 
- Algoritmo matemático de trilateración para localizar la posición de un vehículo a partir de la posición de 3 satélites.
- Algoritmo que permite descifrar un mensaje codificado enviado por el vehículo. 
---

## Funcionamiento de la API

Para la ejecución de la API se realizará la correspondiente petición HTTP a través de Postman (programa que permite realizar peticiones a APIs), accediendo a la URL: https://prueba-teclogi-backend.herokuapp.com/tracking/, seleccionando el método POST, Body y raw, de esta forma aparecerá una sección para añadir la información del payload: las distancias de cada satélite, indicando su nombre y el mensaje codificado, como se observa a continuación:

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/1.png" >
 </div>

Cuando es posible localizar al vehículo y el mensaje descifrado indica que está en peligro, la petición retorna las coordenadas de su ubicación, como se observa anteriormente. 

Lo anterior se puede visualizar geometricamente a través de circuferencias con centro en la posición de cada satelite y radio correspondiente a la distancia entre el vehiculo y el satelite. 

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/2.png" >
 </div>


#### Proyecto realizado con Spring boot.
