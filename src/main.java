// Пусть дан произвольный список целых чисел, удалить из него четные числа

// Чубченко Светлана

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class main {

    public static void main(String[] args) {
        // удаляем четные числа из массива положительных целых чисел
        System.out.println(deleteEven(Arrays.asList(1,2,3,4,5,6,7,8,9)));
        // удаляем четные числа из массива положительных и отрицательных целых чисел
        System.out.println(deleteEven(Arrays.asList(1,2,3,4,5,-1,-2,-3,-4,-5)));
    }

    static List<Integer> deleteEven(List<Integer> integers){
        // формируем Map, где по ключу true будут лежать четные
        // а по ключу false нечетные числа массива
        Map<Boolean, List<Integer>> map = integers.stream()
                .collect(partitioningBy(x -> x % 2 == 0, toList()));
        // возвратим нечетные
        return map.get(false);
    }
}
