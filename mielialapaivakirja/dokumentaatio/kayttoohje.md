# Käyttöohje

## Lataaminen ja käynnnistäminen
Lataa tiedosto 
  ```
  mielialapaivakirja_vko6.jar
  ```
  Käynnistä tiedosto komennolla
  ```
  java -jar mielialapaivakirja.jar
  ```
  
  ## Kirjautuminen sovellukseen
  Sovelluksen käynnistyessä ensimmäistä kertaa se luo tietokantatiedoston *database.db*. Uudessa tietokannassa ei ole yhtään potilasta, joten ensimmäisellä kerralla on     kirjauduttava sisään terapeuttina. Kirjautuminen ei vaadi käyttäjätunnusta. 
  
  Jokaisen käynnistyskerran yhteydessä ladataan automaattisesti tietokanta sovelluksen käyttöön. Tietokanta sisältää potilaiden henkilötiedot, mittarit ja päiväkirjamerkinnät..
  
 Sovelluksen käyttöliittymä sisältää kirjautumisnäkymän lisäksi terapautin ja potilaan näkymät.
  
  ## Terapeutin näkymä
  Terapeutin käyttöliittymä sisältää seuraavan valikon toiminnoista: \
  1 - Perusta potilas \
  2 - Arkistoi tai palauta potilas \
  3 - Tulosta potilaat \
  4 - Valitse potilas \
  5 - Luo mittari \
  6 - Tulosta kaikki mittarit \
  7 - Tulosta potilaan päiväkirja \
  0 - Kirjaudu ulos \
  99 - Lopeta 
  
  Toimintoihin kirjaudutaan antamalla kyseisen rivin edessä oleva numero. Tämän jälkeen sovellus opastaa tarvittavien tietojen antamisessa. 
  Muutamia huomioita:
  - Ennen indikaattorien luomista pitää olla valittuna potilas toiminnolla *4 - Valitse potilas*. 
  - Terapian lopettaneet potilaat siirretään arkistoon toiminnolla *2 - Arkistoi tai palauta potilas*. Vastaavasti samalla komennolla voi siirtää arkistoidun potilaan
  jälleen aktiiviseksi. 
  - Sovelluksen käyttö edellyttää, että kahdelle potilaalle ei luoda samaa käyttäjätunnusta.
  - Potilasta luotaessa sovellus antaa virheilmoituksen, mikäli päivämäärä, kuukausi tai vuosi on väärä.
  - Potilasta ja potilaan indikaattoreita luodessa sovellus tallentaa tiedot automaattisesti myös tietokantaan.  
  
  ## Potilaan näkymä
  Potilaan käyttöliittymä sisältää seuraavan valikon toiminnoista: \
  1 - Tee kirjaus päiväkirjaan \
  2 - Tarkastele päiväkirjaa \
  3 - Tulosta päiväkirja \
  4 - Tulosta mittarit \
  0 - Kirjaudu ulos \
  99 - Lopeta 
  
  Toimintoihin kirjaudutaan samalla tavalla kuin terapeutin näkymässä. Kuten alussa on mainittu, päiväkirjamerkinnät eivät vielä tässä sovelluksen kehitysvaiheessa
  tallennu tietokantaan eivätkä ole näin ollen käytettävissä sovelluksen sulkemisen jälkeen.
  
  
