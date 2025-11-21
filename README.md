# DeviShop
Tu es un nouveau Développeur dans une société de vente de produit en ligne. La société vend trois types de produits : des téléphones haut de gamme, des téléphones milieu de gamme et des ordinateurs portables. Ton Product Manager te demande de développer un programme permettant de calculer le panier d’un consommateur. Il existe deux types de clients : 1) Des clients particuliers identifiés par un id client, un nom et un prénom 2) Des clients professionnels identifiés par un id client, une raison sociale, un numéro de TVA intracommunautaire (qui est optionnel), un SIREN et un chiffre d’affaires annuel Pour les particuliers, le modèle de téléphone haut de gamme coute 1500 euros, le milieu de gamme coûte 800 euros et le laptop 1200 euros. Pour les clients professionnels ayant un chiffre d’affaires supérieur à 10 millions d’euros, le modèle de téléphone haut de gamme coûte 1000 euros, le moyen de gamme coûte 550 euros, et le laptop coûte 900 euros. Pour les clients professionnels ayant un chiffre d’affaires inférieur à 10 millions d’euros, le modèle de téléphone haut de gamme coûte 1150 euros, le milieu de gamme coûte 600 euros et le laptop coûte 1000 euros. Calculez pour un client donné le coût de son panier, sachant que celui-ci pourra contenir les 3 produits en plusieurs exemplaires


Une fois l’app démarrée :

UI Swagger :
👉 http://localhost:8080/swagger-ui.html

exemple :
{
"clientType": "INDIVIDUAL",
"clientId": 100,
"lastName": "maiza",
"firstName": "abdel",
"companyName": "elian consulting",
"siren": "14144785",
"intraVatNumber": "54187451",
"annualTurnover": 150020,
"highEndPhoneQty": 3,
"midRangePhoneQty": 5,
"laptopQty": 3
}

Curl :

curl -X 'POST' \
'http://localhost:8080/api/basket/compute' \
-H 'accept: */*' \
-H 'Content-Type: application/json' \
-d '{
"clientType": "INDIVIDUAL",
"clientId": 100,
"lastName": "maiza",
"firstName": "abdel",
"companyName": "ma consulting",
"siren": "14144785",
"intraVatNumber": "54187451",
"annualTurnover": 150020,
"highEndPhoneQty": 3,
"midRangePhoneQty": 5,
"laptopQty": 3
}'