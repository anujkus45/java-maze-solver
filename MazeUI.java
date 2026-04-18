import javax.swing.*;
import java.awt.*;


public class MazeUI {

    public static void main(String[] args) {
        //frame setup
        JFrame frame = new JFrame("Maze Solver");
        frame.setLayout(new BorderLayout());
        //label add 
        JLabel stepsLabel = new JLabel("Steps: 0");
        frame.add(stepsLabel, BorderLayout.NORTH);
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel panel = new JPanel(new GridLayout(5, 5));
        JButton[][] grid = new JButton[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                JButton cell = new JButton();
                cell.setBackground(Color.WHITE);

                cell.addActionListener(e -> {
                    if (cell.getBackground() == Color.WHITE) {
                        cell.setBackground(Color.BLACK);
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                });

                grid[i][j] = cell;
                panel.add(cell);
            }
        }

        JButton start = new JButton("Start");

        start.addActionListener(e -> {
            new Thread(() -> {

                int[][] maze = new int[5][5];

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (grid[i][j].getBackground() == Color.BLACK) {
                            maze[i][j] = 1;
                        } else {
                            maze[i][j] = 0;
                        }
                    }
                }

                maze[4][4] = 9;

                java.util.List<Integer> path = new java.util.ArrayList<>();

                if (dfs.searchpath(maze, 0, 0, path)) {
                    
                    int steps = path.size() / 2;

                    SwingUtilities.invokeLater(() -> {
                        stepsLabel.setText("Steps: " + steps);
                    });

                    for (int k = path.size() - 2; k >= 0; k -= 2) {
                        int x = path.get(k);
                        int y = path.get(k + 1);

                        SwingUtilities.invokeLater(() -> {
                            if (!(x == 0 && y == 0) && !(x == 4 && y == 4)) {
                                grid[y][x].setBackground(Color.BLUE);
                            }
                        });

                        try { Thread.sleep(150); } catch (Exception ex) {}
                    }

                    System.out.println("Path Found");

                } else {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(
                            null,
                            "No Path Found!",
                            "Result",
                            JOptionPane.ERROR_MESSAGE
                        );
                    });
                }

            }).start();
        });
        JButton reset = new JButton("Reset");

        reset.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    if (i == 0 && j == 0) {
                        grid[i][j].setBackground(Color.GREEN);
                    } else if (i == 4 && j == 4) {
                        grid[i][j].setBackground(Color.RED);
                    } else {
                        grid[i][j].setBackground(Color.WHITE);
                    }
                }
            }
            stepsLabel.setText("Steps: 0");
        });
        JPanel bottom = new JPanel();
        bottom.add(start);
        bottom.add(reset);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);

        grid[0][0].setBackground(Color.GREEN);
        grid[4][4].setBackground(Color.RED);
        grid[0][0].setEnabled(false);
        grid[4][4].setEnabled(false);

        frame.setVisible(true);
    }
}