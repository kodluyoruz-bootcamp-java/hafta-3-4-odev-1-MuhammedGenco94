package com.kodluyoruz.homework3.utils.enums;

/**
 * This enum class is NOT Used !!
 */
public enum GMTDifference {
    ZERO(0, "UTC+00"),
    ONE(1, "UTC+01"),
    TWO(2, "UTC+02"),
    THREE(3, "UTC+03"),
    FOUR(4, "UTC+04"),
    FIVE(5, "UTC+05"),
    M_ONE(-1, "UTC-01"),
    M_TWO(-2, "UTC-02"),
    M_TREE(-3, "UTC-03"),
    M_FOUR(-4, "UTC-04"),
    M_FIVE(-5, "UTC-05");

    private final Integer value;
    private final String name;

    GMTDifference(Integer value, String code) {
        this.value = value;
        this.name = code;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
