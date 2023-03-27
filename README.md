# [Trilateration algorithm](https://github.com/lsofiadb/Trilateration-algorithm/blob/master/documentacion/Documentaci%C3%B3n%20Algoritmo%20de%20trilateraci%C3%B3n.pdf) 👩‍💻
##  *Objective* :telescope:
Locate the position of a vehicle and identify if it is in danger. :mag:

## *Solution* :microscope: 
- Mathematical trilateration algorithm to locate the position of a vehicle based on the position of 3 satellites.
- Algorithm that allows deciphering an encoded message sent by a vehicle.
---

## Tools and dependencies used :hammer:

**Spring Boot, Java 17, OrgJSON, Heroku, Docker, Postman** :leaves:

## Operation of the API 🛰️

To execute the API, the corresponding HTTP request will be made through Postman, requesting the service at the URL: https://localhost:8081/tracking/, selecting the POST method, as well as the Body and raw options. In this way, a section will be enabled to add the information (in JSON format) of the payload:

- Distances between each satellite (indicating its name) and the vehicle
- Encoded message"

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

When it is possible to locate the vehicle and the deciphered message indicates that it is in danger, the request returns the coordinates of its location (which are approximated to a single decimal place in the output), as shown below:

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/Test2.jpg">
 </div>

It should be noted that if a high level of precision is desired, it is pertinent to enter data with a greater number of decimals.

The operation of the algorithm can be geometrically visualized, where the three circles intersect at a single point. To learn more about the mathematical development, you can consult the [*documentation*](https://github.com/lsofiadb/Trilateration-algorithm/blob/master/documentacion/Documentaci%C3%B3n%20Algoritmo%20de%20trilateraci%C3%B3n.pdf) :bulb:

<div align="center">
  <img src="https://github.com/lsofiadb/Prueba-tecnica-Backend/blob/master/Images/Test3.jpg">
 </div>


