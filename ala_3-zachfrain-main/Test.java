import java.util.Random;
import java.util.Arrays;
/**
 * 
 * @author Zachary Frain
 * @version 1.0
 */
public class Test {

	public static void main(String[] args) {
		Number[] numbers = new Number[10]; //Initializing numbers array with size 10
		Random r = new Random(); //Creates new random r
		for(int i=0; i<numbers.length; i++) {
			switch(i%5) {
				case 0: //int
					numbers[i] = r.nextInt(100); //Sets numbers[i] to an int value
					break;
				case 1: //long
					numbers[i] = (long) r.nextInt(100); //Sets numbers[i] to a long value
					break;
				case 2: //float
					numbers[i] = r.nextFloat() * 100; //Sets numbers[i] to a float value
					break;
				case 3: //double
					numbers[i] = r.nextDouble() * 1000000; //Sets numbers[i] to a double value
					break;
				case 4: //rational
					numbers[i] = new Rational(r.nextInt(10), r.nextInt(10)+1); //Sets numbers[i] to a rational
					break;
			}
		}
		System.out.println("List of numbers");
		System.out.println("Value\t\tInt Value\t\tDouble Value");
		for(int i=0; i<numbers.length; i++) { //Prints the list of numbers
			System.out.println(numbers[i].toString() + "\t\t" +
							   numbers[i].intValue() + "\t\t" +
							   numbers[i].doubleValue());
		}
		
		Rational[] fractions = new Rational[8]; //Initializing fractions array with size 8
		for(int i=0; i<fractions.length; i++) {
			fractions[i] = new Rational(r.nextInt(10), r.nextInt(10)+1);//Creates random rationals for the fractions array
		}
		
		System.out.println("Original list of fractions");
		for(int i=0; i<fractions.length; i++) {
			System.out.println(fractions[i].toString()); //Prints the fractions using the toString() method
		}
		
		System.out.println("Operations on fractions");
		System.out.println(fractions[0] + "+" + fractions[1] + " = " +
						   fractions[0].add(fractions[1])); //Adding fractions[0] and fractions[1]
		System.out.println(fractions[2] + "-" + fractions[3] + " = " +
						   fractions[2].sub(fractions[3])); //Subtracting fractions[3] from fractions[2]
		System.out.println(fractions[4] + "*" + fractions[5] + " = " + 
						   fractions[4].mult(fractions[5])); //Multiplying fractions[4] and fractions[5]
		System.out.println(fractions[6] + "/" + fractions[7] + " = " + 
						   fractions[6].div(fractions[7])); //Dividing fractions[6] by fractions[7]
		
		System.out.println("Sorted list of fractions");
		Arrays.sort(fractions); //Sorts the fractions list
		for(int i=0; i<fractions.length; i++) {
			System.out.println(fractions[i].toString()); //Prints the fractions using the toString() method
		}		
	}
}
