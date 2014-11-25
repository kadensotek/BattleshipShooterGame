package com.sotech.battleship;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject
{
    protected Rectangle rect;
    protected Image img;
    protected int xPos;
    protected int yPos;
    protected int height;
    protected int width;
    protected int health;

    abstract void draw(Graphics g);

    abstract void update(final Shooter shooter, final int id);

    abstract Image getImage(String img);

    public Image getImg()
    {
        return img;
    }

    public void setImg(Image img)
    {
        this.img = img;
    }

    public int getxPos()
    {
        return xPos;
    }

    public void setxPos(int xPos)
    {
        this.xPos = xPos;
    }

    public int getyPos()
    {
        return yPos;
    }

    public void setyPos(int yPos)
    {
        this.yPos = yPos;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }
}
