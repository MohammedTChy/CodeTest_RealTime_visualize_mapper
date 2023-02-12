import java.io.BufferedReader;

public class ParserObject implements Runnable {
    private BufferedReader in;
    private MapImageHolder mapImageHolder;

    public ParserObject(BufferedReader in, MapImageHolder mapImageHolder) {
        this.in = in;
        this.mapImageHolder = mapImageHolder;
    }

    private Object parseObjectData(String data) {
        String[] dataFields = data.split(";");
        long id = Long.parseLong(dataFields[0].split("=")[1]);
        int x = Integer.parseInt(dataFields[1].split("=")[1]);
        int y = Integer.parseInt(dataFields[2].split("=")[1]);
        int type = Integer.parseInt(dataFields[3].split("=")[1]);
        return new Object(id, x, y, type);
    }

    @Override
    public void run() {
        try {
            String inData;
            while ((inData = in.readLine()) != null) {
                Object object = parseObjectData(inData);
                mapImageHolder.updateObject(object);
                mapImageHolder.repaint();
            }
        } catch (Exception e) {
            e.printStackTrace(); //This is probably redundant but helps me get more info
            System.err.println("Error: " + e.getMessage());
        }
    }
}
