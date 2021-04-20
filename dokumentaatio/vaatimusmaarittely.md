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
- Tekstikäyttöliittymä sekä terapeutin että potilaan näkymiin perustoiminnallisuuksien osalta.

### Terapeutin näkymä
[x] Terapeutti pystyy luomaan käyttäjätunnuksen potilaalle ja poistamaan käyttäjätunnuksen. Käyttäjätunnukseen yhdistetään potilaan henkilötiedot (Nimi, syntymäaika) 
[] Terapeutti pystyy luomaan potilaalle päiväkirjan. 
[] Terapeutti pystyy luomaan päiväkirjan mittarit. Alkuvaiheessa mittarit saavat arvoikseen kokonaislukuja. **tehty**
[] Terapeutti pystyy tulostamaan potilaan päiväkirjan näytölle. **tehty**
[] Järjestelmään kirjautuminenen ja uloskirjautuminen *tehty*

### Potilaan näkymä
- Potilas pystyy kirjaamaan päiväkirjaan merkintöjä valittujen mittarien alle valitsemalleen päivälle. *tehty*
- Potilas pystyy tulostamaan päiväkirjan näytölle. *tehty*
- Potilas pystyy muokkaamaan kirjauksiaan valitulle päivämäärälle.
- Järjestelmään kirjautuminenen ja uloskirjautuminen *tehty*

## Jatkokehitys
Ensimmäisen version tarjoamia toiminnallisuuksia laajennetaan. 
- Tietojen tallennus tiedostoon / tietokantaan ja lataus tiedostosta / tietokannasta.
### Terapeutin näkymä
- Mahdollisuus lisätä, poistaa tai muokata mittareita. *lisääminen tehty*
- Mahdollisuus saada tilastotietoa potilaan tekemistä kirjauksista valitsemaltaan ajankohdalta tunnuslukujen (esim. mediaani, keskiarvo, minimi, maksimi...) perusteella.
- Mahdollisuus asettaa tietyille mittareille *kriittinen arvo*, jonka alittuessa / ylittyessä sovellus kehottaa potilasta olemaan yhteydessä terapeuttiin tai lähettää potilaalle kannustusviestin.
- Mahdollisuus luoda laadullisia mittareita (String).
### Potilaan näkymä
- Mahdollisuus tietojen tallentamiseen ja lataamiseen.
- Potilas saa viestin, mikäli *kriittinen arvo* alittuu / ylittyy.
- Potilas voi verrata mittarien kehitystä esim. viikkotasolla.
- Automaattinen aikaleima kirjauksille. Kirjattaessa kyseiselle päivälle, ei potilaan tarvitse valita kirjausajankohtaa erikseen. *tehty*

