package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		String s1 = new String("둘리");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("도우너");
		s.add(s1);
		
		System.out.println(s.size());
		System.out.println(s.contains(s1)); //hashCode값 비교
		System.out.println(s); // 내용확인이기 때문에 당연히 안들어감
		
		
		// 순회
		for(String str : s) {
			System.out.println(str);
		}
		
		
		

	}

}
