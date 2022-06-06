# Prueba técnica Backend 👩‍💻
##  *Objetivo* :telescope:
Localizar la posición de un vehículo e identificar si se encuentra en peligro :mag:

## *Solución* :microscope: 
- Algoritmo matemático de trilateración para localizar la posición de un vehículo a partir de la posición de 3 satélites.
- Algoritmo que permite descifrar un mensaje codificado enviado por un vehículo. 
---

## Herramientas y dependencias utilizadas :hammer:

**Spring Boot, Java, Heroku, OrgJSON** :leaves:

## Funcionamiento de la API 🛰️

Para la ejecución de la API se realizará la correspondiente petición HTTP a través de Postman, solicitando el servicio a la URL: https://prueba-teclogi-backend.herokuapp.com/tracking/, seleccionando el método POST, asi como las opciones Body y raw, de esta forma se habilitará una sección para añadir la información (en formato JSON) del payload: 
- Distancias entre cada satélite (indicando su nombre) y el vehículo
- Mensaje codificado 

``` JSON
{
    "satellites":[
        {
        "name": "Sputnik",
        "distance": 568.3009467828068
        },
        {
        "name": "Explorer",
        "distance": 100.18024812424105
        },
        {
        "name": "Asterix",
        "distance": 476.29383589779377
        }
    ],
        "message": [
            "AGAJGA",
            "AAAADC",
            "AAADAD",
            "ACDADD",
            "CDCDFD",
            "CCCCED"
        ]
}
```

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/Test1.jpg" >
 </div>

Cuando es posible localizar al vehículo y el mensaje descifrado indica que está en peligro, la petición retorna las coordenadas de su ubicación (las cuales se encuentran aproximadas a un único decimal en la salida), como se observa a continuación:

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/Test2.jpg">
 </div>

Cabe mencionar que si se desea un alto indice de precisión es pertinente ingresar datos con mayor cantidad de decimales. 

El funcionamiento del algoritmo se puede visualizar geométricamente, en donde las tres circunferencias se intersecan en un único punto. Para comprender más acerca del *desarrollo matemático* se puede consultar la [*documentación*](https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/documentacion/Prueba%20t%C3%A9cnica%20Documentacion.pdf) :bulb:

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/Test3.jpg">
 </div>


