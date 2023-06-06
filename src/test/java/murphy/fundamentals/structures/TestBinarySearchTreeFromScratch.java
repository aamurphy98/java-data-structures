package murphy.fundamentals.structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import murphy.fundamentals.structures.BinarySearchTreeFromScratch.Node;

public class TestBinarySearchTreeFromScratch {
    
    private BinarySearchTreeFromScratch fromScratch;

    @Before
    public void setUp() {
        this.fromScratch = new BinarySearchTreeFromScratch();
    }

    /**
     * Manually create a sample BST referencing the sample graphic provided from:
     * https://www.geeksforgeeks.org/binary-search-tree-data-structure/
     */
    public void manuallyPopulateTree() {

        Node one = fromScratch.new Node(1);
        Node three = fromScratch.new Node(3);
        Node four = fromScratch.new Node(4);
        Node six = fromScratch.new Node(6);
        Node seven = fromScratch.new Node(7);
        Node eight = fromScratch.new Node(8);
        Node ten = fromScratch.new Node(10);
        Node thirteen = fromScratch.new Node(13);
        Node fourteen = fromScratch.new Node(14);

        six.left = four;
        six.right = seven;
        three.left = one;
        three.right = six;
        fourteen.left = thirteen;
        ten.right = fourteen;
        eight.left = three;
        eight.right = ten;

        this.fromScratch.setRoot(eight);
    }

    @Test
    public void testInsertIntoEmptyTree() {
        assertEquals(0, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(4));

        this.fromScratch.insert(4);

        assertEquals(1, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(4));
    }

    @Test
    public void testInsertIntoPopulatedTree() {
        manuallyPopulateTree();

        assertEquals(9, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(2));

        this.fromScratch.insert(2);

        assertEquals(10, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(2));

        this.fromScratch.insert(15);

        assertEquals(11, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(15));

        Integer[] expected = new Integer[11];
        expected[0] = 1;
        expected[1] = 2;
        expected[2] = 3;
        expected[3] = 4;
        expected[4] = 6;
        expected[5] = 7;
        expected[6] = 8;
        expected[7] = 10;
        expected[8] = 13;
        expected[9] = 14;
        expected[10] = 15;

        Integer[] actual = fromScratch.inorder();

        for (int i = 0; i < 9; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testInsertExistingValueIntoPopulatedTree() {
        manuallyPopulateTree();

        assertEquals(9, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(4));

        this.fromScratch.insert(4);

        assertEquals(9, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(4));
    }

    @Test
    public void testDeleteExistingValueWithoutChildren() {
        manuallyPopulateTree();

        assertEquals(9, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(13));

        this.fromScratch.delete(13);

        assertEquals(8, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(13));

        Integer[] preorderExpected = new Integer[8];
        preorderExpected[0] = 8;
        preorderExpected[1] = 3;
        preorderExpected[2] = 1;
        preorderExpected[3] = 6;
        preorderExpected[4] = 4;
        preorderExpected[5] = 7;
        preorderExpected[6] = 10;
        preorderExpected[7] = 14;

        Integer[] inorderExpected = new Integer[8];
        inorderExpected[0] = 1;
        inorderExpected[1] = 3;
        inorderExpected[2] = 4;
        inorderExpected[3] = 6;
        inorderExpected[4] = 7;
        inorderExpected[5] = 8;
        inorderExpected[6] = 10;
        inorderExpected[7] = 14;

        Integer[] postorderExpected = new Integer[9];
        postorderExpected[0] = 1;
        postorderExpected[1] = 4;
        postorderExpected[2] = 7;
        postorderExpected[3] = 6;
        postorderExpected[4] = 3;
        postorderExpected[5] = 14;
        postorderExpected[6] = 10;
        postorderExpected[7] = 8;

        Integer[] preorderActual = fromScratch.preorder();
        Integer[] inorderActual = fromScratch.inorder();
        Integer[] postorderActual = fromScratch.postorder();

        for (int i = 0; i < inorderActual.length; i++) {
            assertEquals("Verify preorder traversal", preorderExpected[i], preorderActual[i]);
            assertEquals("Verify inorder traversal", inorderExpected[i], inorderActual[i]);
            assertEquals("Verify postorder traversal", postorderExpected[i], postorderActual[i]);
        }
    }

    @Test
    public void testDeleteExistingValueWithSingleChild() {
        manuallyPopulateTree();

        assertEquals(9, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(14));

        this.fromScratch.delete(14);

        assertEquals(8, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(14));

        Integer[] preorderExpected = new Integer[8];
        preorderExpected[0] = 8;
        preorderExpected[1] = 3;
        preorderExpected[2] = 1;
        preorderExpected[3] = 6;
        preorderExpected[4] = 4;
        preorderExpected[5] = 7;
        preorderExpected[6] = 10;
        preorderExpected[7] = 13;

        Integer[] inorderExpected = new Integer[8];
        inorderExpected[0] = 1;
        inorderExpected[1] = 3;
        inorderExpected[2] = 4;
        inorderExpected[3] = 6;
        inorderExpected[4] = 7;
        inorderExpected[5] = 8;
        inorderExpected[6] = 10;
        inorderExpected[7] = 13;

        Integer[] postorderExpected = new Integer[9];
        postorderExpected[0] = 1;
        postorderExpected[1] = 4;
        postorderExpected[2] = 7;
        postorderExpected[3] = 6;
        postorderExpected[4] = 3;
        postorderExpected[5] = 13;
        postorderExpected[6] = 10;
        postorderExpected[7] = 8;

        Integer[] preorderActual = fromScratch.preorder();
        Integer[] inorderActual = fromScratch.inorder();
        Integer[] postorderActual = fromScratch.postorder();

        for (int i = 0; i < inorderActual.length; i++) {
            assertEquals("Verify preorder traversal", preorderExpected[i], preorderActual[i]);
            assertEquals("Verify inorder traversal", inorderExpected[i], inorderActual[i]);
            assertEquals("Verify postorder traversal", postorderExpected[i], postorderActual[i]);
        }
    }

    @Test
    public void testDeleteExistingValueWithTwoChildren() {
        manuallyPopulateTree();

        assertEquals(9, this.fromScratch.inorder().length);
        assertTrue(this.fromScratch.search(3));

        this.fromScratch.delete(3);

        assertEquals(8, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(3));

        Integer[] preorderExpected = new Integer[8];
        preorderExpected[0] = 8;
        preorderExpected[1] = 4;
        preorderExpected[2] = 1;
        preorderExpected[3] = 6;
        preorderExpected[4] = 7;
        preorderExpected[5] = 10;
        preorderExpected[6] = 14;
        preorderExpected[7] = 13;

        Integer[] inorderExpected = new Integer[8];
        inorderExpected[0] = 1;
        inorderExpected[1] = 4;
        inorderExpected[2] = 6;
        inorderExpected[3] = 7;
        inorderExpected[4] = 8;
        inorderExpected[5] = 10;
        inorderExpected[6] = 13;
        inorderExpected[7] = 14;

        Integer[] postorderExpected = new Integer[9];
        postorderExpected[0] = 1;
        postorderExpected[1] = 7;
        postorderExpected[2] = 6;
        postorderExpected[3] = 4;
        postorderExpected[4] = 13;
        postorderExpected[5] = 14;
        postorderExpected[6] = 10;
        postorderExpected[7] = 8;

        Integer[] preorderActual = fromScratch.preorder();
        Integer[] inorderActual = fromScratch.inorder();
        Integer[] postorderActual = fromScratch.postorder();

        for (int i = 0; i < inorderActual.length; i++) {
            assertEquals("Verify preorder traversal", preorderExpected[i], preorderActual[i]);
            assertEquals("Verify inorder traversal", inorderExpected[i], inorderActual[i]);
            assertEquals("Verify postorder traversal", postorderExpected[i], postorderActual[i]);
        }
    }

    @Test
    public void testDeleteNonexistentValue() {
        manuallyPopulateTree();

        assertEquals(9, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(2));

        this.fromScratch.delete(2);

        assertEquals(9, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(2));
    }

    @Test
    public void testDeleteFromEmptyTree() {
        assertEquals(0, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(2));

        this.fromScratch.delete(2);

        assertEquals(0, this.fromScratch.inorder().length);
        assertFalse(this.fromScratch.search(2));
    }

    @Test
    public void testSearchForExistingValue() {
        manuallyPopulateTree();

        assertTrue(this.fromScratch.search(8));
        assertTrue(this.fromScratch.search(3));
        assertTrue(this.fromScratch.search(14));
        assertTrue(this.fromScratch.search(7));
    }

    @Test
    public void testSearchForNonexistentValue() {
        assertFalse(this.fromScratch.search(8));

        manuallyPopulateTree();
        assertFalse(this.fromScratch.search(0));
    }

    @Test
    public void testPreOrderTraversal() {
        manuallyPopulateTree();

        Integer[] expected = new Integer[9];
        expected[0] = 8;
        expected[1] = 3;
        expected[2] = 1;
        expected[3] = 6;
        expected[4] = 4;
        expected[5] = 7;
        expected[6] = 10;
        expected[7] = 14;
        expected[8] = 13;

        Integer[] actual = fromScratch.preorder();

        for (int i = 0; i < 9; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testInOrderTraversal() {
        manuallyPopulateTree();

        Integer[] expected = new Integer[9];
        expected[0] = 1;
        expected[1] = 3;
        expected[2] = 4;
        expected[3] = 6;
        expected[4] = 7;
        expected[5] = 8;
        expected[6] = 10;
        expected[7] = 13;
        expected[8] = 14;

        Integer[] actual = fromScratch.inorder();

        for (int i = 0; i < 9; i++) {
            assertEquals(expected[i], actual[i]);
        }    
    }

    @Test
    public void testPostOrderTraversal() {
        manuallyPopulateTree();

        Integer[] expected = new Integer[9];
        expected[0] = 1;
        expected[1] = 4;
        expected[2] = 7;
        expected[3] = 6;
        expected[4] = 3;
        expected[5] = 13;
        expected[6] = 14;
        expected[7] = 10;
        expected[8] = 8;

        Integer[] actual = fromScratch.postorder();

        for (int i = 0; i < 9; i++) {
            assertEquals(expected[i], actual[i]);
        }    }
}
 