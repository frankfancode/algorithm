package com.ff.weekly.contest;

public class Issue6291 {
    public static void main(String[] args) {
        assert new Issue6291().differenceOfSum(new int[]{1, 15, 6, 3}) == 9 : "error";
        assert new Issue6291().differenceOfSum(new int[]{1, 2, 3, 4}) == 0 : "error";
        assert new Issue6291().differenceOfSum(new int[]{2, 7, 8, 10, 8, 10, 1, 10, 5, 9}) == 27 : "error";
        assert new Issue6291().differenceOfSum(new int[]{12, 97, 48, 72, 31, 70, 1, 9, 78, 28, 1, 30, 82, 17, 43, 44,
                53, 12, 73, 16, 74, 24, 79, 9, 51, 77, 36, 38, 81, 38, 69, 60, 29, 21, 66, 6, 62, 55, 13, 90, 66, 7, 15,
                15, 60, 76, 44, 30, 6, 86, 87, 59, 88, 36, 32, 35, 67, 13, 79, 43, 27, 2, 97, 41, 4, 44, 91, 11, 5, 48, 38
                , 64, 9, 90, 39, 28, 50, 57, 60, 4, 99, 44, 39, 12, 95, 32, 66, 100, 45, 42, 22, 35, 65, 7, 49, 43, 41, 40,
                64, 78}) == 3708 : "error";


    }

    public int differenceOfSum(int[] nums) {
        return Math.abs(sum(nums) - sumPos(nums));
    }

    public int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }

    public int sumPos(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + sumNum(num);
        }
        return sum;
    }

    public int sumNum(int num) {
        int sum = 0;
        int yu = num % 10;
        int divedid = num / 10;
        if (divedid == 0 ){
            sum = yu;
        } else if (divedid<10){
            sum = yu + divedid;
        } else {
            sum = yu + sumNum(divedid);
        }

        return sum;
    }
}
