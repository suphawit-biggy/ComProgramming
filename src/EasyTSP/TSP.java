package EasyTSP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TSP {

	public TSP() {
	}

	public int selection(int matrix[][], int i) {
		int j = 1;
		int count = 1;
		int min = matrix[i][j];
		if (min == 0) {
			min = matrix[i][j + 1];
			count++;
		}
		for (j = i + 1; j < matrix.length; j++) {
			if (matrix[i][j] < min) {
				min = matrix[i][j];
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter the number of nodes in the graph");
			Scanner scan = new Scanner(System.in);
			int numNodes = scan.nextInt();
			int matrix[][] = new int[numNodes + 1][numNodes + 1];
			System.out.println("Enter the adjacency matrix");
			for (int i = 1; i <= numNodes; i++) {
				for (int j = 1; j <= numNodes; j++) {
					matrix[i][j] = scan.nextInt();
				}
			}
			for (int i = 1; i <= numNodes; i++) {
				for (int j = 1; j <= numNodes; j++) {
					if (matrix[i][j] == 1 && matrix[j][i] == 0) {
						matrix[j][i] = 1;
					}
				}
			}
			System.out.println("the citys are visited as follows");
			TSP tspMatrix = new TSP();
			int way = tspMatrix.selection(matrix, 1);
			System.out.print(way + "\t");
			for (int i = 2; i <= numNodes; i++) {
				tspMatrix = new TSP();
				way = tspMatrix.selection(matrix, way);
				System.out.print(way + "\t");
			}
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input format");
		}
	}

}