package murphy.fundamentals.structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestArrayListFromScratch {

    private ArrayListFromScratch fromScratch;

    private static final String STRING_01 = "Bug";
    private static final String STRING_02 = "Kite";
    private static final String STRING_03 = "Van";
    private static final String STRING_04 = "Dave";
    private static final String STRING_05 = "Lego";
    private static final String STRING_06 = "Water Bottle";
    private static final String STRING_07 = "Computer";
    private static final String STRING_08 = "Blanket";
    private static final String STRING_09 = "Kitten";
    private static final String EMPTY_STRING = "";

    private void fillArray() {
        fromScratch = new ArrayListFromScratch(2);
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        assertEquals(2, fromScratch.size());
        assertEquals(2, fromScratch.getCapacity());
        assertFalse(fromScratch.isEmpty());
    }
    
    @Before
    public void setUp() {
        fromScratch = new ArrayListFromScratch();
    }

    @Test
    public void testDefaultConstructor() {
        fromScratch = new ArrayListFromScratch();
        assertEquals(10, fromScratch.getCapacity());
        assertEquals(10, fromScratch.getElements().length);
        assertEquals(0, fromScratch.size());
        assertEquals(null, fromScratch.getElements()[0]);
        assertTrue(fromScratch.isEmpty());
    }

    @Test
    public void testInitialCapcityConstructor() {
        fromScratch = new ArrayListFromScratch(17);
        assertEquals(17, fromScratch.getCapacity());
        assertEquals(17, fromScratch.getElements().length);
        assertEquals(0, fromScratch.size());
        assertEquals(null, fromScratch.getElements()[0]);
        assertTrue(fromScratch.isEmpty());
    }

    @Test
    public void testAddToEndOfArrayWithCapacity() {
        fromScratch.add(STRING_01);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_01, fromScratch.get(0));
        assertFalse(fromScratch.isEmpty());
        fromScratch.add(STRING_02);
        assertEquals(2, fromScratch.size());
        assertEquals(STRING_02, fromScratch.get(1));
        assertFalse(fromScratch.isEmpty());
    }

    @Test
    public void testAddToEndOfFullArray() {
        fillArray();
        fromScratch.add(STRING_03);
        assertEquals(3, fromScratch.size());
        assertEquals(4, fromScratch.getCapacity());
        assertEquals(4, fromScratch.getElements().length);
        assertEquals(STRING_03, fromScratch.get(2));
    }

    @Test
    public void testAddToMiddleOfArrayWithCapacity() {
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        fromScratch.add(STRING_03);
        assertEquals(3, fromScratch.size());

        fromScratch.add(1, STRING_04);
        assertEquals(4, fromScratch.size());
        assertEquals(STRING_04, fromScratch.get(1));
    }

    @Test
    public void testAddToMiddleOfFullArray() {
        fillArray();
        fromScratch.add(1, STRING_04);
        assertEquals(3, fromScratch.size());
        assertEquals(4, fromScratch.getCapacity());
        assertEquals(4, fromScratch.getElements().length);
        assertEquals(STRING_04, fromScratch.get(1));
    }

    @Test
    public void testAddInvalidIndex() {
        try {
            fromScratch.add(-1, STRING_05);
            fail("IndexOutOfBoundsException not thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(e.getMessage().equals("Index out of range: -1"));
        }

        try {
            fromScratch.add(2, STRING_05);
            fail("IndexOutOfBoundsException not thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(e.getMessage().equals("Index out of range: 2"));
        }
    }

    @Test
    public void testSetAtValidIndex() {
        fillArray();
        fromScratch.set(0, STRING_05);
        assertEquals(2, fromScratch.size());
        assertEquals(STRING_05, fromScratch.get(0));
        fromScratch.set(1, STRING_06);
        assertEquals(2, fromScratch.size());
        assertEquals(STRING_06, fromScratch.get(1));
    }

    @Test
    public void testSetAtInvalidIndex() {
        fillArray();
        try {
            fromScratch.set(-1, STRING_05);
            fail("IndexOutOfBoundsException not thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(e.getMessage().equals("Index out of range: -1"));
        }

        try {
            fromScratch.set(2, STRING_05);
            fail("IndexOutOfBoundsException not thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(e.getMessage().equals("Index out of range: 2"));
        }
    }

    @Test
    public void testClear() {
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        fromScratch.add(STRING_03);
        fromScratch.add(STRING_04);

        assertEquals(4, fromScratch.size());
        assertEquals(10, fromScratch.getCapacity());
        assertFalse(fromScratch.isEmpty());

        fromScratch.clear();
        assertEquals(0, fromScratch.size());
        assertEquals(10, fromScratch.getCapacity());
        assertTrue(fromScratch.isEmpty());
        assertEquals(null, fromScratch.getElements()[0]);
    }

    @Test
    public void testGetValidIndex() {
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        fromScratch.add(STRING_03);
        fromScratch.add(STRING_04);

        assertEquals(STRING_01, fromScratch.get(0));
        assertEquals(STRING_02, fromScratch.get(1));
        assertEquals(STRING_03, fromScratch.get(2));
        assertEquals(STRING_04, fromScratch.get(3));
    }

    @Test
    public void testContains() {
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        fromScratch.add(STRING_03);
        fromScratch.add(STRING_04);

        assertTrue(fromScratch.contains(STRING_02));
        assertFalse(fromScratch.contains(STRING_05));
        assertFalse(fromScratch.contains(EMPTY_STRING));
        assertFalse(fromScratch.contains(null));
    }

    @Test
    public void testRemoveString() {
        fillArray();
        assertTrue(fromScratch.contains(STRING_01));
        assertTrue(fromScratch.contains(STRING_02));
        fromScratch.remove(STRING_01);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_02, fromScratch.get(0));
        assertFalse(fromScratch.contains(STRING_01));
        fromScratch.remove(STRING_03);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_02, fromScratch.get(0));
        assertFalse(fromScratch.contains(STRING_01));
        fromScratch.remove(EMPTY_STRING);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_02, fromScratch.get(0));
        assertFalse(fromScratch.contains(STRING_01));
        fromScratch.remove(null);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_02, fromScratch.get(0));
        assertFalse(fromScratch.contains(STRING_01));
        fromScratch.remove(STRING_02);
        assertEquals(0, fromScratch.size());
        assertTrue(fromScratch.isEmpty());
        assertFalse(fromScratch.contains(STRING_02));
    }

    @Test
    public void testRemoveFromIndex() {
        fillArray();
        assertTrue(fromScratch.contains(STRING_01));
        assertTrue(fromScratch.contains(STRING_02));
        fromScratch.remove(0);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_02, fromScratch.get(0));
        assertFalse(fromScratch.contains(STRING_01));
        fromScratch.remove(STRING_02);
        assertEquals(0, fromScratch.size());
        assertTrue(fromScratch.isEmpty());
        assertFalse(fromScratch.contains(STRING_02));
    }

    @Test
    public void testRemoveFromInvalidIndex() {
        fillArray();
        try {
            fromScratch.remove(-1);
            fail("IndexOutOfBoundsException not thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(e.getMessage().equals("Index out of range: -1"));
        }

        try {
            fromScratch.remove(2);
            fail("IndexOutOfBoundsException not thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(e.getMessage().equals("Index out of range: 2"));
        }
    }

    @Test
    public void testIndexOf() {
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        fromScratch.add(STRING_03);
        fromScratch.add(STRING_04);

        assertEquals(0, fromScratch.indexOf(STRING_01));
        assertEquals(1, fromScratch.indexOf(STRING_02));

        fromScratch.add(STRING_02);

        assertEquals(1, fromScratch.indexOf(STRING_02));
        assertEquals(-1, fromScratch.indexOf(STRING_05));
        assertEquals(-1, fromScratch.indexOf(EMPTY_STRING));
        assertEquals(-1, fromScratch.indexOf(null));

        fromScratch.remove(1);
        assertEquals(3, fromScratch.indexOf(STRING_02));
    }

    @Test
    public void testLastIndexOf() {
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        fromScratch.add(STRING_03);
        fromScratch.add(STRING_04);

        assertEquals(0, fromScratch.lastIndexOf(STRING_01));
        assertEquals(1, fromScratch.lastIndexOf(STRING_02));

        fromScratch.add(STRING_02);

        assertEquals(4, fromScratch.lastIndexOf(STRING_02));
        assertEquals(-1, fromScratch.lastIndexOf(STRING_05));
        assertEquals(-1, fromScratch.lastIndexOf(EMPTY_STRING));
        assertEquals(-1, fromScratch.lastIndexOf(null));

        fromScratch.remove(4);
        assertEquals(1, fromScratch.lastIndexOf(STRING_02));
    }

    @Test
    public void testToString() {
        fromScratch.add(STRING_01);
        fromScratch.add(STRING_02);
        fromScratch.add(STRING_03);
        fromScratch.add(STRING_04);

        assertEquals("[Bug, Kite, Van, Dave]", fromScratch.toString());

        fromScratch.add(STRING_01);

        assertEquals("[Bug, Kite, Van, Dave, Bug]", fromScratch.toString());

        fromScratch.remove(1);

        assertEquals("[Bug, Van, Dave, Bug]", fromScratch.toString());

        fromScratch.clear();

        assertEquals("[]", fromScratch.toString());

    }


}
