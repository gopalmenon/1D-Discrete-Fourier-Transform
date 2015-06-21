package menon.cs7910.assignment7;

public class OneDDFT {
	
	public static final int POSITIVE_SIGN = 1;
	public static final int NEGATIVE_SIGN = -1;
	
	/**
	 * @param k
	 * @param n
	 * @param N
	 * @param sign
	 * @param thresh
	 * @return the kth complex sinusoid corresponding to the Nth root of unit
	 */
	public static Complex kthComplexSinusoidAt(int k, int n, int N, int sign, double thresh) {
		
		assert(checkSign(sign));
				
		double thetaInRadians = 2 * Math.PI * k * n / N;
		
		double realPart = Math.cos(thetaInRadians);
		if (Math.abs(realPart) < thresh) {
			realPart = 0.0;
		}
		
		double imaginaryPart = Math.sin(thetaInRadians);
		if (Math.abs(imaginaryPart) < thresh) {
			imaginaryPart = 0.0;
		}
		
		return new Complex(realPart, imaginaryPart != 0 ? sign * imaginaryPart : 0.0);
		
	} 
	
	public static Complex[][] computeDFTMat(int N, int sign, double thresh) {
		return null;
	}
	
	public static double[] computeAbsoluteSpectrum(Complex[] signal, int sign, double thresh) {
		return null;
	}
	
	public static Complex[][] computeInverseDFTMat(int N, int sign, double thresh) {
		return null;
	}
	
	public static Complex[] computeSpectrum(Complex[] signal, int sign, double thresh) {
		return null;
	}
	
	public static Complex[] invertSpectrum(Complex[] spectrum, double thresh) {
		return null;
	}
	
	public static double[] invertSpectrumIntoMagnitudes(Complex[] spectrum, double thresh) {
		return null;
	}
	
	/**
	 * Display the kth complex sinusoid
	 * @param k
	 * @param N
	 * @param sign
	 * @param thresh
	 */
	public static void displayKthComplexSinusoid(int k, int N, int sign, double thresh) {
		
		for(int n = 0; n < N; n++) {
			System.out.print(OneDDFT.kthComplexSinusoidAt(k, n, N, sign, thresh) + " ");
		}
		
		System.out.println();
		
	}
	
	private static boolean checkSign(int sign) {
		
		if (sign != POSITIVE_SIGN && sign != NEGATIVE_SIGN) {
			System.err.println("Sign can only be " + NEGATIVE_SIGN + " or " + NEGATIVE_SIGN + ".");
			return false;
		} else {
			return true;
		}
		
	}

}
