package palindrome;

public class MinCharAddToPalin {

	public static int solve(String A) {

		String n = A.replaceAll("[^A-Za-z0-9]", "").replaceAll("\\s", "").toLowerCase();
		StringBuilder sb = new StringBuilder(n);

		if (n.length() == 1 || isPalindrome(n) == true) {
			return 0;
		}

		else {
			int len = n.length();
			while (sb.capacity() != 0) {
				if (isPalindrome(sb.toString())) {
					return len - sb.length();
				} else {
					sb.deleteCharAt(0);
				}
			}

			return len;

		}

	}

	public static boolean isPalindrome(String s) {

		int len = s.length();
		if(len==1) return false;

		for (int i = 0; i < len / 2; i++) {
			if (!(s.charAt(i) == s.charAt(len - i - 1))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(solve("ABC"));
	}

}
