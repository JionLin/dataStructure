package quene;

/**
 * @program: dataStructure
 * @description: 循环队列
 * @author: Join  % 　　取余（取模）有个规律就是：左边小于右边，结果为左边，左边大于右边，看余数
 * @create: 2019-01-07 22:10
 **/
public class LoopQuene<E> implements quene<E> {

	public E[] data;
	public int size;
	public int front, tail;

	/**
	 * @Description: 为什么capacity+1?
	 * @Param: [capacity]
	 * @return:
	 * @Author: Join
	 * @Date: 2019/1/8
	 */
	public LoopQuene(int capacity) {
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}

	public LoopQuene() {
		this(10);
	}

	/**
	 * @Description: 获取容量 为什么-1  需要空出一个空间来,
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public int getCapacity() {
		return data.length - 1;
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
		return size;
	}

	/**
	 * @param e
	 * @Description: 入队 先入先出 入队是往后 往后压
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public void enQuene(E e) {

		if ((tail + 1) % data.length == front) {
			resize(getCapacity() * 2);
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}

	/**
	 * @Description: 出队 是往前出
	 * @Param: []  front 为什么等于 其+1 取余 data.length  出队,从最前面出,最前面的值就为null
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public E deQuene() {
		if (isEmpty()) {
			throw new IllegalArgumentException("quene is Empty");
		}
		E result = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
			resize(getCapacity() / 2);
		}
		return result;

	}

	/**
	 * @Description: 查询第一个元素
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("getFront is Empty");
		}
		return data[front];
	}

	public boolean isEmpty() {
		return front == tail;
	}

	/**
	 * @Description: 进行数组的扩容
	 * @Param: [capacity]
	 * @return: void
	 * @Author: Join
	 * @Date: 2019/1/8
	 */
	private void resize(int capacity) {
		E[] newData = (E[]) new Object[capacity + 1];
		for (int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("LoopQuene: size : %d ,capacity : %d\n",size,getCapacity()));
		stringBuilder.append("front [");
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			stringBuilder.append(data[i]);
			if ((i + 1) % data.length != tail) {
				stringBuilder.append(", ");
			}
		}
		stringBuilder.append("] tail");
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		LoopQuene quene = new LoopQuene();
		for (int i = 0; i < 13; i++) {
			quene.enQuene(i);
			System.out.println(quene);
			if (i % 3 == 2) {
				quene.deQuene();
				System.out.println(quene);
			}
		}
	}
}
