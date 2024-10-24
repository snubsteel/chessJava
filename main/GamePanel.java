package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel; 

public class GamePanel extends JPanel implements Runnable {

    
    public static final int GAME_WIDTH = 400;
    public static final int GAME_HEIGHT = 400;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();

    public GamePanel() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        setBackground(Color.black);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        // Game Loop
       double drawInterval = 1000000000/FPS;
       double delta = 0;
       long lastTime = System.nanoTime();
       long currentTime;

       while (gameThread != null) {

        currentTime = System.nanoTime();

        delta += (currentTime - lastTime)/drawInterval;
        lastTime = currentTime;

        if(delta >= 1) {
            update();
            repaint();
            delta--;
        }

       }
    }

    private void update() {

    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        board.draw(g2);
    }

   
}
