package de.bhtb.lecture05.multiple.inheritance;

/**
 * Created by visenger on 09/12/16.
 */
public interface Resizable {
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
    default void setRelativeSize(int wFactor, int hFactor){
        setAbsoluteSize(getWidth()/wFactor, getHeight()/hFactor);
    }
}
