package com.macwu.Snake.Model;

/**
 * Created by Tong on 2016/11/13.
 */
public class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Node node) {

        if (x != node.x) return false;
        return y == node.y;
    }
}
