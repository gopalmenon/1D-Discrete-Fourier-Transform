package menon.cs7910.assignment7;

public class Complex {
	
	private double real;
	private double imaginary;
	
	/**
	 * Constructor
	 * @param real
	 * @param imaginary
	 */
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	/**
	 * @param complexToAdd
	 * @return a complex number that is the result of adding this and another complex number
	 */
	public Complex add(Complex complexToAdd) {
		
		return new Complex(this.real + complexToAdd.real, this.imaginary + complexToAdd.imaginary);
		
	}
	
	/**
	 * @param complexToSubtract
	 * @return a complex number that is the result of subtracting another complex number from this 
	 */
	public Complex subtract(Complex complexToSubtract) {
		
		return new Complex(this.real - complexToSubtract.real, this.imaginary - complexToSubtract.imaginary);
		
	}

	/**
	 * @param multiplier
	 * @return a new complex number that is the result of multiplying this and another complex number 
	 */
	public Complex multiply(Complex multiplier) {
		
		double realsProduct = this.real * multiplier.real;
		double imaginariesProduct = this.imaginary * multiplier.imaginary;
		double sumProduct = (this.real + this.imaginary) * (multiplier.real + multiplier.imaginary);
			
		return new Complex(realsProduct - imaginariesProduct, sumProduct - (realsProduct + imaginariesProduct));
	}
	
	/**
	 * @return the inverse of this complex number when it is a root of unity
	 */
	public Complex getInverseOfRootOfUnity() {
		
		return new Complex(this.real, -this.imaginary);
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * return a string representation of the complex number
	 */
	public String toString() {
		
		StringBuffer returnValue = new StringBuffer();
		
		returnValue.append(this.real);
		returnValue.append(" + ");
		returnValue.append(this.imaginary);
		returnValue.append("j");
		
		return returnValue.toString();
		
	}
	
	/**
	 * @param exponent
	 * @return the roots of unity as an array of complex numbers
	 */
	public static Complex[] getRootsOfUnity(int exponent) {
		
		Complex[] returnValue = new Complex[exponent];
		
		//Find the angle for the first root of unity
		double complexNumberAngle = 2* Math.PI / exponent;
		
		//Find the first and last roots of unity
		returnValue[0] = new Complex(1, 0);
		Complex increment = new Complex(Math.cos(complexNumberAngle), Math.sin(complexNumberAngle));
		
		//Find the rest by multiplying the previous one with the first one
		for (int index = 1; index < exponent; ++index) {
			returnValue[index] = new Complex(returnValue[index - 1].real, returnValue[index - 1].imaginary).multiply(increment);
		}
		
		return returnValue;
		
	}

	public double getReal() {
		return real;
	}

	public double getImaginary() {
		return imaginary;
	}
	
}

