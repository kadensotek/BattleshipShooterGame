package com.sotech.battleship;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class HealthBar extends GameObject
{
    private Player player;

    public HealthBar(final Player player, int xPos, int yPos, final int width,
            final int height, final String img)
    {
        this.player = player;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.img = getImage(img);
    }

    public void draw(Graphics g)
    {
        g.drawImage(img, xPos, yPos, width, height, null);
    }

    public void update(Shooter shooter, int id)
    {
        /* Updates health bar after hit */
        this.img = Toolkit.getDefaultToolkit().getImage(
                Shooter.graphicsPath + "health" + player.getHealth() + ".gif");
    }

    @Override
    public Image getImage(String img)
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
