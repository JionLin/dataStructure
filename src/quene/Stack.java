package quene;

/**
 * @program: dataStructure
 * @description: 栈  栈的数据格式是先进后出,有所谓的压栈和弹栈 示例有撤销返回键
 * @author: Join
 * @create: 2018-12-25 15:38
 **/
public interface Stack<E> {
    /**
    * @Description: 删除最后一个元素
    * @Param: [] 
    * @return: E 
    * @Author: Join
    * @Date: 2018/12/25 
    */
    E pop();
   /** 
   * @Description: 添加元素
   * @Param: [e] 
   * @return: void 
   * @Author: Join
   * @Date: 2018/12/25 
   */
    void push(E e);
    /** 
    * @Description: 获取数组长度
    * @Param: [] 
    * @return: int 
    * @Author: Join
    * @Date: 2018/12/25 
    */
    int getSize();
   /**
   * @Description: 判断是否为空
   * @Param: []
   * @return: boolean
   * @Author: Join
   * @Date: 2018/12/25
   */
    boolean isEmpty();
    /** 
    * @Description: 获取最后一个元素的值 
    * @Param: [] 
    * @return: E
    * @Author: Join
    * @Date: 2018/12/25 
    */
    E peek();



}
