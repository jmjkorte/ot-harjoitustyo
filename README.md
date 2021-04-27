# Mielialapäiväkirja
Sovelluksen tarkoituksena on toimia apuvälineenä psykiatrisessa, terapeuttisessa työskentelyssä mielialahäiriöistä kärsiviä potilaita hoidettaessa. Mielialapäiväkirja tukee tavoitteellista terapeuttista työskentelyä. Potilas ja terapeutti määrittävät yhdessä mittarit / indikaattorit (esim. mieliala, aktiivisuus, nukkuminen), joita potilas seuraa päivittäin ja kirjaa tuloksen mielialapäiväkirjaan terapiakertojen välillä. Potilaan voinnin kehitystä seurataan terapiakäynneillä mielialapäiväkirjasta.

## Viikko 5

### Sovelluksen kehitystilanne
Sovellukseen voi kirjautua terapeuttina tai potilaana. Potilaita ja potilaiden mittareita on mahdollista luoda terapeutin roolilla. Potilas on myös mahdollista siirtää arkistoon ja arkistosta takaisin aktiiviseksi potilaaksi. Potilaat voivat tehdä ja tarkastella päiväkirjamerkintöjä. Sovelluksen käyttöliittymässä on paljon puutteita, mikäli käyttäjä antaa virheellisiä komentoja / pyydettyjä tietoja. Ääkkösiä ei kannata käyttää ainakaan toistaiseksi.

Sovelluksen käynnistyttyä on mahdollista kirjautua testiympäristöön. Tällöin sovellus generoi testausta varten yhden terapeuttikäyttäjän ja viisi potilasta, joiden käyttäjätunnukset ovat:
```
Terapeutti: test
Potilaat: kalle, urkki, manu, sale, tarja
```
Sovelluksen käyttöliittymää on refaktoroitu oleellisesti edellisestä viikosta. Yhdestä käyttöliittymäluokasta on muodostettu omat luokkansa terapeutin ja potilaan käyttöön. Näiden lisäksi on luotu luokka *UiInit*, jota kutsutaan sovelluksen käynnistyessä main-luokassa.

**HUOM!** Mittarin kriittisen arvon luominen ei toimi käyttöliittymätasolla toivotulla tavalla. Sovelluslogiikan puolella toiminto on kunnossa. 
**HUOM!** Jos kirjaudut ulos sovelluksesta, älä kirjaudu siihen toista kertaa testikäyttäjänä. Tämä luo tällä hetkellä samat käyttäjätunnukset toiseen kertaan.

Sovelluksen jatkokehityksen seuraava askel - puuttuvien toimintojen luonnin ohella - on tehdä siitä tietokantasovellus. Tämän vuoksi sovelluksessa on jo pakkaus *database*, joka tulee sisältämään tietokantatoimintoihin liittyvät luokat. Tämä kehitys on vasta suunnitteluvaiheessa, eikä toteutusta ole vielä tehty.


### Dokumentaatio

[Työaikakirjanpito](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)



### Komentorivitoiminnot

Sovelluksesta voi tehdä jar-tiedoston komennolla:
```
mvn package
```
Jar-tiedosto generoidaan *target* -kansioon ja on nimeltään 


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
