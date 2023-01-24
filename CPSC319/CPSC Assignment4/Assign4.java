
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Assign4{
    public static void main(String[] args) throws IOException{
       // String inputFile = args[0] + ".txt";
        //String inputFile2 = args[1] + ".txt";
        //String outputFile = args[2] + ".txt";
        //String outputFile2 = args[3] + ".txt";
        

        String inputFile = "input.txt";
        String inputFile2 = "query.txt";
        String outputFile = "output1.txt";
        String outputFile2 = "output2.txt";

		try{
            FileInputStream br2 = new FileInputStream(inputFile);
            Scanner sc2 = new Scanner(br2);
            int vertices = sc2.nextLine().split("\\s+").length;
            br2.close();


            FileInputStream br = new FileInputStream(inputFile);
            Scanner sc = new Scanner(br);
            Graph graph = new Graph(vertices);
            System.out.println(vertices);
            
			// vertices
            for(int currRow = 0; currRow < vertices ; currRow++) { 
                //create the edges specified in this row
                if(sc.hasNextLine()){
                    String line = sc.nextLine().trim();
                    String[] row = line.split("\\s+"); // split whitespaces
                    //read each line
                    System.out.println(line);
                        for(int i = 0; i < vertices; i++) { 
                        //edge exists between indices 'currRow' and col 'i'.
                            if(Integer.parseInt(row[i]) == 1) { 
                            System.out.println(currRow + "," + i);
                            graph.addEdge(currRow, i);
                                
                            }
                        }  
			    }
            }

            FileInputStream br3 = new FileInputStream(inputFile2);
            Scanner sc3 = new Scanner(br3);
          
            System.out.println(vertices);
            
			// vertices
            while(sc3.hasNextLine()){
                String line2 = sc3.nextLine().trim();
                if (line2 != null){
                    String[] row2 = line2.split("\\s+"); // split whitespaces
                    //read each line
                    System.out.println(Integer.parseInt(row2[0]) + " " + Integer.parseInt(row2[1]));
                    graph.DFS(Integer.parseInt(row2[0]),Integer.parseInt(row2[1]));
                    graph.BFS(Integer.parseInt(row2[0]),Integer.parseInt(row2[1]));
                    
                }  
            } 
            
			br.close();
            br2.close();
            br3.close();
            sc.close();
            sc2.close();
            sc3.close();
            //System.out.println("");
           
            ArrayList<String> DFS = graph.getDFS();
            
            ArrayList<String> BFS = graph.getBFS();
        
        
            FileWriter writer = new FileWriter(outputFile); 
            for(String str: DFS){
                writer.write(str);
            }
            writer.close();
            System.out.println("Succesfully created and writen in Outputfile");

            FileWriter writer2 = new FileWriter(outputFile2); 
            for(String str: BFS){
                writer2.write(str);
            
            }
            writer2.close();
            System.out.println("Succesfully created and writen in Outputfile");
		
            // catch exceptions & errors
        }
        catch (FileNotFoundException ex){
			ex.printStackTrace();
		} 
        catch (IOException ex) {
			ex.printStackTrace();
		} 
        catch (Exception e) {
			System.out.println("Error: " + e);
        }
        


        
	    

    }  
} 




    /*   
    
        Graph g = new Graph(31);

        g.addEdge(0, 1);
        g.addEdge(0,6);
        g.addEdge(0,7);
        g.addEdge(0,15);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,7);
        g.addEdge(1,8);
        g.addEdge(1,15);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,7);
        g.addEdge(3,14);
        g.addEdge(4,0);
        g.addEdge(4,5);
        g.addEdge(5,1);
        g.addEdge(5,6);
        g.addEdge(6,0);
        g.addEdge(6,4);
        g.addEdge(6,5);
        g.addEdge(7,4);
        g.addEdge(7,5);
        g.addEdge(7,28);
        g.addEdge(8,0);
        g.addEdge(8,11);
        g.addEdge(9,2);
        g.addEdge(9,14);
        g.addEdge(9,28);
        g.addEdge(10,9);
        g.addEdge(10,11);
        g.addEdge(12,14);
        g.addEdge(12,18);
        g.addEdge(13,14);
        g.addEdge(13,15);
        g.addEdge(13,18);
        g.addEdge(14,10);
        g.addEdge(14,18);
        g.addEdge(14,29);
        g.addEdge(15,9);
        g.addEdge(15,11);
        g.addEdge(15,12);
        g.addEdge(16,13);
        g.addEdge(16,27);
        g.addEdge(17,20);
        g.addEdge(17,21);
        g.addEdge(18,13);
        g.addEdge(18,19);
        g.addEdge(18,28);
        g.addEdge(19,28);
        g.addEdge(21,20);
        g.addEdge(21,22);
        g.addEdge(22,23);
        g.addEdge(22,25);
        g.addEdge(22,27);
        g.addEdge(24,19);
        g.addEdge(27,26);
        g.addEdge(28,9);
        g.addEdge(28,29);
        g.addEdge(29,24);
        g.addEdge(30,4);
    
  */
        

