package edu.miu.cs489;

public class ArrayFlattener {

    public int[] flattenArray(int[][] inputArray) {
        if (inputArray == null) {
            return null;
        }

        int totalLength = 0;
        for (int[] arr : inputArray) {
            totalLength += arr.length;
        }

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
