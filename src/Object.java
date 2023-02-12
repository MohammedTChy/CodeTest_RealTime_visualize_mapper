import java.awt.*;

public class Object {
    private long id;
    private int x;
    private int y;
    private int category;

    private int type;

    public Object(long id, int x, int y, int type) {

        this.id = id;
        this.x = x;
        this.y = y;
        this.type = type;
        setCategory(); //Lazy hack

    }

    public long getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory() {
        switch (type) {
            case 1 -> this.category = 1;
            case 2 -> this.category = 1;
            case 3 -> this.category = 2;
            default -> this.category = 0;
        }
        ;
    }

    public int getType() {
        return type;
    }

    public Color getColor() {
        return switch (type) {
            case 1 -> Color.RED;
            case 2 -> Color.GREEN;
            case 3 -> Color.BLUE;
            default -> Color.BLACK;
        };
    }
}
