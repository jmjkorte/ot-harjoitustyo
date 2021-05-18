# Arkkitehtuurikuvaus

Sovelluksen pakkausrakenne on seuraavan kaltainen:

![image](https://yuml.me/jannek/7851cc75.jpg).

Sovelluksen käyttöliittymä on pakkauksessa [mielialapaivakirja.ui](https://github.com/jmjkorte/ot-harjoitustyo/tree/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui), sovelluslogiikka pakkauksessa [mielialapaivakirja.logics](https://github.com/jmjkorte/ot-harjoitustyo/tree/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/logics) ja tietokantatoiminnot pakkauksessa [mielialapaivakirja.database](https://github.com/jmjkorte/ot-harjoitustyo/tree/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/database).

## Sovelluslogiikka

![image](https://yuml.me/jannek/Logics.jpg)

Sovelluksen käynnistyessä luokka *Init* luo potilastietojärjestelmän kutsumalla *PatientInformationSystem*-luokan konstruktoria. Tämä luokka sisältää sovelluslogiikan kannalta olennaiset toiminnot potilaiden luontiin, arkistointiin ja potilastietojärjestelmän ylläpitoon.  Potilas luodaan kutsumalla luokan *Patient* konstruktoria, joka luo potilaalle myös päiväkirjan kutsumalla luokan *Diary* konstruktoria. *Patient* -luokassa on toiminnallisuus potilaan henkilötietojen ylläpitoon.

*Diary*-luokka sisältää toiminnallisuuden indikaattorien ja päiväkirjamerkintöjen luomiseen ja käsittelyyn. Indicator-olio luodaan, kun Diary-olio kutsuu *Indicator*-luokan konstruktoria, Entry-olio vastaavasti kutsumalla *Entry*-luokan konstruktoria. 

## Käyttöliittymä

Käyttöliittymä koostuu kolmesta luokasta:
- [UiInit](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiInit.java)
- [UiTherapist](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiPatient.java)
- [UiPatient](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiPatient.java) 

Lisäksi käyttöliittymään kuuluu aputoiminnallisuuksia sisältävä luokku [UIHelper](https://github.com/jmjkorte/ot-harjoitustyo/blob/master/mielialapaivakirja/src/main/java/fi/mielialapaivakirja/ui/UiHelper.java)

Sovelluksen käynnistyessä Main -luokka tekee uIInit -olion ja kutsuu kyseisen luokan metodia start(). UiInit -luokassa on kirjautumista koskevat toiminnallisuudet. Käyttäjän on mahdollista kirjautua terapeuttina tai potilaana ja tästä riippuen olio kutsuu joko luokkaa UiTherapist tai UiPatient. Terapeutin kirjautuminen onnistuu ilman käyttäjätunnusta, potilaan kirjautuminen vaatii oikean käyttäjätunnuksen antamisen.

## Tietojen tallennus tietokantaan

Sovellus käyttää DAO -rajapintojen kautta SQL-tietokantaa. Tietokannan rakenne on seuraavanlainen:

## Sekvenssikaavio

### Uuden potilaan luonti 

![Potilaan luonti](https://user-images.githubusercontent.com/55651379/115962971-682c3500-a526-11eb-90c7-4c313d11e4fd.png)

