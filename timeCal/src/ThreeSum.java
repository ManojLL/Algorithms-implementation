import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreeSum {
    /**
     * Prints to standard output the (i, j, k) with i < j < k such that a[i] + a[j] + a[k] == 0.
     *
     * @param a the array of integers
     */

    public static void printAll(int[] a) {
        int N = a.length;

        // Complete the method implementation...

    }

    /**
     * Returns the number of triples (i, j, k) with i < j < k such that a[i] + a[j] + a[k] == 0.
     *
     * @param a the array of integers
     * @return the number of triples (i, j, k) with i < j < k such that a[i] + a[j] + a[k] == 0
     */

    public static int count(int[] a) {

        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        // Complete the method implementation...
        return count;

    }

    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     */

    public static void main(String[] args) {
//        In in = new In();
        int[] a = new int[8000];
        try {
            File myObj = new File("8Kints.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                a[i] = Integer.parseInt(myReader.nextLine());
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("");

        }
        System.out.println("start");
        Stopwatch timer = new Stopwatch();
        int cnt = count(a);
        System.out.println("elapsed time = " + timer.elapsedTime());
        System.out.println(cnt);
        System.out.println("end");
    }
}
