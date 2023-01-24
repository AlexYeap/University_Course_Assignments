import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Assignment3{
    public static void main(String[] args) throws IOException{
        String inputFile = args[0] + ".txt";
        String outputFile = args[1] + ".txt";
        String outputFile2 = args[2] + ".txt";

        //String inputFile = "a3input2.txt";
        //String outputFile = "output1.txt";
        //String outputFile2 = "output2.txt";

        BinaryTree tree = new BinaryTree();
        FileInputStream br = new FileInputStream(inputFile);
        Scanner sc = new Scanner(br);
        studentNameRecords data = new studentNameRecords();
        while (sc.hasNextLine()){
            String line = sc.nextLine();

            if (line.charAt(0) == 'I'){
                data.studentRecords(line);
                tree.insertion(line.substring(8,17).trim());

            }
            else if (line.charAt(0) == 'D'){
                tree.deletion(line.substring(8,17).trim());
            }

        }
        sc.close();
        //System.out.print(System.lineSeparator() + System.lineSeparator());
        //data.printArrayList();
        System.out.print(System.lineSeparator() + System.lineSeparator());
        tree.traverseInOrder(tree.root);
        System.out.print(System.lineSeparator() + System.lineSeparator());
        tree.breadthFirst();
        System.out.print(System.lineSeparator() + System.lineSeparator());
        ArrayList<String> inorderTree = tree.traverseInOrder(tree.root);
        System.out.print(System.lineSeparator() + System.lineSeparator());
        ArrayList<String> breadthTree = tree.breadthFirst();
      
        
        
        FileWriter writer = new FileWriter(outputFile); 
        for(String str: inorderTree){
            writer.write(str);
        }
        writer.close();

        FileWriter writer2 = new FileWriter(outputFile2); 
        for(String str: breadthTree){
            writer2.write(str);
        }
        writer2.close();
  
    
    
    }

}