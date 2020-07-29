import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Node<Integer> rootNode = new Node<>();

        for (int i = 0; i < 10; i++) {
            rootNode.add((int) (Math.random() * 20 + 10));
        }

        System.out.println(rootNode.getSortedList());
    }
}

class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> leftNode;
    public Node<T> rightNode;

    public List<T> getSortedList() {
        List<T> list = new ArrayList<>();
        if (leftNode != null) {
            list.addAll(leftNode.getSortedList());
        }
        list.add(this.value);
        if (rightNode != null) {
            list.addAll(rightNode.getSortedList());
        }
        return list;
    }

    public void add(T value) {
        if (this.value == null) {
            this.value = value;
        } else {
            if (value.compareTo(this.value) > 0) {
                if (rightNode == null) {
                    rightNode = new Node<T>();
                }
                this.rightNode.add(value);
            } else if (value.compareTo(this.value) < 0) {
                if (leftNode == null) {
                    leftNode = new Node<T>();
                }
                this.leftNode.add(value);
            }
        }
    }
}