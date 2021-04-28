import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementTest {
    @Test
    public void testGetElement() {
        Element e = new Element("Tests");
        assertEquals("Tests", e.getElem());
    }

    @Test
    public void testSetElement() {
        Element e = new Element("Tests");
        e.setElem("Tests2");
        assertEquals("Tests2", e.getElem());
    }

    @Test
    public void testSetElementDifferentType() {
        Element e = new Element("Tests");
        e.setElem(1);
        assertEquals(1, e.getElem());
    }
}
