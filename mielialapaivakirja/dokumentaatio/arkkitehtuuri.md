# Arkkitehtuurikuvaus

Sovelluksen pakkausrakenne on seuraavan kaltainen:
![image](https://yuml.me/jannek/7851cc75.pdf).

Sovelluksen käyttöliittymä on pakkauksessa [mielialapaivakirja.ui], sovelluslogiikka pakkauksessa [mielialapaivakirja.logics] ja tietokantatoiminnot pakkauksessa [mielialapaivakirja.database].

## Luokkakaavio

![image](https://user-images.githubusercontent.com/55651379/115962831-d02e4b80-a525-11eb-838d-d63f65260dd4.png)

Luokkakaaviossa on kuvattu sekä käyttöliittymäluokkien että sovelluslogiikkaluokkien väliset yhteydet. Käyttöliittymäluokkien ja sovelluslogiikkaluokkien yhteydet on kuvattu katkoviivoin.

## Sekvenssikaavio

### Uuden potilaan luonti 

![Potilaan luonti](https://user-images.githubusercontent.com/55651379/115962971-682c3500-a526-11eb-90c7-4c313d11e4fd.png)

