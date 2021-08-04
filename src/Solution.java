import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static int[] merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftIndex, rightIndex;
        leftIndex = rightIndex = 0;
        while( (leftIndex + rightIndex) < arr.length) {
            try {
                if (leftIndex >= leftArr.length && rightIndex < rightArr.length) {
                    arr[leftIndex + rightIndex] = rightArr[rightIndex];
                    rightIndex++;
                } else {
                    if (rightIndex < rightArr.length && leftArr[leftIndex] < rightArr[rightIndex]) {
                        arr[leftIndex + rightIndex] = leftArr[leftIndex];
                        leftIndex++;
                    }
                }

                if (rightIndex >= rightArr.length && leftIndex < leftArr.length) {
                    arr[leftIndex + rightIndex] = leftArr[leftIndex];
                    leftIndex++;
                } else {
                    if (leftIndex < leftArr.length && rightArr[rightIndex] < leftArr[leftIndex]) {
                        arr[leftIndex + rightIndex] = rightArr[rightIndex];
                        rightIndex++;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }
        }
        return arr;
    }

    public static void randomFill (int[] array){             // i'm a lazy programmer and want my computer to generate random numbers method

        Random rd = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = rd.nextInt(1000);               // give me a random number!!!!!!!!
        }
    }

    public static int[] splitSort(int[] myArr) {
        if (myArr.length > 1) {
            int[] leftArr = Arrays.copyOfRange(myArr, 0, myArr.length / 2);
            int[] rightArr = Arrays.copyOfRange(myArr, myArr.length / 2, myArr.length);
            leftArr = splitSort(leftArr);
            rightArr = splitSort(rightArr);
            return merge(myArr, leftArr, rightArr);
        } else {
            return myArr;
        }
    }

    public static int split(int[] myArr) {
        if (myArr.length > 1) {
            int[] leftArr = Arrays.copyOfRange(myArr, 0, myArr.length / 2);
            int[] rightArr = Arrays.copyOfRange(myArr, myArr.length / 2, myArr.length);
            int left = split(leftArr);
            int right = split(rightArr);
            return (left > right) ? left : right;
        } else {
            return myArr[0];
        }
    }

    public static void main(String[] args) {
        int[] myArr = new int[30];
        randomFill(myArr);
        System.out.println("Max value: ");
        System.out.println(split(myArr)); //finding max value of array
        myArr = splitSort(myArr);
        System.out.println("Sorted: ");
        for (int el: myArr
        ) {
            System.out.print(el+", ");
        }
    }
}
