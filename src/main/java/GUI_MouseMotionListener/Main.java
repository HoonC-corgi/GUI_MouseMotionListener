import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main extends JFrame {
    private JLabel hello = new JLabel("Hello");

    public Main() {
        setTitle("Mouse Event");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        hello.setSize(100, 20);
        hello.setLocation(30, 30);
        c.add(hello);

        // c.addMouseListener(new MouseListener() {
        //   @Override
        //   public void mouseClicked(MouseEvent e) {}

        //   @Override
        //   public void mousePressed(MouseEvent e) {
        //     int x = e.getX();
        //     int y = e.getY();
        //     hello.setLocation(x,y);
        //   }

        //   @Override
        //   public void mouseReleased(MouseEvent e) {}

        //   @Override
        //   public void mouseEntered(MouseEvent e) {}

        //   @Override
        //   public void mouseExited(MouseEvent e) {}
        // });

        // c.addMouseMotionListener(new MouseMotionListener() {
        //   @Override
        //   public void mouseDragged(MouseEvent e) {
        //     hello.setLocation(e.getX(), e.getY());
        //   }

        //   @Override
        //   public void mouseMoved(MouseEvent e) {}
        // });

        // 어댑터 클래스
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                hello.setLocation(e.getX(), e.getY());
            }
        });

        c.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                hello.setLocation(e.getX(), e.getY());
            }
        });

        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = hello.getX();
                int y = hello.getY();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        y += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 10;
                        break;
                }
                hello.setLocation(x,y);
                hello.setText(keyCode + ": " + e.getKeyChar() + ": " +
                        KeyEvent.getKeyText(keyCode));
            }
        });

        setSize(400,400);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    public static void main(String[] args) {
        new Main();
    }
}