# Arkkitehtuurikuvaus

Sovelluksen pakkausrakenne on seuraavan kaltainen:

![image](https://yuml.me/jannek/7851cc75.jpg).

Sovelluksen käyttöliittymä on pakkauksessa [mielialapaivakirja.ui](https://github.com/jmjkorte/ot-harjoitustyo/tree/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui), sovelluslogiikka pakkauksessa [mielialapaivakirja.logics](https://github.com/jmjkorte/ot-harjoitustyo/tree/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/logics) ja tietokantatoiminnot pakkauksessa [mielialapaivakirja.database](https://github.com/jmjkorte/ot-harjoitustyo/tree/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/database).

## Sovelluslogiikka

![image](https://yuml.me/jannek/Logics.jpg)

Sovelluksen käynnistyessä luokka *Init* luo potilastietojärjestelmän kutsumalla *PatientInformationSystem*-luokan konstruktoria. Tämä luokka sisältää sovelluslogiikan kannalta olennaiset toiminnot potilaiden luontiin, arkistointiin ja potilastietojärjestelmän ylläpitoon. Potilas luodaan kutsumalla luokan *Patient* konstruktoria, joka luo potilaalle myös päiväkirjan kutsumalla luokan *Diary* konstruktoria. *Patient* -luokassa on toiminnallisuus potilaan henkilötietojen ylläpitoon.

*Diary*-luokka sisältää toiminnallisuuden indikaattorien ja päiväkirjamerkintöjen luomiseen ja käsittelyyn. Indicator-olio luodaan, kun Diary-olio kutsuu *Indicator*-luokan konstruktoria, Entry-olio vastaavasti kutsumalla *Entry*-luokan konstruktoria. 

## Käyttöliittymä

Käyttöliittymä koostuu kolmesta luokasta:
- [UiInit](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiInit.java)
- [UiTherapist](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiPatient.java)
- [UiPatient](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiPatient.java) 

Lisäksi käyttöliittymään kuuluu aputoiminnallisuuksia sisältävä luokku [UIHelper](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiHelper.java)

Sovelluksen käynnistyessä Main -luokka tekee uIInit -olion ja kutsuu kyseisen luokan metodia start(). UiInit -luokassa on kirjautumista koskevat toiminnallisuudet. Käyttäjän on mahdollista kirjautua terapeuttina tai potilaana ja tästä riippuen olio kutsuu joko luokkaa UiTherapist tai UiPatient. Terapeutin kirjautuminen onnistuu ilman käyttäjätunnusta, potilaan kirjautuminen vaatii oikean käyttäjätunnuksen antamisen.

## Tietokannan käyttö

Sovellus käyttää DAO -rajapintojen kautta SQL-tietokantaa. Tietokannan rakenne on seuraavanlainen: 
![image](https://yuml.me/jannek/4d4e180e.jpg)

Pakkauksessa on neljä luokkaa, joiden vastuulla on seuraavat toiminnallisuudet:
- [DatabaseCreator](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/database/DatabaseCreator.java) : Tietokannan ja tietokantataulujen luominen.
- [PatientDaoJDBC](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/database/PatientDaoJDBC.java) : 'Patients' -tauluun liittyvät toiminnallisuudet.
- [IndicatorDaoJDBC](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/database/IndicatorDaoJDBC.java) : 'Inidcators' -tauluun liittyvät toiminnallisuudet.
- [EntryDaoJDBC](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/database/EntryDaoJDBC.java) : 'Entries' -tauluun liittyvät toiminnallisuudet.

Sovelluksen käynnistyessä kaikki tietokannan tiedot haetaan ja tallennetaan tietorakenteisiin sovelluksen toiminnan ajaksi.
## Toimmallisuudet 

Seuraavassa on kuvattu toimminnallisuudet sekvenssikaavioin koskien uuden potilaan, indikaattorin ja päiväkirjamerkinnän luomista.

### Uuden potilaan luonti 

![https://www.websequencediagrams.com/cgi-bin/cdraw?lz=VWlUaGVyYXBpc3QtPiBQYXRpZW50SW5mb3JtYXRpb25TeXN0ZW06IGNyZWF0ZQAZByhzdXJuYW1lLCBmaXJzdAAFBmJvcm5EYXksIHVzZQAZBSkKADcYIABhCjogbmV3AHAIACkvIC0-IERpYXJ5AD8GAAYFKAARDQBoGTogcACBZQYAgQAkRGFvACYKCgo&s=default](https://user-images.githubusercontent.com/55651379/115962971-682c3500-a526-11eb-90c7-4c313d11e4fd.png)

### Indikaattorin luonti

![Indikaattorin luonti](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=VWlUaGVyYXBpc3QgLT4gRGlhcnk6IGNyZWF0ZUluZGljYXRvcihuYW1lLCBtaW5WYWx1ZSwgbWF4AAMHY3JpdGljYWwAEgdsb3dlck9ySGlnaGVyKQoASgUgLT4gAEIJOiBuZXcABQoAITkAgRMJIC0tPiAAgTAIAAwKAGgTRGFvAIFSCChzdXIAgU4GZmlyc3QAgVkGaQCBZwgpCgo&s=default)

### Päiväkirjamerkinnän luonti
![Päiväkirjamerkinnän luonti](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=VWlUaGVyYXBpc3QgLT4gRGlhcnk6IGNyZWF0ZUluZGljYXRvcihuYW1lLCBtaW5WYWx1ZSwgbWF4AAMHY3JpdGljYWwAEgdsb3dlck9ySGlnaGVyKQoASgUgLT4gAEIJOiBuZXcABQoAITkAgRMJIC0tPiAAgTAIAAwKAGgTRGFvAIFSCChzdXIAgU4GZmlyc3QAgVkGaQCBZwgpCgo&s=default)

### Muut toiminnallisuudet
Tärkeimpiä muita toiminnallisuuksia sovelluksessa ovat
* Päiväkirjamerkintöjen katselu
* Potilaan arkistointi
* Potilaan noutaminen arkistosta


### Heikkoudet
Sovelluksen nykyisessä versiossa on jäljellä paljon heikkouksia. Suurimmalta osin nämä koskevat luokkien välisiä riippuvuuksia.
- PatientInformatioSystem -luokassa on julkinen oliomuuttuja 'patient', jota myös sovelluslogiikkaluokat käyttävät. 
- Tietokantatoiminnallisuuksia voisi edelleen erottaa sovelluslogiikasta: esimerkiksi tietokantatiedosto on kovakoodattu, eikä käyttäjä voi sitä itse valita.
- Sovellus ei käytä konfiguraatiotiedostoja. Tämä mahdollistaisi esimerkiksi tunnusten luomisen terapeutille, joka ei sovelluksen nykyisessä versiossa ole mahdollista. 
