package main.java;

import java.util.HashSet;
import java.util.Set;

public class LCA {
    /**
     * Get the Lowest Common Ancestor of any two nodes in an n-ary tree.
     *
     * @param root  The root node of the n-ary tree
     * @param nodea The first node to find the ancestor of
     * @param nodeb The second node to find the ancestor of
     * @param <V>   The type of the nodes the tree holds
     * @return The ancestor of the two input nodes, or null if not found
     */
    public static <V> Node<V> getLCA(Node<V> root, Node<V> nodea, Node<V> nodeb) {
        if (root == null || nodea == root || nodeb == root) return root;

        int childrenFound = 0;
        Node<V> lastFoundNode = null;

        for (Node<V> child : root.children) {
            Node<V> node = getLCA(child, nodea, nodeb);

            if (node != null) {
                lastFoundNode = node;
                childrenFound++;
            }

            if (childrenFound >= 2) return root;
        }

        return lastFoundNode;
    }

    /**
     * A node of a n-ary tree. Has children and data. The key is equivalent to the reference.
     *
     * @param <V>
     */
    public static class Node<V> {
        public final Set<Node<V>> children = new HashSet<>();
        public final V data;

        public Node(V data) {
            this.data = data;
        }
    }
}
