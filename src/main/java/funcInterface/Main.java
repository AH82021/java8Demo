package funcInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        // java 8 2014
        // lambda Expression
        // Stream API
        //Date and Time API+

        //
        //Functional Interface: An interface with only one abstract method.

// Lambda Expression: an anonymous method.
        // (parameter list ) -> lambda body
        //
        /*
        double getPIValue() {
        return 3.14 }

        () -> 3.14;

         */
        MyFunctionalInterface func = () -> System.out.println(" Lambda Expression are great.");
        func.getValue();

        MyFunctionalInterface show = () -> System.out.println("I want to show lambda Expression.");

        Operations addOps = ( a,  b) ->   a + b ;
        Operations subtractOps = ( a, b) -> a - b ;
        Operations multiplyOps = ( a, b) -> a * b ;
        Operations divOps = (a,b) -> a / b ;

        System.out.println("The sum of 5, and 6.3 = "+addOps.calculate(5, 6.3));

        OddEven check = ( n )->(n %2 == 0);

        System.out.println("Checking if 14 is and even number : "+check.isEven(14));

        Predicate<Integer> predi = ( n )->(n %2 == 0);
        System.out.println(predi.test(5));


        System.out.println("List of all students :");

        for (Student student : getStudentList()) {
            System.out.println(student);
        }

        System.out.println("List of adult students");

        for (Student student : getAdultStudent()) {
            System.out.println(student);
        }

        //void

        Runnable greeting =()->System.out.println("Hello , Welcome to the team.");

        greeting.run();

           Function<Double,Double> kmToMIle=( k) -> k * 1.6;

           Function<UserEntity,UserDTO> userDTO = user -> new UserDTO(user.getUsername(), user.getEmail());


           UserDTO person = userDTO.apply(new UserEntity(1L,"java@23","pass","jack@binary.com"));
        System.out.println(person);
        System.out.println(kmToMIle.apply(70.0));

        List<String> places = new ArrayList<>();
        places.add("France, Paris");
        places.add("UK, London");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Iran, Tehran");
        places.add("USA, Virgina");
        Predicate<String> pl = p -> p.startsWith("USA");

        pl.test("USA, New York");
        places.stream().
                filter(p->p.startsWith("USA"))
                .map(String::toUpperCase)
                .sorted().forEach(System.out::println);

           MasRun add =     (a,  b) ->System.out.println( a+b);
           add.run(5,7);



    }

    void display(){
        System.out.println("Hello , Java");
    }

    static List<Student> getStudentList(){
     return    Arrays.asList(

                new Student(2,"Javad",23),
                 new Student(3,"Jack",11),
                new Student(5,"Shad",33),
                new Student(11,"Dimitri",20),
                new Student(1,"Ajmal",16)

        )

        ;
    }

    static List<Student> getAdultStudent(){
        Predicate<Student> adultStudent = (student) -> student.age()> 18 ;

        List<Student> adults = new ArrayList<>();

        for (Student student : getStudentList()) {
            if(adultStudent.test(student)){
                adults.add(student);
            }
        }
        return adults;

    }

}
