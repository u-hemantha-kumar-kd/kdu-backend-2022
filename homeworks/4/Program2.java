package homework4;

import java.util.ArrayList;
import java.util.List;

//OUTPUT::
//FOR LOOP TIME: 2
//FOR-EACH TIME: 4
//STREAMS TIME: 3
//PARELLEL TIME: 16
//50005000
//50005000
//50005000
//50005000
//after summing first 10000 natural numbers using various methods, it turned out to be for-loop taking very less time

public class Program2 {

    public static void main(String[] args) {
        long sumThroughFor = 0;
        int LIMIT = 10000;

        long start, end;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=LIMIT; i++)
        {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for(int i = 0; i<LIMIT; i++){
            sumThroughFor += list.get(i);
        }
        end = System.currentTimeMillis();

        System.out.println("FOR LOOP TIME: "+(end-start));


        long sumThroughForEach = 0;
        start = System.currentTimeMillis();
        for(int i: list){
            sumThroughForEach += i;
        }
        end = System.currentTimeMillis();

        System.out.println("FOR-EACH TIME: "+(end-start));


        start = System.currentTimeMillis();
        Integer streamSum = list.stream()
                .reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("STREAMS TIME: "+(end-start));

        start = System.currentTimeMillis();
        Integer parallelSum = list.stream().parallel().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("PARELLEL TIME: "+(end-start));


        System.out.println(sumThroughFor);
        System.out.println(sumThroughForEach);
        System.out.println(streamSum);
        System.out.println(parallelSum);

    }
}


