package edu.teamrocket.dispatchers;
import org.junit.jupiter.api.Test;

import edu.teamrocket.payment.CreditCard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class CrystalExpenderTest {

    private CrystalExpender expender = null;

    @BeforeEach
    public void setupExpender() {
        expender = new CrystalExpender(100, 50.0);
        assertNotNull(expender, "Expender creado");
    }

    @Test 
    public void constructortest() {  
        assertNotNull(expender, "Expender creado");      
        assertEquals(100, expender.stock());
    }

    @Test
    public void dispatchTestOK() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender.dispatch(card);
        assertEquals(99, expender.stock());
    }

    @Test
    public void dispatchTestNoStock() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender = new CrystalExpender(0, 50.0);
        expender.dispatch(card);
        assertEquals(0, expender.stock());
        assertEquals(3000, card.credit(), 0);
    }

    @Test
    public void dispatchTestNoCredit() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender = new CrystalExpender(100, 4000);
        expender.dispatch(card);
        assertEquals(100, expender.stock());
    }
}