package Project;


/**
 * @author lujain Abdullah
 * @author Sara Alahmari
 * @author Shaima Bashammakh
 */
//---------------AllSourceSPAlg Class----------------------------------------
public class AllSourceSPAlg extends ShortestPathAlgorithm {

    
    // ---------------------------- variables ----------------------------------

    /**
     * 
     * readFile variable
     * variable to know if we will use the algorithm with requirement 1 (read from file) or requirement 1
     * readFile -- > will be true with requirement 1 (read from file)
     */
    private boolean readFile=false;
    
    // ---------------------------- constructors -------------------------------

    /**
     * constructor for AllSourceSPAlg class
     * @param graph
     * graph is a Graph object
     * 
     */
    public AllSourceSPAlg(Graph graph) {
        super(graph);
    }

    
    // ------------------------------- methods ---------------------------------
    //method to compute the minimum distance between two vertices 
    //method to compute the floyed and warshal algorithm

    /**
     * method to compute the minimum distance between two vertices 
     * @param graph 
     * graph is a Graph object
     * 
     */
    public void computeFloyedWarshalAlg(Graph graph) {

        //we will print this if we use read from file -> requirement 1
        if(readFile){
        System.out.println("D(0)");
            graph.printMatrixBeforeFloyedWarshal();}
        
        else{
            //fill the empty places in the adjMatrix to avoid the errors
            graph.fillEmpty();}
        
        // variable to store the number of vertices
        int Vnumber = graph.getVerticesNo();
        // begin the algorithm
        for (int k = 0; k < Vnumber; k++) {
            for (int i = 0; i < Vnumber; i++) {
                for (int j = 0; j < Vnumber; j++) {
                    // find the mimimum distance(weight)
                    int minValue = Math.min(graph.getWeightSpecificAdjMatrix(i, j), (graph.getWeightSpecificAdjMatrix(i, k) + graph.getWeightSpecificAdjMatrix(k, j)));
                    // change the distance(weight)between two specific vertices to the smallest distance, if any
                    graph.setWeightSpecificAdjMatrix(minValue, i, j);    
                }
            }

            if(readFile){
            System.out.println("D("+(k+1)+")");
            graph.printMatrixBeforeFloyedWarshal();
            }
        }
    }

    //-------------------------------------------------------------------------------------------------------------

    /**
     * method to print the matrix before the algorithm
     * @param graph
     * graph is a Graph object
     */
    public void printMatrixBefore(Graph graph) {
        graph.printMatrixBeforeFloyedWarshal();
    }
    
    //-------------------------------------------------------------------------------------------------------------

    /**
     * method to print the matrix after the algorithm
     * @param graph
     * graph is a Graph object
     *  
     */
    public void printMatrixAfter(Graph graph) {
        graph.printMatrixAfterFloyedWarshal();
    }

    //-------------------------------------------------------------------------------------------------------------

    /**
     * method to print the graph
     * @param graph
     * graph is a Graph object
     * 
     */
    public void printGraph(Graph graph) {
        graph.print();
    }

     //-------------------------------------------------------------------------------------------------------------

    /**
     * method to change the variable (readFile)
     * @param readFile
     * readFile is a boolean value
     */
    public void setReadFile(boolean readFile) {
        this.readFile = readFile;
    }
    
    //-------------------------------------------------------------------------------------------------------------

    
}//End class
//----------------------------------------------------------------------------------------------------------------