package innerclass;

/**
 * ¾²Ì¬ÄÚ²¿Àà
 * @author weiming
 *
 */
public class StaticInner {  
    static class Inner {  
        void go() {  
            System.out.println("Inner class reference is: " + this);  
        }  
    }
    
    public static void main(String[] args) {  
        StaticInner.Inner n = new StaticInner.Inner();  
        n.go();  
    }  
}  