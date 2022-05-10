package Project;


/**
 * 
 * @author Lujain Abdullah
 * @author Sara Alahmari
 * @author Shaima Bashammakh
 */


public class Edge {

    //--------------------------------variables---------------------------------

    /**
     * variable weight
     */
    private int weight;

    /**
     * variable source
     */
    private Vertex Source;

    /**
     * variable target
     */
    private Vertex Target;
  

    // ------------------------------constructers-------------------------------

    /**
     *
     * @param Source
     * source is a Vertex
     * @param Target
     * target is a Vertex
     * @param weight
     * weight value of the edge
     * 
     */
    public Edge(Vertex Source, Vertex Target, int weight) {
        this.weight = weight;
        this.Source = Source;
        this.Target = Target;
    }

    /**
     *
     * @param v
     * v is a Vertex
     */
    public Edge(Vertex v) {
        this.weight = 0;
        this.Source = v;
        this.Target = v;
    }

//----------------------------------- methods ---------------------------------
    //Setter and Getter methods 

    /**
     *
     * @return weight of the edge
     */
    public int getWeight() {
        return weight;
    }

    //-------------------------------------------------------------------------------------------------------------
    
    /**
     * method to change the weight
     * @param weight
     * weight of the edge
     * 
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    
    //-------------------------------------------------------------------------------------------------------------
    
    
    /**
     *
     * @return Source of the edge
     */
    public Vertex getSource() {
        return Source;
    }

    
    //-------------------------------------------------------------------------------------------------------------
    
    
    /**
     * method to change the source vertex
     * @param Source
     * source of the edge
     */
    public void setSource(Vertex Source) {
        this.Source = Source;
    }

    
    //-------------------------------------------------------------------------------------------------------------
    
    
    /**
     *
     * @return Target of the edge
     */
    public Vertex getTarget() {
        return Target;
    }

    //-------------------------------------------------------------------------------------------------------------
    
    /**
     * method to change the target vertex
     * @param Target
     * target of the edge
     */
    public void setTarget(Vertex Target) {
        this.Target = Target;
    }
   
}
 //---------------------END Class--------------------------------
