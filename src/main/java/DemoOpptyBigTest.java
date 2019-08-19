

/**
 * Hungarian Algorithm is a combinatorial optimization algorithm that solves the assignment problem in polynomial time. Link: http://en.wikipedia.org/wiki/Hungarian_algorithm
 * Coded by Amir El Bawab
 * Date: 4 May 2014
 * License: MIT License ~ Please read License.txt for more information about the usage of this software
 * */
public class DemoOpptyBigTest{

	public static void main(String[] args) {


//		double[][] values = {
//		{ 68, 38, 9, 60, 46, 58, 83, 87, 84, 20 },
//		{ 53, 4, 16, 4, 44, 72, 34, 97, 69, 5 },
//		{ 21, 2, 45, 55, 34, 15, 2, 13, 12, 51 },
//		{ 8, 93, 22, 66, 25, 9, 59, 71, 12, 95 },
//		{ 42, 35, 33, 23, 3, 8, 8, 50, 23, 95 },
//		{ 74, 37, 15, 21, 36, 49, 80, 55, 79, 53 },
//		{ 21, 97, 55, 12, 25, 67, 10, 65, 2, 49 },
//		{ 8, 48, 1, 92, 8, 76, 41, 32, 87, 36 },
//		{ 32, 73, 71, 47, 94, 92, 16, 97, 5, 4 },
//		{ 58, 37, 54, 52, 84, 16, 34, 5, 72, 26 } };


		/*
			a = 200, 300, 4000

			b = 100, 100, 100, 200, 4000, 1000000

			cell: (diff/a)^2

		 */


		 long startTime = System.currentTimeMillis();

		 // FIXME

		// loop para analizar 100 listas que devuelva salesforce:
		// claramente es una aproximacion burda, donde debo sacar la generacion de los 150 arrays.

		 int max = 150;

		for (int lista=0; lista<150; lista++) {


			double[][] values = new double[max][max];



			// inicializo values:
			for (int i=0; i<values.length; i++) {
				for (int j=0; j<values[0].length; j++) {

					values[i][j] = 1 + (int)(Math.random() * 150);

				}
			}



			// calculo de hungarian:

			long time = System.currentTimeMillis(); // Start time recording
			HungarianDouble hungarian = new HungarianDouble(values);
			System.out.println(String.format("Total time: %dms\n", System.currentTimeMillis() - time)); // Stop time recording and display time consumed

			// Display result on screen
			int[] result = hungarian.getResult();
			for(int i = 0; i < result.length; i++)
				System.out.println(String.format("Row%d => Col%d (%f)", i+1, result[i]+1, values[i][result[i]])); // Rowi => Colj (value)

			System.out.println(String.format("\nTotal: %f", hungarian.getTotal())); // Total

		} // fin-lista loop

		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("elapsedTime=" + elapsedTime);

	}

}



