package linkedlist;
import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        if (isHappy(n)) {
            System.out.println("The number is Happy");
        } else {
            System.out.println("The number is not Happy");
        }
    }

    //I am going to create a HashSet of integers. The moment we get the same value again it will return a
    //false. Else it will go till we get a one.
    private static boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        while (true) {
            if (sumOfDigitSq(n) == 1) return true;
            if (set.add(sumOfDigitSq(n))) {
                n = sumOfDigitSq(n);
            } else {
                return false;
            }
        }
    }

    public static int sumOfDigitSq(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow((n % 10), 2);
            n /= 10;
        }
        return sum;
    }
}