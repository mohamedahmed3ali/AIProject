import java.awt.*;        // Using AWT container and component classes
import javax.swing.*;
import java.awt.event.*;  // Using AWT event classes and listener interfaces
public class GUI extends JFrame  {
    MazeGen maze;
    public GUI(){
        maze = new MazeGen();
        setLayout(new GridLayout(maze.m, maze.n));
        for (int i = maze.m -1; i >= 0; i--) {
            for (int j = 0; j < maze.n; j++) {
                JButton btn = new JButton (getImage(i, j));
                btn.setBackground(Color.WHITE);
                btn.setBorderPainted(false);
//                Button btn = new Button();
                add(btn);
            }
        }
        setSize(1200, 680);
        setTitle("Pokemon");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ImageIcon getImage(int i, int j){
        Cell c = maze.maze[i][j];
        ImageIcon start = new ImageIcon(getClass().getResource("Images/0000.png"));

        if(!c.wallUp && !c.wallDown && !c.wallRight && !c.wallLeft){
             start = new ImageIcon(getClass().getResource("Images/0000.png"));
        }else {
            if (!c.wallUp && !c.wallDown && !c.wallRight && c.wallLeft) {
                 start = new ImageIcon(getClass().getResource("Images/0001.png"));
            } else {
                if (!c.wallUp && !c.wallDown && c.wallRight && !c.wallLeft) {
                     start = new ImageIcon(getClass().getResource("Images/0010.png"));
                } else {
                    if (!c.wallUp && !c.wallDown && c.wallRight && c.wallLeft) {
                         start = new ImageIcon(getClass().getResource("Images/0011.png"));
                    } else {
                        if (!c.wallUp && c.wallDown && !c.wallRight && !c.wallLeft) {
                             start = new ImageIcon(getClass().getResource("Images/0100.png"));
                        } else {
                            if (!c.wallUp && c.wallDown && !c.wallRight && c.wallLeft) {
                                 start = new ImageIcon(getClass().getResource("Images/0101.png"));
                            } else {
                                if (!c.wallUp && c.wallDown && c.wallRight && !c.wallLeft) {
                                     start = new ImageIcon(getClass().getResource("Images/0110.png"));
                                } else {
                                    if (!c.wallUp && c.wallDown && c.wallRight && c.wallLeft) {
                                         start = new ImageIcon(getClass().getResource("Images/0111.png"));
                                    } else {
                                        if (c.wallUp && !c.wallDown && !c.wallRight && !c.wallLeft) {
                                             start = new ImageIcon(getClass().getResource("Images/1000.png"));
                                        } else {
                                            if (c.wallUp && !c.wallDown && !c.wallRight && c.wallLeft) {
                                                 start = new ImageIcon(getClass().getResource("Images/1001.png"));
                                            } else {
                                                if (c.wallUp && !c.wallDown && c.wallRight && !c.wallLeft) {
                                                     start = new ImageIcon(getClass().getResource("Images/1010.png"));
                                                } else {
                                                    if (c.wallUp && !c.wallDown && c.wallRight && c.wallLeft) {
                                                         start = new ImageIcon(getClass().getResource("Images/1011.png"));
                                                    } else {
                                                        if (c.wallUp && c.wallDown && !c.wallRight && !c.wallLeft) {
                                                             start = new ImageIcon(getClass().getResource("Images/1100.png"));
                                                        } else {
                                                            if (c.wallUp && c.wallDown && !c.wallRight && c.wallLeft) {
                                                                 start = new ImageIcon(getClass().getResource("Images/1101.png"));
                                                            } else {
                                                                if (c.wallUp && c.wallDown && c.wallRight && !c.wallLeft) {
                                                                     start = new ImageIcon(getClass().getResource("Images/1110.png"));
                                                                } else {
                                                                    if (c.wallUp && c.wallDown && c.wallRight && c.wallLeft) {
                                                                         start = new ImageIcon(getClass().getResource("Images/1111.png"));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Image img = start.getImage();
        Image newimg = img.getScaledInstance((1200/maze.n)+5, (680/maze.m)+3,  java.awt.Image.SCALE_SMOOTH);
        start = new ImageIcon(newimg);
        return start;
    }

    public static void main(String[]args){
        GUI g = new GUI();
    }
}
