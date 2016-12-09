package de.bhtb.lecture05.multiple.inheritance;

/**
 * Created by visenger on 09/12/16.
 */
public class Monster implements Moveable, Resizable {
    private int width;
    private int height;
    private int x;
    private int y;

    public Monster() {
        this.width = 0;
        this.height = 0;
        this.x = 0;
        this.y = 0;

    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;

    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setY(int y) {
        this.y = y;

    }

    @Override
    public void setHeight(int height) {
        this.height = height;

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

        this.setWidth(getX() + width);
        this.setHeight(getY() + height);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
