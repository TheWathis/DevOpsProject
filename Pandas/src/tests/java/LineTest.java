package pandas;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LineTest {

    /**
     * Tests for function add element.
     * */
    @Test
    public void testAddElementInLine() {
        Line l = new Line();
        Element e = new Element("Test");
        l.add(e);
        assertEquals("Test", l.getElements().get(0).getData());
    }

    @Test
    public void testAddMultipleElementInLine() {
        Line l = new Line();
        Element e = new Element("Test");
        l.add(e);
        Element e2 = new Element("Test2");
        l.add(e2);
        assertEquals("Test", l.getElements().get(0).getData());
        assertEquals("Test2", l.getElements().get(1).getData());
    }

    /**
     * Tests for function get sub line with index.
     * */
    @Test
    public void testGetSubColumnFromNumber() throws ExceptionWrongIndex {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element(0));
        listOfElement.add(new Element(1));
        listOfElement.add(new Element(2));
        listOfElement.add(new Element(3));
        Line l = new Line(0, listOfElement);
        ArrayList<Integer> indexOfColumn = new ArrayList<>();
        indexOfColumn.add(0);
        indexOfColumn.add(1);
        indexOfColumn.add(2);
        indexOfColumn.add(3);
        Line l2 = l.getSubLineFromColumnNumber(indexOfColumn);
        ArrayList<Element> l1List = l.getElements();
        ArrayList<Element> l2List = l2.getElements();
        boolean assertBoolean = true;
        for(int i = 0; i < l1List.size(); i++){
            if(l1List.get(i).getData() != l2List.get(i).getData()){
                assertBoolean = false;
                break;
            }
        }
        assertEquals(true, assertBoolean);
    }

    @Test
    public void testGetSubColumnFromNumberOnlyFirstColumn() throws ExceptionWrongIndex {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element(0));
        listOfElement.add(new Element(1));
        listOfElement.add(new Element(2));
        listOfElement.add(new Element(3));
        Line l = new Line(0, listOfElement);
        ArrayList<Integer> indexOfColumn = new ArrayList<>();
        indexOfColumn.add(0);
        Line l2 = l.getSubLineFromColumnNumber(indexOfColumn);
        ArrayList<Element> l1List = l.getElements();
        ArrayList<Element> l2List = l2.getElements();
        boolean assertBoolean = true;
        if(l1List.get(0).getData() != l2List.get(0).getData() || l2List.size() != 1 ){
            assertBoolean = false;
        }
        assertEquals(true, assertBoolean);
    }

    @Test
    public void testGetSubColumnFromNumberOnlyLastColumn() throws ExceptionWrongIndex {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element(0));
        listOfElement.add(new Element(1));
        listOfElement.add(new Element(2));
        listOfElement.add(new Element(3));
        Line l = new Line(0, listOfElement);
        ArrayList<Integer> indexOfColumn = new ArrayList<>();
        indexOfColumn.add(3);
        Line l2 = l.getSubLineFromColumnNumber(indexOfColumn);
        ArrayList<Element> l1List = l.getElements();
        ArrayList<Element> l2List = l2.getElements();
        boolean assertBoolean = true;
        if(l1List.get(3).getData() != l2List.get(0).getData() || l2List.size() != 1 ){
            assertBoolean = false;
        }
        assertEquals(true, assertBoolean);
    }

    @Test
    public void testGetSubColumnFromNumberMultipleElement() throws ExceptionWrongIndex {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element(0));
        listOfElement.add(new Element(1));
        listOfElement.add(new Element(2));
        listOfElement.add(new Element(3));
        Line l = new Line(0, listOfElement);
        ArrayList<Integer> indexOfColumn = new ArrayList<>();
        indexOfColumn.add(1);
        indexOfColumn.add(3);
        Line l2 = l.getSubLineFromColumnNumber(indexOfColumn);
        ArrayList<Element> l1List = l.getElements();
        ArrayList<Element> l2List = l2.getElements();
        boolean assertBoolean = true;
        if(l1List.get(3).getData() != l2List.get(1).getData()
                || l1List.get(1).getData() != l2List.get(0).getData()
                || l2List.size() != 2 ){
            assertBoolean = false;
        }
        assertEquals(true, assertBoolean);
    }

    @Test
    public void testGetSubColumnFromNumberMultipleUnorderedElement() throws ExceptionWrongIndex {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element(0));
        listOfElement.add(new Element(1));
        listOfElement.add(new Element(2));
        listOfElement.add(new Element(3));
        Line l = new Line(0, listOfElement);
        ArrayList<Integer> indexOfColumn = new ArrayList<>();
        indexOfColumn.add(3);
        indexOfColumn.add(1);

        Line l2 = l.getSubLineFromColumnNumber(indexOfColumn);
        ArrayList<Element> l1List = l.getElements();
        ArrayList<Element> l2List = l2.getElements();
        boolean assertBoolean = true;
        if(l1List.get(3).getData() != l2List.get(0).getData()
                || l1List.get(1).getData() != l2List.get(1).getData()
                || l2List.size() != 2 ){
            assertBoolean = false;
        }
        assertEquals(true, assertBoolean);
    }

    @Test
    public void testGetSubColumnFromNumberSameColumnMultipleTime() throws ExceptionWrongIndex {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element(0));
        listOfElement.add(new Element(1));
        listOfElement.add(new Element(2));
        listOfElement.add(new Element(3));
        Line l = new Line(0, listOfElement);
        ArrayList<Integer> indexOfColumn = new ArrayList<>();
        indexOfColumn.add(1);
        indexOfColumn.add(1);
        indexOfColumn.add(1);

        Line l2 = l.getSubLineFromColumnNumber(indexOfColumn);
        ArrayList<Element> l1List = l.getElements();
        ArrayList<Element> l2List = l2.getElements();
        boolean assertBoolean = true;
        if(l1List.get(1).getData() != l2List.get(0).getData()
                || l1List.get(1).getData() != l2List.get(1).getData()
                || l1List.get(1).getData() != l2List.get(2).getData()
                || l2List.size() != 3 ){
            assertBoolean = false;
        }
        assertEquals(true, assertBoolean);
    }

    /**
     * Tests for function get index.
     * */
    @Test
    public void testGetIndexFunction() {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element(0));
        listOfElement.add(new Element(1));
        listOfElement.add(new Element(2));
        listOfElement.add(new Element(3));
        Line l = new Line(0, listOfElement);
        int index = l.getIndexFromDataName("Test");
        assertEquals(-1, index);
    }

    @Test
    public void testGetIndexFirstElement() {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element("A"));
        listOfElement.add(new Element("B"));
        listOfElement.add(new Element("C"));
        listOfElement.add(new Element("D"));
        Line l = new Line(0, listOfElement);
        int index = l.getIndexFromDataName("A");
        assertEquals(0, index);
    }

    @Test
    public void testGetIndexLastElement() {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element("A"));
        listOfElement.add(new Element("B"));
        listOfElement.add(new Element("C"));
        listOfElement.add(new Element("D"));
        Line l = new Line(0, listOfElement);
        int index = l.getIndexFromDataName("D");
        assertEquals(3, index);
    }

    @Test(expected = ExceptionWrongIndex.class)
    public void testGetWrongIndex() throws ExceptionWrongIndex {
        ArrayList<Element> listOfElement = new ArrayList<>();
        listOfElement.add(new Element("A"));
        listOfElement.add(new Element("B"));
        Line l = new Line(0, listOfElement);
        Element index = l.getElementByIndex(2);
    }

}
