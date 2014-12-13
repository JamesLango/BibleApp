import java.util.ArrayList;

public class BibleTree<T> {
	
	// constructor for a node.
    public static class Node<V,N> {
    	
        private V nodeType;
		private N childType;
        private ArrayList<Node<V,N>> children;
        //private HashMap<Node<V,N>> test;

        public Node(V nodeType,N childType) {
            this.nodeType = nodeType;
			this.childType = childType;
        }

        public V getNodeType() {
            return nodeType;
        }

        public ArrayList<Node<V,N>> getChildren() {
            return children;
        }

        public int getNumberOfChildren() {
            return children.size();
        }

        @Override
        public String toString() {
            return "This is a "+nodeType.toString() + "object, containing " + children.toString() + "objects.";
        }
    }
}
