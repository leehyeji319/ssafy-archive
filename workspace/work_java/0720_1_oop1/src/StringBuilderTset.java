
public class StringBuilderTset {
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("hello");
		sb.append(" ssafy");
		sb.reverse();
		System.out.println(sb.toString());
		
		System.out.println(new StringBuilder().append("hello")
				.append(" ssafy").reverse().toString());
	}
}
