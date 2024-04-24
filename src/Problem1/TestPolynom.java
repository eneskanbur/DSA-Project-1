/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;

import java.util.Scanner;

/**
 *
 * @author Enes
 */
public class TestPolynom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coefficient and power of the first polynomial. Type 0 at the end:\n");
        MyLinkedList firstPolynomial = new MyLinkedList();
        MyLinkedList secondPolynomial = new MyLinkedList();
        firstPolynomial = firstPolynomial.createPolynomial();
        firstPolynomial.sortPolynomial(firstPolynomial);
        System.out.println("\nEnter the coefficient and power of the second polynomial. Type 0 at the end:\n");
        secondPolynomial = secondPolynomial.createPolynomial();
        secondPolynomial.sortPolynomial(secondPolynomial);
        System.out.println("Your polynomials are : " );
        firstPolynomial.printPolynomial();
        System.out.println("\n");
        secondPolynomial.printPolynomial();
        
        
        
        boolean go = true;
        while(go){
            System.out.print(
                    "\nWhich task you want to do? \n"
                    + "1. Add.\n"
                    + "2. Multiply.\n"
                    + "3. Print\n"
                    + "4. Delete.\n"
                    + "5. Exit.\n"
                    + "Please Enter A Digit[1-5]:"
            );
            int choice = scanner.nextInt();
            MyLinkedList newMyLinklist = null;
            switch (choice) {
                case 1:
                    MyLinkedList resultPolynomial = firstPolynomial.AddPolynomials(firstPolynomial,secondPolynomial);
                    resultPolynomial.printPolynomial();
                    break;
                case 2:
                    resultPolynomial = firstPolynomial.MultiplyPolynomials(firstPolynomial,secondPolynomial);               
                    resultPolynomial.printPolynomial();            
                    break;
                case 3:
                    System.out.println("Your polynomials are : " );
                    firstPolynomial.printPolynomial();
                    System.out.println("\n");
                    secondPolynomial.printPolynomial();
                    break;
                case 4:
                    System.out.println("Which power you want to be delated from both polynomials:" );
                    int del_power = scanner.nextInt();
    
                    if(secondPolynomial.DeleteNode(secondPolynomial,del_power)==true 
                            && firstPolynomial.DeleteNode(firstPolynomial,del_power)==true){
                        System.out.println("The element having this power has been deleted.");
                    }else{
                        System.out.println("This power does not exist in any polynomial.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    go = false;
                    break;
                default:
                    System.out.println("Please enter the correct numbers to complete the task.");
                    break;
            }
        }
    
    }
}
        

