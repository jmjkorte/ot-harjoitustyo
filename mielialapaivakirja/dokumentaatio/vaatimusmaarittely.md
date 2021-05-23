# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovelluksen tarkoituksena on toimia mielialahäiriöitä sairastavien potilaiden apuna osana terapeuttista työskentelyä. Sovelluksen avulla potilaat voivat pitää päiväkirjaa erillisistä, terapian tavoitteisiin liittyvistä asioista ja tapahtumista, kuten mielialastaan ja aktiivisuudestaan. Sovellukseen potilaan syöttämät tiedoilla on keskeinen asema terapiakäyntien aikaisessa työskentelyssä ja sovellus tukee näin ollen terapiaprosessia. 

Potilaan päiväkirjaan kirjaamat tiedot tallennetaan ja niiden avulla terapeutin ja potilaan on mahdollista tarkastella potilaan voinnin kehittymistä myös pitkällä aikavälillä.

Sovelluksen on tarkoitus tuottaa myös jossain määrin tilastollista tietoa terapeuttikäyttäjille potilaiden voinnista ja sen kehittymisestä.

Sovellus ohjelmoidaan Java-ohjelmointikielellä.

HUOM! Todellisuudessa vastaavan kaltaisen sovelluksen olisi otettava huomioon potilastietojen tietoturva. Tietoturvaa ei huomioida tässä harjoitussovelluksessa.

## Käyttäjät
Sovelluksella on kaksi käyttäjäroolia, *terapeutti* ja *potilas*. Terapeutin on mahdollista luoda potilaille käyttäjätunnus. Vain terapeutin tunnuksilla on mahdollista luoda potilaan päiväkirja ja siinä seurattavat asiat.

## Käyttöliittymä
Sovelluksessa on ensi vaiheessa tekstikäyttöliittymä, myöhemmin mahdollisessti graafinen käyttöliittymä. 

## Ensimmäisen version tarjoama toiminnallisuus
- [x] Tekstikäyttöliittymä sekä terapeutin että potilaan näkymiin perustoiminnallisuuksien osalta.

### Terapeutin näkymä
- [x] Terapeutti pystyy luomaan käyttäjätunnuksen potilaalle ja poistamaan käyttäjätunnuksen. Käyttäjätunnukseen yhdistetään potilaan henkilötiedot (Nimi, syntymäaika). *Potilasta ei voi poistaa, vaan siirtää arkistoon. Tämä vastaa todellista potilastietojärjestelmien .* 
- [x] Terapeutti pystyy luomaan potilaalle päiväkirjan. 
- [x] Terapeutti pystyy luomaan päiväkirjan mittarit. Alkuvaiheessa mittarit saavat arvoikseen kokonaislukuja. 
- [x] Terapeutti pystyy tulostamaan potilaan päiväkirjan näytölle. 
- [x] Järjestelmään kirjautuminenen ja uloskirjautuminen 

### Potilaan näkymä
- [x] Potilas pystyy kirjaamaan päiväkirjaan merkintöjä valittujen mittarien alle valitsemalleen päivälle.
- [x] Potilas pystyy tulostamaan päiväkirjan näytölle. 
- [x] Potilas pystyy muokkaamaan kirjauksiaan valitulle päivämäärälle.
- [x] Järjestelmään kirjautuminen ja uloskirjautuminen 

## Jatkokehitys
Ensimmäisen version tarjoamia toiminnallisuuksia laajennetaan. 
- [x] Tietojen tallennus tietokantaan ja lataus tietokannasta. *Indikaattorien ja potilaiden tallennus ja lataaminen onnistuu. *
### Terapeutin näkymä
- [ ] Mahdollisuus lisätä, poistaa tai muokata mittareita. *lisääminen tehty; muut ominaisuudet ei mukana tässä versiossa.*
- [ ] Mahdollisuus saada tilastotietoa potilaan tekemistä kirjauksista valitsemaltaan ajankohdalta tunnuslukujen (esim. mediaani, keskiarvo, minimi, maksimi...) perusteella. *Ominaisuus ei ole mukana tässä versiossa.*
- [x] Mahdollisuus asettaa tietyille mittareille *kriittinen arvo*, jonka alittuessa / ylittyessä sovellus kehottaa potilasta olemaan yhteydessä terapeuttiin tai lähettää potilaalle kannustusviestin.
- [ ] Mahdollisuus luoda laadullisia mittareita (String). *Ominaisuus ei ole mukana tässä versiossa.*
### Potilaan näkymä
- [x] Mahdollisuus tietojen tallentamiseen ja lataamiseen. *Indikaattorien tallennus ja lataaminen onnistuu *
- [x] Potilas saa viestin, mikäli *kriittinen arvo* alittuu / ylittyy.
- [ ] Potilas voi verrata mittarien kehitystä esim. viikkotasolla. *Ominaisuus ei ole mukana tässä versiossa.*
- [x] Automaattinen aikaleima kirjauksille. Kirjattaessa kyseiselle päivälle, ei potilaan tarvitse valita kirjausajankohtaa erikseen. *Erillistä aikaleimaa ei loda, mutta potilas voi tehdä merkinnän kirjauspäivälle antamatta erikseen päivämäärää.*

