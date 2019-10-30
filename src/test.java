import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Second "Yandex" testing task.
 * Input: String compressed by RLE algorithm.
 * Output: Size of unzipped string.
 * @author Konstantin
 */
public class test {

    public static void main(String[] args) {
        String input=null;
        try (Scanner in = new Scanner(new File("input.txt"))) {
            input=in.nextLine();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
            System.exit(1);
        }
        int sum = 0, numCount=0;
        for(int i = 0; i< input.length(); i++) {
            if(!Character.isDigit(input.charAt(i)))
                if(numCount==0)
                    sum++;
                else {
                    sum+=Integer.parseInt(input.substring(i-numCount,i));
                    numCount=0;
                }
            else
                numCount++;
        }
        if(numCount!=0)
            sum+=(Integer.parseInt(input.substring(input.length()-numCount,input.length())))-1;//minus one because of already counted first symbol.

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(Integer.toString(sum));
        } catch(IOException ex) {
            System.out.println(ex.toString());
            System.exit(1);}
    }

}
