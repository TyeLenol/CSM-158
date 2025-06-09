import java.util.Scanner;
public class ClassExercise2 {

    static double Final; static int Average;static int Midsem;static int Exams;static int Sum; static int A=0, B=0, C=0, D=0, F=0, q=0, Min=100, Max=0; //To make Final global and hence work everywhere

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in); //For input :)

            System.out.println("Input the number of students: "); //q is actually for testing purposes; I was tired of inputting 15 students' infos ;)

            q=input.nextInt();

            Object Meow[][]=new Object[q][3];
            
            String IndexNumber;
            
            //All the inputs are numbers, so no need for Object array.
            //Using for loop for the array;
            for (int i = 0; i < q; i++) {
                for (int j = 0; j < 3; j++) {
    
                    if (j==0) { //For b numbers
    
                        System.out.println("Input Index Number of Student " + (i+1) + ": ");
                        IndexNumber=input.next();
                        Meow[i][j]=IndexNumber;
    
                    } else if (j==1) { //For computing Final scores
                        System.out.println("Input mid-semester scores: ");
                        Midsem=input.nextInt();
    
                        System.out.println("Input examination scores: ");
                        Exams=input.nextInt();
    
                        Final=(Midsem*0.3) + (Exams*0.7);


                        Meow[i][j]=(int)Final;

                        Sum=Sum+(int)Final;

                        //For minimum and maximum scores
                        if (Final>Max){
                            Max=(int)Final;
                        }else if (Final<Min){
                            Min=(int)Final;
                        }

                    } else {
                    int Grade=((int)Final/10);
                    switch(Grade) {
                        case 1:
                        case 2:
                        case 3:
                            Meow[i][j]="F";
                            F ++;
                            break;

                        case 4:
                            Meow[i][j]="D";
                            D ++;
                            break;
                        
                        case 5:
                            Meow[i][j]="C";
                            C ++;
                            break;

                        case 6:
                            Meow[i][j]="B";
                            B ++;
                            break;

                        default:
                            Meow[i][j]="A";
                            A++;
                        }
                    }
                }
            
            }

            Average=(Sum/q); //Average of Final scores
            //Printing out the Array
            System.out.println("Index Number \t Final Score \t Grade \t ");

            for(int a=0; a<q; a++){
                for (int b = 0; b < 3; b++) {
                        if(b==0){
                        System.out.print(Meow[a][b] + "\t\t      ");
                    } else if (b==1) {
                        System.out.print(Meow[a][b] + "\t   ");
                    } else if (b==2) {
                        System.out.print(Meow[a][b] + "\n");
                    }
    
                }
            }

            System.out.println(" The average of the scores is: " + Average + "\n The number of people who got grades A-F are as follows;\n A: " + A + "\n B: " + B + "\n C: " + C + "\n D: " + D + "\n F: " + F + "\n And the minimum and maximum scores respectively are " + Min + " and " + Max);

            input.close();

            
        }
    }  
                

