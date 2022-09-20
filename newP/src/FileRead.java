import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FileRead {
    File file=new File("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\src\\nomi.txt");


    String choose() throws FileNotFoundException {
        String s = null;
        Scanner sc=new Scanner(file);
        Random r=new Random();
        int n=r.nextInt(1625);
        int i=0;
        while(sc.hasNext()){
         if(i==n){
             s=sc.nextLine();
         }
         i++;
        }
        return s;
    }
}
