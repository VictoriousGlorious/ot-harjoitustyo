package com.mycompany.unicafe;

import com.mycompany.unicafe.Kassapaate;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void kassapaateLuotuOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullinenLounasKateismaksullaToimii() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(60, kassa.syoEdullisesti(300));

    }

    @Test
    public void myydytEdullisetLounaatKasvavat() {
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukasLounasKateismaksullaToimii() {
        kassa.syoMaukkaasti(600);
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(200, kassa.syoMaukkaasti(600));

    }

    @Test
    public void myydytMaukkaatLounaatKasvavat() {
        kassa.syoMaukkaasti(600);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void riittamatonMaksuPalautuu() {
        assertEquals(180, kassa.syoEdullisesti(180));
        assertEquals(240, kassa.syoMaukkaasti(240));
    }

    @Test
    public void syoEdullisestiKortillaToimii() {
        kassa.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
        assertEquals(true, kassa.syoEdullisesti(kortti));
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiKortillaToimii() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
        assertEquals(true, kassa.syoMaukkaasti(kortti));
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortillaLiianVahanRahaa() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(false, kassa.syoEdullisesti(kortti));
        assertEquals(false, kassa.syoMaukkaasti(kortti));
        assertEquals(200, kortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());

    }
    
    @Test
    public void kassanSaldoOikeinKortillaMaksettaessa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahanLatausKortilleToimii() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(100500, kassa.kassassaRahaa());
    }
    
    @Test
    public void negatiivistaSummaaEiVoidaLadataKortille () {
        kassa.lataaRahaaKortille(kortti, -500);
        assertEquals(100000, kassa.kassassaRahaa());
    }

}
