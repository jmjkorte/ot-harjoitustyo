# Arkkitehtuurikuvaus

Sovelluksen pakkausrakenne on seuraavan kaltainen:

![image](https://yuml.me/jannek/7851cc75.jpg).

Sovelluksen käyttöliittymä on pakkauksessa [mielialapaivakirja.ui], sovelluslogiikka pakkauksessa [mielialapaivakirja.logics] ja tietokantatoiminnot pakkauksessa [mielialapaivakirja.database].

## Sovelluslogiikka

![image]https://yuml.me/jannek/Logics.jpg

Sovelluksen käynnistyessä luokka *Init* luo potilastietojärjestelmän tekemällä *PatientInformationSystem*-olion kutsumalla viimeksi mainitun luokan konstruktoria. Tämä luokka sisältää sovelluslogiikan kannalta olennaiset toiminnot potilaiden luontiin ja potilastietojärjestelmän ylläpitoon. Potilas luodaan kutsumalla luokan *Patient* konstruktoria, joka luo potilaalle myös päiväkirjan kutsumalla luokan *Diary* konstruktoria. *Patient* -luokassa on metodit patient-olion henkilötietojen ylläpitoon.

*Diary*-luokka sisältää toiminnallisuuden indikaattorien ja päiväkirjamerkintöjen luomiseen ja käsittelyyn. Indicator-olio luodaan Diary-olion kutsuessa *Indicator*-luokan konstruktoria, Entry-olio vastaavasti kutsumalla *Entry*-luokan konstruktoria.

## Sekvenssikaavio

### Uuden potilaan luonti 

![Potilaan luonti](https://user-images.githubusercontent.com/55651379/115962971-682c3500-a526-11eb-90c7-4c313d11e4fd.png)

