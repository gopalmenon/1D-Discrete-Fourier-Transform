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

	public double getReal() {
		return real;
	}

	public double getImaginary() {
		return imaginary;
	}
	
}

