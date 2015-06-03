public class PL2_Implementation {
	public static String x1 = "0yjnpjxcvssoblmoorxuc$";
	public static int n = x1.length() - 2;
	public static int pos[] = new int[10];
	public static int len[] = new int[10];
	public static int pref = 0;
	public static int i = 1;
	public static int m = 0;

	public static void main(String[] args) {
		System.out.println("PL2 Implementation:");
		char[] pattern = { 'a','b', 'a', 'a', 'b', 'a', 'b', 'a' };
		String pattern1 = new String(pattern);
		String preprocess = pattern1 + "$" + x1;

		final long startTime = System.nanoTime();
		while (i < n) {
			if (pref == 0) {
				i = i + 1;
			}

			while (x1.charAt(i + pref) == x1.charAt(1 + pref)) {
				pref = pref + 1;
			}

			if (pref != 0) {
				m = m + 1;
				pos[m] = i;
				len[m] = pref;
				// pref = copy(i, pref, m);

				int j = 1;
				int max = 0;
				while (pos[j] <= pref) {
					max = pref - pos[j] + 1;
					if (len[j] < max) {
						m = m + 1;
						pos[m] = i + pos[j] - 1;
						len[m] = len[j];
					} else if ((i + pref) >= n) {
						m = m + 1;
						pos[m] = i + pos[j] - 1;
						len[m] = max;
					} else {
						pref = -1;
						j = j - 1;
					}
					j = j + 1;
				}
				if (pref == -1) {
					i = i + pos[j] - 1;
					pref = max;
				} else {
					i = i + pref - 1;
					pref = 0;
				}
			}
		}
		 System.out.print("Pos Array: ");
		 for(int k = 1; k <= m; k++){
		 System.out.print(pos[k] + " ");
		 }
		 System.out.println();
		 System.out.print("Len Array: ");
		 for(int k = 1; k <= m; k++){
		 System.out.print(len[k] + " ");
		 }
		final long endTime = System.nanoTime();
		System.out.println();
		//System.out.println("Total execution time: " + (endTime - startTime)
				//+ " ms");
	}

	 private static int copy(int value, int pref, int value1) {
	 int j = 1;
	 int max = 0;
	 while (pos[j] <= pref) {
	 max = pref - pos[j] + 1;
	 if (len[j] < max) {
	 m = value1 + 1;
	 pos[m] = value + pos[j] - 1;
	 len[m] = len[j];
	 } else if ((value + pref) >= n) {
	 m = value1 + 1;
	 pos[m] = value + pos[j] - 1;
	 len[m] = max;
	 } else {
	 pref = -1;
	 j = j - 1;
	 }
	 j = j + 1;
	 }
	 if (pref == -1) {
	 i = value + pos[j] - 1;
	 pref = max;
	 } else {
	 i = value + pref - 1;
	 pref = 0;
	 }
	 return pref;
	 }
	 private static int match(int i, int pref) {
	 while (x1.charAt(i + pref) == x1.charAt(1 + pref)) {
	 pref = pref + 1;
	 }
	 return pref;
	 }
}
