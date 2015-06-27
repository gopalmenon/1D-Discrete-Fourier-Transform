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
		
		double thetaInRadians = 2 * Math.PI * k * n / N;
		
		double realPart = Math.cos(thetaInRadians);
		double imaginaryPart = Math.sin(thetaInRadians);
		
		return new Complex(realPart, sign == NEGATIVE_SIGN ? sign * imaginaryPart : imaginaryPart, thresh);
		
	} 
	
	private static Complex[][] computeDFTAndInverseDFTMatrix(int N, int sign, double thresh, boolean inverseDft) {
		
		int signToUse = 0;
		if (inverseDft) {
			signToUse = NEGATIVE_SIGN * sign;
		} else {
			signToUse = sign;
		}
		
		Complex[][] returnValue = new Complex[N][N];
		
		for (int kthSinusoidIndex = 0; kthSinusoidIndex < N; ++kthSinusoidIndex) {
			for (int sinusoidComponentIndex = 0; sinusoidComponentIndex < N; ++sinusoidComponentIndex) {
				
				returnValue[kthSinusoidIndex][sinusoidComponentIndex] = kthComplexSinusoidAt(kthSinusoidIndex, sinusoidComponentIndex, N, signToUse, thresh);
				
			}
		}
		
		return returnValue;
		
	}
	
	/**
	 * @param N
	 * @param sign
	 * @param thresh
	 * @return two dimensional array of complex numbers containing the complex sinusoids for doing DFT
	 */
	public static Complex[][] computeDFTMat(int N, int sign, double thresh) {
		
		return computeDFTAndInverseDFTMatrix(N, sign, thresh, false);
		
	}
	
	/**
	 * @param signal
	 * @param sign
	 * @param thresh
	 * @return DFT components
	 */
	public static Complex[] computeSpectrum(Complex[] signal, int sign, double thresh) {
		
		Complex[][] dftMatrix = computeDFTMat(signal.length, sign, thresh);
		
		Complex kthFrequencyElement = null;
		Complex[] returnValue = new Complex[signal.length];
		for (int kthSinusoidIndex = 0; kthSinusoidIndex < signal.length; ++kthSinusoidIndex) {
			
			kthFrequencyElement = Complex.valueOf(0.0, 0.0);
			for (int signalIndex = 0; signalIndex < signal.length; ++signalIndex) {
				
				kthFrequencyElement = kthFrequencyElement.add(signal[signalIndex].multiply(dftMatrix[kthSinusoidIndex][signalIndex], thresh));
				
			}
			
			returnValue[kthSinusoidIndex] = kthFrequencyElement;
		
		}
		
		return returnValue;

	}
	
	public static double[] computeAbsoluteSpectrum(Complex[] signal, int sign, double thresh) {
		
		Complex[] spectrum = computeSpectrum(signal, sign, thresh);
		
		double[] returnValue = new double[spectrum.length];
		
		int absoluteSpectrumIndex = 0;
		for (Complex complexComponent : spectrum) {
			
			returnValue[absoluteSpectrumIndex++] = complexComponent.getAbsoluteValue();
			
		}

		return returnValue;
	}
	
	public static Complex[][] computeInverseDFTMat(int N, int sign, double thresh) {
		
		return computeDFTAndInverseDFTMatrix(N, sign, thresh, true);
		
	}
	
	public static Complex[] invertSpectrum(Complex[] spectrum, double thresh) {
		
		int spectrumLength = spectrum.length;
		
		Complex[][] inverseDftMatrix = computeInverseDFTMat(spectrumLength, NEGATIVE_SIGN, thresh);
		
		Complex kthFrequencyElement = null;
		Complex[] returnValue = new Complex[spectrumLength];
		for (int kthSinusoidIndex = 0; kthSinusoidIndex < spectrumLength; ++kthSinusoidIndex) {
			
			kthFrequencyElement = Complex.valueOf(0.0, 0.0);
			for (int signalIndex = 0; signalIndex < spectrumLength; ++signalIndex) {
				
				kthFrequencyElement = kthFrequencyElement.add(spectrum[signalIndex].multiply(inverseDftMatrix[kthSinusoidIndex][signalIndex], thresh));
				
			}
			
			returnValue[kthSinusoidIndex] = kthFrequencyElement.divide(spectrumLength, thresh);
		
		}
		
		return returnValue;
	}
	
	public static double[] invertSpectrumIntoMagnitudes(Complex[] spectrum, double thresh) {
		
		Complex[] invertedSpectrum = invertSpectrum(spectrum, thresh);
		
		double[] returnValue = new double[invertedSpectrum.length];
		
		int absoluteInvertedSpectrumIndex = 0;
		for (Complex complexComponent : invertedSpectrum) {
			
			returnValue[absoluteInvertedSpectrumIndex++] = complexComponent.getAbsoluteValue();
			
		}

		return returnValue;
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
	
	/**
	 * @param vec
	 * @return an equivalent complex vector for a real vector
	 */
	public static Complex[] convertToComplexVector(double[] realVector) {
		
		int vectorLength = realVector.length;
		Complex[] returnValue = new Complex[vectorLength]; 
		
		for(int i = 0; i < vectorLength; i++) {
		
			returnValue[i] = Complex.valueOf(realVector[i], 0);
		
		}
		
		return returnValue;
		
	}

	/**
	 * Print the complex vector to the output stream
	 * @param complexVector
	 */
	public static void displayComplexVector(Complex[] complexVector) {
		
		StringBuffer output = new StringBuffer();
		
		output.append("[");

		boolean firstTime = true;
		for (Complex value : complexVector) {
		
			if (firstTime) {
				firstTime = false;
			} else {
				output.append(", ");
			}
		
			output.append(value);
		}

		output.append("]");
		System.out.print(output.toString());
		
	}
	
	public static void displayRealVector(double[] realVector) {
		
		StringBuffer output = new StringBuffer();
		
		output.append("[");

		boolean firstTime = true;
		for (double value : realVector) {
		
			if (firstTime) {
				firstTime = false;
			} else {
				output.append(", ");
			}
		
			output.append(value);
		}

		output.append("]");
		System.out.print(output.toString());		
	}

}
