package cpsc319;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Assign3b {
    public static void main(String[] args) throws IOException{
        //String inputFile = args[0] + ".txt";
  
        String inputFile = "a3input1.txt";

        avlTree tree = new avlTree();
        avlTree tree2 = tree;

        FileInputStream br = new FileInputStream(inputFile);
        Scanner sc = new Scanner(br);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.charAt(0) == 'I'){
                tree2.root = tree2.insertion(tree2.root,line.substring(8,17).trim());
            }
        }
        sc.close();
        tree2.preOrder(tree2.root);
    }
}
