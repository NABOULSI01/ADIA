import java.util.Scanner;

public class Pile {
    static final int max = 100;
    char tab[];
    int sommet;

    public Pile() {
        tab = new char[max];
        sommet = -1;
    }

    public void empiler(char c) {
        if (!estPleine())
            tab[++sommet] = c;
        else
            System.out.println("Pile est pleine");
    }

    public char sommet() {
        if (!estVide())
            return tab[sommet];
        else {
            System.out.println(" Pile est vide");
            return '\0';
        }
    }

    public void depiler() {
        if (!estVide())
            sommet--;
        else
            System.out.println(" Pile est vide, ");

    }

    public boolean estVide() {
        return sommet == -1;
    }

    public boolean estPleine() {
        return sommet == max - 1;
    }

    public static String reverseStr(String chain) {
        Pile p = new Pile();

        for (int i = 0; i < chain.length(); i++) {
            p.empiler(chain.charAt(i));
        }

        StringBuilder reverse = new StringBuilder();

        while (!p.estVide()) {
            reverse.append(p.sommet());
            p.depiler();
        }

        return reverse.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String inStr = scanner.nextLine();

        String reversedString = reverseStr(inStr);

        System.out.println("Reversed string: " + reversedString);

        scanner.close();
    }
}