package murphy.fundamentals.structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestStackFromScratch {

    private StackFromScratch fromScratch;

    private static final String STRING_01 = "Bug";
    private static final String STRING_02 = "Kite";
    private static final String STRING_03 = "Van";
    private static final String STRING_04 = "Dave";

    @Before
    public void setUp() throws Exception {
        fromScratch = new StackFromScratch(3);
    }

    @Test
    public void testDefaultConstructor() {
        fromScratch = new StackFromScratch();
        assertEquals(10, fromScratch.getCapacity());
        assertTrue(fromScratch.isEmpty());
    }

    @Test
    public void testPush() {
        assertTrue(fromScratch.isEmpty());
        assertEquals(0, fromScratch.size());
        assertEquals(3, fromScratch.getCapacity());
        boolean success = fromScratch.push(STRING_01);

        assertTrue(success);
        assertFalse(fromScratch.isEmpty());
        assertEquals(1, fromScratch.size());

        success = fromScratch.push(STRING_02);

        assertTrue(success);
        assertFalse(fromScratch.isEmpty());
        assertEquals(2, fromScratch.size());

        success = fromScratch.push(STRING_03);

        assertTrue(success);
        assertFalse(fromScratch.isEmpty());
        assertEquals(3, fromScratch.size());

        LinkedListFromScratch list = fromScratch.getElements();

        assertEquals(STRING_01, list.get(0));
        assertEquals(STRING_02, list.get(1));
        assertEquals(STRING_03, list.get(2));

        success = fromScratch.push(STRING_04);
        assertFalse(success);
        assertEquals(3, fromScratch.size());
    }

    @Test
    public void testPeek() {
        assertEquals(null, fromScratch.peek());
        fromScratch.push(STRING_01);
        assertEquals(STRING_01, fromScratch.peek());

        fromScratch.push(STRING_02);
        assertEquals(STRING_02, fromScratch.peek());

        fromScratch.push(STRING_03);
        assertEquals(STRING_03, fromScratch.peek());
    }

    @Test
    public void testPop() {
        assertEquals(null, fromScratch.pop());

        fromScratch.push(STRING_01);
        fromScratch.push(STRING_02);
        assertEquals(STRING_02, fromScratch.peek());
    
        String s2 = fromScratch.pop();
        assertEquals(STRING_02, s2);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_01, fromScratch.peek());
    
        String s1 = fromScratch.pop();
        assertEquals(STRING_01, s1);
        assertEquals(0, fromScratch.size());
        assertTrue(fromScratch.isEmpty());
        assertEquals(null, fromScratch.peek());
    }
}