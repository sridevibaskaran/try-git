import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PLS_Implementation {
	public static void main(String[] args) throws IOException {
		
		String text = "ABABABAC";
		String pattern = "BAB";
		
		int index = text.indexOf(pattern);
		
		while(index >= 0){
			System.out.println(index);
			index = text.indexOf(pattern, index+1);
		}
		
	}
}
