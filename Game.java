import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        
        // draw the table
        int rows = 4;
        int columns = 4;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                if (i == 2 && j == 2) {
                    System.out.print("2   ");
                }
                else {
                    System.out.print("*   ");
                }
            }
            System.out.println();
        }

        // loop for the main game
        while (true) { 
            
            // get the direction from user
        System.out.println("Enter direction (r, l, u, d):");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine(); 


        // Handle the direction input
        switch (direction) {
            case "u":
            // numbers have to go "direction" if above is * until they hit another number or end of table
            // in row1 and row2 , if columns are the same then add and put in row1
            // in row2 and row3 , if columns are the same then add and put in row2
            // in row3 and row4 , if columns are the same then add and put in row3
            // random "2" appear in table 
                System.out.println("moving up");
                break;

            case "d":
            // numbers have to go "direction" if below is * until they hit another number or end of table
            // in row4 and row3 , if columns are the same then add and put in row4
            // in row3 and row2 , if columns are the same then add and put in row3
            // in row2 and row1 , if columns are the same then add and put in row2
                System.out.println("moving down");
                break;

            case "r":
            // numbers have to go "direction" if right is * until they hit another number or end of table
            
                System.out.println("moving right");
                break;

            case "l":
            // numbers have to go "direction" if left is * until they hit another number or end of table
            
                System.out.println("moving left");
                break;


                }
        }
        
                
            
        } 
        
    }
