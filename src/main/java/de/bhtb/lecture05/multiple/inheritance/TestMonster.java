package de.bhtb.lecture05.multiple.inheritance;

/**
 * Created by visenger on 09/12/16.
 */
public class TestMonster {
    public static void main(String... args) {
        Monster monster = new Monster();
        monster.moveHorizontally(20);
        monster.moveVertically(12);

        monster.setAbsoluteSize(monster.getWidth(), monster.getHeight());
        monster.setRelativeSize(3, 5);

        System.out.println("moving monster = " + monster);
    }
}
