package Project;


// ---------------------------- packeges ----------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author lujain Abdullah
 * @author Sara Alahmari
 * @author Shaima Bashammakh
 */
public class Application {

    /**
     * main method to run the program
     *
     * @param args String []
     * @throws FileNotFoundException exception to avoid the file errors
     */
    public static void main(String[] args) throws FileNotFoundException {

        //define the time variables
        double startTime, finishTime, time;
        //create scanner
        Scanner input = new Scanner(System.in);
        //define the graph
        Graph g;

        int choice = 0;
        while (choice != 3) {
            System.out.println("");
            System.out.println("------------------------------------------------------------------");
            System.out.println("                     CPCS325 Project Phase 2  ");
            System.out.println("------------------------------------------------------------------");
            System.out.println("Choose one of the following options: ");
            System.out.println(" 1- Read the graph vertecies and edges from the file. ");
            System.out.println(" 2- Choose a specific number of vertecies and edges. ");
            System.out.println(" 3- End the program. ");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                //create a graph
                g = new Graph();
                File myFile = new File("graph.txt");
                //call the method to read from file
                g.readGraphFromFile(myFile);
                System.out.println("Choose one of the following Algorithm: ");
                System.out.println(" 1- Floyd-Warshall algorithm. ");
                System.out.println(" 2- Dijkstra algorithm. ");
                System.out.print("Enter your choice: ");
                int Algo = input.nextInt();
                System.out.println("");
                g.printFile();
                if (Algo == 1) {
                    AllSourceSPAlg p = new AllSourceSPAlg(g);
                    System.out.println("The matrix (graph) bafore Floyed Warshal algorithm.");
                    p.printMatrixBefore(g);
                    p.setReadFile(true);
                    startTime = System.currentTimeMillis();
                    p.computeFloyedWarshalAlg(g);
                    finishTime = System.currentTimeMillis();
                    time = finishTime - startTime;
                    System.out.println("\nThe matrix (graph) after Floyed Warshal algorithm.");
                    p.printMatrixAfter(g);
                    System.out.println("---------------------------------------");
                    System.out.println("The Runtime (in MilliSecond) of n= " + g.getVerticesNo() + " and m= " + g.getEdgeNo() + " :" + time);

                } else if (Algo == 2) {
                    SingleSourceSPAlg p = new SingleSourceSPAlg(g);
                    p.setReadFile(true);
                    startTime = System.currentTimeMillis();
                    p.computeDijkstraAlg(g);
                    finishTime = System.currentTimeMillis();
                    time = finishTime - startTime;
                    System.out.println("---------------------------------------");
                    System.out.println("The Runtime (in MilliSecond) of n= " + g.getVerticesNo() + " and m= " + g.getEdgeNo() + " :" + time);

                }

            } else if (choice == 2) {

                System.out.println("Choose the number of vertecies and edges from the following list: ");
                System.out.println(" (n) is number of vertecies, (m) is number of edges ");
                System.out.println(" 1- n=2000 , m=10000");
                System.out.println(" 2- n=3000 , m=15000");
                System.out.println(" 3- n=4000 , m=20000");
                System.out.println(" 4- n=5000 , m=25000");
                System.out.println(" 5- n=6000 , m=30000");
                System.out.println("");
                System.out.print("Enter your choice: ");
                int option = input.nextInt();
                System.out.println("Choose one of the following Algorithm: ");
                System.out.println(" 1- Floyd-Warshall algorithm. ");
                System.out.println(" 2- Dijkstra algorithm. ");
                     System.out.print("Enter your choice: ");
                int Algo = input.nextInt();
                if (Algo == 1) {
                    switch (option) {
                        case 1:
                            //creat a graph
                            g = new Graph(2000, 10000);
                            AllSourceSPAlg p1 = new AllSourceSPAlg(g);
                            p1.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the floyed and warshal method
                            p1.computeFloyedWarshalAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=2000, m=10000: " + time);
                            break;
                        case 2:
                            //creat a graph
                            g = new Graph(3000, 15000);
                            AllSourceSPAlg p2 = new AllSourceSPAlg(g);
                            p2.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the floyed and warshal method
                            p2.computeFloyedWarshalAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=3000, m=15000: " + time);
                            break;
                        case 3:
                            //creat a graph
                            g = new Graph(4000, 20000);
                            AllSourceSPAlg p3 = new AllSourceSPAlg(g);
                            p3.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the floyed and warshal method
                            p3.computeFloyedWarshalAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=4000, m=20000: " + time);
                            break;
                        case 4:
                            //creat a graph
                            g = new Graph(5000, 25000);
                            AllSourceSPAlg p4 = new AllSourceSPAlg(g);
                            p4.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the floyed and warshal method
                            p4.computeFloyedWarshalAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=5000, m=25000: " + time);
                            break;
                        case 5:
                            //creat a graph
                            g = new Graph(6000, 30000);
                            AllSourceSPAlg p5 = new AllSourceSPAlg(g);
                            p5.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the floyed and warshal method
                            p5.computeFloyedWarshalAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond) of n=6000, m=30000: " + time);
                            break;
                        default:
                            System.out.println("You entered a wrong choice .. try again ");

                    }// end switch
                }// end if 
                else if (Algo == 2) {
                    SingleSourceSPAlg p = null;
                    switch (option) {
                        case 1:
                            //creat a graph
                            g = new Graph(2000, 10000);
                            p = new SingleSourceSPAlg(g);
                            p.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the Dijkstra  method
                            p.computeDijkstraAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=2000, m=10000: " + time);
                            break;
                        case 2:
                            //creat a graph
                            g = new Graph(3000, 15000);
                            p = new SingleSourceSPAlg(g);
                            p.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the Dijkstra  method
                            p.computeDijkstraAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=3000, m=15000: " + time);
                            break;
                        case 3:
                            //creat a graph
                            g = new Graph(4000, 20000);
                            p = new SingleSourceSPAlg(g);
                            p.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the Dijkstra  method
                            p.computeDijkstraAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=4000, m=20000: " + time);
                            break;
                        case 4:
                            //creat a graph
                            g = new Graph(5000, 25000);
                            p = new SingleSourceSPAlg(g);
                            p.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the Dijkstra  method
                            p.computeDijkstraAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond)of n=5000, m=25000: " + time);
                            break;
                        case 5:
                            //creat a graph
                            g = new Graph(6000, 30000);
                            p = new SingleSourceSPAlg(g);
                            p.setReadFile(false);
                            startTime = System.currentTimeMillis();
                            //call the Dijkstra  method
                            p.computeDijkstraAlg(g);
                            finishTime = System.currentTimeMillis();
                            time = finishTime - startTime;
                            System.out.println("---------------------------------------");
                            System.out.println("The Runtime (MilliSecond) of n=6000, m=30000: " + time);
                            break;
                        default:
                            System.out.println("You entered a wrong choice .. try again ");

                    }// end switch
                }
            }// end if (choice ==2 )
        }// while 

        System.out.println("");
        System.out.println("------------ END OF PROGRAM ------------");
        System.out.println("     Thanks for using our program..");

    }// end method 
}// end class 
