package array;

/**
 * @program: dataStructure
 * @description: 自定义泛型数组
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
        this(10);
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
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引参数错误");
        }
        if (index == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
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

    //是否有包含元素e,如果没有,返回false
    public boolean isConstains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @Param: [index, e]
     * @return: int
     * @Author: Join
     * @Date: 2018/12/16 16:33
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * @Description: 从数组中删除index位置的元素, 返回删除的元素 TODO 为什是这样
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
            data[i - 1] = data[i];
        }
        size--;
        if (size == data.length / 4 && size != data.length / 2) {
            resize(data.length / 2);
        }
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
     * @Description: 删除掉最后一个
     * @Param: []
     * @return: E
     * @Author: Join
     * @Date: 2018/12/18
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * @Description: 从数组中删除元素e
     * @Param: [e]
     * @return: void
     * @Author: Join
     * @Date: 2018/12/18
     */
    public void removeElement(E e) {
        //拿到其中的索引
        int data = find(e);
        if (data != -1) {
            remove(data);
        }
    }

    /**
     * @Description: 进行动态数组的调整 扩容整理
     * @Param: [newData]
     * @return: void
     * @Author: Join
     * @Date: 2018/12/18
     */
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }

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
        //进行添加元素
        CustomerGenericArray<Integer> genericArray = new CustomerGenericArray<>();
        for (int i = 0; i < 30; i++) {
            //添加最后一个
            genericArray.addLast(i);
        }
        System.out.println(genericArray);
        System.out.println("===");
        //添加第一个
        genericArray.add(1, 100);
        System.out.println(genericArray);
        System.out.println("===");

        // 从数组中删除index索引位置的元素, 返回删除的元素
        genericArray.remove(1);
        System.out.println(genericArray);
        System.out.println("===");

        //删除最后一个
        genericArray.removeLast();
        System.out.println(genericArray);
        System.out.println("===");

        //删除第一个
        genericArray.removeFirst();
        System.out.println(genericArray);

        //添加索引3为5
        genericArray.add(3, 5);
        System.out.println(genericArray);
        System.out.println("===");
        //删除某个元素
        genericArray.removeElement(5);
        System.out.println(genericArray);
        System.out.println("===");

        //修改index索引位置的元素为e
        genericArray.set(1, 22);
        System.out.println(genericArray);
        System.out.println("===");

        //获取数组的长度
        System.out.println(genericArray.getSize());
        System.out.println("===");


        //获取索引为2的元素的值
        System.out.println(genericArray.getIndex(2));
        System.out.println("===");

        System.out.println(genericArray.find(22));
        System.out.println("===");

        System.out.println(genericArray.isConstains(16));
        System.out.println("===");

    }
}