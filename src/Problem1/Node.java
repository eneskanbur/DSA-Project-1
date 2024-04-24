/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;

public class Node {
    int coef;
    int power;
    Node next;

    public Node(int coef, int power) {
        this.coef = coef;
        this.power=power;
        next = null;
    }
    public String getData() {


        if(coef==1 && power==1){
            return "x";
        }else if(coef==-1 && power==1){
            return "-x";
        }
        else if(coef==1 &&power!=0){
            return "x^"+ power;
        }
        else if(coef==-1 &&power!=0){
            return "-x^"+ power;
        }
        else if(power==0){
            return ""+coef;
        }else if(power==1){
            return coef+"x";
        }
        else{
            return coef +"x^"+ power;
        }

    }
    public Node getNext() { return next; }
    public void setData(int coef, int pow) {  this.coef= coef; this.power=pow; }
    public void setNext(Node n) { next = n; }
}

