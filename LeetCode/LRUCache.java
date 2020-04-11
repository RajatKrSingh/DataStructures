package LeetCode;

import com.sun.media.sound.DLSInfo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {

    public class DLinkedList
    {
        int val,key;
        DLinkedList next,prev;
        public DLinkedList(int key,int val)
        {
            this.val = val;
            this.key = key;
        }

    }

    public static void add_tonode(DLinkedList head, DLinkedList next_node)
    {
        next_node.next = head.next;
        next_node.prev = head;
        head.next.prev = next_node;
        head.next = next_node;
        head.val++;
    }

    public static int remove_node(DLinkedList tail, DLinkedList head)
    {
        int val_removed= tail.prev.key;
        DLinkedList temp = tail.prev.prev;
        tail.prev.prev.next = tail;
        tail.prev.prev = null;
        tail.prev = temp;

        head.val--;
        return val_removed;
    }

    public static void add_to_front(DLinkedList lru_dlink_head,DLinkedList node_to_get)
    {
        node_to_get.prev.next = node_to_get.next;
        node_to_get.next.prev = node_to_get.prev;
        node_to_get.prev = lru_dlink_head;
        node_to_get.next = lru_dlink_head.next;
        lru_dlink_head.next.prev= node_to_get;
        lru_dlink_head.next = node_to_get;
    }

    HashMap<Integer,DLinkedList> hmap;
    DLinkedList lru_dlink_head;
    DLinkedList lru_dlink_tail;
    int capacity;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        hmap = new HashMap<>();
        lru_dlink_head = new DLinkedList(-1,0);
        lru_dlink_tail = new DLinkedList(-1,0);
        lru_dlink_head.next = lru_dlink_tail;
        lru_dlink_tail.prev = lru_dlink_head;
    }

    public int get(int key)
    {
        if(hmap.containsKey(key))
        {
            DLinkedList node_to_get = hmap.get(key);
            add_to_front(lru_dlink_head,node_to_get);
            return node_to_get.val;
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if(hmap.containsKey(key))
        {
            DLinkedList get_node = hmap.get(key);
            get_node.val = value;
            add_to_front(lru_dlink_head,get_node);
            return;
        }
        if(lru_dlink_head.val==capacity)
        {
            hmap.remove(lru_dlink_tail.prev.key);
            remove_node(lru_dlink_tail,lru_dlink_head);
        }
        DLinkedList new_node = new DLinkedList(key,value);
        add_tonode(lru_dlink_head,new_node);
        hmap.put(key,new_node);
    }
}
