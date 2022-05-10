package Project;


/**
 * @author lujain Abdullah
 * @author Sara Alahmari
 * @author Shaima Bashammakh
 */

//---------------Vertex Class----------------------------------------
public class Vertex {

    //----------------------variables---------------------------------

    /**
     * variable label
     */
    private char label;

    /**
     * variable isVisited
     */
    private boolean isVisited;

    /**
     * variable position
     */
    private int position;

    //------------------------constructers-------------------------------- 

    /**
     *
     * @param label
     * @param isVisited
     */
    public Vertex(char label, boolean isVisited) {
        this.label = label;
        this.isVisited = isVisited;
    }

    /**
     *
     * @param position
     * position is a integer value , it is position of the vertex
     * @param isVisited
     * isVisited is a boolean value
     */
    Vertex(int position, boolean isVisited) {
        this.position = position;
        this.isVisited = isVisited;

    }

    /**
     *
     * @param label
     * label is a char value
     */
    public Vertex(char label) {
        this.label = label;
        this.isVisited = true;
    }

    //------------------------methods-------------------------------- 
    //Setter and Getter methods 

    /**
     * method to return the position of the vertex
     * @param position
     * integer value
     */
    public void setPosition(int position) {
        this.position = position;
    }

    
    //-------------------------------------------------------------------------------------------------------------
    
    
    /**
     *
     * @return position of the vertex
     */
    public int getPosition() {
        return position;
    }

    
    //-------------------------------------------------------------------------------------------------------------
    
    
    /**
     *
     * @return label of the vertex
     */
    public char getLabel() {
        return label;
    }

    
    //-------------------------------------------------------------------------------------------------------------
    
    
    /**
     * method to change the label of the vertex
     * @param label
     * char value
     */
    public void setLabel(char label) {
        this.label = label;
    }
    
    //-------------------------------------------------------------------------------------------------------------

    /**
     * method to check if the vertex is visited or not
     * @return true or false
     */
    public boolean isIsVisited() {
        return isVisited;
    }

    
    //-------------------------------------------------------------------------------------------------------------
    
    
    /**
     * method to change the vertex state
     * @param isVisited
     * isVisited is a boolean value 
     */
    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    
    //-------------------------------------------------------------------------------------------------------------
   

    /**
     * we will not use it
     * @param v
     * v is a Vertex
     * @return position of the vertex
     */
    public int getVertPos(Vertex v) {
        return position;
    }
    
}//---------------------END Class--------------------------------
