package array;

/**
 * @program: dataStructure
 * @description: 学生类
 * @author: Join
 * @create: 2018-12-18 20:29
 **/
public class Student {
    private String name;
    private Integer id;

    public Student() {
    }

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
//        return String.format("Student(name:%s,id:%s)", name,id);
        return String.format("Student(name: %s, id: %d)", name, id);

    }

    public static void main(String[] args) {
        CustomerGenericArray<Student> genericArray=new CustomerGenericArray<>();
        Student student1=new Student("小强",18);
        Student student2=new Student("小牛",22);
        Student student3=new Student("小黑",24);
        genericArray.addLast(student1);
        genericArray.addLast(student3);
        genericArray.addLast(student2);
        System.out.println(genericArray);

    }
}
