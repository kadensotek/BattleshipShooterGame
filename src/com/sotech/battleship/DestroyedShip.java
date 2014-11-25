package com.sotech.battleship;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class DestroyedShip extends GameObject
{
    public DestroyedShip(int xPos, int yPos, final int width, final int height, final String img)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.img = getImage(img);
    }

    @Override
    void draw(Graphics g)
    {
        g.drawImage(img, xPos, yPos, width, height, null);
    }

    @Override
    void update(Shooter shooter, int id)
    {
        ; /* do nothing */
    }

    @Override
    Image getImage(String img)
    {
        return Toolkit.getDefaultToolkit().getImage(img);
    }
}
