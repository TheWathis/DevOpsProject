import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTest {

    /**
     * Tests for function add element.
     * */
    @Test
    public void testAddElementInLine() {
        Line l = new Line();
        Element e = new Element("Test");
        l.add(e);
        assertEquals("Test", l.getElements().get(0).getElem());
    }

    @Test
    public void testAddMultipleElementInLine() {
        Line l = new Line();
        Element e = new Element("Test");
        l.add(e);
        Element e2 = new Element("Test2");
        l.add(e2);
        assertEquals("Test", l.getElements().get(0).getElem());
        assertEquals("Test2", l.getElements().get(1).getElem());
    }
}
