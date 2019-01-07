package quene;

/**
 * @program: dataStructure
 * @description:
 * @author: Join
 * @create: 2019-01-06 10:44
 **/
public class queneImpl<E> implements quene<E> {

	private CustomerGenericArray array;

	//构造函数
	public queneImpl(int capacity) {
		array = new CustomerGenericArray(capacity);
	}

	public queneImpl() {
		this(10);
	}

	/**
	 * @Description: 获取容量
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public int getCapacity() {
		return array.getCapacity();
	}

	/**
	 * @Description: 获取长度
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public int getSize() {
		return array.getSize();
	}

	/**
	 * @Description: 入队 先入先出 入队是往后
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public void enQuene(E e) {
		array.addLast(e);
	}

	/**
	 * @Description: 出队 是往前出
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public void deQuene() {
		array.removeFirst();
	}

	/**
	 * @Description: 查询最后一个元素
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public E getFront() {
		return (E) array.getFirst();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("queue [");
		for (int i = 0; i < array.size; i++) {
			builder.append(array.getElement(i));
			if (i != array.size - 1) {
				builder.append(", ");
			}
		}
		builder.append("] top");
		return builder.toString();
	}

	public static void main(String[] args) {
		queneImpl quene = new queneImpl();
		for (int i = 0; i < 11; i++) {
			quene.enQuene(i);
			System.out.println(quene);
		}
		quene.deQuene();
		System.out.println(quene);
		System.out.println(quene.getFront());
	}
}
