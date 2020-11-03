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
        assertTrue(kortti != null);
    }

    @Test
    public void saldoOikeinAlussa() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    
    @Test
    public void rahanOttaminenVahentaaSaldoaOikein() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuKunRahaaLiianVahan() {        
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void metodiPalauttaaFalseKunRahaEiRiita() {
        assertEquals(false, kortti.otaRahaa(20));
    }
    
    @Test
    public void metodiPalauttaaTrueKunrahaRiittaa () {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void saldoOnOikein() {
        assertEquals(10, kortti.saldo());
    }
}
