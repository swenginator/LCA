import java.util.HashSet;
import java.util.Set;

public class LCA {

    public static void main(String... args) {
        // Create a simple test tree
        Node<Integer> root = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        root.children.add(node1);
        root.children.add(node2);

        Node<Integer> lca = getLCA(root, node1, node2);
        System.out.println("LCA: " + lca.data);

    }

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
