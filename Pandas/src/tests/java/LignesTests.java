import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LignesTests {
    /**
     * Function getElem tests
     * */
    @Test
    public void testAddElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        List<Colonnes> listColonnes = new ArrayList<>();
        listColonnes.add(colonnesInteger);
        Lignes lignes = new Lignes(0, listColonnes);

        lignes.addElem(3, "Integer");
        int numberIndex0 = (int) lignes.colonnes.get(0).getElem(0);
        lignes.addElem(5, "Integer");
        int numberIndex1 = (int) lignes.colonnes.get(0).getElem(0);
        assertEquals(5, numberIndex1);
    }

    @Test
    public void testAddMultipleElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        List<Colonnes> listColonnes = new ArrayList<>();
        listColonnes.add(colonnesInteger);
        Lignes line = new Lignes(0, listColonnes);
        Lignes line1 = new Lignes(1, listColonnes);
        line.addElem(3, "Integer");
        line.addElem(5, "Integer");
        int numberInLine = (int) line.colonnes.get(0).getElem(0);
        int size = line.colonnes.get(0).elems.size();
        assertEquals(5, numberInLine);
        assertEquals(1, size);
    }

    /**
     * Function removeElem tests
     * */
    @Test
    public void testRemoveElem() {
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        List<Colonnes> listColonnes = new ArrayList<>();
        listColonnes.add(colonnesInteger);
        Lignes line = new Lignes(0, listColonnes);
        Lignes line1 = new Lignes(1, listColonnes);

        line.addElem(0, "Integer");
        line1.addElem(1, "Integer");
        line.removeElem("Integer");
        //On vérifie que dans la ligne 1 nous avons toujours le nombre 1
        int numberInLine1 = (int) line1.colonnes.get(0).elems.get(1);
        assertEquals(1, numberInLine1);
    }

    /**
     * Function getElem tests
     * */
    @Test
    public void testGetElem(){
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        Colonnes<Integer> colonnesInteger2 = new Colonnes<>("Integer2");
        List<Colonnes> listColonnes = new ArrayList<>();
        listColonnes.add(colonnesInteger);
        listColonnes.add(colonnesInteger2);
        Lignes line = new Lignes(0, listColonnes);
        line.addElem(0, "Integer");
        line.addElem(2, "Integer2");
        int numberInLine = line.getElem("Integer");
        assertEquals(0, numberInLine);
        numberInLine = line.getElem("Integer2");
        assertEquals(2, numberInLine);
    }

    /**
     * Plusieurs colonnes ne peuvent pas avoir le meme nom
     * **/
    @Test(expected = Exception.class)
    public void testSameColumnName(){
        Colonnes<Integer> colonnesInteger = new Colonnes<>("Integer");
        Colonnes<Integer> colonnesInteger2 = new Colonnes<>("Integer");
        List<Colonnes> listColonnes = new ArrayList<>();
        listColonnes.add(colonnesInteger);
        listColonnes.add(colonnesInteger2);
        Lignes line = new Lignes(0, listColonnes);
    }
}

