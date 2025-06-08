import javax.swing.*;
import java.util.Scanner;
public class Exceptions{
    public static void main(String[] args) {
        /*String name=JOptionPane.showInputDialog(null, "Enter your name: ","Thy name",1);
        JOptionPane.showMessageDialog(null, "Your name is "+ name, "Your name ", 1);
    }*/
        int result=0;
        String fnum;
        String snum;
    
        Scanner input=new Scanner(System.in);
        try {
            System.out.println("Enter first num: ");
            fnum=input.next();
            System.out.println("Enter second num: ");
            snum=input.next();
            
            int F_name=Integer.parseInt(fnum);
            int S_name=Integer.parseInt(snum);

            //int divide=fnum / snum;
            int division=F_name/S_name;
            System.out.println(division);

        }
            catch (ArithmeticException e) {
                System.out.println("Please don't divide by 0!");
        }

            catch (ArithmeticException e){
                System.out.println("Please don't divide by 0!");
        }
}
}