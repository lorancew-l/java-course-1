package src.lr3.Task8;

class Node<T> {
  public T value;
  public Node<T> next;

  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }
}

public class LinkedList<T> {
  private Node<T> head;

  public void createHead(T[] values) {
    for (T value : values) {
      this.addLast(value);
    }
  }

  public void createTail(T[] values) {
    for (int i = values.length - 1; i >= 0; i--) {
      this.head = new Node<T>(values[i], this.head);
    }
  }

  public String toString() {
    String output = "";

    Node<T> ref = this.head;
    while (ref != null) {
      output += " " + ref.value;
      ref = ref.next;
    }

    return output;
  }

  public void addFirst(T value) {
    this.head = new Node<T>(value, this.head);
  }

  public void addLast(T value) {
    if (this.head == null) {
      this.head = new Node<T>(value, null);
      return;
    }

    Node<T> lastNode = this.head;

    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }

    lastNode.next = new Node<T>(value, null);
  }

  public void insert(int index, T value) {
    Node<T> nodeAtIndex = this.head;

    for (int i = 0; i < index; i++) {
      if (i < index - 1 && nodeAtIndex.next == null) {
        throw new Error("Invalid index");
      } else if (i < index - 1) {
        nodeAtIndex = nodeAtIndex.next;
      }
    }

    Node<T> insertedNode = new Node<T>(value, nodeAtIndex.next);
    nodeAtIndex.next = insertedNode;
  }

  public T removeFirst() {
    Node<T> previousHead = head;
    this.head = previousHead.next;

    return previousHead.value;
  }

  public T removeLast() {
    Node<T> lastNode = this.head;
    Node<T> secondToLastNode = null;

    while (lastNode.next != null) {
      secondToLastNode = lastNode;
      lastNode = lastNode.next;
    }

    secondToLastNode.next = null;
    return lastNode.value;
  }

  public T removeAt(int index) {
    Node<T> nodeAtIndex = this.head;
    Node<T> secondToNodeAtIndex = null;

    for (int i = 0; i <= index; i++) {
      if (i <= index && nodeAtIndex.next == null) {
        throw new Error("Invalid index");
      } else if (i != index) {
        secondToNodeAtIndex = nodeAtIndex;
        nodeAtIndex = nodeAtIndex.next;
      }
    }

    secondToNodeAtIndex.next = nodeAtIndex.next;
    return nodeAtIndex.value;
  }

  public void createHeadRec(T[] values) {
    createHeadRec(values, values.length - 1);
  }

  private void createHeadRec(T[] values, int index) {
    if (index < 0) {
      return;
    }

    createHeadRec(values, index - 1);
    this.addLast(values[index]);
  }

  public void createTailRec(T[] values) {
    if (values.length == 0) {
      return;
    }

    this.head = createTailRecursive(values, 0);
  }

  private Node<T> createTailRecursive(T[] values, int index) {
    if (index == values.length - 1) {
      return new Node<T>(values[index], null);
    }

    Node<T> nextNode = createTailRecursive(values, index + 1);
    return new Node<T>(values[index], nextNode);
  }

  public String toStringRec() {
    return toStringRecursive(this.head);
  }

  private String toStringRecursive(Node<T> node) {
    if (node == null) {
      return "";
    }

    if (node.next == null) {
      return " " + node.value;
    }

    return " " + node.value + toStringRecursive(node.next);
  }
}
