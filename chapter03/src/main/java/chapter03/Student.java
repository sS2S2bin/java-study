package chapter03;

public class Student extends Person {
    public Student() {
        // 자식 생성자에서 부모 생성자를 명시적으로 호출하지 않으면 
        // 자동으로 부모의 기본 생성자를 호출하게 된다.
    	// super();
        
        
        System.out.println("Student 클래스의 생성자가 호출");
        // 프린트 뒤에 찍으니까 왜 에러가 나지?
        // super();
        // 명시를 할 때도 앞에다 넣어야한다. 먼저 불려야하니까
        
    }

}
