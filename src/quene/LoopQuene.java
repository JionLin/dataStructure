package quene;

/**
 * @program: dataStructure
 * @description: 循环队列\
 * @author: Join
 * @create: 2019-01-07 22:10
 **/
public class LoopQuene<E> implements quene<E> {

	public E[] data;
	public int size;
	public int front,tail;

	public LoopQuene(int capacity) {
		data =(E[]) new Object[capacity + 1];
		front=0;
		tail=0;
		size = 0;
	}

	public LoopQuene() {
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
		return 0;
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
		return 0;
	}

	/**
	 * @param e
	 * @Description: 入队 先入先出 入队是往后
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	@Override
	public void enQuene(E e) {

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
		return null;
	}
}
