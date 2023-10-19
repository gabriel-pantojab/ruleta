package view;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RouletteView extends JPanel {
    private PocketView[] pockets;
    private Timer timer;
    private int delay;
    private int time;
    public RouletteView() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setLayout(null);
        setBackground(new Color(3, 51, 6));
        setBounds(0, 0, 400, 400);
        pockets = Constants.pockets;
        delay = 30;
        time = 5500;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(126, 70, 43));
        g2.fillOval(10, 25, 370, 370);
        for(PocketView pp : pockets){
            pp.paint(g2);
        }
        g2.setColor(new Color(66, 33, 20));
        g2.fillOval(106, 126, 273,273);
        g2.setColor(new Color(239, 198, 45));
        g2.setStroke(new BasicStroke(10.0f));
        g2.fillOval(217, 237, 50,50);
        g2.drawLine(173, 189, 317, 340);
        g2.drawLine(317, 189, 173, 340);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void spin(){
        timer = new Timer(delay, new ActionListener() {
            int t = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = pockets[0].getCenterX();
                int y = pockets[0].getCenterY();
                double rotate = pockets[0].getAngleRotation();
                Color color = pockets[0].getColor();
                for(int i = 0; i < pockets.length-1; i++){
                    pockets[i].update(pockets[i+1].getCenterX(),pockets[i+1].getCenterY(), pockets[i+1].getAngleRotation(), pockets[i+1].getColor());
                }
                pockets[pockets.length-1].update(x,y,rotate,color);
                repaint();
                t += delay;
                delay += 2;
                timer.setDelay(delay);
                if(t >= time) {
                    delay = 30;
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    public void stopSpin() {
        if(timer != null) {
            timer.stop();
        }
    }
}
