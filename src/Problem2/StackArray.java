package Problem2;    

public class StackArray {
    String data[]; // array to hold items
    int top; // the top most item index
    
    
    public StackArray(int size) {
    data = new String[size];
    top = -1;
    }
    
    
    public void push(String name) {
    if (!isFull()) {
    top++;
    data[top] = name;
    }
    }
    
    
    public String pop() {
    if (isEmpty()) {
    throw new java.util.NoSuchElementException();
    } else {
    top--;
    return data[top + 1];
    }
    }
    
    
    public boolean isFull() {
    if (top == data.length - 1) {
    return true;
    }
    return false;
    }
    
    
    public boolean isEmpty() {
    if (top == - 1) {
    return true;
    }
    return false;
    }
    
    public String peek(){
        if(!isEmpty()){
            return data[top];
        }else{
            return "-1";
        }
    }
    
    public void printStack(StackArray s1){
        if(s1.isEmpty()){
            return;
        }else{
            String tmp = s1.peek();
            s1.pop();
            printStack(s1);
            System.out.print(tmp + ", ");
            s1.push(tmp);
        }
    }
    
    public boolean isPalindrome(StackArray s1){
        //if(s1.isEmpty() || s1.data.length % 2 !=0){
          int s1Top = s1.top;
          if(s1.isEmpty()){ 
            return false;
          }else if(s1Top%2!=0){//çift eleman sayılı
              StackArray temp = new StackArray((s1.top/2)+1);
                for (int i = s1Top; i > s1Top/2; i--) {//yarısı kadar eleman atılıyor
                temp.push(s1.pop());
            }
                s1Top = s1.top;//geçici top güncelleniyor
                for (int i = 0; i <= (s1.top/2)+1; i++) {//stringler eşitlenip kontrol ediliyor
                  String a = s1.data[i];
                  String b = temp.data[i];
                  if(!a.equals(b)){
                      for (int j = 0; j <= (s1Top/2)+1; j++) {//geçici stacke atılanlar main stacke gönderiliyor
                          s1.push(temp.pop());
                      }
                      return false;
                  }
              }
                for (int j = 0; j <= (s1Top/2)+1; j++) {//geçici stacke atılanlar main stacke gönderiliyor
                          s1.push(temp.pop());
                      }
                return true;
          }else{//tek eleman sayılı
              StackArray temp = new StackArray(s1.top/2);
              for (int i = s1Top; i > s1Top/2; i--) {
                  temp.push(s1.pop());
              }
              s1Top = s1.top;//geçici top değerini güncelliyoruz
              for (int i = 0; i < (s1.top/2)+1; i++) {
                  String a = s1.data[i];
                  String b = temp.data[i];
                  if(!a.equals(b)){
                      for (int j = 0; j < (s1Top/2)+1; j++) {//geçici stacke atılanlar main stacke gönderiliyor
                          String y = temp.pop();
                          System.out.println(y);
                          s1.push(y);
                      }
                     return false;
              }
          }
                for (int j = 0; j < (s1Top/2)+1; j++) {//geçici stacke atılanlar main stacke gönderiliyor
                          s1.push(temp.pop());
                      }
                return true;
            }
        }
    
    public void resize(int capacity) {
        //System.out.println("Resizing stack to " + capacity);
        String[] temp = new String[capacity];
        for (int i = 0; i <= top; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
    
}