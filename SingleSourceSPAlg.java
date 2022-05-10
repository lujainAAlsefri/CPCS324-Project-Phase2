package Project;


/**
 * @author lujain Abdullah
 * @author Sara Alahmari
 * @author Shaima Bashammakh
 */
//---------------MHPrimAlg Class----------------------------------------
/**
 *
 * @author lujain Abdullah
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    /**
     *
     * readFile variable variable to know if we will use the algorithm with
     * requirement 1 (read from file) or requirement 1 readFile -- > will be
     * true with requirement 1 (read from file)
     */
    private boolean readFile = false;

//-------------------------------constructers------------------------------

    /**
     * constructor 
     * @param graph
     * graph is a Graph object 
     */
        public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

    // ----------------------------methods----------------------------------
    /**
     *method to compute Dijkstra algorithm 
     * @param graph
     * graph is a Graph object 
     */
        public void computeDijkstraAlg(Graph graph) {
        //fill the empty places in the adjMatrix to avoid the errors
        graph.fillEmpty();

        // declaring some variables to use them in the algorithm   
        // 1- variable to save the MatrixSize of the martrix to use it 
        int MatrixSize = graph.getAdjMatrixLen();
        // variable of infinity 
        final int Infinity = 999999;

        // array to hold the distance from the source  
        int distance[] = new int[MatrixSize];
        // array to hold the final result of the algorithm 
        String[] Result = new String[MatrixSize];

        // for loop to change the verticies state and distance array 
        for (int i = 0; i < MatrixSize; i++) {
            // make vertices unvisited
            graph.setSpecificVertexIsVisited(i);
            //make distance equal to infinity
            distance[i] = Infinity;
        }//end for 

        // take the frst vertex as source and initialize the paths
        distance[0] = 0;
        // if the graph is from file 
        if (readFile) {
            Result[0] = "A -(" + distance[0] + ")-> ";
        }//end if
        // if the graph is generated randomly
        else {
            Result[0] = "0 -(" + distance[0] + ")-> ";
        }//end else 

        // ------------------------------------
        //Start the algorithm
        //nasted for loop to find the minimum distance  among all the vertices
        for (int i = 0; i < MatrixSize; i++) {

            int index = -1;

            int minimumDis = Infinity;
            // for loop 
            for (int j = 0; j < MatrixSize; j++) {
                if (graph.getSpecificVertexIsVisited(j) != true && distance[j] < minimumDis) {
                    minimumDis = distance[j];
                    // assign the minimum distance vertex index 
                    index = j;
                }//end inner loop 
            }//end outer loop 
//--------------------------------------------------------------

            // set the vertex that has position equal to index as visited
            graph.setSpecificVertexIsVisited2(index, true);

            // for loop to update distances
            for (int v = 0; v < MatrixSize; v++) {
                if (graph.getSpecificVertexIsVisited(v) != true && graph.getWeightSpecificAdjMatrixDijkstra(index, v) != Infinity && graph.getWeightSpecificAdjMatrixDijkstra(index, v) != 0) {
                    if (distance[index] + graph.getWeightSpecificAdjMatrixDijkstra(index, v) < distance[v]) {
                        distance[v] = distance[index] + graph.getWeightSpecificAdjMatrixDijkstra(index, v);
                        // change the Result to = current vertix Result + parent Result
                        if (readFile) {
                             Result[v] = Result[index] + (char) (v + 65) + " -(" + (distance[v] - distance[index]) + ")-> ";
                        }else{
                         Result[v] = Result[index] + (v) + " -(" + (distance[v] - distance[index]) + ")-> ";
                        }//end else 
                       
                    }//end if
                }//end if 
            }//end for 
        }//end for 

        // calling the print method to print the result 
      graph.printMatrixAfterDijkstraAlgorithm(distance, readFile, Result);
    }//end method

//---------------------------------------------------------------------------------
    /**
     * method to change the variable (readFile)
     *
     * @param readFile readFile is a boolean value
     */
    public void setReadFile(boolean readFile) {
        this.readFile = readFile;
    }
}
//end class
//--------------------------------------------------------------------------------------
