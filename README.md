# API POUR LE TP FINAL PAR ABDELFETTAH YOUBI ET TRISTAN SIX

Cette API gére trois choses, les trucks et leurs affectation, 
les positions ainsi que les creneaux.

--------------------------------------------------------------------
## LES DIFFERENTS INPUT DE L'API ET CHEMIN UTILISABLE
### LES TRUCKS

Pour récupérer une liste des trucks dans la base :</br>
method : get</br>
url : localhost:8081/api/trucks</br>

Pour récupérer un truck dans la base :</br>
method : get</br>
url : localhost:8081/api/trucks/{idDuTruckSouhaiter}</br>

Pour affecter à un truck une position :</br>
Régle : Trois truck ne peuvent être au même endroit</br>
method : put</br>
url : localhost:8081/api/trucks/{idDuTruck}/position/{idDeLaPosition}</br>

Pour affecter à un truck une creneau :</br>
method : put</br>
url : localhost:8081/api/trucks/{idDuTruck}/creneau/{idDuCreneau}</br>

Modifie intégralement un truck, l'id est requis afin de savoir le quel modifier</br>
Régle : Trois truck ne peuvent être au même endroit</br>
method : put</br>
url : localhost:8081/api/trucks</br>
Body:</br>
{
id_truck": 1,
"name": "Nom du truck",
"description": "Description du truck",
"id_creneau": 1,
"id_position": 1
}

Pour ajouter un truck dans la base :</br>
Régle : Trois truck ne peuvent être au même endroit</br>
method : post</br>
url : localhost:8081/api/trucks</br>
Body:</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>
{
"name": "Nom du truck",
"description": "Description du truck",
"id_creneau": 1,
"id_position": 1
}

Pour supprimer un truck de la base :</br>
method : delete</br>
url : localhost:8081/api/trucks/{idDuTruck}</br>

--------------------------------------------------------------------
### LES POSITIONS
Pour récupérer une liste de positions dans la base :</br>
method : get</br>
url : localhost:8081/api/positions</br>

Pour récupérer une position dans la base :</br>
method : get</br>
url : localhost:8081/api/positions/{idDeLaPositionSouhaiter}</br>

Pour récupérer une position dans la base à partir de son attribut name(la recherche
partial est possible):</br>
method : get</br>
url : localhost:8081/api/positions/search/{NameRechercher}</br>

Modifier intégralement une position l'id est requis afin de savoir le quel modifier</br>
method : put</br>
url : localhost:8081/api/positions</br>
Body:</br>
{
"id_position": 1,
"name": "Nom du position",
"description": "Description du position",
"longitude": une valeur comprise entre 180 et -180,
"latitude": une valeur comprise entre 90 et -90
}

Pour ajouter une position dans la base :</br>
method : post</br>
url : localhost:8081/api/positions</br>
Body:</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>
{
"name": "Nom du position",
"description": "Description du position",
"longitude": une valeur comprise entre 180 et -180,
"latitude": une valeur comprise entre 90 et -90
}

Pour supprimer une position de la base :</br>
Régle : Une position ne peut être supprimer si un truc y va</br>
method : delete</br>
url : localhost:8081/api/positions/{ideDeLaPosition}</br>
--------------------------------------------------------------------
### LES CRENEAUX
Pour récupérer une liste de créneaux dans la base :</br>
method : get</br>
url : localhost:8081/api/creneaux</br>

Pour récupérer un créneau dans la base :</br>
method : get</br>
url : localhost:8081/api/creneaux/{idDuCreneauxSouhaiter}</br>

Pour récupérer un créneau dans la base à partir de son attribut date:</br>
method : post</br>
url : localhost:8081/api/creneaux/search</br>
Body:</br>
{
"date": "date au format yyyy-MM-dd"
}

Modifier intégralement un créneau l'id est requis afin de savoir le quel modifier</br>
method : put</br>
url : localhost:8081/api/creneaux</br>
Body:</br>
{
"id_creneau": 1,
"name": "NouveauCréneau",
"description": "test rezqqsfdgsdcsfd",
"date": "date au format yyyy-MM-dd"
}

Pour ajouter un créneau dans la base :</br>
method : post</br>
url : localhost:8081/api/creneaux</br>
Body:</br>
//Pas besoin de mettre d'id il est générer automatiquement</br>
{
"name": "Nom du créneau",
"description": "Description du créneau",
"date": "date au format yyyy-MM-dd"
}

Pour supprimer un créneau de la base :</br>
Régle : Une position ne peut être supprimer si un truc y va</br>
method : delete</br>
url : localhost:8081/api/creneaux/{ideDeLaPosition}</br>


--------------------------------------------------------------------
Vous trouverez ci-joint dans les fichiers de l'API le fichier 
TP FINAL.postman_collection.json, qui est une collection de toutes 
les requêtes sur l'API. Ainsi que des requêtes près remplis afin de la tester.
