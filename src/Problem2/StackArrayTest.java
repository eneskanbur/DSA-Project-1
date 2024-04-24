/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// 2. push yapıldığında yeni stack oluşuyor. palindrome da popladıktan sonra tekrar geri nasıl pushlayacağız. 
package Problem2;

import java.util.Scanner;

public class StackArrayTest {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        StackArray s1 = new StackArray(0);
        
        boolean loop = true;
        while(loop) {
            System.out.print(
                    "\nWhich task you want to do? \n"
                    + "1. Push.\n"
                    + "2. Pop.\n"
                    + "3. Print\n"
                    + "4. Delete middle.\n"
                    + "5. Is palindrome\n"
                    + "6. Exit.\n"
                    + "Please Enter A Digit[1-6]:"
            );
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nHow many pushes you want to do?");
                    int size = scanner.nextInt();
                    s1.resize(size + s1.data.length);
                    System.out.println("Enter " + size + " strings.");
                    for (int i = 0; i < size; i++) {
                        String name = scanner.next();
                        s1.push(name);
                    }
                    break;
                case 2:
                    System.out.println(s1.pop());
                    s1.resize(s1.data.length-1);
                    break;
                case 3:
                    if (s1.isEmpty()) {
                        System.out.println("There is no element.");
                    } else {
                        s1.printStack(s1);
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.out.println(s1.top);
                    if (!s1.isEmpty() && (s1.top +1) % 2 != 0) {
                        StackArray tmp = new StackArray(((s1.top + 1) / 2));
                        
                        for (int i = s1.top; i > tmp.data.length; i--) {
                            tmp.push(s1.pop());
                        }
                        
                        s1.pop();
                        s1.resize(s1.data.length-1);
                        System.out.println("The middle element has been deleted");
                        
                        while(!tmp.isEmpty()) {
                            s1.push(tmp.pop());
                        }
                    } else {
                        System.out.println("There is no element as the size of stack even.");
                    }
                    
                    break;
                case 5:
                    if (s1.isPalindrome(s1)) {
                        System.out.println("it is palindrome");
                    } else {
                        System.out.println("it is not palindrome");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    loop = false;
                    break;
                
            }
        }
    }
}
