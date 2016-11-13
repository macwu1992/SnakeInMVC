package com.macwu.Snake.Controller;

import com.macwu.Snake.Model.DirectionEnum;
import com.macwu.Snake.Model.Grid;
import com.macwu.Snake.Settings;
import com.macwu.Snake.View.GameView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Tong on 2016/11/13.
 */
public class GameController implements KeyListener, Runnable{
    private final Grid grid;
    private final GameView gameView;

    private boolean gameRunning;

//    do nothing
    public void keyTyped(KeyEvent e) {}

//    do nothing
    public void keyReleased(KeyEvent e) {}

//    定义按下按键的动作
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                grid.getSnake().setNowDirection(DirectionEnum.UP);
                break;
            case KeyEvent.VK_DOWN:
                grid.getSnake().setNowDirection(DirectionEnum.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                grid.getSnake().setNowDirection(DirectionEnum.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                grid.getSnake().setNowDirection(DirectionEnum.LEFT);
                break;
            default:
                break;
        }
    }

    public void run() {

//        判断游戏终止符
//        未终止则继续下一轮
//        不然就跳出循环

        while (this.gameRunning) {
            try {
                Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
            }catch (InterruptedException e) {
                break;
            }
            this.gameRunning = grid.nextRound();
            gameView.draw();
        }
        gameView.showGameOverMsg();
    }

    public GameController(Grid grid, GameView gameView) {
        this.grid = grid;
        this.gameView = gameView;
        this.gameRunning = true;
    }
}
