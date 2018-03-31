
// GS Question 1
public class CompareDigits {

	public static void main(String[] args) {
		System.out.println(compare (10,20));

	}

	private static boolean compare(int i, int j) {
		
		String ivalue = i + "";
		char[] charArray = ivalue.toCharArray();
		
		String ivalue2 = j + "";
		char[] charArray2 = ivalue2.toCharArray();
		
		for (char c1 : charArray) {
			for (char c2 : charArray2) {
				
				if(c1 == c2){
					return false;
				}
				
			}
		}
		
		return true;
		
	}

}
