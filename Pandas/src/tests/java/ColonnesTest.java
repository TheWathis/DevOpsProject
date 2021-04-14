import org.junit.Test;

import static org.junit.Assert.*;

public class ColonnesTest {
    /***
     * Tests sur la foonction addElem
     * */
    @Test
    public void testAddElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(0, 2);
        int numberIndex0 = colonnesInteger.elems.get(0);
        assertEquals(2, numberIndex0);
    }

    @Test
    public void testAddMultipleElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(0, 2);
        colonnesInteger.addElem(0, 1);
        int numberIndex0 = colonnesInteger.elems.get(0);
        int numberIndex1 = colonnesInteger.elems.get(1);
        assertEquals(1, numberIndex0);
        assertEquals(2, numberIndex1);
    }

    @Test
    public void testAddEndElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(0, 2);
        colonnesInteger.addElem(1, 1);
        int numberIndex0 = colonnesInteger.elems.get(0);
        int numberIndex1 = colonnesInteger.elems.get(1);
        assertEquals(2, numberIndex0);
        assertEquals(1, numberIndex1);
    }

    @Test
    public void testAddElemOutOfBound() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(3, 2);
        int numberIndex0 = colonnesInteger.elems.get(3);
        assertEquals(2, numberIndex0);
    }

    /**
     * Tests sur la fonction removeElem
     * */
    @Test
    public void testRemoveElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(0, 2);
        colonnesInteger.addElem(0, 1);
        int numberIndex0 = colonnesInteger.removeElem(0);
        int numberIndex1 = colonnesInteger.removeElem(0);
        assertEquals(1, numberIndex0);
        assertEquals(2, numberIndex1);
    }

    @Test
    public void testRemoveElemOutOfBound() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(0, 2);
        colonnesInteger.addElem(0, 1);
        int numberIndex0 = colonnesInteger.removeElem(3);
        int numberIndex1 = colonnesInteger.removeElem(0);
        assertEquals(1, numberIndex0);
        assertEquals(2, numberIndex1);
    }

    /**
     * Tests sur la fonction sameLabel
     * */
    @Test
    public void testSameLabel() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        Colonnes<Integer> colonnesInteger2 = new Colonnes<>("Integer2");
        assertFalse(colonnesInteger.sameLabel("Integer2"));
        assertTrue(colonnesInteger2.sameLabel("Integer2"));
    }

    /**
     * Tests sur la fonction getElem
     * */
    @Test
    public void testGetElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(0, 2);
        colonnesInteger.addElem(0, 1);
        int numberIndex0 = colonnesInteger.getElem(0);
        int numberIndex1 = colonnesInteger.getElem(1);
        assertEquals(1, numberIndex0);
        assertEquals(2, numberIndex1);
    }

    @Test
    public void testGetElemOutOfBound() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        colonnesInteger.addElem(0, 2);
        colonnesInteger.addElem(0, 1);
        int numberIndex0 = colonnesInteger.getElem(3);
        int numberIndex1 = colonnesInteger.getElem(1);
        assertEquals(1, numberIndex0);
        assertEquals(2, numberIndex1);
    }
}
