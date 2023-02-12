import javax.swing.*;
import java.awt.*;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MapApplication {

    private static final int SERVER_PORT = 5463;
    private static MapImageHolder mapImageHolder;
    private static JFrame frame;
    private static JPanel ButtonControlPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frame = new JFrame("Map Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            mapImageHolder = new MapImageHolder();
            frame.add(mapImageHolder, BorderLayout.CENTER);
            ButtonControlPanel = new JPanel();
            frame.add(ButtonControlPanel, BorderLayout.SOUTH);

            JButton btnCategory1 = new JButton("Category 1 (Type 1 & 2)");
            btnCategory1.addActionListener(e -> mapImageHolder.setCategoryFilter(1));
            ButtonControlPanel.add(btnCategory1);

            JButton btnCategory2 = new JButton("Category 2 (Type 3)");
            btnCategory2.addActionListener(e -> mapImageHolder.setCategoryFilter(2));
            ButtonControlPanel.add(btnCategory2);

            JButton btnAllCategories = new JButton("All Categories");
            btnAllCategories.addActionListener(e -> mapImageHolder.setCategoryFilter(0));
            ButtonControlPanel.add(btnAllCategories);

            try {
                Socket socket = new Socket("localhost", SERVER_PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Thread updateThread = new Thread(new ParserObject(in, mapImageHolder));
                updateThread.start();
            } catch (Exception e) {
                e.printStackTrace(); //This is probably redundant but helps me get more info
                System.err.println("Error: " + e.getMessage());
            }

            frame.pack();
            frame.setVisible(true);
        });
    }
}