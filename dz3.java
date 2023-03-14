//1. Реализовать алгоритм сортировки списков слиянием

import java.util.ArrayList;

public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(6);
        list.add(5);

        System.out.println("Unsorted List: " + list);

        mergeSort(list);

        System.out.println("Sorted List: " + list);
    }

    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;

            ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
            ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;

            while (i < left.size() && j < right.size()) {
                if (left.get(i) < right.get(j)) {
                    list.set(k++, left.get(i++));
                } else {
                    list.set(k++, right.get(j++));
                }
            }

            while (i < left.size()) {
                list.set(k++, left.get(i++));
            }

            while (j < right.size()) {
                list.set(k++, right.get(j++));
            }
        }
    }
}

//2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
import java.util.ArrayList;
import java.util.Iterator;

public class RemoveEvenNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(6);
        list.add(5);

        System.out.println("Original List: " + list);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("List after removing even numbers: " + list);
    }
}

//3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка
public static void findMinMaxAverage(List<Integer> list) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    double sum = 0;

    for (int i : list) {
        if (i < min) {
            min = i;
        }
        if (i > max) {
            max = i;
        }
        sum += i;
    }

    double average = sum / list.size();

    System.out.println("Minimum: " + min);
    System.out.println("Maximum: " + max);
    System.out.println("Average: " + average);
}

//4. Дано два целочисленных списка, объединить их не допуская элементы второго
public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
    List<Integer> result = new ArrayList<>(list1);

    for (int i : list2) {
        if (!list1.contains(i)) {
            result.add(i);
        }
    }

    return result;
}

//5. Создать ArrayList<Integer> и добавить нулевым элементом ноль 10000 раз

List<Integer> list = new ArrayList<>();
for (int i = 0; i < 10000; i++) {
    list.add(0, 0);
}

//6. Повторить пятый пункт но с LinkedList

List<Integer> list = new LinkedList<>();
for (int i = 0; i < 10000; i++) {
    list.add(0, 0);
}

//7. Сравнить время работы пятого и шестого пунктов

List<Integer> arrayList = new ArrayList<>();
long startTime1 = System.currentTimeMillis();
for (int i = 0; i < 10000; i++) {
    arrayList.add(0, 0);
}
long endTime1 = System.currentTimeMillis();
System.out.println("ArrayList time: " + (endTime1 - startTime1) + " ms");

List<Integer> linkedList = new LinkedList<>();
long startTime2 = System.currentTimeMillis();
for (int i = 0; i < 10000; i++) {
    linkedList.add(0, 0);
}
long endTime2 = System.currentTimeMillis();
System.out.println("LinkedList time: " + (endTime2 - startTime2) + " ms");


ArrayList time: 46 ms
LinkedList time: 47 ms