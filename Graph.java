package Project;


// ---------------------------- packeges ----------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author lujain Abdullah
 * @author Sara Alahmari
 * @author Shaima Bashammakh
 */
//---------------Graph Class----------------------------------------
public class Graph {

    //-------------------- variables---------------------------------
    /**
     * variable of number of vertices
     */
    private int verticesNo;

    /**
     * variable of number of edges
     */
    private int edgeNo;

    /**
     * variable to count the number of edges
     */
    private int edgeNumber;

    /**
     *
     */
    //Always true because the graphs that used in this project (requirement 1 & 2) are: directed
    private boolean isDigraph;
    //or
    //private boolean isDigraph = true;

    /**
     * An array for all vertices
     */
    private Vertex[] vertices = null;
    //an array for all edges 

    /**
     * Two dimension array to store the graph's edge
     */
    private Edge[][] adjMatrix = null;

    //-----------------------------------------------------------------
    // --------------------constructers--------------------------------
    /**
     *
     * @param verticesNo
     * @param edgeNo
     */
    //This constructor used only with requirement 2
    public Graph(int verticesNo, int edgeNo) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = true;
        this.edgeNumber = 0;
        adjMatrix = new Edge[verticesNo][verticesNo];
        //by default all elements of the 2-dimention array (adjMatrix) will point to null
        //call the makeGraph
        makeGraph(verticesNo, edgeNo);
    }

    /**
     * constructor used with requirement one
     *
     */
//This constructor used only with requirement 1
    public Graph() {
        //Create the adjency matrix with size 10*10 ( Like what is required in requirement 1: 10 vertices )
        adjMatrix = new Edge[10][10];
        //NOTE : if the size was not 10*10 --> we can change the size by use the method (setAdjMatrixSize)
    }
//----------------------------------------------------------------------
    // ---------------------Methods-------------------------------------    

    /**
     * method to read the graph from the file
     *
     * @param file file that we will read from
     * @throws FileNotFoundException exception to avoid the file errors
     */

    public void readGraphFromFile(File file) throws FileNotFoundException {
        Scanner read = new Scanner(file);

        //reading the first number to know if the graph is directed or not
        int diagraph = read.nextInt();
        if (diagraph == 0) {
            this.setIsDigraph(false);
        }//end if 
        else {
            this.setIsDigraph(true);
        }//end else 
        //************************************************
        // reading the number of vertex 
        int v = read.nextInt();
        this.setVerticesNo(v);
        this.setAdjMatrixSize(v);
        // reading the number of edges 
        int e = read.nextInt();
        this.setEdgeNo(e);
        //*********************************************
        // declare and cerate the array for list of vertices 
        vertices = new Vertex[verticesNo];

        //***********************************************
        //while loop to read the graph from the file 
        while (read.hasNext()) {
            // reading the source , the target , and the weight 
            char source = read.next().charAt(0);
            char target = read.next().charAt(0);
            int w = read.nextInt();

            // variables to save the position of the vertecies 
            int sourcePos = source - 'A';
            int targetPos = target - 'A';
      
            //calling add edge method to create the edge 
            Edge edge = addEdge(sourcePos, targetPos, w, 1);

            // set the lable of the source vertex
            edge.getSource().setLabel(source);
            // set the lable of the target vertex
            edge.getTarget().setLabel(target);
        }//end while 
    }//End method 
//-----------------------------------------------------------------------------------------------

    /**
     * method to generate the graph based on vertices and edges
     *
     * @param verticesNo number of vertices
     * @param edgeNo number of edges
     */

    public void makeGraph(int verticesNo, int edgeNo) {

        // declare and cerate the array for list of vertices 
        vertices = new Vertex[verticesNo];
        //-----------Vertex--------------------
        //initialize the array  for all the vertices
        for (int i = 0; i < vertices.length; i++) {

            // creating a vertex opject
            Vertex v = new Vertex(i, false);

            // adding the vertex to the array 
            vertices[i] = v;
        }  //End for 

        //-----------Edge--------------------
        // creating edges for each vertex randomely 
        //1- connect all vertex together 
        for (int i = 0; i < vertices.length - 1; i++) {
            Vertex s = vertices[i];
            Vertex t = vertices[i + 1];
            int wt = (int) (Math.random() * 50);
            Edge e = new Edge(s, t, wt);
            adjMatrix[i][i + 1] = e;
            edgeNumber++;
        }//end for
        //connecting the last vertex with the first one
        Vertex s = vertices[vertices.length - 1];
        Vertex t = vertices[0];
        int wt = (int) (Math.random() * 50);
        Edge e = new Edge(s, t, wt);
        adjMatrix[vertices.length - 1][0] = e;
        edgeNumber++;
        //-------------------------------------------------

        //loop to insure that the number of generated edges is equal the requested number
        while (edgeNumber != edgeNo) {

            // 2- generate random source and target 
            int rand1 = (int) (Math.random() * verticesNo);
            int rand2 = (int) (Math.random() * verticesNo);
            Random randomNum = new Random();
            int w = 1 + randomNum.nextInt(50);
            Edge edge = addEdge(rand1, rand2, w, -1);
        }//end while 

    }//End Method 

//----------------------------------------------------------------------------------------------
    /**
     * method to add the edges to the source and target vertices
     *
     * @param Source source value is a number
     * @param Target target value is a number
     * @param w w is a weight edge
     * @param whichGraph whichGraph is to know which method is calling add edge
     * @return an edge
     */
    public Edge addEdge(int Source, int Target, int w, int whichGraph) {
        // preparing the variables 
        Vertex s = null;
        Vertex t = null;
        Edge e = null;
        //----------------------------------
        // if the whichGraph variable were -1 then this means that the calling is from make graph method
        if (whichGraph == -1) {
            //3- chack if the edge is exsist or not
            int check = 0;
            for (int i = 0; i < edgeNumber; i++) {
                if (Source == Target) {
                    check = 1;
                }//end if
                if (adjMatrix[Source][Target] == null) {
                    check = 0;
                }//end if
                else {
                    check = 1;
                }//end else 
            }//end for

            // 4- generate the edge 
            if (check == 0) {
                s = vertices[Source];
                t = vertices[Target];
                e = new Edge(s, t, w);
                //-------------------------------------------------
            }//End if 
            // else if the edge is already exsist  
            else {
                return null;
            }
            // if the graph is directed --> create a directed edge  
            if (e != null && isDigraph) {
                //adding the edge to the source vertex only 
                adjMatrix[Source][Target] = e;
                edgeNumber++;
            }//end if 
            // if the graph is not directed --> create two edgs 
            else if (isDigraph == false && e != null) {
                Edge edge2 = new Edge(e.getTarget(), e.getSource(), w);
                // add the edge to the matrix in both at the source and the target 
                adjMatrix[Source][Target] = e;
                adjMatrix[Target][Source] = edge2;
                edgeNumber = edgeNumber + 2;
            }// end else if 

        }//End if for make graph method 

        //*******************************************************88
        if (whichGraph == 1) {

            // variable to save the position of the vertex
            int sourcePos = -1;
            int targetPos = -1;
            // check if the vertecies in the vertices array or not 
            if (vertices[Source] != null) {
                sourcePos = Source;
            }//end if 
            if (vertices[Target] != null) {
                targetPos = Target;
            }//end if 

            if (sourcePos == -1) {
                // creating an object for source vertex 
                s = new Vertex(Source, false);
                vertices[Source] = s;
            }//end if 
            if (targetPos == -1) {
                // creating an object for target vertex 
                t = new Vertex(Target, false);
                vertices[Target] = t;
            }//end if 

            //1-  if both vertecies not exist
            if (sourcePos == -1 && targetPos == -1) {
                // creating an edge object
                e = new Edge(s, t, w);
            }//end if 

            //2- if the source is found but the target is not 
            if (sourcePos != -1 && targetPos == -1) {
                // creating an edge object
                e = new Edge(vertices[sourcePos], t, w);
            }//end if 

            //3- if the target is found but the source is not 
            if (sourcePos == -1 && targetPos != -1) {
                // creating an edge object
                e = new Edge(s, vertices[targetPos], w);
            }//end if 

            // 4- if both verticies are found 
            if (sourcePos != -1 && targetPos != -1) {
                // creating an edge object
                e = new Edge(vertices[sourcePos], vertices[targetPos], w);
            }//end if 

            // if the graph is directed --> create a directed edge  
            if (isDigraph) {
                // add the edge to the matrix 
                adjMatrix[Source][Target] = e;
            }//end if 
            // if the graph is not directed --> create two edgs 
            else if (isDigraph == false) {
                Edge edge2 = new Edge(e.getTarget(), e.getSource(), w);
                // add the edge to the matrix 
                adjMatrix[Source][Target] = e;
                adjMatrix[Target][Source] = edge2;
            }// end if 
        }//End if for the read from file method
        //---------------------------------

        // return the created edge object
        return e;
    }// End Method

//---------------------------------------------------------------------------------
    /**
     * method used to change the matrix size if the size is not 10*10 (vertices
     * number was not 10)
     *
     * @param size size is an integer value that represent the adjMatrix size
     */
    public void setAdjMatrixSize(int size) {
        adjMatrix = new Edge[size][size];
    }
//-----------------------------------------------------------------------------------

    /**
     * method to return the number of vertices
     *
     * @return the number of vertices
     */
    public int getVerticesNo() {
        return verticesNo;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to change the number of vertices
     *
     * @param verticesNo verticesNo is an integer value of number of vertices
     */
    public void setVerticesNo(int verticesNo) {
        this.verticesNo = verticesNo;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to return the number of edges
     *
     * @return the number of edges
     */
    public int getEdgeNo() {
        return edgeNo;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to change the number of edges
     *
     * @param edgeNo edgeNo is an integer value of number of edges
     */
    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to return if the graph is directed or not ( ture if directed )
     * check if the graph is directed or not ( ture if directed )
     *
     * @return true or false
     */
    public boolean isIsDigraph() {
        return isDigraph;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to change the state of the graph
     *
     * @param isDigraph isDigraph is a boolean value
     */
    public void setIsDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to return the array of vertices
     *
     * @return the list of vertices
     */
    public Vertex[] getVertices() {
        return vertices;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method the change the vertices array
     *
     * @param vertices vertices are objects of Vertex
     *
     */
    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the adjMatrix
     */
    public Edge[][] getAdjMatrix() {
        return adjMatrix;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     *
     * @param adjMatrix matrix of the graph
     */
    public void setAdjMatrix(Edge[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to return a specific edge from the matrix
     *
     * @param row position of a row
     * @param column position of a column
     * @return a specific edge from the matrix
     */
    public Edge getSpecificAdjMatrix(int row, int column) {
        return adjMatrix[row][column];
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to change a specific edge from the matrix
     *
     * @param edge weight of the edge
     * @param row position of a row
     * @param column position of a column
     */
    public void setSpecificAdjMatrix(Edge edge, int row, int column) {
        adjMatrix[row][column] = edge;

    }

   //-------------------------------------------------------------------------------------------------------------
    /**
     * method to change a specific weight from the matrix
     *
     * @param weight weight of the edge
     * @param row position of a row
     * @param column position of a column
     */
    public void setWeightSpecificAdjMatrix(int weight, int row, int column) {
        adjMatrix[row][column].setWeight(weight);

    }

   //-------------------------------------------------------------------------------------------------------------
    /**
     * method to return a specific weight from the matrix
     *
     * @param row position of a row , integer value
     * @param column position of a column , integer value
     * @return a weight from the matrix
     */
    public int getWeightSpecificAdjMatrix(int row, int column) {
       
             return adjMatrix[row][column].getWeight();
    }
    
    /**
     * method to return a specific weight from the matrix
     *
     * @param row position of a row , integer value
     * @param column position of a column , integer value
     * @return a weight from the matrix
     */
    public int getWeightSpecificAdjMatrixDijkstra(int row, int column) {
        if (row >=0 && column >=0) {
             return adjMatrix[row][column].getWeight();
        }
       return 0;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the length of the adjMatrix
     */
    public int getAdjMatrixLen() {
        return adjMatrix.length;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * we will not use it in out program
     *
     * @param label
     * @return
     */
    public boolean addVertLabel(char label) {
        return true;
    }

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to fill the null positions in the adjMatrix of edges
     */
    public void fillEmpty() {
        for (int n = 0; n < adjMatrix.length; n++) {
            for (int m = 0; m < adjMatrix.length; m++) {
                // check and find the null positions in the adjMatrix ( positions that do not contain a created edge ) 
                // then create an edge for null positions

                if (adjMatrix[n][m] == null) {
                    // 1- n and m are not equal -> put infinity (99999999)
                    if (n != m) {
                        Vertex s = null;
                        Vertex v = null;
                        int maxValue = 99999999;
                        //create the edge
                        adjMatrix[n][m] = new Edge(s, v, maxValue);
                    }//end if
                    // 2- n and m are equal -> put zero (0) -> the diagonal weights will be equal to 0 
                    else {
                        Vertex s = null;
                        Vertex v = null;
                        int minValue = 0;
                        //create the edge
                        adjMatrix[n][m] = new Edge(s, v, minValue);
                    }//end else

                }//end if
            }//end for

        }//end for
    }//end method

   //-------------------------------------------------------------------------------------------------------------
    /**
     * method to print all vertices and their edges ( only for requirement 1 )
     */
    public void printFile() {
        // two for loops to traverse all elements and weights an adjMatrix
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] != null) {
                    System.out.print("Vertex [" + adjMatrix[i][j].getSource().getLabel() + "] connected with");
                    System.out.print(" vertex [" + adjMatrix[i][j].getTarget().getLabel() + "] by edge has weight: " + adjMatrix[i][j].getWeight());
                    System.out.println("");
                }
            }//end for 
            System.out.println("");
        }//end for 

    }//end method

    //-------------------------------------------------------------------------------------------------------------
    //we will not use this method because the n and m are very large
    /**
     * method to print all vertices and their edges ( only for requirement 2 )
     */
    public void print() {
        // two for loops to traverse all elements and weights an adjMatrix
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] != null) {
                    System.out.print("Vertex [" + adjMatrix[i][j].getSource().getPosition() + "] connected with");
                    System.out.print(" vertex [" + adjMatrix[i][j].getTarget().getPosition() + "] by edge has weight: " + adjMatrix[i][j].getWeight());
                    System.out.println("");
                }
            }//end for 
        }//end for 

        System.out.println("");
    }//end method

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to print the matrix before the algorithm
     */
    public void printMatrixBeforeFloyedWarshal() {

        //Call the method
        fillEmpty();
        //print the first row of the matrix
        System.out.print("   ");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.printf("%-4s", (char) (i + 65));
        }
        System.out.println();

        ////print the matrix
        for (int i = 0; i < adjMatrix.length; i++) {
            //print the first column of the matrix
            System.out.print((char) (i + 65) + "  ");
            for (int j = 0; j < adjMatrix.length; j++) {
                //print infinity if the weight = 99999999
                if (adjMatrix[i][j].getWeight() == 99999999) {
                    //System.out.print("∞  ");
                    System.out.print("INF ");
                } else {
                    //print the weight of the edge
                    System.out.printf("%-2d  ", adjMatrix[i][j].getWeight());
                }
            } //end for
            System.out.println();
        }//end for
        System.out.println("\n");

    }//end method 

    //-------------------------------------------------------------------------------------------------------------
    /**
     * method to print the matrix after the algorithm
     */
    public void printMatrixAfterFloyedWarshal() {
        System.out.println("\n***************** FloyedWarshal Algorithm *****************");
        //print the first row of the matrix
        System.out.print("   ");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.printf("%-4s", (char) (i + 65));
        }
        System.out.println();

        //print the matrix
        for (int i = 0; i < adjMatrix.length; i++) {
            //print the first column of the matrix
            System.out.print((char) (i + 65) + "  ");
            for (int j = 0; j < adjMatrix.length; j++) {
                //print infinity if the weight = 99999999
                if (adjMatrix[i][j].getWeight() == 99999999) {
                    //System.out.print("∞  ");
                    System.out.print("INF ");
                } else {
                    //print the weight of the edge
                    System.out.printf("%-2d  ", adjMatrix[i][j].getWeight());
                }
            } //end for
            System.out.println();
        } //end for
        System.out.println("\n");
    }//end method 

    /**
     *
     * @param distance
     * @param readFile
     * @param Result
     */
    public void printMatrixAfterDijkstraAlgorithm(int [] distance , boolean readFile , String[] Result ) {
      //print all the distances with the pathes
        System.out.println("\n***************** Dijkstra Algorithm *****************");
        System.out.println("All the shortest distances from the source vertex to other vertices in graph");
        if (readFile) {
         for (int i = 0; i < adjMatrix.length; i++) {
            System.out.println("Shortest Distance from 'A' to '" + (char) (i + 65) + "' is " + distance[i] + ", the Path: " + Result[i] + " " + (char) (i + 65) + " and the lenght is " + distance[i]);
        }
        System.out.println();
    }else{
           
        }//end else 
      
}

    /**
     * method to change a specific vertex state 
     * @param i
     * i is a position of a vertex 
     */
    public void setSpecificVertexIsVisited(int i) {
       vertices[i].setIsVisited(false);
    }
    
    /**
     *method to change a specific vertex state 
     * @param i
     * i is a position of a vertex 
     * @param x
     * x is a state of a vertex 
     */
    public void setSpecificVertexIsVisited2(int i,boolean x) {
        if (i >= 0) {
            vertices[i].setIsVisited(x);
        }
       
    }

    /**
     * method to return a specific vertex state 
     * @param i
     *  i is a position of a vertex
     * @return a specific vertex state 
     */
    public boolean getSpecificVertexIsVisited(int i) {
        return vertices[i].isIsVisited();
    }

}//End class
//---------------------------------------------------------------------------------------
