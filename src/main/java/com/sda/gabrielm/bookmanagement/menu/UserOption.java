package com.sda.gabrielm.bookmanagement.menu;

import jdk.swing.interop.SwingInterOpUtils;

public enum UserOption {
    CREATE_AUTHOR(1, "Create author"),
    SHOW_ALL_AUTHORS(2, "display all authors"),
    UPDATE_AUTHOR(3, "update author"),
    EXIT(99, "Exit"),

    UNKNOWN(100,"unknown option") ;

    private int numericOption;
    private String displayValue;

    UserOption(int numericOption, String displayValue) {
        this.numericOption = numericOption;
        this.displayValue = displayValue;
    }

    public int getNumericOption() {
        return numericOption;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static void printAllOptions() {
        for (UserOption value : values()) {
            if (value != UNKNOWN) {
                System.out.println(value.getNumericOption() + "-" + value.getDisplayValue());
            }

        }
    }

    public static UserOption findUserOption(int numericValue) {
        for (UserOption value : values()) {
            if (value.getNumericOption() == numericValue) {
                return value;
            }
        }
        return UNKNOWN;

    }
}
