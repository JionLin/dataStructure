package linkedlist;

/**
 * @program: dataStructure
 * @description: 链表
 * @author: Join
 * @create: 2019-01-09 21:59
 **/
public class LinkedList<E> {


	/**
	 * 自定义节点类,里面存储有元素以及节点
	 */
	private class Node {
		public E e;
		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	/**
	 * 节点
	 */
	private Node head;
	/**
	 * 链表的长度
	 */
	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * @Description: 获取链表的长度
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/10 9:20
	 */
	public int getSize() {
		return size;
	}


	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @Description: 往数组的头添加元素
	 * @Param: [e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2019/1/10 9:23
	 */
	public void addFirst(E e) {
		Node node = new Node(e);
		node.next = head;
		head = node;
//		head = new Node(e, head);
		size++;
	}

	/**
	 * @Description: 往索引中添加元素e
	 * @Param: [index, e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2019/1/10 10:03
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException(" index exception, add filed");
		}
		if (index == 0) {
			addFirst(e);
		} else {
			Node prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			Node node = new Node(e);
			node.next = prev.next;
			prev.next = node;
			size++;
		}
	}

	/**
	 * @Description: 往最后一个索引添加元素
	 * @Param: [e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2019/1/10 10:20
	 */
	public void addLast(E e) {
		add(size, e);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Node cur = head.next; cur != null; cur = cur.next) {
			stringBuilder.append(cur + "->");
		}
		stringBuilder.append("NULL");
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
//		linkedList.addLast(100);
//		System.out.println(linkedList);
	}

}
