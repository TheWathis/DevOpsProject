import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementTest {
    @Test
    public void testGetElement() {
        Element e = new Element("Tests");
        assertEquals("Tests", e.getData());
    }

    @Test
    public void testSetElement() {
        Element e = new Element("Tests");
        e.setData("Tests2");
        assertEquals("Tests2", e.getData());
    }

    @Test
    public void testSetElementDifferentType() {
        Element e = new Element("Tests");
        e.setData(1);
        assertEquals(1, e.getData());
    }
}
