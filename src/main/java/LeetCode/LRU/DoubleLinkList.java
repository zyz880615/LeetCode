package LeetCode.LRU;

/**
 * 双向链表
 */
public class DoubleLinkList {

    //头结点
    private Node head;
    //尾节点
    private Node tail;

    private int size;

    public DoubleLinkList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    //在链表头部添加节点
    public void addFirst(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    //删除链表中指定节点，该节点一定存在
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    //删除链表中最后一个节点，并返回该节点，时间O(1)
    public Node removeLast(){
        if (head.next == tail){
            return null;
        }

        Node last = tail.prev;
        remove(last);
        return last;
    }

    //返回链表长度
    public int size(){
        return size;
    }
}
