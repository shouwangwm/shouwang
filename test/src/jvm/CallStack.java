package jvm;

public class CallStack {
    public static void printCallStatck() {
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                System.out.print(stackElements[i].getClassName()+" ");
                System.out.print(stackElements[i].getFileName()+" ");
                System.out.print(stackElements[i].getLineNumber()+" ");
                System.out.println(stackElements[i].getMethodName());
                System.out.println("-----------------------------------");
            }
        }
    }
   
    public static void main(String[] args) {
		printCallStatck();
	}
}