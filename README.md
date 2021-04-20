# Mielialapäiväkirja
Sovelluksen tarkoituksena on toimia apuvälineenä psykiatrisessa, terapeuttisessa työskentelyssä mielialahäiriöistä kärsiviä potilaita hoidettaessa. Mielialapäiväkirja tukee tavoitteellista terapeuttista työskentelyä. Potilas ja terapeutti määrittävät yhdessä mittarit / indikaattorit (esim. mieliala, aktiivisuus, nukkuminen), joita potilas seuraa päivittäin ja kirjaa tuloksen mielialapäiväkirjaan terapiakertojen välillä. Potilaan voinnin kehitystä seurataan terapiakäynneillä mielialapäiväkirjasta.

## Viikko 4

### Sovelluksen kehitystilanne
Sovellukseen on ohjelmoitu terapeutin näkymää käyttöliittymässä ja siihen liittyviä toiminnallisuuksia.**Sovelluksen käynnistyttyä kysytään käyttäjätunnusta, johon tulee kirjoittaa *test*.** Sovellus luo oletusarvoisesti muutamia testipotilaita, joille on merkitty myös syntymäaika. Sovelluksen toiminnalisuuksista toimii tällä hetkellä seuraavat:
1. Sisään- ja uloskirjautuminen
2. Uuden potilaan luominen. Uutta potilasta luotaessa tarkastetaan potilaan nimen ja syntymäajan kirjoitusasu. Etu- ja sukunimen kirjainten koon tarkastamiseen ja korjaamiseen käytetään ulkopuolisen kirjaston, Strmanin metodia. 
3. Kaikkien potilaiden tietojen listaus
4. Mittarin luominen ja mittareiden tulostaminen


### Dokumentaatio

[Työaikakirjanpito](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)



### Komentorivitoiminnot

Sovelluksen voi suorittaa sekä Netbeansissa että komentorivin kautta komennolla 
```
mvn compile exec:java -Dexec.mainClass=fi.mielialapaivakirja.main.Main
```
Testit suoritetaan komennolla
```
mvn test
```
Testikattavuusraportti luodaan komennolla
```
mvn test jacoco:report
``` 
