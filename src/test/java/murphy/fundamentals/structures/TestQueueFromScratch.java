package murphy.fundamentals.structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestQueueFromScratch {

    private QueueFromScratch fromScratch;

    private static final String STRING_01 = "Bug";
    private static final String STRING_02 = "Kite";
    private static final String STRING_03 = "Van";

    @Before
    public void setUp() {
        fromScratch = new QueueFromScratch();
    }

    @Test
    public void testOffer() {
        assertTrue(fromScratch.isEmpty());
        assertEquals(0, fromScratch.size());

        fromScratch.offer(STRING_01);

        assertFalse(fromScratch.isEmpty());
        assertEquals(1, fromScratch.size());

        fromScratch.offer(STRING_02);

        assertFalse(fromScratch.isEmpty());
        assertEquals(2, fromScratch.size());

        LinkedListFromScratch list = fromScratch.getElements();

        assertEquals(STRING_01, list.get(0));
        assertEquals(STRING_02, list.get(1));
    }

    @Test
    public void testPeek() {
        assertEquals(null, fromScratch.peek());
        fromScratch.offer(STRING_01);
        assertEquals(STRING_01, fromScratch.peek());

        fromScratch.offer(STRING_02);
        assertEquals(STRING_01, fromScratch.peek());

        fromScratch.offer(STRING_03);
        assertEquals(STRING_01, fromScratch.peek());
    }

    @Test
    public void testPoll() {
        assertEquals(null, fromScratch.poll());

        fromScratch.offer(STRING_01);
        fromScratch.offer(STRING_02);
        assertEquals(STRING_01, fromScratch.peek());
    
        String s1 = fromScratch.poll();
        assertEquals(STRING_01, s1);
        assertEquals(1, fromScratch.size());
        assertEquals(STRING_02, fromScratch.peek());
    
        String s2 = fromScratch.poll();
        assertEquals(STRING_02, s2);
        assertEquals(0, fromScratch.size());
        assertTrue(fromScratch.isEmpty());
        assertEquals(null, fromScratch.peek());
    }
}