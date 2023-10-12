# FxDealWareHouse


The project is to develop a data warehouse system for Bloomberg to analyze FX deals. This system will handle incoming deal details, validate their structure, and persist them into a MYSQL database. 



Sample API :
http://localhost:8082/api/fx-deal/create


Request :
{
    "id": 9008,
    "fromCurrencyISOCode": "KJY",
    "toCurrencyISOCode": "KJH",
    "dealTimestamp": "2023-10-11T14:30:00",
    "dealAmount": 123
}

success:
{
    "message": "FXDEAL has been saved successfully!"
}

Failed:
{
    "message": "Duplicate Request"
}

#The project is based on a small web service which uses the following technologies:

Java 1.8

Spring Boot

Mysql 

Maven

Hibernate
