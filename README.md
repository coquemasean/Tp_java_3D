# Catch me if you can 

## Introduction

Ce travail s'inscrit dans la matière Java/UML enseigné à l'ENSEA par Nicolas Papazoglou et Antoine Tauvel en 2022.

## Présentation générale du projet

Il s’agit d’un petit utilitaire permettant d’afficher quelques données relatives à l’aviation de tourisme.
Dans ces scéances de tp j'ai utilisé des données statiques (la liste des a ́eroports mondiaux au format.csv) et une source de données dynamiques (une API sur le site aviationstack.com).

## Structure UML 
![Capture](https://user-images.githubusercontent.com/46956234/150637311-cb54321a-cde2-4887-8c01-8ba8b2ae5b7f.PNG)

## Déroulement des scéances

La liste ci-dessous est dans l’ordre dans laquelle nous construirons les classes :

### Areroport

Elle définit ce qu’est un aéroport du point de vue de l’application : un nom, des coordonnées GPS (lattitude et longitude) et un code IATA.

### World

Cette classe contient la liste de tous les aéroports du monde entier. Elle est crée par la lecture d’un fichier CSV. Cette classe offre deux moyens de retrouver un aéroport : par son code ou par les coordonnées GPS (le système renvoie l’aéroport le plus proche quelque soit la distance réelle).

### Interface

Ici on retrouve l’interface du projet. Elle contient un objet de groupe "Earth" et des méthodes pour gérer l’interactivité. 
En cas de clic sur le globe terrestre, elle calcul l’aéroport le plus proche, l’affiche en rouge, recherche sur Internet tous les vols en direction de cet aéroport et affiche en jaune les aéroports d’origines.

### Flight

Cette classe permet de modéliser un vol. Ce vol est notamment définis par deux aéroports, un de départ et un d’arrivée.

### JsonFlightFillerOracle

Elle utilise un paquet d’analyse JSON fournis par Oracle pour interroger une base en ligne et récupérer tous les vols.

### Earth

Cette La classe héte de la classe groupe (en effet, elle est constituée de la terre et des aéroports concernés)
