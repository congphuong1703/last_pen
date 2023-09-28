package lastpencil;

import javax.print.attribute.standard.JobHoldUntil;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static final String JACK = "Jack";
    private static final String JOHN = "John";

    public static void main(String[] args) {
        String pencils = initPencils();
        String name = initName();
        boolean isBot = JACK.equalsIgnoreCase(name);

        System.out.println(pencils);
        for (int i = 1; ; i++) {
            System.out.println(name + "'s turn" + (JACK.equalsIgnoreCase(name) ? ":" : "!"));
            int drawPencil;
            if (JACK.equalsIgnoreCase(name)) {
                name = JOHN;
            } else {
                name = JACK;
            }
            do {

                try {
                    if (isBot) {
                        if (pencils.length() % 4 == 0) {
                            drawPencil = 3;
                        } else if (pencils.length() % 4 == 3) {
                            drawPencil = 2;
                        } else {
                            drawPencil = 1;
                        }
                        System.out.println(drawPencil);
                    } else {
                        drawPencil = Integer.parseInt(sc.next());
                    }
                    if (drawPencil > 3 || drawPencil < 1) {
                        throw new Exception();
                    } else if (drawPencil > pencils.length()) {
                        System.out.println("Too many pencils were taken");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            } while (true);
            pencils = pencils.substring(0, pencils.length() - drawPencil);

            if (pencils.length() == 0) {
                System.out.println(name + " won!");
                return;
            }
            isBot = !isBot;
            System.out.println(pencils);
        }
    }

    private static String initPencils() {
        System.out.println("How many pencils would you like to use:");
        int numberOfPencils;
        do {
            try {
                numberOfPencils = Integer.parseInt(sc.nextLine());
                if (numberOfPencils < 1) {
                    System.out.println("The number of pencils should be positive");
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
            }
        } while (true);
        return "|".repeat(numberOfPencils);
    }

    private static String initName() {
        System.out.println("Who will be the first (John, Jack):");
        String name;
        do {
            name = sc.next();
            if (!"John".equalsIgnoreCase(name) && !"Jack".equalsIgnoreCase(name)) {
                System.out.println("Choose between 'John' and 'Jack'");
            } else {
                break;
            }
        } while (true);

        return name;
    }
}
