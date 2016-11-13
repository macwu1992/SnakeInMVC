package com.macwu.Snake;

import com.macwu.Snake.Model.DirectionEnum;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Tong on 2016/11/13.
 */
public final class Settings {


//    grid长与宽
    public static final int DEFAULT_GRID_WIDTH = 400;
    public static final int DEFAULT_GRID_HEIGHT = 300;

//    food方块大小
    public static final int DEFAULT_FOOD_SIZE = 10;

//    snake方块大小
    public static final int DEFAULT_SNAKE_SIZE = 10;
//    public static final DirectionEnum INIT_SNAKE_DIRECTION;

//    snake移动的间隔时间
    public static final int DEFAULT_MOVE_INTERVAL = 200;
}
