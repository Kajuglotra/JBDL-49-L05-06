package geeks.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {

        // [1,2,3,4,5,6,7,8,9,10] -> arr/list
        // filter -> even num from the list -> 2,4,6,8,10 -> 11,22,33
        // square the num -> 4,16, 64, ..
        //  need to sum of this list.
        // get the list of squares of num


        //iterative
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        set.add(12);
        set.add(22);
        set.add(24);
        set.add(26);
        set.add(28);
        set.add(2112);
        set.add(2222);
        set.add(2342);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                sum += list.get(i) * list.get(i);
            }
        }
        System.out.println("sum after the iterative manner is : " + sum);

        //declarative -> declare first what we are trying to do
//        Stream -> does not change anything
        //filter and map ->
        int num = list.parallelStream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                System.out.println("Inside the filter method with thread name: " + Thread.currentThread().getName());
                return integer % 2 == 0;
            }
        }).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println("Inside the map method with thread name: " + Thread.currentThread().getName());
                return integer * integer;
            }
        }). reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                System.out.println("integers as well integer1 " + integer+ " integer2 is "+ integer2  );
                System.out.println("Inside the reduce method with thread name: " + Thread.currentThread().getName());
                return integer+integer2;
            }
        });
//                .collect(Collectors.toList());
//                .reduce(new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer+integer2;
//            }
//        });
//                reduce(0, new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                System.out.println("Inside the reduce method");
//                return integer+integer2;
//            }
//        });
        System.out.println("sum after the declarative manner is :" + num);

        // for loop -> int i =0 -> one by one everything is done
//        streams-> one

//        stream are internally working

//        System.out.println(list.stream().filter(i -> i%2 == 0).map(i -> i*i).reduce(0, (i, j) -> i+j ));
//        list.stream().filter(i -> i % 2 == 0).map(i -> i * i).collect(Collectors.toCollection(ArrayList::new)).forEach(i -> System.out.println(i));

        // collection-> stream -> intermediate method1 -> 2 -> 3 -> terminal method -> cannot do anything

//        serial streaming and parallel streaming-> multiple threads -> start executing it

//        list.parallelStream().filter(i -> i % 2 == 0).map(i -> i * i).collect(Collectors.toCollection(ArrayList::new)).forEach(i -> System.out.println(i));
//        list -> indexed or not? -> parallel stream output will come out to be accurate
        // set -> indexed or not? -> parallel stream can give different outputs
//        set.parallelStream().filter(i -> i % 2 == 0).map(i -> i * i).collect(Collectors.toCollection(ArrayList::new)).forEach(i -> System.out.println(i));

//        findFirst()
        System.out.println(set.stream().filter(i -> i%2 ==0 ).findFirst());
        // indexed collection-> parallel stream
    }
}
