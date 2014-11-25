package com.sotech.battleship.input;

public class Controller
{
    public double x;

    public void tick(boolean up, boolean down, boolean shoot)
    {
        double walkSpeed = 1.0;
        double xMove = 0;
        double zMove = 0;

        if(up)
        {
            zMove++;
        }

        if(down)
        {
            zMove--;
        }

        if(shoot)
        {
            xMove--;
        }
    }
}
