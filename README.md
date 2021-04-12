# Ohjelmistotekniikka, harjoitustyö

## Viikko 3

### Sovelluksen kehitystilanne
Sovellukseen on ohjelmoitu terapeutin näkymää käyttöliittymässä ja siihen liittyviä toiminnallisuuksia. Sovelluksen käynnistyttyä kysytään käyttäjätunnusta, johon tulee kirjoittaa 'test'. Sovellus luo oletusarvoisesti muutamia testipotilaita, joille on merkitty myös syntymäaika. Sovelluksen toiminnalisuuksista toimii tällä hetkellä seuraavat:
1. Sisään- ja uloskirjautuminen
2. Uuden potilaan luominen. Uutta potilasta luotaessa tarkastetaan potilaan nimen ja syntymäajan kirjoitusasu. Etu- ja sukunimen kirjainten koon tarkastamiseen ja korjaamiseen käytetään ulkopuolisen kirjaston, Strmanin metodia. 
3. Kaikkien potilaiden tietojen listaus
4. Sovellukseen on luotu yksi testi, joka testaa Patient -luokan kostruktorin toimintaa. Testin voi ajaa komentorivin komennolla mvn test.
5. Testikattavuusraportin voi generoida komennolla mvn test jacoco:report
6. Sovelluksen voi ajaa sekä Netbeansissa että komentorivin kautta komennolla mvn compile exec:java -Dexec.mainClass=fi.mielialapaivakirja.main.Main
