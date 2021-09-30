import java.util.Arrays;

/**
* Práctica 1 del curso de Estructuras de Datos.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Septiembre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/
public class Practica01{

	/** 
	* Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
	* una posición límite
	* @param array1 el primer arreglo a mezlar
	* @param n el límite de mezcla del primer arreglo
	* @param array2 el segundo arreglo a mezclar
	* @param m el límite de mezcla del segundo arreglo.
	* @return un arreglo ordenado de longitud m+n con la mezcla definida.
	*/
	public static int[] mergeSortedArray(int[] array1, int n, int[] array2, int m){
		if(n > array1.length || m > array2.length)
			throw new RuntimeException("Límites no válidos");
		
		int[] result = new int[n + m];
		int pointer;
		for(pointer = 0; pointer < n; pointer++)
			result[pointer] = array1[pointer];
		for(int i = 0 ; i < m ; i++, pointer++)
			result[pointer] = array2[i];
		
		// Ordenamiento del arreglo result
		for(int j = 0; j < result.length - 1; j++){
			for(int k = j+1; k < result.length; k++){
				if(result[k] < result[j]){
					int aux = result[k];
					result[k] = result[j];
					result[j] = aux;
				}
			}
		}

		return result;
	}

	/** 
	* Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
	* una posición límite
	* @param array1 el primer arreglo a mezlar
	* @param n el límite de mezcla del primer arreglo
	* @param array2 el segundo arreglo a mezclar
	* @param m el límite de mezcla del segundo arreglo.
	* @return un arreglo ordenado de longitud m+n con la mezcla definida.
	*/
	public static int[] mergeSortedArrayMejorado(int[] array1, int n, int[] array2, int m){
		if(n > array1.length || m > array2.length)
			throw new RuntimeException("Límites no válidos");
		
		int[] result = new int[n + m];
		int pointer = 0;
		if(n >= m){
			for(int i = 0; i < n; i++){
				if(i < m){
					result[pointer] = array2[i];
					pointer++;
				}
				result[pointer] = array1[i];
				pointer++;
			}
		}else{
			for(int i = 0; i < m; i++){
				if(i < n){
					result[pointer] = array1[i];
					pointer++;
				}
				result[pointer] = array2[i];
				pointer++;
			}
		}
		
		// Ordenamiento del arreglo result
		for(int j = 0; j < result.length - 1; j++){
			for(int k = j+1; k < result.length; k++){
				if(result[k] < result[j]){
					int aux = result[k];
					result[k] = result[j];
					result[j] = aux;
				}
			}
		}

		return result;
	}

    /**
    * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
    * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
    * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
	* false en otro caso.
    */
    public static boolean isValidBoard(int[][] board){
    	int length = board.length;
		for (int i = 0; i < length ; i++) {
			for (int j = 0; j < length ; j++ ) {
				boolean verificador = false;
				// Verifica sobre las filas
				for(int k = 0 ; k < length; k++){
					if(board[i][k] == j){
						verificador = true;
						break;
					}
				}
				if(!verificador){
					return false;
				}
				verificador = false;
				// Verifica sobre las columnas
				for(int k = 0 ; k < length; k++){
					if(board[k][i] == j){
						verificador = true;
						break;
					}
				}
				if(!verificador){
					return false;
				}
			}
		}
		return true;
	}

	/**
    * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
    * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
    * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
	* false en otro caso.
    */
    public static boolean isValidBoardMejorado(int[][] board){
    	int length = board.length;
    	int[] arregloAux = new int[length];
    	for(int i = 0; i < length; i++){
    		int aux = 0;
    		for(int j = 0; j < length; j++){//filas
    		   arregloAux[board[i][j]] += 1;	
    		}
    		for(int k = 0; k < length; k++){//columnas
    			arregloAux[board[k][i]] += 1;
    		}
    		for(int m = 0; m < length-1; m++){
    			if(arregloAux[m] != arregloAux[m+1]){
    				return false;
    			}
    		}
    	}
    	return true;
	}

	/**
	* Rota position cantidad de veces los elementos de un arreglo
	* hacia el vecino izquierdo.
	* @param num el arreglo de enteros a rotar.
	* @param position la cantidad de espacios a rotar.
	*/
	public static void rotateArray(int[] num, int position){
		for(int i = 0; i < position ; i++){
			int aux = num[0];
			for(int j = 0; j < num.length -1 ; j++){
				num[j] = num[j+1];
			}
			num[num.length-1] = aux;
		}
	}

	/**
	* Rota position cantidad de veces los elementos de un arreglo
	* hacia el vecino izquierdo.
	* @param num el arreglo de enteros a rotar.
	* @param position la cantidad de espacios a rotar.
	*/
	public static void rotateArrayMejorado(int[] num, int position){
		int[] arregloAux = Arrays.copyOf(num, num.length);
		for(int i = 0; i < num.length; i++){	
			int index = (num.length - (position-i));
			if(position-i <= 0){
				index = (position-i)*-1;
			}
			num[index] = arregloAux[i];
		}
	}

	public static void main(String[] args) {

		String directorio1 = "src/clases/Tests/ArrayTests/";
		String directorio2 = "src/clases/Tests/BoardTests/";

		// EJEMPLOS DE ACTIVIDAD 1
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 1\n");

		int[] arrayA1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayA2 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
		int[] arrayB1 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayB2 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
		int[] arrayC1 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayC2 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");
		int[] arrayD1 = ArrayReader.readArray(directorio1 + "ArrayD1.txt");
		int[] arrayD2 = ArrayReader.readArray(directorio1 + "ArrayD2.txt");
		int[] arrayE1 = ArrayReader.readArray(directorio1 + "ArrayE1.txt");
		int[] arrayE2 = ArrayReader.readArray(directorio1 + "ArrayE2.txt");
		int[] arrayF1 = ArrayReader.readArray(directorio1 + "ArrayF1.txt");
		int[] arrayF2 = ArrayReader.readArray(directorio1 + "ArrayF2.txt");

		long inicio = System.currentTimeMillis();
		int[] resultA = mergeSortedArray(arrayA1, 500, arrayA2, 700);
		long fin = System.currentTimeMillis();
		//System.out.println("Resultado A: "+Arrays.toString(resultA));
		System.out.println("El algoritmo 1.1 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		int[] resultB = mergeSortedArray(arrayB1, 2000, arrayB2, 3500);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado B: "+Arrays.toString(resultB));
		System.out.println("El algoritmo 1.2 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		int[] resultC = mergeSortedArray(arrayC1, 4000, arrayC2, 4000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.3 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		int[] resultD = mergeSortedArray(arrayD1, 7000, arrayD2, 8000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.4 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		int[] resultE = mergeSortedArray(arrayE1, 15000, arrayE2, 19000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.5 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		int[] resultF = mergeSortedArray(arrayF1, 30000, arrayF2, 25000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.6 se tardo: "+(fin-inicio)+" milisegundos");

		// EJEMPLOS DE ACTIVIDAD MEJORADO 1
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 1 MEJORADO\n");

		inicio = System.currentTimeMillis();
		resultA = mergeSortedArrayMejorado(arrayA1, 500, arrayA2, 700);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado A: "+Arrays.toString(resultA));
		System.out.println("El algoritmo 1.1 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		resultB = mergeSortedArrayMejorado(arrayB1, 2000, arrayB2, 3500);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado B: "+Arrays.toString(resultB));
		System.out.println("El algoritmo 1.2 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		resultC = mergeSortedArrayMejorado(arrayC1, 4000, arrayC2, 4000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.3 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		resultD = mergeSortedArrayMejorado(arrayD1, 7000, arrayD2, 8000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.4 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		resultE = mergeSortedArrayMejorado(arrayE1, 15000, arrayE2, 19000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.5 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		resultF = mergeSortedArrayMejorado(arrayF1, 30000, arrayF2, 25000);
		fin = System.currentTimeMillis();
		//System.out.println("Resultado C: "+Arrays.toString(resultC));
		System.out.println("El algoritmo 1.6 se tardo: "+(fin-inicio)+" milisegundos");



		// EJEMPLOS DE ACTIVIDAD 2
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 2\n");

		int[][] boardA = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
		inicio = System.currentTimeMillis();
		boolean boardResultA = isValidBoard(boardA);
		fin = System.currentTimeMillis();
		System.out.println("El tablero A es válido: "+boardResultA);
		System.out.println("El algoritmo 2.1 se tardo: "+(fin-inicio)+" milisegundos");

		int[][] boardB = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
		inicio = System.currentTimeMillis();
		boolean boardResultB = isValidBoard(boardB);
		fin = System.currentTimeMillis();
		System.out.println("El tablero B es válido: "+boardResultB);
		System.out.println("El algoritmo 2.2 se tardo: "+(fin-inicio)+" milisegundos");

		int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
		inicio = System.currentTimeMillis();
		boolean boardResultC = isValidBoard(boardC);
		fin = System.currentTimeMillis();
		System.out.println("El tablero C es válido: "+boardResultC);
		System.out.println("El algoritmo 2.3 se tardo: "+(fin-inicio)+" milisegundos");		

		int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
		inicio = System.currentTimeMillis();
		boolean boardResultD = isValidBoard(boardD);
		fin = System.currentTimeMillis();
		System.out.println("El tablero D es válido: "+boardResultD);
		System.out.println("El algoritmo 2.4 se tardo: "+(fin-inicio)+" milisegundos");

		int[][] boardE = ArrayReader.readMatrix(directorio2 + "BoardE.txt");
		inicio = System.currentTimeMillis();
		boolean boardResultE = isValidBoard(boardE);
		fin = System.currentTimeMillis();
		System.out.println("El tablero E es válido: "+boardResultE);
		System.out.println("El algoritmo 2.5 se tardo: "+(fin-inicio)+" milisegundos");		

		int[][] boardF = ArrayReader.readMatrix(directorio2 + "BoardF.txt");
		inicio = System.currentTimeMillis();
		boolean boardResultF = isValidBoard(boardF);
		fin = System.currentTimeMillis();
		System.out.println("El tablero D es válido: "+boardResultF);
		System.out.println("El algoritmo 2.6 se tardo: "+(fin-inicio)+" milisegundos");


		// EJEMPLOS DE ACTIVIDAD 2 MEJORADO
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 2 MEJORADO\n");

		inicio = System.currentTimeMillis();
		boardResultA = isValidBoardMejorado(boardA);
		fin = System.currentTimeMillis();
		System.out.println("El tablero A es válido: "+boardResultA);
		System.out.println("El algoritmo 2.1 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		boardResultB = isValidBoardMejorado(boardB);
		fin = System.currentTimeMillis();
		System.out.println("El tablero B es válido: "+boardResultB);
		System.out.println("El algoritmo 2.2 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		boardResultC = isValidBoardMejorado(boardC);
		fin = System.currentTimeMillis();
		System.out.println("El tablero C es válido: "+boardResultC);
		System.out.println("El algoritmo 2.3 se tardo: "+(fin-inicio)+" milisegundos");		

		inicio = System.currentTimeMillis();
		boardResultD = isValidBoardMejorado(boardD);
		fin = System.currentTimeMillis();
		System.out.println("El tablero D es válido: "+boardResultD);
		System.out.println("El algoritmo 2.4 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		boardResultE = isValidBoardMejorado(boardE);
		fin = System.currentTimeMillis();
		System.out.println("El tablero E es válido: "+boardResultE);
		System.out.println("El algoritmo 2.5 se tardo: "+(fin-inicio)+" milisegundos");		

		inicio = System.currentTimeMillis();
		boardResultF = isValidBoardMejorado(boardF);
		fin = System.currentTimeMillis();
		System.out.println("El tablero F es válido: "+boardResultF);
		System.out.println("El algoritmo 2.6 se tardo: "+(fin-inicio)+" milisegundos");


		// EJEMPLOS DE ACTIVIDAD 3
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 3\n");

		inicio = System.currentTimeMillis();
		rotateArray(arrayA1, 500);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.1 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArray(arrayB1, 1000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.2 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArray(arrayC1, 2000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.3 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArray(arrayD1, 3000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.4 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArray(arrayE1, 10000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.5 se tardo: "+(fin-inicio)+" milisegundos");
		
		inicio = System.currentTimeMillis();
		rotateArray(arrayF1, 20000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.6 se tardo: "+(fin-inicio)+" milisegundos");

		/*System.out.println("Arreglo A1 rotado 5 veces: " + Arrays.toString(arrayA1));
		System.out.println("Arreglo B1 rotado 0 veces: " + Arrays.toString(arrayB1));
		System.out.println("Arreglo C1 rotado 6 veces: " + Arrays.toString(arrayC1));*/

		//System.out.println("\n\nFIN DE EJEMPLOS\n");

		// EJEMPLOS DE ACTIVIDAD MEJORADA 3
		System.out.println("\nEJEMPLOS DE ACTIVIDAD MEJORADA 3\n");

		inicio = System.currentTimeMillis();
		rotateArrayMejorado(arrayA1, 500);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.1 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArrayMejorado(arrayB1, 1000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.2 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArrayMejorado(arrayC1, 2000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.3 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArrayMejorado(arrayD1, 3000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.4 se tardo: "+(fin-inicio)+" milisegundos");

		inicio = System.currentTimeMillis();
		rotateArrayMejorado(arrayE1, 10000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.5 se tardo: "+(fin-inicio)+" milisegundos");
		
		inicio = System.currentTimeMillis();
		rotateArrayMejorado(arrayF1, 20000);
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 3.6 se tardo: "+(fin-inicio)+" milisegundos");

		/*System.out.println("Arreglo A1 rotado 5 veces: " + Arrays.toString(arrayA1));
		System.out.println("Arreglo B1 rotado 0 veces: " + Arrays.toString(arrayB1));
		System.out.println("Arreglo C1 rotado 6 veces: " + Arrays.toString(arrayC1));*/

		System.out.println("\n\nFIN DE EJEMPLOS\n");
	}
}