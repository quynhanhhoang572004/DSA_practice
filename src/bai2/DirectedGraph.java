package bai2;
/*Given a directed graph 𝐺 = (𝑉, 𝐸) with 𝑛 vertices numbered from 1 to 𝑛.
 The entry degree of vertex 𝑖 is the number of incoming arcs at vertex 𝑖.
 The output degree of vertex 𝑖 is the number of arcs going out of vertex 𝑖.
 Calculate the input and output degrees of all vertices in the graph town.
Input data: BacVaoRa.INP text file
•	The first line contains the integer 𝑛 (𝑛 ≤ 1000) which is the number of vertices in the graph.
•	The next 𝑛 lines each contain 𝑛 numbers representing the adjacency matrix of the graph.
Output data: BacVaoRa.OUT text file
•	The first line is a positive integer 𝑛 is the number of vertices in the graph.
•	The next 𝑛 line, the 𝑖th line, includes two integers, the input and output steps of vertex 𝑖
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DirectedGraph {
    public static void main (String[] args) throws IOException {
        String input = "src/bai2/BacVaoRa.INP";
        File file = new File(input);
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        // read all the input of the matrix
        for (int i =0; i<n; i++){
            for (int j = 0; j<n;j++){
                matrix[i][j] = scanner.nextInt();

            }
        }
        scanner.close();

        int [] degreeIn = new int[n];
        int[] degreeOut = new int[n];
        //calculate degree in and the degree out
        for(int i =0; i<n;i++){
            for(int j =0; j<n; j++){
                degreeOut[i] += matrix[i][j];
                degreeIn[j]+= matrix[i][j];
            }
        }
        String outputFile = "src/bai2/ BacVaoRa.OUT";
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(n + "\n");
        for(int i =0; i< n;i++){
           writer.write(degreeIn[i] + " " +degreeOut[i] + "\n");
        }
        writer.newLine();
        writer.close();

    }

}
