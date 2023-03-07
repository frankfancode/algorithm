package com.ff.offer;

public class Offer05 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return  stringBuilder.toString();
    }
}
