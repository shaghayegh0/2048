import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    
    public static void printTable(List<List<String>> table){
        for (List<String> row : table) {
            for (String cell : row) {
                System.out.print(cell + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // draw the table
        int rows = 4;
        int columns = 4;

        List<List<String>> table = new ArrayList<>();

        for (int i = 0 ; i < rows ; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0 ; j < columns ; j++) {
                if (i == 2 && j == 2) {
                    row.add("2");
                }
                else {
                    row.add("*");
                }
            }
            table.add(row);
        }

        System.out.println(table);
        printTable(table);



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
                for (int i = 1; i < 4 ; i++ ){
                    for (int j = 0 ; j < 4 ; j++){
                        System.out.println("i: " + Integer.toString(i) + " j: " + Integer.toString(j));

                        // if it is a number
                        if (!"*".equals(table.get(i).get(j)) ) {
                            String num = table.get(i).get(j);
                            String u = table.get(i-1).get(j);

                            // if above is star
                            if ("*".equals(u)) {
                                    table.get(i-1).set(j , num);
                                    table.get(i).set(j , "*");
                                    printTable(table);
                                    if (i > 1 ) {
                                        i = i - 1;
                                        break;
                                    }

                            }

                            // if above is equal to num (not *)
                            if (!"*".equals(u) && num.equals(u)) {
                                // string "2" to int --> int 2 to string again to put in table
                                table.get(i-1).set(j , Integer.toString(Integer.parseInt(num)*2));
                                table.get(i).set(j , "*");

                                printTable(table);
                                if (i > 1 ) {
                                        i = i - 1;
                                        j = j - 1;
                                        break;  
                                    }
                            }

                            // if above is number but not equal
                            if (!"*".equals(u) && !num.equals(u)) {
                            }
                        }
                    }
                }

                while (true) { 
                    // add a new 2 to table
                    Random rand = new Random();
                    int randomNumber1 = rand.nextInt(4);
                    int randomNumber2 = rand.nextInt(4);

                    // if that cell is empty
                    if (table.get(randomNumber1).get(randomNumber2).equals("*")){
                        table.get(randomNumber1).set(randomNumber2 , "2");
                        break;
                    }
                }
                
                
                printTable(table);
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


            default:
                System.out.println("wrong input. try again");
                }
        }
        
                
            
        } 
        
    }
