package Problem1;
import java.util.Scanner;

public class MyLinkedList {
    Node first,last;
    public MyLinkedList() {
        first = null;
        last = null;
    }

    public void addNode(MyLinkedList list, Node node){
        if(list.first==null){
            first=node;
        }
        else{
            Node tmp = list.first;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
    public void printPolynomial(){
        Node tmp = first;
        while (tmp != null) {
            System.out.print(tmp.getData());
            tmp = tmp.next;
            if(tmp!=null){
                if(tmp.coef>0){
                    System.out.print("+");
                    
                }
                
            }
            
        }
        
    }
    public MyLinkedList createPolynomial(){
        Scanner scanner = new Scanner(System.in);
        MyLinkedList polynomial = new MyLinkedList();
        int coef , pow;
        while(true){
            System.out.println("Please enter the coefficient : ");
            coef = scanner.nextInt();
            if(coef==0){
                break;
            }
            System.out.println("Please enter the power : ");
            pow = scanner.nextInt();
            Node node = new Node(coef,pow);
            System.out.println(node.getData());
            polynomial.addNode(polynomial,node);
        }
        return polynomial ;
    }
    public void sortPolynomial(MyLinkedList list) {
        Node tmp = first;
        Node nextNode = null;
        int temp_coef;
        int temp_power;

        if(tmp == null) {
            return;
        }
        else {
            while(tmp != null) {
                nextNode = tmp.next;
                while(nextNode != null) {
                    if(nextNode.power > tmp.power) {
                        temp_coef = tmp.coef;
                        temp_power= tmp.power;

                        tmp.coef = nextNode.coef;
                        tmp.power= nextNode.power;

                        nextNode.coef = temp_coef;
                        nextNode.power =temp_power;

                    }
                    nextNode = nextNode.next;
                }
                tmp = tmp.next;
            }
        }

         tmp = first;

         while(tmp!=null){
             nextNode=tmp.next;
             while(nextNode!=null){
                 if(tmp.power== nextNode.power){
                     tmp.setData(tmp.coef+ nextNode.coef, tmp.power);
                     tmp.next=nextNode.next;
                 }nextNode=nextNode.next;
             }
             tmp=tmp.next;


         }
    }

    public MyLinkedList AddPolynomials(MyLinkedList firstPoly, MyLinkedList SecondPoly){
        Node FirstCurrent = firstPoly.first;
        Node SecondCurrent = SecondPoly.first;
        MyLinkedList newPolynomial = new MyLinkedList();
        while(FirstCurrent!=null){
            if(SecondCurrent==null){
                while(FirstCurrent!=null){
                    newPolynomial.addNode(newPolynomial,new Node(FirstCurrent.coef,FirstCurrent.power));
                    FirstCurrent=FirstCurrent.next;
                }
                break;
            }
            if(FirstCurrent.power==SecondCurrent.power){
                newPolynomial.addNode(newPolynomial,new Node(FirstCurrent.coef+SecondCurrent.coef,FirstCurrent.power));
                FirstCurrent=FirstCurrent.next;
                SecondCurrent=SecondCurrent.next;
            }else if(FirstCurrent.power>SecondCurrent.power){
                newPolynomial.addNode(newPolynomial,new Node(FirstCurrent.coef,FirstCurrent.power));
                FirstCurrent=FirstCurrent.next;
            }else if(FirstCurrent.power<SecondCurrent.power){
                newPolynomial.addNode(newPolynomial,new Node(SecondCurrent.coef,SecondCurrent.power));
                SecondCurrent=SecondCurrent.next;
            }
        }

        if(FirstCurrent==null){
            while(SecondCurrent!=null){
                newPolynomial.addNode(newPolynomial,new Node(SecondCurrent.coef,SecondCurrent.power));
                SecondCurrent=SecondCurrent.next;
            }
        }
        newPolynomial.sortPolynomial(newPolynomial);
        return  newPolynomial;
        

    }
    public MyLinkedList MultiplyPolynomials(MyLinkedList poly1, MyLinkedList poly2) {
        Node FirstCurrent = poly1.first;
        Node SecondCurrent = poly2.first;
        int coef;
        MyLinkedList newPolynomial = new MyLinkedList();
        while(FirstCurrent!=null){
            while(SecondCurrent!=null){
                coef=FirstCurrent.coef*SecondCurrent.coef;
                newPolynomial.addNode(newPolynomial,new Node(coef,(FirstCurrent.power+ SecondCurrent.power)));
                SecondCurrent=SecondCurrent.next;
            }
            FirstCurrent=FirstCurrent.next;
            SecondCurrent=poly2.first;
        }
        newPolynomial.sortPolynomial(newPolynomial);
        return newPolynomial;
    }
    public boolean DeleteNode(MyLinkedList list,int power) {
        Node tmp = list.first; 
        Node prev = null;
        if (tmp != null && tmp.power == power) {
            first = tmp.next;
            return true;
        }
        while (tmp != null && tmp.power != power) {
            prev = tmp;
            tmp = tmp.next;
        }
        if (tmp != null && tmp.power == power){
            prev.next = tmp.next; 
            return true;
        }else{ 
           return false;
        }
    }
}