package src.Learn.Link_List;

/**
 * 测试类
 */
public class Link_List_Test {

    public static void main(String[] args) {

        Link_List<Integer> link_list  = new Link_List<>();
        // 获取当前的 size
        System.out.println("为插入元素之前，size="+link_list.size);
        // 添加元素
        link_list.linkFirst(1);
        System.out.println("插入一个节点1之后,当前的链表的长度为："+link_list.size);

        link_list.linkFirst(2);
        System.out.println("插入一个节点2之后,当前的链表的长度为："+link_list.size);

        link_list.linkTail(3);
        System.out.println("插入一个节点3之后,当前的链表的长度为："+link_list.size);

        // 预期的元素顺序：2 1 3
        Node<Integer> first = link_list.first;
        while(first!=null){
            System.out.println(first.item);
            first = first.next;
        }
        System.out.println("========================");
        // 预期的元素顺序：3 2 1
        Node<Integer> tail = link_list.tail;
        while(tail!=null){
            System.out.println(tail.item);
            tail = tail.prev;
        }
        link_list.removeFirst(); // 1 3
        link_list.add(4);  // 1 3 4
        link_list.removeLast(); // 1 3

        System.out.println("========================");
        // 预期的元素顺序：1 3
        Node<Integer> first1 = link_list.first;
        while(first1!=null){
            System.out.println(first1.item);
            first1 = first1.next;
        }
    }
}
