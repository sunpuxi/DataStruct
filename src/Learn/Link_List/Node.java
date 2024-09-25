package src.Learn.Link_List;

/**
 * 双向链表的节点
 * @param <E>
 */
public class Node<E> {

    E item;  //元素
    Node<E> prev;  //指向前一个元素的指针
    Node<E> next;  //指向后一个元素的指针

    private Node<E> first;  //头节点
    private Node<E> tail;  //尾节点

    public int size;  //长度

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
}
