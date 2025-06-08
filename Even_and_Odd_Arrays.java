import java.util.Scanner;
public class Even_and_Odd_Arrays {
    public static void main (String[] args){
        int number=0;
        int [][]Even=new int[3][3];
        int [][]Odd=new int[3][3];
        Scanner input=new Scanner(System.in);
        int EvenIndex = 0, OddIndex = 0; // Track number of even/odd numbers added

        int EvenProduct=1; //Product of Even array leading diagonals
        int OddProduct=1; //Product of Odd array leading diagonals
        int TrailOddProduct=1; //Product of Odd array trailing diagonals

        while (EvenIndex < 9 || OddIndex < 9) { // Ensure 9 even and 9 odd numbers are collected
            System.out.println("Give me the numbers from 1 - 19: ");
            number = input.nextInt();

            if (number >= 1 && number <= 19) { // Ensure number is within range
                if (number % 2 == 0 && EvenIndex < 9) { // Store even numbers in Even array
                    Even[EvenIndex / 3][EvenIndex % 3] = number;
                    if ((EvenIndex/3)==(EvenIndex%3)) {
                        EvenProduct = EvenProduct * Even[EvenIndex/3][EvenIndex/3];
                    }
                    EvenIndex++;
                } 
                else if (number % 2 != 0 && OddIndex < 9) { // Store odd numbers in Odd array
                    Odd[OddIndex / 3][OddIndex % 3] = number;
                    if ((OddIndex/3)==(OddIndex%3)) {
                        OddProduct = OddProduct * Odd[OddIndex/3][OddIndex/3];
                    } else if ((OddIndex/3)+(OddIndex%3)==2) {
                        TrailOddProduct=TrailOddProduct*Odd[OddIndex/3][OddIndex%3];
                    }
                    OddIndex++;
                }
            } else {
                System.out.println("Invalid input! Please enter the numbers between 1 - 19.");
                }
        }
        System.out.println("\nEven array :");
        printArray(Even);
        System.out.println("\nOdd array :");
        printArray(Odd);
        
        System.out.println("\nThe product of the leading diagonal of Even array is; " + EvenProduct);
        System.out.println("The product of the leading diagonal of Odd array is; " + OddProduct);
        System.out.println("The difference of the products of the leading diagonal and trailing diagonal of Odd array is; " + (OddProduct-TrailOddProduct));

        System.out.println(Even[0][0]);
        input.close();


    




    
    
}

public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
