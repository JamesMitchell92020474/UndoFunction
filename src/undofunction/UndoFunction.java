/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undofunction;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @title UndoFunction.java
 * @author James Mitchell 92020474
 * @date 3/09/19
 * 
 */

public class UndoFunction {
    
    private static final Scanner in = new Scanner(System.in);
    private static String input;
    private static final Stack<String> directionsList = new Stack();
 
    public static void main(String[] args) {
        //obtaining user input
        while (true){
            System.out.println("Press D to enter new direction, U to cancel last entry and E to quit the program");
            input = in.nextLine();
            switch (input) {
                case "D":
                    getDirection();
                    break;
                case "U":
                    undoDirection();
                    break;
                case "E":
                    System.out.println("Bye...");
                    System.exit(0);
                default:
                    System.out.println("The command is not recognised");
                    break;
            }
        }
    }
    
    //this method removes last element from the stack with list of directions 
    //if the stack is not empty
    public static void undoDirection(){
        if (directionsList.isEmpty()){
            System.out.println("The list of directions is empty.");
        }
        else{
            System.out.println(directionsList.peek() + " has been removed from the directions list");
            directionsList.pop();
            displayDirections();            
        }
    }
    //this method adds an element to the stack with list of directions 
    public static void getDirection(){
        System.out.println("Type in the direction\n");
        input = in.nextLine();
        directionsList.push(input);  
        displayDirections();
    }  
    //displays all the elements in the direction list
    public static void displayDirections(){
        System.out.println("LIST OF DIRECTIONS: ");
        directionsList.forEach((s) -> {
            System.out.println(s);
        });
    }   
    
}
