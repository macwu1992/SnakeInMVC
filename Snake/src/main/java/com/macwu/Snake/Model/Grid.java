package com.macwu.Snake.Model;

import com.macwu.Snake.Settings;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Tong on 2016/11/13.
 */
public class Grid {

    private final int width;
    private final int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Snake snake;

    public Snake getSnake() {
        return snake;
    }

    private Node food;

    public Node getFood() {
        return food;
    }

    public final boolean gridStatues[][];

    public void initSnake(){
        snake = new Snake();

        int snakeLength = (this.width/3);

        int init_x = (this.width/2);
        int init_y = (this.height/2);

        for(int i=0;i<snakeLength;i++){
            snake.addTail(new Node(init_x+i, init_y));
        }

//        在grid中,将snake所占的格子填上true
        for(Node snakeNode:snake.getSnakeBody()){
            this.gridStatues[snakeNode.getX()][snakeNode.getY()] = true;
        }
    }

//    生成两个在grid范围内的随机数,一个作为food的横座标,另一个作为纵坐标,并在grid中填上true
    public void createFood(){
        Random random = new Random();
        int rndBound = this.width<this.height?this.width:this.height;

        int food_x = random.nextInt(rndBound);
        int food_y = random.nextInt(rndBound);

        food = new Node(food_x, food_y);

        this.gridStatues[food.getX()][food.getY()] = true;
    }

//    判断snake是否触到边缘,或是咬到自己
    private boolean snakeHit(){
        Node snakeHead = snake.getHead();

        LinkedList<Node> snakeBody = snake.getSnakeBody();

//        触到边缘
//        if X, Y 在grid的范围内就看有没有咬到自己。
//        else 触到边缘

        if (snakeHead.getX()>0 && snakeHead.getX()<this.width  && snakeHead.getY()>0 && snakeHead.getY()<height) {

//            判断在无头的snakeBody中是否还含有与snakeHead坐标一样的Node:
//              如果有就是咬到自己
//              如果没有就继续判断

            for (Node node : snakeBody.subList(1, snakeBody.size())) {
                if (snakeHead.equals(node)) {
                    return true;
                }else {
                    continue;
                }
            }

            return false;
        } else {
            return true;
        }
    }

    public void snakeChangeDirection(DirectionEnum direction){
        this.snake.setNowDirection(direction);
    }

    //    每一轮都更新一次Grid的状态,包括Snake的位置,食物的位置
    public boolean nextRound(){
        snake.Move();

//        先判断是否吃到食物
        if (snake.getHead().equals(food)) {
            snake.Eat();
            food = null;
        }

        if (food == null) {
            this.createFood();
        }

//        再判断是否碰到边界或是咬到自己
        if (this.snakeHit()) {
            return false;
        }

//        没有出现一场情况的话就返回true,进行下一轮
        return true;
    }

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        gridStatues = new boolean[width][height];

        initSnake();
        createFood();
    }
}