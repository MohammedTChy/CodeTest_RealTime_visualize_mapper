import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.imageio.ImageIO;

public class MapImageHolder extends JPanel {
    private Map<Long, Object> objects;
    private int categoryFilter;
    private BufferedImage mapImage;

    public MapImageHolder() {
        objects = new HashMap<>();
        categoryFilter = 0;
        try {
            mapImage = ImageIO.read(new File("map.gif"));
        } catch (IOException e) {
            e.printStackTrace(); //This is probably redundant but helps me get more info
            System.err.println("Error: " + e.getMessage());
        }

        setPreferredSize(new Dimension(mapImage.getWidth(), mapImage.getHeight()));
    }

    public void updateObject(Object object) {
        objects.put(object.getId(), object);
    }

    public void setCategoryFilter(int categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mapImage, 0, 0, null);
        for (Object object : objects.values()) {
            if (categoryFilter == 0 || categoryFilter == object.getCategory()) {
                g.setColor(object.getColor());
                g.fillOval(object.getX(), object.getY(), 10, 10);
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(object.getType()), object.getX(), object.getY());
            }
        }
    }
}
