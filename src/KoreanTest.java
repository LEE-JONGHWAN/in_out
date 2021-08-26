import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class KoreanTest {
	public static void main(String[] args) {
		
		PrintStream out;
		try {
			out = new PrintStream(System.out, true, "UTF-8");
			out.println("한글이 잘 보입니까?");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
