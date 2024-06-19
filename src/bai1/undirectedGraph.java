package bai1;/*Given an undirected graph 𝐺 = (𝑉, 𝐸) with 𝑛 (𝑛 ≤ 1000) vertices,
 the vertices are numbered from 1 to 𝑛. The graph 𝐺 is stored in a text file as an adjacency matrix.
  Organize an adjacency matrix data structure to represent the graph, and write a program to read the graph 𝐺 from the given file into that data structure,
   then calculate the degree of the vertices in the graph (the degree of a vertex is the number of edges attached to that vertex).

Input data: Text file bacdothivohuong.in
•	The first line contains the integer 𝑛 which is the number of vertices in the graph.
        •	The next 𝑛 lines each contain 𝑛 numbers representing the adjacency matrix of the graph.
Output data: bacdothivohuong.out
•	The first line contains the number 𝑛 which is the number of vertices in the graph.
        •	The second line contains 𝑛 integers corresponding to the degrees of vertices 1, 2, …,𝑛
        (Numbers on the same line, separated by 1 space) */
import java.io.*;
import java.util.Scanner;

public class undirectedGraph {
    public static void main(String[] args) throws IOException {
     String input = "src/bai1/bacdothivohuong.in";
     File file = new File(input);
     Scanner scanner = new Scanner(file);
     int n = scanner.nextInt();
     int [][] matrix = new int[n][n];
     for (int i = 0; i< n; i++){
         for (int j =0; j<n;j++){
             matrix[i][j]=scanner.nextInt();
         }
     }
     scanner.close();
     int [] degree = new int[n];
     for(int i =0;i<n;i++){
         for(int j =0;j<n;j++){
             degree[i]+=matrix[i][j];
         }
     }
     String outputFile = "src/bai1/bacdothivohuong.out";
     BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
     writer.write(n + "\n");
     for(int i=0;i<n;i++){
         writer.write(degree[i] +  (i == n - 1 ? "" : " "));
     }
        writer.newLine();
        writer.close();
}
}
