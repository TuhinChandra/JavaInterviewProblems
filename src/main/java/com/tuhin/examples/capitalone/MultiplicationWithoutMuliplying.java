package com.tuhin.examples.capitalone;


public class MultiplicationWithoutMuliplying {
    public static long multiply(long arg1, long arg2) {
        if (arg1 == 0 || arg2 == 0) {
            return 0L;
        }
        if (Math.abs(arg2) > Math.abs(arg1)) {
            long temp = arg2;
            arg2 = arg1;
            arg1 = temp;
        }
        if ((arg1 > 0 && arg2 > 0) || (arg1 < 0 && arg2 < 0)) {
            return getRecursiveSum(Math.abs(arg1), Math.abs(arg2));
        } else {
            return getRecursiveSum(0 - Math.abs(arg1), Math.abs(arg2));
        }
    }

    private static long getRecursiveSum(long arg1, long arg2) {
        long sum = arg1;
        for (long index = 1; index < arg2; index++) {
            sum += arg1;
        }
        return sum;
    }

}
