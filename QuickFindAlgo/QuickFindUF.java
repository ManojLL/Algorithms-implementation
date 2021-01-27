import java.io.*;  // For reading the input data within an IDE - DELETE if you work within a console or terminal
import java.util.Scanner; // For reading the input data within an IDE - DELETE if you work within a console or terminal

public class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components

    /**
     * Initialises an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    
    public QuickFindUF(int N) {
        
	id = new int[10];
	for(int i = 0; i< N; i++){
			id[i]=i;
		}

    }

    /**
     * Returns the number of components.
     * @return the number of components (between 1 and N)
     */
    
    public int count() {
        return count;
    }

    /**
     * Returns the component identifier for the component containing site <tt>p</tt>.
     * @param p the integer representing one site
     * @return the component identifier for the component containing site <tt>p</tt>
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    
    public int find(int p) {
        
	// Complete the method....
	return id[p];

    }

    /**
     * Are the two sites <tt>p</tt> and <tt>q/tt> in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt> are in
     *    the same component, and <tt>false</tt> otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    
    public boolean connected(int p, int q) {
        
	// Complete the method....
	return id[p] == id[q];

    }
  
    /**
     * Merges the component containing site<tt>p</tt> with the component
     * containing site <tt>q</tt>.
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    
    public void union(int p, int q) {
        
	// Complete the method....
	int pid = id[p];
	int qid = id[q];
	
	for(int i =0; i<id.length; i++){
			if(id[i] == pid){
				id[i] = qid;
			}
	
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input, 
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    
    public static void main(String[] args) {
    	
    	// ONLY for IDE version, remove otherwise
    	Scanner input = null;
		try {
			input = new Scanner(new File("tinyUF.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// END of IDE version
		
        // int N = StdIn.readInt();  <- ENABLE if reading from console or terminal
    	int N = input.nextInt(); // ONLY for IDE version
    	
    	System.out.println("Number of nodes is: " + N);
    	QuickFindUF uf = new QuickFindUF(N);
    	
        // while (!StdIn.isEmpty()) {   <- ENABLE ONLY if reading from console or terminal
    	while (input.hasNextInt()) { // ONLY for IDE version, remove otherwise
            // int p = StdIn.readInt(); <- ENABLE ONLY if reading from console or terminal
    		int p = input.nextInt(); // ONLY for IDE version, remove otherwise
            // int q = StdIn.readInt(); <- ENABLE ONLY if reading from console or terminal
    		int q = input.nextInt(); // ONLY for IDE version, remove otherwise
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
         System.out.println(uf.count() + " components");
    }

}



