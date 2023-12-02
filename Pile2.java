import java.util.Scanner;

public class Pile2 {
    static final int max = 8;
    char t[];
    int top;

    public Pile2() {
        t = new char[max];
        top = -1;
    }

    public void empiler(char c) {
        if (!estPleine())
            t[++top] = c;
        else
            System.out.println("Pile est pleine");
    }

    public char sommet() {
        if (!estVide())
            return t[top];
        else {
            System.out.println(" Pile est vide");
            return '\0';
        }
    }

    public void depiler() {
        if (!estVide())
            top--;
        else
            System.out.println(" Pile est vide, ");

    }

    public boolean estVide() {
        return top == -1;
    }

    public boolean estPleine() {
        return top == max - 1;
    }
 
    public static boolean verifierParentheses(String chain) {
        Pile pile = new Pile();

        for (char cara : chain.toCharArray()) {
            if (cara == '(') {
                pile.empiler(cara);
            } else if (cara == ')') {
                if (pile.estVide()) {
                    System.out.println("Erreur : Plus de parenthèses fermantes que d'ouvrantes.");
                    return false;
                }
                pile.depiler();
            } else if (cara == '#') {
                break; 
            }
        }

        if (pile.estVide()) {
            return true;
        } else {
            System.out.println("Erreur : Plus de parenthèses ouvrantes que de fermantes.");
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le texte : ");
        String txt = scanner.nextLine();
        if (verifierParentheses(txt)) {
            System.out.println("L'expression est bien parenthésée.");
        } else {
            System.out.println("L'expression n'est pas bien parenthésée.");
        }
        scanner.close();
    }

}
