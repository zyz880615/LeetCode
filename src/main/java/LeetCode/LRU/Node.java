package LeetCode.LRU;

public class Node {

    //节点的next指针
    public Node next;

    //节点的prev指针
    public Node prev;

    public int key,value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
