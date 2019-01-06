package quene;

/**
 * @program: dataStructure
 * @description: 队列
 * @author: Join
 * @create: 2019-01-06 10:38
 **/
public interface quene<E> {
	/**
	 * @Description: 获取容量
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	int getCapacity();

	/**
	 * @Description: 获取长度
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	int getSize();

	/**
	 * @Description: 入队 先入先出 入队是往后
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	void addElement(E e);


	/**
	 * @Description: 出队 是往前出
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	void removeElement();

	/**
	 * @Description: 查询最后一个元素
	 * @Param: []
	 * @return: int
	 * @Author: Join
	 * @Date: 2019/1/6
	 */
	E findElementLast();
}
