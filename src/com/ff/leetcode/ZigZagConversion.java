package com.ff.leetcode;

/**
 * Created on 30/01/2017.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        char[] charArr = s.toCharArray();
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        int length = charArr.length;
        while (i < length) {
            for (int idx = 0; idx < numRows && i < length; idx++) {
                sb[idx].append(charArr[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < length; idx--) {
                sb[idx].append(charArr[i++]);
            }
        }

        for (i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}
