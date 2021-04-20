# Mielialapäiväkirja
Sovelluksen tarkoituksena on toimia apuvälineenä psykiatrisessa, terapeuttisessa työskentelyssä mielialahäiriöistä kärsiviä potilaita hoidettaessa. Mielialapäiväkirja tukee tavoitteellista terapeuttista työskentelyä. Potilas ja terapeutti määrittävät yhdessä mittarit / indikaattorit (esim. mieliala, aktiivisuus, nukkuminen), joita potilas seuraa päivittäin ja kirjaa tuloksen mielialapäiväkirjaan terapiakertojen välillä. Potilaan voinnin kehitystä seurataan terapiakäynneillä mielialapäiväkirjasta.

## Viikko 4

### Sovelluksen kehitystilanne
Sovellukseen on ohjelmoitu terapeutin näkymää käyttöliittymässä ja siihen liittyviä toiminnallisuuksia.Sovelluksen käynnistyttyä kysytään käyttäjätunnusta. Sovellus generoi testausta varten yhden terapeuttikäyttäjän ja viisi potilasta, joiden käyttäjätunnukset ovat:
```
Terapeutti: test
Potilaat: kalle, urkki, manu, sale, tarja
```
Oletusarvoisesti terapeutin käyttöliittymässä on valittu potilas *manu*.
Testipotilaiden ja terapeutin generointi tapahtuu luokan *PatientInformationSystem* metodilla *InitTestEnvironment*. Metodia kutsutaan saman luokan konstruktorissa rivillä 26. Tämä rivi tulee poistaa, mikäli testipotilaita ei haluta luoda. 
HUOM! Terapeutin luonti ei ole sovelluksessa vielä mahdollista, joten saman luokan riviä 24 ei tule poistaa!


### Dokumentaatio

[Työaikakirjanpito](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)



### Komentorivitoiminnot

Sovelluksen voi suorittaa sekä Netbeansissa että komentorivin kautta komennolla: 
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
