package stack;

/**
 * @program: dataStructure
 * @description:
 * @author: Join
 * @create: 2018-12-25 15:53
 **/
public class StackImpl<E> implements Stack<E> {

	private CustomerGenericArray<E> array;

	//构造函数
	public StackImpl(int capacity) {
		array = new CustomerGenericArray<>(capacity);
	}

	//无参构造
	public StackImpl() {
		this(10);
	}

	/**
	 * @Description: 删除最后一个元素
	 * @Param: []
	 * @return: E
	 * @Author: Join
	 * @Date: 2018/12/25
	 */
	@Override
	public E pop() {
		return array.removeLast();
	}

	/**
	 * @param e
	 * @Description: 添加元素
	 * @Param: [e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/25
	 */
	@Override
	public void push(E e) {
		array.addLast(e);
	}

	/**
	 * @Description: 获取数组长度
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/25
	 */
	@Override
	public int getSize() {
		return array.getSize();
	}

	/**
	 * @Description: 获取数组的容量
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/25
	 */
	public int getCapacity() {
		return array.getCapacity();
	}

	/**
	 * @Description: 判断是否为空
	 * @Param: []
	 * @return: boolean
	 * @Author: Join
	 * @Date: 2018/12/25
	 */
	@Override
	public boolean isEmpty() {
		return array.size == 0;
	}

	/**
	 * @Description: 获取最后一个元素的值
	 * @Param: []
	 * @return: E
	 * @Author: Join
	 * @Date: 2018/12/25
	 */
	@Override
	public E peek() {
		return array.getElement(array.size - 1);
	}

	//toString方法
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < array.size; i++) {
			builder.append(array.data[i]);
			if (i != array.size - 1) {
				builder.append(", ");
			}
		}
		builder.append("] top");
		return builder.toString();
	}

	/**
	 * @Description: 进行测试
	 * @Param: [args]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/25
	 */
	public static void main(String[] args) {
		StackImpl stack = new StackImpl();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println(stack);
		}
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
