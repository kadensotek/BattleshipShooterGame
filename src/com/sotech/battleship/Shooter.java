package com.sotech.battleship;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Shooter extends JFrame implements KeyListener
{
    private static final long serialVersionUID = 1L;
    public static final String audioPath = "resources/audio/";
    public static final String graphicsPath = "resources/graphics/";
    
    private Player player1;
    private Player player2;
    private HealthBar player1Bar;
    private HealthBar player2Bar;
    private DestroyedShip player1Sunk;
    private DestroyedShip player2Sunk;
    private Image image;
    private Graphics graphics;

//    private SoundClip shipExplosion;
//    private SoundClip backgroundNoise;

    public static boolean player1Up = false;
    public static boolean player1Down = false;
    public static boolean player2Up = false;
    public static boolean player2Down = false;
    CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();

    public Shooter()
    {
//        shipExplosion = new SoundClip(audioPath + "FireExplosion.wav");
//        backgroundNoise = new SoundClip(audioPath + "background1.wav");

                        /* xPos, yPos, width, height, health, image address */
        player1 = new Player(10, 170, 14, 100, 10, graphicsPath + "ship1.png");
        player2 = new Player(570, 170, 14, 100, 10, graphicsPath + "ship2.png");

                               /* player, xPos, yPos, width, height, image address */
        player1Bar = new HealthBar(player1, 10, 40, 82, 20, graphicsPath + "health10.gif");
        player2Bar = new HealthBar(player2, 510, 40, 82, 20, graphicsPath + "health10.gif");

                                    /* xPos, yPos, width, height, image address */
        player1Sunk = new DestroyedShip(10, 0, 35, 100, graphicsPath + "ship1sunk.png");
        player2Sunk = new DestroyedShip(550, 0, 35, 100, graphicsPath + "ship2sunk.png");

        setTitle("Battleship Shooter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 420);
        setBackground(Color.BLUE);
        setResizable(false);
        addKeyListener(this);
        setVisible(true);
        
        displayRules();
        
//        backgroundNoise.play();
    }

    private void displayRules()
    {
        Frame frame = new Frame();
        JOptionPane.showMessageDialog(frame, "Player 1: W/S for movement and space to shot.\n" +
                                             "Player 2: Up/Down for movement and enter to shoot.");
    }

    public void paint(Graphics g)
    {
        /* Creates new image for screen */
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();

        paintComponent(graphics);
        g.drawImage(image, 0, 0, null);
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        if(player1.getHealth() > 0 && player2.getHealth() > 0)
        {
            for(Bullet bullet : bullets)
            {
                bullet.draw(g);
                bullet.update(this, 0);
            }
        }
        else if(player1.getHealth() == 0)
        {
            player1Sunk.setyPos(player1.getyPos());
            declareWinner(g, Color.RED, "Player 2 has won!");
        }
        else if(player2.getHealth() == 0)
        {
            player2Sunk.setyPos(player2.getyPos());
            declareWinner(g, Color.YELLOW, "Player 1 has won!");
        }

        player1Bar.draw(g);          // bar updates from bullet class on hit
        updateIfSunk(player1, 1, g); // if sunk, will draw sunk ship
        player2Bar.draw(g);
        updateIfSunk(player2, 2, g);
    }
    
    /* Writes message declaring game winner */
    public void declareWinner(Graphics g, Color color, String winMessage)
    {
//      backgroundNoise.stop();
//      shipExplosion.play();
        
        g.setColor(color);
        g.drawString(winMessage, 250, 210);
    }
    
    /* Draws sunken ship if needed */
    public void updateIfSunk(Player player, int playerNum, Graphics g)
    {
        if(player.getHealth() != 0)
        {
            player.draw(g);
            player.update(this, playerNum);
        }
        else
        {
            if(playerNum == 1)
            {
                player1Sunk.draw(g);
                player1Sunk.update(this, playerNum);
            }
            else
            {
                player2Sunk.draw(g);
                player2Sunk.update(this, playerNum);

            }
        }
    }

    
/*
 * INPUT METHODS
 * 
 * 
 */
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            // player 2 move up
            player2Up = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            // player 2 move down
            player2Down = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_W)
        {
            // player 1 move up
            player1Up = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_S)
        {
            // player 1 move down
            player1Down = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE) /* player 1 shoots */
        {
            Bullet player1Bullet = new Bullet(player2, player2Bar, 1,
                    player1.getxPos() + 14, player1.getyPos() + 45, 4, 4,
                    graphicsPath + "bullet.gif");
            bullets.add(player1Bullet);
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER) /* player 2 shoots */
        {
            Bullet player2Bullet = new Bullet(player1, player1Bar, -1,
                    player2.getxPos(), player2.getyPos() + 45, 4, 4,
                    graphicsPath + "bullet.gif");
            bullets.add(player2Bullet);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            // player 2 stops move up
            player2Up = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            // player 2 stops move down
            player2Down = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_W)
        {
            // player 1 stops move up
            player1Up = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_S)
        {
            // player 1 stops move down
            player1Down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        ; /* do nothing */
    }

    public static void main(String[] args)
    {
        new Shooter();
    }
}
