package Notes;

import java.awt.*;

public abstract class Shape2D {
    private String name;
    private int positionX;
    private int positionY;

    public Shape2D(String name, int positionX, int positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
