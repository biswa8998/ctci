package array_strings;

import java.util.*;

public class PalindromePermutation {
	public static boolean solution(String str) {
		str = str.replace(" ", "").toLowerCase();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			Integer i = map.get(c);
			if (i == null) {
				map.put(c, 1);
			} else {
				map.put(c, i + 1);
			}
		}

		int oddCount = 0;
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if (m.getValue() % 2 != 0)
				oddCount++;
		}

		return oddCount == 0 || oddCount == 1;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("aaa aaa a b"));
	}
}
