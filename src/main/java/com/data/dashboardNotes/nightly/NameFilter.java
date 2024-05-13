package com.data.dashboardNotes.nightly;

import java.util.Arrays;
import java.util.regex.Pattern;

public class NameFilter {
    static int CODE_LENGTH = 11;

    // xxx.xxx.xxx
    static String CODE_PATTERN = "^\\w{3}\\.\\w{3}\\.\\w{3}$";

    public static void main(String[] args) {
        String normalName = "123 qwe asd.zxc.qwe";
        String onlyName = "123 qwe zxc 1";

        System.out.println(Arrays.toString(checkFullName(normalName)));
    }

    //substring, charat, compareto, concat, starstwith, endswith, indexof, lastindexof, replace
    //stringbuilder: append, tostring, insert, delete
    public static String[] checkFullName(String fullName) {
        int fullNameLength = fullName.length();
        String name = null;
        String code = null;
        if (fullNameLength > CODE_LENGTH) {
            name = fullName.substring(0 , fullNameLength - CODE_LENGTH - 1);
            code = fullName.substring(fullNameLength - CODE_LENGTH, fullNameLength);
        }
        if (code == null || !code.matches(CODE_PATTERN)) {
            return null;
        }
        return new String[]{name, code};
    }
}
