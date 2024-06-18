import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static int[][] rect;
    static int N;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter("cowtip.out");

        N = sc.nextInt();

        rect = new int[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            String[] temp = sc.next().split("");
            for (int j = 0; j < N; j++) {
                rect[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (rect[i][j] == 1) {
                    count++;
                    for(int z = i; z >= 0; z--) {
                        for(int a = j; a >= 0; a--) {
                            if(rect[z][a] == 1) {
                                rect[z][a] = 0;
                            }
                            else {
                                rect[z][a] = 1;
                            }
                        }
                    }
                }
            }
        }
        pw.println(count);
        pw.close();
    }
}