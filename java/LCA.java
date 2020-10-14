import java.util.HashSet;
import java.util.Set;

public class LCA {

    public static class Node<V> {
        public final Set<Node<V>> children = new HashSet<>();
        public final V data;

        public Node(V data) {
            this.data = data;
        }
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
}
