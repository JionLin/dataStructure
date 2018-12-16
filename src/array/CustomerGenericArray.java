package array;

/**
 * @program: dataStructure
 * @description: 自定义泛型数组  // TODO: 2018/12/16 未做测试
 * @author: Join
 * @create: 2018-12-16 14:02
 **/
public class CustomerGenericArray<E> {
	// TODO: 2018/12/15  带参构造 无参构造 数组的容量 是否为空  元素个数
	// TODO: 2018/12/15  向所有元素后添加一个新元素 向所有元素前添加一个新元素 在index索引的位置插入一个新元素e
	// TODO: 2018/12/15  获取index索引位置的元素  修改index索引位置的元素为e tostring方法
	// TODO: 2018/12/15 查找数组中元素e所在的索引，如果不存在元素e，则返回-1  从数组中删除index位置的元素, 返回删除的元素
	// TODO: 2018/12/15 从数组中删除第一个元素, 返回删除的元素  从数组中删除最后一个元素, 返回删除的元素 从数组中删除元素e
	// TODO: 2018/12/15 泛型数据结构
	// TODO: 2018/12/15  动态数组
	// TODO: 2018/12/15  时间复杂度分析


	private E[] data;
	private int size;


	public CustomerGenericArray(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	public CustomerGenericArray() {
		this(20);
	}


	/**
	 * @Description: 获取数组的容量
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 14:17
	 */
	public int getCapacity() {
		return data.length;
	}

	/**
	 * @Description: 判断是否为空
	 * @Param: []
	 * @return: boolean
	 * @Author: Join
	 * @Date: 2018/12/16 14:16
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @Description: 获取数组的长度
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 14:18
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @Description: 在index索引的位置插入一个新元素e
	 * @Param: [index, e] 判断索引是否符合标准
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/16 14:21
	 */
	public void add(int index, E e) {
		if (index == data.length) {
			throw new IllegalArgumentException("索引越界");
		}
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引参数错误");
		}
		for (int i = index + 1; i < size; i++) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	/**
	 * @Description: 向所有元素前添加一个新元素
	 * @Param: [e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/16 14:22
	 */
	public void addFirst(E e) {
		add(0, e);
	}

	/**
	 * @Description: 向所有元素后添加一个新元素
	 * @Param: [e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/16 14:22
	 */
	public void addLast(E e) {
		add(size - 1, e);
	}

	/**
	 * @Description: 获取index索引位置的元素
	 * @Param: [e]
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 14:34
	 */
	public E getIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引参数错误");
		}
		return data[index];
	}

	/**
	 * @Description: 修改index索引位置的元素为e
	 * @Param: [index, e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/16 14:35
	 */
	public void set(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("索引异常");
		}
		data[index] = e;
	}

	/**
	 * @Description: 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
	 * @Param: [index, e]
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 16:33
	 */
	public int find(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引参数错误");
		}
		for (int i = 0; i < size; i++) {
			if (data[i] == e) {
				return i;
			}
		}
		return -1;

	}

	/**
	 * @Description: 从数组中删除index位置的元素, 返回删除的元素
	 * @Param: [index, e]
	 * @return: E
	 * @Author: Join
	 * @Date: 2018/12/16 16:35
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引参数错误");
		}
		E e = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return e;
	}

	//	  从数组中删除最后一个元素, 返回删除的元素 从数组中删除元素e

	/**
	 * @Description: 从数组中删除第一个元素, 返回删除的元素
	 * @Param: []
	 * @return: E
	 * @Author: Join
	 * @Date: 2018/12/16 16:47
	 */
	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size - 1);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < size; i++) {
			builder.append(data[i]);
			if (i != size - 1) {
				builder.append(",");
			}
			builder.append("]");
		}
		return builder.toString();
	}
}