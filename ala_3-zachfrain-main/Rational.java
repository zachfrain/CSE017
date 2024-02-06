/**
 * 
 * @author Zachary Frain
 * @version 1.0
 *
 */
public class Rational extends Number implements Comparable<Rational>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numerator, denominator;
	/**
	 * Creates a rational with no parameters
	 */
	public Rational() {
		numerator = 0;
		denominator = 1;
	}
	/**
	 * Creates a rational with numerator and denominator specified
	 * @param n The numerator for the rational
	 * @param d The denominator for the rational
	 */
	public Rational(int n, int d) {
		numerator=n;
		denominator=d;
	}
	/**
	 * Gets the rational's numerator
	 * @return An int that represents the rational's denominator
	 */
	public int getNumerator() {
		return numerator;
	}
	/**
	 * Gets the rational's denominator
	 * @return An int that represents the rational's denominator
	 */
	public int getDenominator() {
		return denominator;
	}
	/**
	 * Sets the rational's numerator
	 * @param n An int containing the rational's numerator
	 */
	public void setNumerator(int n) {
		numerator = n;
	}
	/**
	 * Sets the rational's denominator
	 * @param d An int containing the rational's denominator
	 */
	public void setDenominator(int d) {
		denominator = d;
	}
	/**
	 * Returns a formatted string with the rational's information
	 */
	public String toString() {
		reduce();
		if(numerator == 0)
			return "0";
		else if(denominator == 1)
			return "" + numerator;
		else if(denominator < 0)
			return (-numerator) + "/" + (-denominator);
		else if(numerator == denominator)
			return "1";
		else
			return numerator + "/" + denominator;
	}
	/**
	 * Adds two rationals together
	 * @param r The rational being added to the rational called from
	 * @return The reduced sum of the two rationals
	 */
	public Rational add(Rational r) {
		int sumN = this.numerator * r.denominator + this.denominator * r.numerator;
		int sumD = this.denominator * r.denominator;
		Rational sum = new Rational(sumN, sumD);
		sum.reduce();
		return sum;
	}
	/**
	 * Subtracts two rationals
	 * @param r The rational that is subtracted from the rational called from
	 * @return The difference between the two rationals
	 */
	public Rational sub(Rational r) {
		int diffN = this.numerator * r.denominator - this.denominator * r.numerator;
		int diffD = this.denominator * r.denominator;
		Rational diff = new Rational(diffN, diffD);
		diff.reduce();
		return diff;
	}
	/**
	 * Multiplies two rationals together
	 * @param r The rational being multiplied by the rational called from
	 * @return The product of the two rationals
	 */
	public Rational mult(Rational r) {
		int prodN = this.numerator * r.numerator;
		int prodD = this.denominator * r.denominator;
		Rational product = new Rational(prodN, prodD);
		product.reduce();
		return product;
	}
	/**
	 * Divides two rationals
	 * @param r The rational that divides the rational called from
	 * @return The quotient of the two rationals
	 */
	public Rational div(Rational r) {
		int quotN = this.numerator * r.denominator;
		int quotD = this.denominator * r.numerator;
		Rational quotient = new Rational(quotN, quotD);
		quotient.reduce();
		return quotient;
	}
	/**
	 * Reduces a rational
	 */
	private void reduce() {
		int g = gcd();
		numerator /= g;
		denominator /= g;
	}
	/**
	 * Finds the greatest common denominator between two rationals
	 * @return An int representing the greatest common denominator of the two rationals
	 */
	public int gcd() {
		int g=1;
		int min = Math.min(numerator,  denominator);
		for(int i=2; i<min; i++) {
			if(numerator % i == 0 && denominator % i == 0) {
				g = i;
			}
		}
		return g;
	}
	/**
	 * @return The int value of the rational
	 */
	public int intValue() {
		return numerator / denominator;
	}
	/**
	 * @return The long value of the rational
	 */
	public long longValue() {
		return (long)(numerator/denominator);
	}
	/**
	 * @return The float value of the rational
	 */
	public float floatValue() {
		return (float)(numerator/denominator);
	}
	/**
	 * @return The double value of the ratoinal
	 */
	public double doubleValue() {
		return (double)(numerator/denominator);
	}
	/**
	 * Compares two rationals
	 */
	public int compareTo(Rational r) {
		if(this.doubleValue() == r.doubleValue())
			return 0;
		else if(this.doubleValue() > r.doubleValue())
			return 1;
		else
			return -1;
	}
}
