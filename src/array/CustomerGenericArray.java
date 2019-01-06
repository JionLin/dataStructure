package array;

/**
 * @program: dataStructure
 * @description: 自定义泛型数组  2019年1月6日 做好，问题找好
 * @author: Join
 * @create: 2018-12-16 14:02
 **/
public class CustomerGenericArray<E> {

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
			resize(data.length * 2);
		}
		if (index < 0 || index > size) {
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
		add(size, e);
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
		if (index == data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		E e = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return e;
	}

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


	/**
	* @Description: 删除最后一个元素
	* @Param: []
	* @return: E
	* @Author: Join
	* @Date: 2019/1/6
	*/
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
		}
		builder.append("]");
		return builder.toString();
	}


	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
}