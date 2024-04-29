package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		// Map<String, int> map = new HashMap<>();
		
		map.put("one", 1); // auto boxing
		map.put("two", 2);
		map.put("three",3);
		
		int i = map.get("one");
		int j = map.get(new String("one"));
		System.out.println(i + " : " + j);
		
		// set이 순회가 됨 
		// 순회
		Set<String> s = map.keySet();
		for(String key : s) {
			System.out.println(map.get(key));
		}

	}

}
