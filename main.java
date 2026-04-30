import java.util.Random;
import java.util.Scanner;

public class Main {

    static String[] woerter = {
        "APFEL", "BLUME", "BREIT", "DANKE", "DELTA",
        "ENGEL", "FALKE", "GABEL", "HAFEN", "INSEL",
        "JACKE", "KATZE", "LAMPE", "MAUER", "NACHT",
        "OFFEN", "PFEIL", "QUARZ", "REGEN", "STERN",
        "TISCH", "UHREN", "VOGEL", "WELLE", "XENON"
    };

    static String gibFeedback(String tipp, String geheimwort) {
        String feedback = "";

        for (int i = 0; i < 5; i++) {
            char buchstabe = tipp.charAt(i);

            if (buchstabe == geheimwort.charAt(i)) {
                feedback += "🟩";
            } else if (geheimwort.indexOf(buchstabe) != -1) {
                feedback += "🟨";
            } else {
                feedback += "⬜";
            }
        }

        return feedback;
    }

    public static void main(String[] args) {
        Random zufall = new Random();
        String geheimwort = woerter[zufall.nextInt(woerter.length)];
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════╗");
        System.out.println("║     WORDLE auf Konsole   ║");
        System.out.println("╚══════════════════════════╝");
        System.out.println("Rate das 5-Buchstaben-Wort in 6 Versuchen!\n");

        int maxVersuche = 6;
        boolean gewonnen = false;

        for (int versuch = 1; versuch <= maxVersuche; versuch++) {
            System.out.print("Versuch " + versuch + "/6 → ");
            String eingabe = scanner.nextLine().toUpperCase().trim();

            // Validierung
            if (eingabe.length() != 5) {
                System.out.println("⚠️  Bitte genau 5 Buchstaben eingeben!\n");
                versuch--; // Versuch zählt nicht
                continue;
            }

            // Feedback ausgeben
            String feedback = gibFeedback(eingabe, geheimwort);
            System.out.println("         " + eingabe + "  " + feedback + "\n");

            // Gewonnen?
            if (eingabe.equals(geheimwort)) {
                System.out.println("🎉 Glückwunsch! Du hast gewonnen in " + versuch + " Versuch(en)!");
                gewonnen = true;
                break;
            }
        }

        if (!gewonnen) {
            System.out.println("😢 Leider verloren! Das Wort war: " + geheimwort);
        }

        scanner.close();
    }
}