
import java.util.stream.IntStream;

public class lab12 {
	
	void detect(int n) {
		
		if(n <= 0) {
			System.out.println("Input can't be less than 1");
			return;
		}


		System.out.println("Divisors: "); 
		
		IntStream
			.rangeClosed(1, n/2)              
			.filter(x -> n % x == 0)
			.forEach(System.out::println);
		
		int sum = IntStream
						.rangeClosed(1, n/2)
						.filter(x -> n % x == 0)
						.sum();
		
		
		System.out.println("");
		System.out.println("Your number was " + n + ".  Sum of the divisors = " + sum);
		System.out.println("");
		
		if(n == sum) {
			System.out.println("The number is perfect!");
		}
		
		else if (sum < n) {
			System.out.println("The number is deficient!");
		}
		
		else {
			System.out.println("The number is abundant!");
		}
	}

	public static void main(String[] args) {
	
		lab12 PerfectNumber = new lab12();
		
		PerfectNumber.detect(28);
	}

}