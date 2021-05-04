# Käyttöohje

## Lataaminen ja käynnnistäminen
Lataa tiedosto 
  ```
  ```
  Käynnistä tiedosto komennolla
  ```
  java -jar mielialapaivakirja.jar
  ```
  
  ## Kirjautuminen sovellukseen
  Sovelluksen käynnistyessä ensimmäistä kertaa se luo tietokantatiedoston *testdatabase.db*. Sovellus luo lisäksi testiterapeutin tunnuksen 'test' ja 4 testipotilasta
  'kalle', 'manu', 'urkki' ja 'sale'. Käyttäjätunnuksilla pääsee vastaavasti kirjautumaan terapeutin ja potilaan näkymiin. Terapeutin luonti ei ole tässä kehitysvaiheessa
  vielä mahdollista. 
  
  Jokaisen käynnistyskerran yhteydessä ladataan automaattisesti tietokanta sovelluksen käyttöön. Nykyisessä sovelluksen kehitysvaiheessa tietokantaan tallennetaan potilastiedot
  ja potilaiden indikaattorit, mutta ei päiväkirjamerkintöjä.
  
  **Huom!** Sovelluksen tämän hetkisessä versiossa on paljon bugeja ja sovellus saattaa kaatua käyttäjän virheellisiin syötteisiin.
  
  ## Terapeutin näkymä
  Terapeutin käyttöliittymä sisältää seuraavan valikon toiminnoista: \
  1 - Perusta potilas \
  2 - Arkistoi tai palauta potilas \
  3 - Tulosta potilaat \
  4 - Valitse potilas \
  5 - Luo indikaattori \
  6 - Tulosta kaikki indikaattorit \
  0 - Kirjaudu ulos \
  99 - Lopeta \
  
  Toimintoihin kirjaudutaan antamalla kyseisen rivin edessä oleva numero. Tämän jälkeen sovellus opastaa tarvittavien tietojen antamisessa. 
  Muutamia huomioita:
  - Ennen indikaattorien luomista pitää olla valittuna potilas toiminnolla *4 - Valitse potilas*. 
  - Terapian lopettaneet potilaat siirretään arkistoon toiminnolla *2 - Arkistoi tai palauta potilas*. Vastaavasti samalla komennolla voi siirtää arkistoidun potilaan
  jälleen aktiiviseksi. Tietokantatoiminnot eivät tue vielä potilaan arkistointia.
  - Sovelluksen käyttö edellyttää, että kahta saman nimistä potilasta ei luoda.
  - Potilasta ja potilaan indikaattoreita luodessa sovellus tallentaa tiedot automaattisesti myös tietokantaan.  
  
  ## Potilaan näkymä
  Potilaan käyttöliittymä sisältää seuraavan valikon toiminnoista: \
  1 - Tee kirjaus päiväkirjaan \
  2 - Tarkastele päiväkirjaa \
  3 - Tulosta päiväkirja \
  4 - Tulosta mittarit \
  0 - Kirjaudu ulos \
  99 - Lopeta \
  
  Toimintoihin kirjaudutaan samalla tavalla kuin terapeutin näkymässä. Kuten alussa on mainittu, päiväkirjamerkinnät eivät vielä tässä sovelluksen kehitysvaiheessa
  tallennu tietokantaan eivätkä ole näin ollen käytettävissä sovelluksen sulkemisen jälkeen.
  
  
