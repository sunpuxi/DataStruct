package src.Learn.Link_List;

/**
 * 双向链表的节点
 * @param <E>
 */
public class Node<E> {

    E item;  //元素
    Node<E> prev;  //指向前一个元素的指针
    Node<E> next;  //指向后一个元素的指针

    /**
     * 有参数构造函数
     * @param prev pre
     * @param next next
     * @param item value
     */
    public Node(Node<E> prev,Node<E> next,E item){
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    public Node(E item){
        this.item = item;
    }
}
