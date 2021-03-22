package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test 
    public void saldoAlussaOikein(){
       assertEquals("saldo: 0.10", kortti.toString()); 
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 10.10", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinJosRahaaTarpeeksi(){
        kortti.lataaRahaa(1000);
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.10", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi(){
        kortti.otaRahaa(200);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void trueJosRahatRiittaa(){
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void falseJosRajatEiRiita(){
        assertFalse(kortti.otaRahaa(11));
    }
    
    @Test
    public void saldoPalauttaaSaldonOikein(){
        assertEquals(10, kortti.saldo());
    }
}
