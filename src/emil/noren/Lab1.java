package emil.noren;

public class Lab1 {

	public static void main(String[] args) {

		char fizz[] = {'f', 'i', 'z', 'z'};
		char buzz[] = {'b', 'u', 'z', 'z'};

		String guide = "Answer to the Ultimate Question of Life, the Universe, and Evrything";
 		
		for(int i = 1; i <= 100; i++) {
			
			String ans;
//			System.out.println(i);
//			String ans = New String(fizz);
			
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("Fizzbuzz");
			} else if(i % 3 == 0) {
				System.out.println("Fizz");
			} else if(i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}
