package edu.miu.cs489;


import java.util.Arrays;

public class ArrayFlattenerServiceMock implements ArrayFlattenerService {
    @Override
    public int[] flattenArray(int[][] inputArray) {
        int totalLength = Arrays.stream(inputArray).mapToInt(arr -> arr.length).sum();
        int[] flattenedArray = new int[totalLength];
        int index = 0;
        for (int[] arr : inputArray) {
            for (int num : arr) {
                flattenedArray[index++] = num;
            }
        }
        return flattenedArray;
    }
}

