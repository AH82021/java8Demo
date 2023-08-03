package funcInterface;
@FunctionalInterface
public interface Operations {

    double calculate(double x, double y);

    default void display(){
        System.out.println(" Helper function");
    }
}
