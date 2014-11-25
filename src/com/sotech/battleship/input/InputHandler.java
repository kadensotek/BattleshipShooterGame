package com.sotech.battleship.input;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

public class InputHandler
{
    public boolean[] key = new boolean[68836];

    @Override
    public void focusGained(FocusEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void focusLost(FocusEvent e)
    {
        for(int i = 0; i < key.length; i++)
        {
            key[i] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        ;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(keyCode > 0 && keyCode < key.length)
        {
            key[keyCode] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(keyCode > 0 && keyCode < key.length)
        {
            key[keyCode] = false;
        }
    }
}
