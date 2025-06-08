import java.util.Scanner;
public class UniversityGradingSystem {
    static int n, Subject1, Subject2, Subject3, Total, Average; static int Total_Sum=0;
    static String Name;
    public static void main (String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter the number of students: "); // For inputting n

        n=input.nextInt(); //The number of students
        Object Students [][]=new Object[n][6]; //Array for the students (Name and Four Semesters)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                
                if (j==0) { //The first array space is for the Student's name

                    System.out.println("Enter First name of Student " +(i+1) + ": ");
                    Name=input.next();
                    Students[i][j]=Name;
                    System.out.println("Student: " + Name + "\n");
                    
                    

                }else if (j<=4){
                   
                    System.out.println("For Semester: "+ j);
                    System.out.println("Input Subject 1 scores: ");
                    Subject1=input.nextInt(); //Inputting Subject 1 scores
                    System.out.println("Input Subject 2 scores: ");
                    Subject2=input.nextInt(); //Inputting Subject 2 scores
                    System.out.println("Input Subject 3 scores: ");
                    Subject3=input.nextInt(); //Inputting Subject 3 scores
                    System.out.println("\n");
                   
                    Total=Subject1+Subject2+Subject3;
                    Total_Sum=Total_Sum + Total;
                    
                    Students[i][j]=Total; //Total of subjects of the semester
                    Average=Total/3;
                    System.out.println("The Average is: " + Average + " for Semester "+ j + "\n");

                } else if(j==5){
                    Students[i][j]=Total_Sum;
                    Total=Total_Sum=0;
                }

            }
        }

        input.close();

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < 6; b++) {
                if (b==0) { //The first array space is for the Student's name
                    System.out.print("Name: "+ Students[a][b]);
                }else if (b<=4){
                    System.out.print("\t Sem " + b + ": "+ Students[a][b]);
                }else if (b==5){
                    System.out.print("\t Total: " + Students[a][b] + "\n");
                }
            }
        }
        

    }
}
