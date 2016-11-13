package com.macwu.Snake.Model;

import java.util.LinkedList;

/**
 * Created by Tong on 2016/11/13.
 */
public class Snake {
    private LinkedList<Node> snakeBody = new LinkedList<Node>();

    private DirectionEnum nowDirection;

//    吃食物,尾部增加一个Node
    public void Eat(){
        int newTail_x = this.getSnakeBody().getLast().getY();
        int newTail_y = this.getSnakeBody().getLast().getX();

        switch (nowDirection) {
            case UP:
                newTail_y++;
                break;
            case DOWN:
                newTail_y--;
                break;
            case RIGHT:
                newTail_x--;
                break;
            case LEFT:
                newTail_x++;
                break;
            default:
                break;

        }
        this.addTail(new Node(newTail_x, newTail_y));
    }

//    移动,头部的Node按照当前方向增加一格,尾部的Node减去一格
    public void Move(){
        int newHead_x = this.getHead().getX();
        int newHead_y = this.getHead().getY();

        switch (nowDirection) {
            case UP:
                newHead_y--;
                break;
            case DOWN:
                newHead_y++;
                break;
            case RIGHT:
                newHead_x++;
                break;
            case LEFT:
                newHead_x--;
                break;
            default:
                break;
        }

        this.addHead(new Node(newHead_x, newHead_y));
        this.getSnakeBody().removeLast();
    }

    public LinkedList<Node> getSnakeBody() {
        return snakeBody;
    }

    public Node getHead(){
        return snakeBody.getFirst();
    }

    public DirectionEnum getNowDirection() {
        return nowDirection;
    }

    public void setNowDirection(DirectionEnum nowDirection) {
        this.nowDirection = nowDirection;
    }

    public void addHead(Node node){
        snakeBody.addFirst(node);
    }

    public void addTail(Node node){
        snakeBody.addLast(node);
    }

    public Snake() {
        nowDirection = DirectionEnum.LEFT;
    }
}
