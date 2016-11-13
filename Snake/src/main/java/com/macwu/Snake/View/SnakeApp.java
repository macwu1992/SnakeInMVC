package com.macwu.Snake.View;

import com.macwu.Snake.Controller.GameController;
import com.macwu.Snake.Model.Grid;
import com.macwu.Snake.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tong on 2016/11/13.
 */
public class SnakeApp {

    public void init() {

//        初始化Grid
        Grid grid = new Grid(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT);

//        创建游戏窗体
        JFrame windowFrame = new JFrame("贪吃蛇游戏");

//        获取windowFrame下的Panel,以便将画板加入
        Container contentPane = windowFrame.getContentPane();

//        使用grid来初始化GameView
        GameView gameView = new GameView(grid);
        gameView.init();

//        对画笔设置大小
        gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));

//        将画布加入窗口中,且置中
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);

//        设置窗体的属性
        windowFrame.pack();
        windowFrame.setResizable(false);
        windowFrame.setVisible(true);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        初始化GameController
        GameController gameController = new GameController(grid, gameView);

//        将按键时间注册到windowFrame
        windowFrame.addKeyListener(gameController);

//        开始游戏线程
        new Thread(gameController).start();
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}
