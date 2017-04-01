package de.my.playground;

/**
 * Created by visenger on 03/02/17.
 */
public class IdentifyMyParts {

    public static int x = 7;
    public int y = 3;
}

class TesterForIdentifyer {
    public static void main(String... args) {
        IdentifyMyParts a = new IdentifyMyParts();
        IdentifyMyParts b = new IdentifyMyParts();

        a.y = 5;
        b.y = 6;
        a.x = 1;
        b.x = 2;

        System.out.println("a.y = " + a.y);
        System.out.println("b.y = " + b.y);
        System.out.println("a.x = " + a.x);
        System.out.println("b.x = " + b.x);

        System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x);


    }

}
