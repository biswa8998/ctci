package array_strings;

public class Urlify {
	public static String solution(String str) {
		char[] carr = str.toCharArray();
		char[] regex = new char[] { '%', '2', '0' };
		boolean isNonSpaceFound = false;
		int s = carr.length - 1;
		for (int i = s; i >= 0; i--) {
			if (carr[i] != ' ') {
				if (!isNonSpaceFound)
					isNonSpaceFound = true;
				carr[s] = carr[i];
				s--;
			} else {
				if (isNonSpaceFound) {
					int count = regex.length - 1;
					while (count >= 0) {
						carr[s] = regex[count];
						count--;
						s--;
					}
				}
			}
		}

		return String.valueOf(carr);
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("Mr John Smith    "));
	}
}
