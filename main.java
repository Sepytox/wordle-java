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

    // Vergleicht den Tipp mit dem Geheimwort und gibt Emojis zurück
    static String gibFeedback(String tipp, String geheimwort) {
        String feedback = "";

        for (int i = 0; i < 5; i++) {
            char buchstabe = tipp.charAt(i);

            if (buchstabe == geheimwort.charAt(i)) {
                feedback += "🟩"; // Richtige Position
            } else if (geheimwort.indexOf(buchstabe) != -1) {
                feedback += "🟨"; // Im Wort, falsche Position
            } else {
                feedback += "⬜"; // Nicht im Wort
            }
        }

        return feedback;
    }

    public static void main(String[] args) {
        Random zufall = new Random();
        String geheimwort = woerter[zufall.nextInt(woerter.length)];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen bei Wordle!");
        System.out.println("Rate das 5-Buchstaben-Wort in 6 Versuchen.");
        System.out.println("--------------------------------------------");

        System.out.print("Dein Tipp: ");
        String eingabe = scanner.nextLine().toUpperCase().trim();

        if (eingabe.length() != 5) {
            System.out.println("Ungültig! Bitte genau 5 Buchstaben eingeben.");
        } else {
            System.out.println(eingabe + "  " + gibFeedback(eingabe, geheimwort));
        }

        scanner.close();
    }
}