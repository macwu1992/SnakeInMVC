package com.macwu.Snake.Model;

/**
 * Created by Tong on 2016/11/13.
 */
public enum DirectionEnum {
    UP(1),
    DOWN(2),
    LEFT(3),
    RIGHT(4);

    private int value;

    public int getValue() {
        return value;
    }

    DirectionEnum(int value) {
        this.value = value;
    }
}
