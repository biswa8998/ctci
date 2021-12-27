package array_strings;

import java.util.*;

public class OneAway {
	public static boolean solution(String lStr, String sStr) {
		if (lStr.length() < sStr.length()) {
			return solution(sStr, lStr);
		}

		// create map using small string
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : sStr.toCharArray()) {
			Integer i = map.get(c);
			if (i == null) {
				map.put(c, 1);
			} else {
				map.put(c, i + 1);
			}
		}

		int diffCount = 0;

		for (char c : lStr.toCharArray()) {
			if (diffCount >= 2) {
				return false;
			}

			Integer i = map.get(c);
			if (i == null) {
				diffCount++;
			} else if (i == 0) {
				diffCount++;
			} else {
				map.put(c, i - 1);
			}
		}

		return diffCount <= 1;
	}

	public static void main(String[] args) {
		System.out.println(solution("pale", "ple") == true);
		System.out.println(solution("pales", "pale") == true);
		System.out.println(solution("pale", "bale") == true);
		System.out.println(solution("pale", "bake") == false);
	}
}
