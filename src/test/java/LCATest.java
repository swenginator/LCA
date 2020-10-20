package test.java;

import main.java.LCA;
import org.junit.jupiter.api.Test;

import static main.java.LCA.getLCA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LCATest {

    /**
     * Test with a fairly simple tree structure
     * Find ancestor of 3 and 4, should be 1
     * (0)
     * (1)       (2)
     * (3)  (4)
     */
    @Test
    void getLCATest3HighTree1Ancestor() {
        LCA.Node<Integer> root = new LCA.Node<>(0);
        LCA.Node<Integer> node1 = new LCA.Node<>(1);
        LCA.Node<Integer> node2 = new LCA.Node<>(2);
        LCA.Node<Integer> node3 = new LCA.Node<>(3);
        LCA.Node<Integer> node4 = new LCA.Node<>(4);

        root.children.add(node1);
        root.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);

        LCA.Node<Integer> lca = getLCA(root, node3, node4);
        assertEquals(1, lca.data);
    }

    /**
     * Test with a fairly simple tree structure
     * Find ancestor of 3 and 2, should be 0
     * (0)
     * (1)       (2)
     * (3)  (4)
     */
    @Test
    void getLCATest3HighTree0Ancestor() {
        LCA.Node<Integer> root = new LCA.Node<>(0);
        LCA.Node<Integer> node1 = new LCA.Node<>(1);
        LCA.Node<Integer> node2 = new LCA.Node<>(2);
        LCA.Node<Integer> node3 = new LCA.Node<>(3);
        LCA.Node<Integer> node4 = new LCA.Node<>(4);

        root.children.add(node1);
        root.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);

        LCA.Node<Integer> lca = getLCA(root, node3, node2);
        assertEquals(0, lca.data);
    }

    /**
     * Test with a fairly simple tree structure
     * Find ancestor of root and root node
     * (0)
     * (1)       (2)
     * (3)  (4)
     */
    @Test
    void getLCATest3HighTreeRootAncestor() {
        LCA.Node<Integer> root = new LCA.Node<>(0);
        LCA.Node<Integer> node1 = new LCA.Node<>(1);
        LCA.Node<Integer> node2 = new LCA.Node<>(2);
        LCA.Node<Integer> node3 = new LCA.Node<>(3);
        LCA.Node<Integer> node4 = new LCA.Node<>(4);

        root.children.add(node1);
        root.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);

        LCA.Node<Integer> lca = getLCA(root, root, root);
        assertEquals(0, lca.data);
    }

    /**
     * Check if using null inputs causes any crashes.
     */
    @Test
    void testNullInputs() {
        assertNull(getLCA(null, null, null));
    }

    /**
     * Test if having nodes with the same values causes issues with equality checking.
     */
    @Test
    void testDuplicateValueNodes() {
        LCA.Node<Integer> root = new LCA.Node<>(0);
        LCA.Node<Integer> node1 = new LCA.Node<>(0);

        root.children.add(node1);

        LCA.Node<Integer> lca = getLCA(root, root, node1);
        assertEquals(0, lca.data);
    }

    /**
     * Check if having the same node twice still returns a reasonable value.
     */
    @Test
    void testDuplicateNodes() {
        LCA.Node<Integer> root = new LCA.Node<>(0);

        root.children.add(root);

        LCA.Node<Integer> lca = getLCA(root, root, root);
        assertEquals(0, lca.data);
    }
}