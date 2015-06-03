import java.util.Random;

public class Generate_Random_Strings {
	public static void main(String[] args) {
		char[] chars = "ab".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
	}
}
