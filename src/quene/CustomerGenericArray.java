package quene;

/**
 * @program: dataStructure
 * @description: 自定义泛型数组
 * @author: Join
 * @create: 2018-12-25 10:24
 **/
public class CustomerGenericArray<E> {

	//长度
	public int size;
	//数组
	public E[] data;

	//自定义构造方法
	public CustomerGenericArray(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	//无参构造
	public CustomerGenericArray() {
		this(10);
	}

	//获取数组的容量 1
	public int getCapacity() {
		return data.length;
	}

	//获取数组中的元素个数 2
	public int getSize() {
		return size;
	}

	//返回数组是否为空 3
	public boolean isEmpty() {
		return size == 0;
	}

	//在index索引的位置插入一个新元素e 4
	public void addElement(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("索引异常");
		}
		if (size == data.length) {
			resize(data.length * 2);
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;

	}

	//向所有元素后添加一个新元素 5
	public void addLast(E e) {
		addElement(size, e);
	}

	//在所有元素前添加一个新元素 6
	public void addFirst(E e) {
		addElement(0, e);
	}

	//获取index索引位置的元素 7
	public E getElement(int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("索引异常");
		}
		return data[index];
	}

	//修改index索引位置的元素e 8
	public void set(int index, E e) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("索引异常");
		}
		data[index] = e;
	}

	//查找数组中是否有元素e 9
	public boolean isContain(E e) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	//查找数组中元素e所在的索引,如果没有,返回-1  10
	public int find(E e) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}

		return -1;
	}

	//从数组中删除index位置的元素,返回删除的元素 11
	public E removeElement(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引异常");
		}
		if (size == data.length / 4 && size != data.length / 2) {
			resize(data.length / 2);
		}
		for (int i = size - 1; i >= index; i--) {
			data[i - 1] = data[i];
		}
		size--;
		return data[index];
	}

	//从数组中删除第一个元素,返回删除的元素 12
	public void removeFirst() {
		removeElement(0);
	}

	//从数组中删除最后一个元素,返回删除的元素 13
	public E removeLast() {
		return removeElement(size - 1);
	}

	//toString方法 14 Array :  size=  length=   [1,2,3]
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerGenericArray: size: %d,length: %d", size, data.length);
		builder.append("[");
		for (int i = 0; i < data.length; i++) {
			builder.append(data[i] + " ,");
			if (data.length == size - 1) {
				builder.append(data[i]);
			}
		}
		builder.append("]");
		return builder.toString();
	}

	//将数组空间的容量变成newCapacity大小 15  todo
	public void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	//获取最后一个
	public E getLast() {
		return getElement(size - 1);
	}

	//获取第一个
	public E getFirst() {
		return getElement(0);
	}

}
