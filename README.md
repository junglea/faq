# faq

## Project definition
===
Lors de la planification du lundi matin, le product owner vous a assigné les users stories suivantes :

**User story 1 :**
> En tant qu'utilisateur ayant les droits "administrateur", je peux insérer une question / réponse dans la base de connaissances (FAQ) du produit. Une question / réponse est définie par :
> 1. Le libellé de la question ;
> 0. Le libellé de la réponse ;
> 0. La liste des tags associés.

**User story 2 :**
> En tant qu'utilisateur ayant les droits "administrateur", je peux lister toutes les questions / réponses de la base de connaissances.

**User story 3 :**
> En tant qu'utilisateur, je peux rechercher la réponse à une question sans avoir à saisir le texte exact correspondant à une question ou à une réponse de la base de connaissances.

## Building from Source
===
You can use:

<pre>$ mvn clean install</pre>

or, if you want to use the latest Spring Boot with maven wrapper:

<pre>$ ./mvnw clean install</pre>

## Configure your application
===

MongoDB database porperties are defined in src/resources/application.properties


## How to test
===

There is some integration tests in project but you can also use curl request.
In this case, you will need a mongoDB database that listen to localhost:27017.

### 1. Install a mongoDB database

By default, faq project will try to connect on  localhost:27017 (default listening IP:port of mongoDB). You can change
this in src/resources/application.properties

### 2. Launch application

You can launch with:

<pre>$ mvn spring-boot:run</pre>

Or use tomcat and war:

<pre>$ mvn package</pre>
<pre>$ cp target/faq-0.0.1-SNAPSHOT.war TOMCAT_PATH</pre>


<pre>$ </pre>
<pre>$ </pre>

