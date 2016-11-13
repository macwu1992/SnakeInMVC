package com.macwu.Snake.View;

import com.macwu.Snake.Model.Grid;
import com.macwu.Snake.Model.Node;
import com.macwu.Snake.Model.Snake;
import com.macwu.Snake.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tong on 2016/11/13.
 */
public class GameView {
    private final Grid grid;

    private JPanel canvas;

    public void init() {
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                drawBackground(g);
                drawFood(g, grid.getFood());
                drawSnake(g, grid.getSnake());
            }
        };
    }

    public void draw() {
        canvas.repaint();
    }

    public void drawBackground(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, grid.getWidth(), grid.getHeight());
    }

    public void drawFood(Graphics graphics, Node food) {
        graphics.setColor(Color.red);
        graphics.fillOval(food.getX(), food.getY(), Settings.DEFAULT_FOOD_SIZE, Settings.DEFAULT_FOOD_SIZE);
    }

    public void drawSnake(Graphics graphics, Snake snake) {
        graphics.setColor(Color.blue);
        for (Node node : snake.getSnakeBody()) {
            graphics.fillRect(node.getX(), node.getY(), Settings.DEFAULT_SNAKE_SIZE, Settings.DEFAULT_SNAKE_SIZE);
        }
    }

    public void showGameOverMsg() {
        JOptionPane.showMessageDialog(null, "Game Over!", "GameOver!", JOptionPane.INFORMATION_MESSAGE);
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public GameView(Grid grid) {
        this.grid = grid;
    }
}
