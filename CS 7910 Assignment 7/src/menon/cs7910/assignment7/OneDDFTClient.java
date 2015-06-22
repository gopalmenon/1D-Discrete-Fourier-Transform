package menon.cs7910.assignment7;

public class OneDDFTClient {

	public static void main(String[] args) {
		
		for(int k = 0; k < 8; k++) { 
			OneDDFT.displayKthComplexSinusoid(k, 8, -11, 0.001); 
		} 
		
		System.out.println();
		
		for(int k = 0; k < 4; k++) { 
			OneDDFT.displayKthComplexSinusoid(k, 4, 1, 0.001); 
		}
		
		test_dft();

	}

	// do the DFT of a complex signal and display it
	public static void dft_complex_test(Complex[] signal) {
		Complex[] spec1 = OneDDFT.computeSpectrum(signal, -1, 0.001);
		OneDDFT.displayComplexVector(spec1); 
	}
	
	// do the DFT of a real signal and display it
	public static void dft_real_test(double[] signal) {
		
		Complex[] complexSignal = OneDDFT.convertToComplexVector(signal);
		Complex[] spec1 = OneDDFT.computeSpectrum(complexSignal, -1, 0.001);
		OneDDFT.displayComplexVector(spec1); 
	}

	// do the DFT of a real signal and display its spectrum of magnitudes. 
	public static void dft_abs_real_test(double[] signal) {
		Complex[] csignal = OneDDFT.convertToComplexVector(signal);
		double[] absSpec = OneDDFT.computeAbsoluteSpectrum(csignal, -1, 0.001); OneDDFT.displayRealVector(absSpec);
	}
	
	// compute the DFT spectrum of magnitudes of a complex signal and display it 
		public static void dft_abs_complex_test(Complex[] signal) {
			double[] absSpec = OneDDFT.computeAbsoluteSpectrum(signal, -1, 0.001);
			OneDDFT.displayRealVector(absSpec); 
	}
	
	/**
	 * define a few real and complex signals and test them
	 */
	public static void test_dft() {
		
		// real signals
		final double[] signal00 = {5};
		final double[] signal01 = {6, 2};
		final double[] signal02 = {1, 2, 3};
		final double[] signal03 = {2, 3, 5, 7};
		final double[] signal04 = {10, 11, 50, 32, 1};
		final double[] signal05 = {101, 2, 234, 89, 78, 5, 90, 453};
		
		// complex signals
		final Complex[] csignal00 = {Complex.valueOf(5, 3)};
		final Complex[] csignal01 = {Complex.valueOf(4, -1), Complex.valueOf(10, 4)};
		final Complex[] csignal02 = {Complex.valueOf(1, 2), Complex.valueOf(7, -8), Complex.valueOf(19, 21)};
		
		System.out.print("\nDFT00 = ");
		dft_real_test(signal00); 
		System.out.print("\nDFT01 = "); 
		dft_real_test(signal01); 
		System.out.print("\nDFT02 = "); 
		dft_real_test(signal02); 
		System.out.print("\nDFT03 = "); 
		dft_real_test(signal03); 
		System.out.print("\nDFT04 = "); 
		dft_real_test(signal04); 
		System.out.print("\nDFT05 = "); 
		dft_real_test(signal05);

	}
}
