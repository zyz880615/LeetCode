package LeetCode.LRU;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> hashMap;

    private DoubleLinkList cache;

    private int cap;

    public LRUCache(int capacity) {
        hashMap = new HashMap<>();
        cache = new DoubleLinkList();
        this.cap = capacity;
    }

    //将某个 key 提升为最近使用的
    private void makeRecently(int key){
        Node node = hashMap.get(key);
        //先删除该节点
        cache.remove(node);
        //将该节点添加到队头
        cache.addFirst(node);
    }

    //添加最近使用的元素
    private void addRecently(int key, int val){
        Node newNode = new Node(key,val);
        //在链表头部添加节点
        cache.addFirst(newNode);
        //在map里添加该节点
        hashMap.put(key,newNode);
    }

    //删除某一个 key
    private void deleteKey(int key){
        Node node = hashMap.get(key);
        cache.remove(node);
        hashMap.remove(key);
    }

    //删除最久未使用的元素
    private void removeLeastRecently(){
        //链表的最后一个元素，就是最久未使用的
        Node node = cache.removeLast();
        hashMap.remove(node.key);
    }

    public int get(int key){
        if (!hashMap.containsKey(key)){
            return -1;
        }

        makeRecently(key);
        return hashMap.get(key).value;
    }

    public void put(int key, int val){
        //若key已存在
        if (hashMap.containsKey(key)){
            deleteKey(key);
            addRecently(key, val);
            return;
        }

        if (cap == cache.size()){
            removeLeastRecently();
        }

        addRecently(key, val);

    }

}
