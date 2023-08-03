package methodRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
 Driver.greeting(4);

 DemoFunctional obj = (p)-> System.out.println("Hi "+p);
 obj.doSomething(5);

 // MethodRef
        //1- Static method  ClassName::staticMETHOD
        DemoFunctional func = Driver::greeting;
        func.doSomething(10);


        Calculator cal = Test::add;
        double res = cal.calculate(5,34);
        System.out.println(res);

        Calculator calSub = Test::sub;
        double subRes = calSub.calculate(23,6);
        System.out.println(subRes);

        Display test = new Display();
        test.show(5);

        DemoFunctional demo = test::show;
        demo.doSomething(10);

        DemoFunctional aDemo = new Display()::show;
        aDemo.doSomething(20);

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };

        Arrays.sort(stringArray,String::compareToIgnoreCase);

        System.out.println(Arrays.toString(stringArray));


        MyFunctionalInterface ref = Student::new;
        Student s2 = ref.createStudent("java");


        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);

        //finding Evenumbers
        List<Integer> evens = new ArrayList<>();
        int sum = 0;

        for (Integer n : numbers) {
            if (n % 2 == 0) {
                int sq = n * n;
                sum = sum + sq;
                 evens.add(n);
            }
        }

        System.out.println(evens);

        System.out.println(" sum of all squared even numbers in the list : " + sum);


                    int sSum =   numbers.parallelStream()
                               .filter(n -> n % 2 == 0)
                               .map(n-> n * n)
                               .reduce(0,Integer::sum);
        System.out.println("The sum of all squared even numbers in the list : " + sSum);

        // sum of the square even numbers




        // External Iteration

        for (Integer number : numbers) {
            System.out.println(number);
        }

        System.out.println("_________________");
        numbers.forEach(n->System.out.println(n));

        numbers.forEach(System.out::println);// Internal Iteration


        // Aggregate operation: computes a single value form a collection of values. The result of aggregation may be  a simply primitive data type,an object
        //or void.
        // Stream: is a sequence of data elements that support sequential and parallel aggregate operations.


// Creating a stream from a collection

        List<String> fruits = Arrays.asList("apple","banana","orange","cherry","date");

        Stream<String> stream = fruits.stream();
        Stream<String> pStream = fruits.parallelStream();

        pStream.forEach(System.out::println);

        String[] array = {"apple", "banana", "cherry", "date"};

        Stream<String> result = Arrays.stream(array);


        List<Student> students = Arrays.asList(new Student("John"),
                new Student("Alex"),
                new Student("Sham"),
                new Student("Josh"));

        Stream<Student> studentStream = students.stream();

        Stream<Integer> numbs = Stream.iterate(1,n-> n +1).limit(10);
        numbs.forEach(System.out::println);

        List<String> list = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
        //1. create an empty list
        // 2. loop through the list.
        //3. check for an element that startIWith J
        // Add elements to the empty list.

        List<String> listWithJ = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).startsWith("J")){
                listWithJ.add(list.get(i));
            }
        }

        System.out.println(listWithJ);
        // create from the list
        // filter elements that start with j
        // convert stream to list


      var listoflettersJ =
                 list.stream()
                 .filter(z-> z.startsWith("J"))
                 .toList();

      listoflettersJ.forEach(System.out::println);

      List<Product> products = Arrays.asList(
              new Product(5L,"Book",34),
              new Product(22L,"Pen",43),
              new Product(8L,"Coffee",81),
              new Product(3L,"Alo Ka paratha",93),
              new Product(15L,"Qabuli Plow ",100)

      );

      List<Double> productsOver50 = products.stream()
              .filter(p->p.price()>50)
              .map(Product::price)
              .sorted()
              .skip(3)
              .toList();
      productsOver50.forEach(System.out::println);


    var dimitri =    products.stream()
               .filter(p->p.price()> 50)
               .sorted(Comparator.comparing(Product::price).thenComparing(Product::name))
               .toList();

        dimitri.forEach(System.out::println);


    }
}
