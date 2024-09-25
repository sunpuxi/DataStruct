package src.Learn.Link_List;

/**
 * 自定义双向链表
 */
public class Link_List<E> {

    public Node<E> first;  //头节点
    public Node<E> tail;  //尾节点

    public int size;  //长度

    public Link_List(){
    }

    /**
     * 在头部插入节点
     */
    public void linkFirst(E element){
        Node<E> node = new Node<>(null,null,element);
        // 获取当前的头节点
        Node<E> head = this.first;
        size++;
        // 判断是否为空
        if (head != null){
            // 如果不为空
            // 1、那么将头节点的 pre 指针指向新插入的节点。
            // 2、将 node 节点的 pre 指针指向 null，next 指针指向 head。
            head.prev = node;
            node.prev = null;
            node.next  = head;
            // 如果 head 是尾节点
            if (head.next == null){
                this.tail  = head;
            }
        }else{
            // 如果为空，那么新插入进来的节点就是新的头节点
            node.prev = null;
            node.next = null;
        }
        // 将 first 改为 node
        this.first = node;
        // 如果当前的链表里面只有一个元素，那么尾节点和头节点就是相同的
        if (size == 1){
            this.tail = node;
        }
    }

    /**
     * 在尾部插入节点
     */
    public void linkTail(E element){
        Node<E> node = new Node<>(null,null,element);
        // 获取当前的 tail 节点
        Node<E> last = this.tail;
        // 长度加一
        this.size++;
        // 如果 last 为空，当前链表为空链表。
        if (size == 1){
            this.first = node;
            this.tail = node;
            // 修改指针
            node.prev = null;
            node.next = null;
        }else{
            // 如果不为空，将 tail 节点的 next 指针指向 node。
            // 将 node 的 prev 指向 tail 节点
            // 将当前节点作为为节点
            last.next = node;
            node.prev = last;
            this.tail = node;
        }
    }

    // 常规的 add，调用尾插即可。
    public void add(E element){
        this.linkTail(element);
    }

    // 删除最后一个节点
    public void removeLast(){
        // 无元素直接返回
        if (size == 0) return;
        // 长度减一
        size--;
        // 如果只有一个元素，删除之后，将 tail 和 first 改为 null 直接 return 即可。
        if (size == 0){
            this.tail = null;
            this.first = null;
            return;
        } else if (size == 1) {
            // 如果 size == 1，那么当前的 tail 和 first 节点都为第一个节点即 first
            // 并删除最后一个元素
            this.first.next = null;
            this.tail = this.first;
            return;
        }
        // 其他情况，获取到 tail 节点的前一个节点 preNode
        Node<E> preNode = this.tail.prev;
        preNode.next = null;
        this.tail = preNode;
    }

    // 删除头节点
    public void removeFirst(){
        // 无元素直接返回
        if (size == 0) return;
        // 长度减一
        size--;
        // 如果只有一个元素，删除之后，将 tail 和 first 改为 null 直接 return 即可。
        if (size == 0){
            this.tail = null;
            this.first = null;
            return;
        }else if (size == 1) {
            // 如果 size == 1，那么当前的 tail 和 first 节点都为第一个节点即 first
            // 并删除第一个元素
            this.tail.next = null;
            this.first = this.tail;
            return;
        }
        // 其他情况，获取到第一个节点的 nextNode
        Node<E> nextNode = this.first.next;
        this.first.next = null;
        nextNode.prev = null;
        // 更新 first
        this.first = nextNode;
    }
}
