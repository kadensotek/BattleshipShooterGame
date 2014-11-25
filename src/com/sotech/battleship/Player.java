package com.sotech.battleship;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends GameObject
{    
    /**
     * Create a player
     * @param xPos      X Position
     * @param yPos  Y Position
     * @param width Width of player
     * @param height    Height of player
     * @param health    Health of player
     * @param img   Image of player
     */
    public Player(int xPos, int yPos, final int width, final int height, final int health, final String img)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.health = health;
        this.img = getImage(img);
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(img, xPos, yPos, width, height, null);
    }

    @Override
    void update(final Shooter shooter, final int id)
    {
        if(id == 1 && this.getHealth()!=0)
        {
            if(Shooter.player1Up)
            {
                if( !(yPos < 65) )
                {
                yPos--;
                rect.y--;
                }
            }
            else if(Shooter.player1Down)
            {
            if( !(yPos > (shooter.getHeight()-106) ) )
                {
                    yPos++;
                    rect.y++;
                }
            }
            
        }
        else if(id == 2 && this.getHealth()!=0)
        {
            if(Shooter.player2Up)
            {
                if( !(yPos < 65) )
                {
                yPos--;
                rect.y--;
                }
            }
            else if(Shooter.player2Down)
            {
            if( !(yPos > (shooter.getHeight()-106) ) )
                {
                    yPos++;
                    rect.y++;
                }
            }
        }
    }

    @Override
    Image getImage(String img)
    {
        return Toolkit.getDefaultToolkit().getImage(img);
    }    
}