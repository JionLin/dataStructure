package linkedlist;

/**
 * @program: dataStructure
 * @description: 虚拟头结点链表
 * @author: Join
 * @create: 2019-01-10 10:45
 **/
public class DummyHeadLinkedList<E> {
	/**
	 * 内部类节点
	 */
	private class Node {
		//元素
		public E e;
		//节点
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

	public Node dummyHead;
	public int size;


	public DummyHeadLinkedList() {
		size=0;
		dummyHead = new Node();
	}

	/** 
	* @Description: 在第一个位置添加元素e
	* @Param: [e] 
	* @return: void 
	* @Author: Join
	* @Date: 2019/1/10 10:52 
	*/
	public void addFirst(E e) {

	}

	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index exception ,add error");
		}


	}

	/** 
	* @Description: 在最后一个位置添加元素e 
	* @Param: [e] 
	* @return: void 
	* @Author: Join
	* @Date: 2019/1/10 10:52 
	*/
	public void addLast(E e) {

	}
}