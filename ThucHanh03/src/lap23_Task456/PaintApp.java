package lap23_Task456;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class PaintApp extends JFrame {
    private DrawingPanel drawingPanel;
    private JButton convertButton;

    public PaintApp() {
        setTitle("Paint App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        convertButton = new JButton("Convert to Text");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = drawingPanel.convertToText();
                JOptionPane.showMessageDialog(PaintApp.this, text);
            }
        });
        add(convertButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintApp().setVisible(true);
            }
        });
    }
}

class DrawingPanel extends JPanel {
    private BufferedImage image;
    private Graphics2D g2d;
    private int prevX, prevY;

    public DrawingPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                prevX = e.getX();
                prevY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                g2d.drawLine(prevX, prevY, x, y);
                repaint();
                prevX = x;
                prevY = y;
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public String convertToText() {
        StringBuilder sb = new StringBuilder();
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y += 10) {
            for (int x = 0; x < width; x += 5) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
                int gray = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                char character = getCharacter(gray);
                sb.append(character);
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    private char getCharacter(int gray) {
        char[] characters = {'@', '#', '8', '&', 'o', ':', '*', '.', ' '};
        int numCharacters = characters.length;
        int range = 255 / numCharacters;

        int index = gray / range;
        if (index >= numCharacters) {
            index = numCharacters - 1;
        }

        return characters[index];
    }
}