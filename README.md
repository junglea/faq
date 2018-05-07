# faq

## Project definition

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

You can use:

<pre>$ mvn clean install</pre>

or, if you want to use the latest Spring Boot with maven wrapper:

<pre>$ ./mvnw clean install</pre>

## Configure your application

MongoDB database porperties are defined in src/resources/application.properties


## How to test

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

### 3. Launch requests

Exemple of list:
<pre>
$ curl http://localhost:8080/api/faqs
</pre>

Exemple of create:
<pre>
$ curl -H "Content-Type: application/json" -X POST -d '{
      "question": "What is Spring Framework 5?",
      "answer": "Spring Framework 5 is a major version upgrade of the Spring Framework, several years in the making. It introduces a new non-blocking web framework called Spring WebFlux which uses Reactor to support the Reactive Streams API.",
      "tags": ["spring framework 5", "new", "API"]
  }' http://localhost:8080/api/faqs
</pre>

Exemple of create:
<pre>
$ curl -H "Content-Type: application/json" -X POST -d '{
    "question": "Does Spring Boot support Spring Framework 5?",
    "answer": "Yes, the Spring Boot 2.x line is built on Spring Framework 5.",
    "tags": ["Spring Boot", "Spring framework 5"]
}' http://localhost:8080/api/faqs
</pre>

Exemple of create:
<pre>
$ curl -H "Content-Type: application/json" -X POST -d '{
    "question": "Will Spring Framework 5 work with Java 6 or Java 7?",
    "answer": "No. Spring Framework 5 requires Java 8 or later. Please keep using Spring Framework 4.3 for Java 6/7 scenarios.",
    "tags": ["java", "Spring framework 5"]
}' http://localhost:8080/api/faqs
</pre>

Exemple of remove:
<pre>
$ curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/api/faqs/5af04025791e3d38dfca6797
</pre>


<pre>$ </pre>
<pre>$ </pre>