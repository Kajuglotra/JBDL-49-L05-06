package geeks.stream;

public class StreamMain {
    public static void main(String[] args) {
        FunctionalInterfaceEx functionalInterfaceEx = new FunctionalInterfaceEx() {
            @Override
            public void abstractMethod(int x, int y) {
                System.out.println("i am inside body of anonymous class of function interface");
            }
        };

        FunctionalInterfaceEx functionalInterfaceEx1 = (int x, int y) -> System.out.println("i am inside body of anonymous class of function interface");
        functionalInterfaceEx1.abstractMethod(2, 3);
    }
}
