package array;

import javax.sound.midi.Soundbank;

/**
 * @program: dataStructure
 * @description: 自定义数组
 * @author: Join
 * @create: 2018-12-15 13:17
 **/
public class CustomerArray {

	// TODO: 2018/12/15  带参构造 无参构造 数组的容量 是否为空  元素个数
	// TODO: 2018/12/15  向所有元素后添加一个新元素 向所有元素前添加一个新元素 在index索引的位置插入一个新元素e
	// TODO: 2018/12/15  获取index索引位置的元素  修改index索引位置的元素为e tostring方法
	// TODO: 2018/12/15 查找数组中元素e所在的索引，如果不存在元素e，则返回-1  从数组中删除index位置的元素, 返回删除的元素
	// TODO: 2018/12/15 从数组中删除第一个元素, 返回删除的元素  从数组中删除最后一个元素, 返回删除的元素 从数组中删除元素e
	// TODO: 2018/12/15 泛型数据结构
	// TODO: 2018/12/15  动态数组
	// TODO: 2018/12/15  时间复杂度分析


	private int[] data;
	private int size;


	/**
	 * @Description: 带参构造
	 * @Param: [capacity]
	 * @return:
	 * @Author: Join
	 * @Date:
	 */
	public CustomerArray(int capacity) {
		data = new int[capacity];
		size = 0;
	}


	/**
	 * @Description: 无参构造
	 * @Param: []
	 * @return:
	 * @Author: Join
	 * @Date:
	 */
	public CustomerArray() {
		this(10);
	}

	/**
	 * @Description: 获取容量
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 17:12
	 */
	public int getCapacity() {
		return size;
	}

	/**
	 * @Description: 判断是否为空
	 * @Param: []
	 * @return: boolean
	 * @Author: Join
	 * @Date: 17:13
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @Description: 获取数组的长度
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 17:15
	 */
	public int getLength() {
		return data.length;
	}


	/**
	 * @Description: 往所有元素后添加一个元素
	 * @Param: [e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/15 17:58
	 */
	public void addLast(int e) {
		//size 从0开始计算,带进来的,e为添加的哪个元素
		add(size, e);
	}


	/**
	 * @Description: 在index索引的位置插入一个新元素e
	 * @Param: [index, e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/15 17:28
	 */
	public void add(int index, int e) {
		// e  0 1  2 3 4
		//判断size是否等于数组的长度
		if (size == data.length) {
			throw new IllegalArgumentException("add File size exception");
		}
		// 判断索引是否越界
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("add File index exception");
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}


	/**
	 * @Description: 往第一个添加元素
	 * @Param: [e]
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/15 18:00
	 */
	public void addFirst(int e) {
		//0 1 2 3 4
		add(0, e);
	}

	/**
	 * @Description: 获取index索引位置的元素
	 * @Param: [index]
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 8:30
	 */
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("get index exception");
		}
		return data[index];
	}

	/**
	 * @Description: 修改index索引位置的元素为e
	 * @Param: []
	 * @return: void
	 * @Author: Join
	 * @Date: 2018/12/16 8:34
	 */
	public void set(int index, int e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("get index exception");
		}
		data[index] = e;
	}

	/**
	 * @Description: 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
	 * @Param: [e]
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 9:02
	 */
	public int getIndex(int e) {
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
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 9:14
	 */
	public int remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("get index exception");
		}
		int result = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		return result;
	}

	/**
	 * @Description: 从数组中删除第一个元素, 返回删除的元素
	 * @Param: [index]
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 13:50
	 */
	public int removeFirst(int index) {
		return remove(0);
	}

	/**
	 * @Description: 从数组中删除最后一个元素, 返回删除的元素
	 * @Param: [index]
	 * @return: int
	 * @Author: Join
	 * @Date: 2018/12/16 13:51
	 */
	public int removeLast(int index) {
		return remove(size - 1);
	}

	/**
	 * @Description: 重写object的toString方法
	 * @Param: []
	 * @return: java.lang.String
	 * @Author: Join
	 * @Date: 2018/12/16 8:29
	 */
	@Override
	public String toString() {

		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
		res.append('[');
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) {
				res.append(", ");
			}
		}
		res.append(']');
		return res.toString();
	}

	public static void main(String[] args) {
		CustomerArray array = new CustomerArray();
		for (int i = 0; i < 5; i++) {
			array.addLast(i);
		}
		System.out.println(array);
		System.out.println(array.get(3));
		array.set(2, 100);
		System.out.println(array);
		System.out.println("getIndex= " + array.getIndex(4));
		System.out.println("remove= " + array.remove(2));
		System.out.println(array);
		System.out.println("============");
		System.out.println(array.removeFirst(0));
		System.out.println(array);
		System.out.println("============");
		System.out.println(array.removeLast(array.size - 1));
		System.out.println(array);
	}



}
