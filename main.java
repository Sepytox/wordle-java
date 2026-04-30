import java.util.Random;

public class Main {

    // Eine kleine Auswahl an deutschen Wörtern mit 5 Buchstaben
    static String[] woerter = {
        "APFEL", "BLUME", "BREIT", "DANKE", "DELTA",
        "ENGEL", "FALKE", "GABEL", "HAFEN", "INSEL",
        "JACKE", "KATZE", "LAMPE", "MAUER", "NACHT",
        "OFFEN", "PFEIL", "QUARZ", "REGEN", "STERN",
        "TISCH", "UHREN", "VOGEL", "WELLE", "XENON"
    };

    public static void main(String[] args) {
        // Zufälliges Wort auswählen
        Random zufall = new Random();
        String geheimwort = woerter[zufall.nextInt(woerter.length)];

        System.out.println("Willkommen bei Wordle!");
        System.out.println("Rate das 5-Buchstaben-Wort in 6 Versuchen.");

        // Nur zum Testen – später wieder entfernen!
        System.out.println("(Debug) Geheimwort: " + geheimwort);
    }
}