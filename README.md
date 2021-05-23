# Mielialapäiväkirja
Sovelluksen tarkoituksena on toimia apuvälineenä psykiatrisessa, terapeuttisessa työskentelyssä mielialahäiriöistä kärsiviä potilaita hoidettaessa. Mielialapäiväkirja tukee tavoitteellista terapeuttista työskentelyä. Potilas ja terapeutti määrittävät yhdessä mittarit / indikaattorit (esim. mieliala, aktiivisuus, nukkuminen), joita potilas seuraa päivittäin ja kirjaa tuloksen mielialapäiväkirjaan terapiakertojen välillä. Potilaan voinnin kehitystä seurataan terapiakäynneillä mielialapäiväkirjasta.


## Sovelluksen kehitystilanne
Sovellukseen voi kirjautua terapeuttina tai potilaana. Potilaita ja potilaiden mittareita on mahdollista luoda terapeutin roolilla. Potilas on myös mahdollista siirtää arkistoon ja arkistosta takaisin aktiiviseksi potilaaksi. Potilaat voivat tehdä ja tarkastella päiväkirjamerkintöjä. Sovelluksen käyttöliittymässä on paljon puutteita, mikäli käyttäjä antaa virheellisiä komentoja / pyydettyjä tietoja. Ääkkösiä ei kannata käyttää. 

**HUOM! Sovelluksesta puuttuu ominaisuus, joka estäisi kahden identtisen käyttäjätunnuksen luomisen, joten käytä potilailla erillisiä käyttäjätunnuksia.**


Sovellusta ei kyetty aikarajojen puitteissa saattamaan täysin vaatimusmäärittelyn tasolle. Mikäli sovellusta tullaan kehittämään jatkossa, vaatimusmäärittelyssä mainittujen ominaisuuksien lisäksi oleellisinta on graafisen käyttöliittymän luominen. Sovelluksen testaus on jäänyt liian vähälle huomiolle. 




## Dokumentaatio

[Työaikakirjanpito](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/testaus.md) 

### Komentorivitoiminnot

Sovelluksesta voi tehdä jar-tiedoston komennolla:
```
mvn package
```
Jar-tiedosto generoidaan *target* -kansioon ja sen voi suorittaa komennolla: 
```
java -jar Mielialapaivakirja-1.0-SNAPSHOT.jar
```


Sovelluksen voi myös suorittaa sekä Netbeansissa että komentorivin kautta komennolla: 
```
mvn compile exec:java -Dexec.mainClass=fi.mielialapaivakirja.main.Main
```


#### Testaus
Testit suoritetaan komennolla:
```
mvn test
```
Testikattavuusraportti luodaan komennolla:
```
mvn test jacoco:report
``` 
#### Checkstyle
Tiedostossa [checkstyle.xml](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/checkstyle.xml) määritellyt tarkistukset suoritetaan komennolla:
```
mvn jxr:jxr checkstyle:checkstyle
```

#### JavaDoc
JavaDoc on generoitavissa komennolla:
```
mvn javadoc:javadoc
```
