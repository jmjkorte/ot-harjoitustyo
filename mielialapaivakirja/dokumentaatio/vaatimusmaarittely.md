# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovelluksen tarkoituksena on toimia mielialahäiriöitä sairastavien potilaiden apuna osana terapeuttista työskentelyä. Sovelluksen avulla potilaat voivat pitää päiväkirjaa erillisistä, terapian tavoitteisiin liittyvistä asioista ja tapahtumista, kuten mielialastaan ja aktiivisuudestaan. Sovellukseen potilaan syöttämät tiedoilla on keskeinen asema terapiakäyntien aikaisessa työskentelyssä. 

Potilaan päiväkirjaan kirjaamat tiedot tallennetaan ja niiden avulla terapeutin ja potilaan on mahdollista tarkastella potilaan voinnin kehittymistä myös pitkällä aikavälillä.

## Käyttäjät
Sovelluksella on kaksi käyttäjäroolia, *terapeutti* ja *potilas*. Terapeutin on mahdollista luoda potilaille käyttäjätunnus. Vain terapeutin tunnuksilla on mahdollista luoda potilaan päiväkirja ja siinä seurattavat asiat.

## Käyttöliittymä
Sovelluksessa on ensi vaiheessa tekstikäyttöliittymä.

## Ensimmäisen version tarjoama toiminnallisuus
### Terapeutin näkymä
- Terapeutti pystyy luomaan käyttäjätunnuksen potilaalle.
- Terapeutti pystyy luomaan potilaalle päiväkirjan.
- Terapeutti pystyy luomaan päiväkirjan mittarit. Alkuvaiheessa mittarit saavat arvoikseen kokonaislukuja.
- Terapeutti pystyy tulostamaan potilaan päiväkirjan.
- Käyttäjätunnuksen poistaminen
- Järjestelmään kirjautuminenen ja uloskirjautuminen

### Potilaan näkymä
- Potilas pystyy kirjaamaan päiväkirjaan merkintöjä valittujen mittarien alle valitsemalleen päivälle.
- Potilas pystyy tulostamaan päiväkirjan.
- Potilas pystyy muokkaamaan kirjauksiaan valitulle päivämäärälle.
- Järjestelmään kirjautuminenen ja uloskirjautuminen

## Jatkokehitys
Ensimmäisen version tarjoamia toiminnallisuuksia laajennetaan. 
- Tietojen tallennus tiedostoon / tietokantaan ja lataus tiedostosta / tietokannasta.
### Terapeutin näkymä
- Mahdollisuus lisätä, poistaa tai muokata mittareita.
- Mahdollisuus saada tilastotietoa potilaan tekemistä kirjauksista valitsemaltaan ajankohdalta tunnuslukujen (esim. mediaani, keskiarvo, minimi, maksimi...) perusteella.
- Mahdollisuus asettaa tietyille mittareille *kriittinen arvo*, jonka alittuessa / ylittyessä sovellus kehottaa potilasta olemaan yhteydessä terapeuttiin tai lähettää potilaalle kannustusviestin.
- Mahdollisuus luoda laadullisia mittareita (String).
### Potilaan näkymä
- Mahdollisuus tietojen tallentamiseen ja lataamiseen.
- Potilas saa viestin, mikäli *kriittinen arvo* alittuu / ylittyy.
- Potilas voi verrata mittarien kehitystä esim. viikkotasolla.
- Automaattinen aikaleima kirjauksille. Kirjattaessa kyseiselle päivälle, ei potilaan tarvitse valita kirjausajankohtaa erikseen.

