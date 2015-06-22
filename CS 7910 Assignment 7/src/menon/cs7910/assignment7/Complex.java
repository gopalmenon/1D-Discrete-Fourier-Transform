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
	 * Constructor
	 * @param real
	 * @param imaginary
	 * @param threshold
	 */
	public Complex(double real, double imaginary, double threshold) {
		
		if (Math.abs(real) < threshold) {
			this.real = 0.0;
		} else {
			this.real = real;
		}

		if (Math.abs(imaginary) < threshold) {
			this.imaginary = 0.0;
		} else {
			this.imaginary = imaginary;
		}
	}

	public static Complex valueOf(double real, double imaginary) {
		return new Complex(real, imaginary);
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
	 * @param divisor
	 * @return complex after dividing by  a real divisor
	 */
	public Complex divide(double divisor) {
		
		return new Complex(this.real / divisor, this.imaginary / divisor);
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * return a string representation of the complex number
	 */
	public String toString() {
		
		StringBuffer returnValue = new StringBuffer();
		
		returnValue.append("(");
		returnValue.append(this.real);
		returnValue.append(" + ");
		returnValue.append(this.imaginary);
		returnValue.append("i");
		returnValue.append(")");
		
		return returnValue.toString();
		
	}

	public double getReal() {
		return real;
	}

	public double getImaginary() {
		return imaginary;
	}
	
	public double getAbsoluteValue() {
		
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
		
	}
	
}

