package com.sotech.battleship;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bullet extends GameObject
{
    private Player player;
    private int deltaX;
    private HealthBar healthBar;
    
    public Bullet(final Player player, HealthBar healthBar, final int deltaX, int xPos, 
                    int yPos, final int width, final int height, final String img)
    {
        this.player = player;
        this.healthBar = healthBar;
        this.deltaX = deltaX;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.img = getImage(img);
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(img, xPos, yPos, width, height, null);
    }

    @Override
    void update(final Shooter shooter, final int id)
    {
        if(rect.intersects(player.rect))
        {
            player.setHealth(player.getHealth()-1);
            healthBar.update(shooter, id);
            shooter.bullets.remove(this);
        }
        else if(xPos<3 || xPos>597)
        {
            shooter.bullets.remove(this);
        }
        else
        {
            xPos += deltaX;
            rect.x += deltaX;
        }
    }

    public int getDeltaX()
    {
        return deltaX;
    }

    public void setDeltaX(int deltaX)
    {
        this.deltaX = deltaX;
    }

    @Override
    Image getImage(String img)
    {
        return Toolkit.getDefaultToolkit().getImage(img);
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
}
