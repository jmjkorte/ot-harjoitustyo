# Mielialapäiväkirja
Sovelluksen tarkoituksena on toimia apuvälineenä psykiatrisessa, terapeuttisessa työskentelyssä mielialahäiriöistä kärsiviä potilaita hoidettaessa. Mielialapäiväkirja tukee tavoitteellista terapeuttista työskentelyä. Potilas ja terapeutti määrittävät yhdessä mittarit / indikaattorit (esim. mieliala, aktiivisuus, nukkuminen), joita potilas seuraa päivittäin ja kirjaa tuloksen mielialapäiväkirjaan terapiakertojen välillä. Potilaan voinnin kehitystä seurataan terapiakäynneillä mielialapäiväkirjasta.

## Viikko 6

### Sovelluksen kehitystilanne
Sovellukseen voi kirjautua terapeuttina tai potilaana. Potilaita ja potilaiden mittareita on mahdollista luoda terapeutin roolilla. Potilas on myös mahdollista siirtää arkistoon ja arkistosta takaisin aktiiviseksi potilaaksi. Potilaat voivat tehdä ja tarkastella päiväkirjamerkintöjä. Sovelluksen käyttöliittymässä on paljon puutteita, mikäli käyttäjä antaa virheellisiä komentoja / pyydettyjä tietoja. Ääkkösiä ei kannata käyttää ainakaan toistaiseksi.

Viikon 6 kehittys on painottunut voimakkaasti tietokantatoiminnallisuuden lisäämiseen ja kehittämiseen. Tällä hetkellä onnistuu tietokannan luominen sekä potilastietojen ja indikaattorien tallennus ja lataaminen. Päiväkirjamerkintöjen tallentaminen / lataaminen ei vielä onnistu. Tietokantatoiminnallisuuksiin liittyvässä koodissa on vielä merkittävästi refaktoroitavaa. 

Terapeutin käyttöliittymää on hieman paranneltu, sovelluksen ei pitäisi kaatua niin monessa kohdassa kuin edellisellä viikolla. Kriittisen arvon asettaminen indikaattorille onnistuu, samoin 'hälytysviestin' välittäminen potilaalle, jos arvo alittuu / ylittyy.

Testejä ei ajan rajallisuuden vuoksi ole tällä viikolla lisätty. SQL-toiminnallisuuksien vuoksi kahden luokan testit (DiaryTest, PatientInformationSystemTest) on otettu väliaikaisesti pois käytöstä.  

Sovellus luo tässä vaiheessa kehitystä tietokannan luomisen yhteydessä sinne 4 testipotilasta ja testiterapeutin.


### Dokumentaatio

[Työaikakirjanpito](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/dokumentaatio/arkkitehtuuri.md)



### Komentorivitoiminnot

Sovelluksesta voi tehdä jar-tiedoston komennolla:
```
mvn package
```
Jar-tiedosto generoidaan *target* -kansioon ja sen voi suorittaa komennolla 
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
