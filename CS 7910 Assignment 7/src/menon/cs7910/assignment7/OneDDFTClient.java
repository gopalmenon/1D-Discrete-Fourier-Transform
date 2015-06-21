package menon.cs7910.assignment7;

public class OneDDFTClient {

	public static void main(String[] args) {
		
		for(int k = 0; k < 4; k++) { 
			OneDDFT.displayKthComplexSinusoid(k, 4, -1, 0.001); 
		} 
		
		System.out.println();
		
		for(int k = 0; k < 4; k++) { 
			OneDDFT.displayKthComplexSinusoid(k, 4, 1, 0.001); 
		}

	}

}
