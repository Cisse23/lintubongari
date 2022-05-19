Tämä harjoitustyö on toteutettu osana Haaga-Helian Ohjelmointi 2 -kurssia.
Harjoitustyön tavoitteena oli luoda yksinkertainen verkkosovellus joka
-käsittelee käyttäjältä saatua dataa servlettien avulla ja välittää datan servletiltä käyttöliittymälle.
-käyttää eriytettyä tietokantakerrosta datan hakemiseen, lisäämiseen ja poistamiseen turvallisilla kyselyillä
-muodostaa HTML-sivut dynaamisesti JSP-teknologialla ja käsittelee dataa JSP-sivuilla JSTL-kirjaston avulla

Harjoitustyön aiheena on tietokantapohjainen verkkosivu, jolle voidaan kirjata bongattuja lintuja.
kurssin oppimistavoitteissa ja tehtävän arvioinnissa tyyleillä ei ole painoarvoa.

Projektin pohjana on käytetty: https://github.com/ohjelmointi2/embedded-tomcat-template

Lintubongari:
http://localhost:8080/lintubongari


## Projektin tiedostot

Projekti noudattaa seuraavaa hakemistorakennetta:

```tree
embedded-tomcat
│   pom.xml
│   README.md
│
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───database
│   │   │   │       BongattuLintuDAO.java
│   │   │   │       Database.java
│   │   │   │       JDBCBongattuLintu.java
│   │   │   │
│   │   │   ├───launch
│   │   │   │       Main.java
│   │   │   │
│   │   │   ├───model
│   │   │   │       BongattuLintu.java
│   │   │   │
│   │   │   └───servlet
│   │   │           AddBongattuLintuServlet.java
│   │   │           DeleteBongattuLintuServlet.java
│   │   │           IndexServlet.java
│   │   │
│   │   ├───resources
│   │   └───webapp
│   │       ├───styles
│   │       │       demo.css
│   │       │
│   │       └───WEB-INF
│   │               index.jsp
│   │
│   └───test
│       ├───java
│       │   ├───servlet
│       │   │       IndexServletTest.java
│       │   │
│       │   └───testserver
│       │           TestServer.java
│       │
│       └───resources
```

Sijainti                                | Tarkoitus
----------------------------------------|---------------------
[README.md](README.md)                                                  | Tämä tiedosto
[pom.xml](pom.xml)                                                      | "[Project Object Model](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)"-tiedosto mm. riippuvuuksien määrittelemiseksi
[src/main/java](src/main/java)                                          | Java-pakettien juurihakemisto
[src/main/resources](src/main/resources)                                | Hakemisto esimerkiksi .properties-tiedostoille
[src/main/java/database/BongattuLintuDAO.java](src/main/java/database/BongattuLintuDAO.java)  | Rajapinta, määrittelee metodit, jotka sen toteuttavien luokkien on toteutettava samoilla parametriarvoilla ja paluuarvoilla
[src/main/java/database/Database.java](src/main/java/database/Database.java)  | luokka yhteyden luomiseksi tietokantaan
[src/main/java/database/JDBCBongattuLintu.java](src/main/java/database/JDBCBongattuLintu.java)  | JDBC-teknologiaa hyödyntävä luokka, joka toteuttaa BongattuLintuDAO-rajapinnan
[src/main/java/launch/Main.java](src/main/java/launch/Main.java)        | Luokka Tomcat-palvelimen käynnistämiseksi
[src/main/java/servlet/IndexServlet.java](src/main/java/servlet/IndexServlet.java) | Esimerkki HTTP-liikennettä tukevasta Java-luokasta
[src/main/webapp](src/main/webapp)                                      | Hakemisto staattisille tiedostoille (css, kuvat, JS)
[src/main/webapp/WEB-INF](src/main/webapp/WEB-INF)                      | Erityinen hakemisto, jonne on estetty suora pääsy selaimilta ¹
[src/main/webapp/WEB-INF/index.jsp](src/main/webapp/WEB-INF/index.jsp)  | IndexServlet-luokan käyttämä sivupohja
[src/test/java](src/test/java)                                          | JUnit-testiluokkien pakettien juurihakemisto
[src/test/java/servlet/IndexServletTest.java](src/test/java/servlet/IndexServletTest.java)  | IndexServlet-luokan JUnit-testit
[src/test/java/testserver/TestServer.java](src/test/java/testserver/TestServer.java)  | Apuluokka palvelimen testaamiseksi
[src/test/resources](src/test/resources)                                | Hakemisto esimerkiksi testien .properties-tiedostoille

¹ "No file contained in the WEB-INF directory may be served directly to a client by the container. However, the contents of the WEB-INF directory are visible to servlet code..." [Java Servlet Specification Version 2.4](http://download.oracle.com/otn-pub/jcp/servlet-2.4-fr-spec-oth-JSpec/servlet-2_4-fr-spec.pdf)


## Tietokanta

Tietokanta: lintuBongari.db

Tietokannan luonti:
CREATE TABLE "bongattu_lintu" (
	"id"	INTEGER,
	"laji"	TEXT,
	"paikka"	TEXT,
	"pvm"	TEXT,
	PRIMARY KEY("id")
)

SQL esimerkkilauseet:

SELECT * FROM bongattu_lintu;

INSERT INTO bongattu_lintu (laji, paikka, pvm)
VALUES ('Varpunen', 'Etupiha', '24.12.2021');

DELETE FROM bongattu_lintu
WHERE id = 6;
