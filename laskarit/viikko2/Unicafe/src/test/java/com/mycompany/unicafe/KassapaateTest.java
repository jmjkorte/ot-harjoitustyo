
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    Kassapaate paate;
    Maksukortti riittava;
    Maksukortti riittamaton;
    @Before
    public void setUp() {
        paate = new Kassapaate();
        riittava = new Maksukortti(1000);
        riittamaton = new Maksukortti(100);
    }
    
    @Test
    public void kassanAlkuRahamaaraOikea(){
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void maukkaitaLounaitaMyytyAlussa0(){
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisiaLounaitaMyytyAlussa0(){
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void riittavaMaksuKasvattaaEdullisiaLounaita(){
        paate.syoEdullisesti(riittava);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }    

    @Test
    public void riittavaMaksuKasvattaaMaukkaitaLounaita(){
        paate.syoMaukkaasti(riittava);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
     @Test
    public void syoEdullisestiPalauttaaVaihtorahanOikein(){
        
        assertEquals(760, paate.syoEdullisesti(1000));
    }
    @Test
    public void syoMaukkaastiPalauttaaVaihtorahanOikein(){
        assertEquals(600, paate.syoMaukkaasti(1000));
    }
   
    @Test
    public void syoMaukkaastiKasvattaaKassanRahamaaraaOikein(){
        paate.syoMaukkaasti(10000);
        assertEquals(100400, paate.kassassaRahaa());
    }
     @Test
    public void syoEdullisestiKasvattaaKassanRahamaaraaOikein(){
        paate.syoEdullisesti(1000);
        assertEquals(100240, paate.kassassaRahaa());
    }
    
    @Test
    public void josEiTarpeeksiRahaaEdullisetLounaatEiLisaanny(){
        paate.syoEdullisesti(100);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void josEiTarpeeksiRahaaMaukkaatLounaatEiLisaanny(){
        paate.syoMaukkaasti(100);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josEiTarpeeksiRahaaKassanRahamaaraEiMuutuKunSyoEdullisesti(){
        paate.syoEdullisesti(100);
        assertEquals(100000, paate.kassassaRahaa());
    }
    @Test
    public void josEiTarpeeksiRahaaKassanRahamaaraEiMuutuKunSyoMaukkaasti(){
        paate.syoMaukkaasti(100);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void josEiTarpeeksiRahaaKaikkiPalautetaanKunSyoEdullisesti(){
        assertEquals(100, paate.syoEdullisesti(100));
    }
    
    @Test
    public void josEiTarpeeksiRahaaKaikkiPalautetaanKunSyoMaukkaasti(){
        assertEquals(100, paate.syoMaukkaasti(100));
    }
    
     @Test
    public void syoEdullisestiPalauttaaVaihtorahanOikeinKortille(){
        paate.syoEdullisesti(riittava);
        assertEquals(760, riittava.saldo());
    }
    @Test
    public void syoMaukkaastiPalauttaaVaihtorahanOikeinKortille(){
        paate.syoMaukkaasti(riittava);
        assertEquals(600, riittava.saldo());
    }
    
    @Test
    public void josKortillaTarpeeksiRahaaSyoMaukkaastiPalauttaaTrue(){
        assertEquals(true, paate.syoMaukkaasti(riittava));
    }
    
    @Test
    public void josKortillaTarpeeksiRahaaSyoEdullisestiPalauttaaTrue(){
        assertEquals(true, paate.syoEdullisesti(riittava));
    }
    
     @Test
    public void syoEdullisestiPalauttaaRahatKortilleJosEiTarpeeksiRahaa(){
        paate.syoEdullisesti(riittamaton);
        assertEquals(100, riittamaton.saldo());
    }
    @Test
    public void syoMaukkaastiPalauttaaRahatKortilleJosEiTarpeeksiRahaa(){
        paate.syoMaukkaasti(riittamaton);
        assertEquals(100, riittamaton.saldo());
    }
    
    @Test
    public void josKortillaTarpeeksiRahaaEdullistenLounaidenMaaraKasvaa(){
        paate.syoEdullisesti(riittava);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void josKortillaTarpeeksiRahaaMaukkaidenLounaidenMaaraKasvaa(){
        paate.syoMaukkaasti(riittava);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaRahatPalautetaanEdullisestaLounaasta(){
        paate.syoEdullisesti(riittamaton);
        assertEquals(100, riittamaton.saldo());
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaRahatPalautetaanMaukkaastaLounaasta(){
        paate.syoMaukkaasti(riittamaton);
        assertEquals(100, riittamaton.saldo());
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaEdullistenLounaidenMaaraEiMuutu(){
        paate.syoEdullisesti(riittamaton);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaMaukkaidenLounaidenMaaraEiMuutu(){
        paate.syoMaukkaasti(riittamaton);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaPalautetaanFalseEdullisistaLounaista(){
        assertEquals(false, paate.syoEdullisesti(riittamaton));
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaPalautetaanFalseMaukkaistaLounaista(){
        assertEquals(false, paate.syoMaukkaasti(riittamaton));
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaKassanRahamaaraEiMuutuEdullisistaLounaista(){
        paate.syoEdullisesti(riittamaton);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaKassanRahamaaraEiMuutuMaukkaistaLounaista(){
        paate.syoMaukkaasti(riittamaton);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattaessaKortinSaldoMuuttuu(){
        paate.lataaRahaaKortille(riittava, 1000);
        assertEquals(2000, riittava.saldo());
    }
    
    @Test
    public void kortilleLadattaessaKassanSaldoMuuttuu(){
        paate.lataaRahaaKortille(riittava, 1000);
        assertEquals(101000, paate.kassassaRahaa());
    }
    
    @Test
    public void kortilleEiVoiLadataNegatiivistaSummaa(){
        paate.lataaRahaaKortille(riittava, -1000);
        assertEquals(1000, riittava.saldo());
    }
}
