import java.awt.*;
import javax.swing.*;

public class Taylorreihe extends JPanel {

    // Die maximale Anzahl der Terme, die für die Taylor-Reihen verwendet werden
    private static final int TERME = 500;

    // Methode zur Berechnung der Taylor-Reihe für den Sinus
    // Sinusreihe:
    // sin(x) = x - (x^3)/3! + (x^5)/5! - (x^7)/7! + (x^9)/9! ....

    public static double sinusReihe(double x, int terme) {
        double ergebnis = 0.0;  // Variable für das Ergebnis der Reihe
        double term = x;        // Der erste Term der Taylor-Reihe ist x
        int vorzeichen = 1;     // Das Vorzeichen der Terme wechselt (+1, -1, ...)

        // Die Schleife durchläuft die Anzahl der gewünschten Terme
        for (int n = 1; n <= terme; n++) {
            ergebnis += vorzeichen * term; // Addiere den aktuellen Term (mit Vorzeichen) zum Ergebnis
            vorzeichen *= -1;              // Vorzeichen für den nächsten Term wechseln

            // Berechne den nächsten Term der Reihe (x^n / n!)
            term *= (x * x) / (2 * n * (2 * n + 1));
        }

        return ergebnis;  // Gib das berechnete Ergebnis für sin(x) zurück
    }

    // Methode zur Berechnung der Taylor-Reihe für den Kosinus
    // Cosinusreihe:
    // cos(x) = 1 - (x^2)/2! + (x^4)/4! - (x^6)/6! + (x^8)/8! ...

    public static double cosinusReihe(double x, int terme) {
        double ergebnis = 1.0;  // Der erste Term der Kosinusreihe ist 1
        double term = 1.0;      // Startwert für die Berechnung der weiteren Terme
        int vorzeichen = -1;    // Das Vorzeichen wechselt zwischen -1 und +1

        // Schleife für die Anzahl der Terme
        for (int n = 1; n <= terme; n++) {
            // Berechne den aktuellen Term der Reihe (x^2n / (2n)!)
            term *= (x * x) / (2 * n * (2 * n - 1));

            // Addiere den Term (mit Vorzeichen) zum Ergebnis
            ergebnis += vorzeichen * term;

            // Vorzeichen für den nächsten Term wechseln
            vorzeichen *= -1;
        }

        return ergebnis;  // Gib das berechnete Ergebnis für cos(x) zurück
    }

    // Methode zur Berechnung der Taylor-Reihe für die Exponentialfunktion (e^x)
    // Eulerreihe:
    // e^x = 1 + x + (x^2)/2! + (x^3)/3! + (x^4)/4! + (x^5)/5! ...

    public static double eulerReihe(double x, int terme) {
        double ergebnis = 1.0;  // Der erste Term der Eulerreihe ist 1
        double term = 1.0;      // Startwert für die Berechnung der weiteren Terme

        // Schleife für die Anzahl der Terme
        for (int n = 1; n <= terme; n++) {
            // Berechne den aktuellen Term der Reihe (x^n / n!)
            term *= x / n;

            // Addiere den aktuellen Term zum Ergebnis
            ergebnis += term;
        }

        return ergebnis;  // Gib das berechnete Ergebnis für e^x zurück
    }

    // Methode zum Zeichnen der Funktionen im GUI.
    // Diese Methode wird bei der Aktualisierung des Fensters aufgerufen.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Ruft die paintComponent-Methode der Superklasse auf, um das Standardzeichnen zu ermöglichen

        // Setze die Hintergrundfarbe auf Weiß und fülle den gesamten Bereich
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Zeichne die Achsen (X- und Y-Achse) auf dem Panel
        drawAxes(g);

        // Zeichne die Taylor-Reihen für Sinus, Kosinus und Euler in verschiedenen Farben
        drawFunction(g, Color.RED, true, false);   // Zeichne die Sinusreihe in Rot
        drawFunction(g, Color.BLUE, false, false); // Zeichne die Kosinusreihe in Blau
        drawFunction(g, Color.GREEN, false, true); // Zeichne die Eulerreihe (e^x) in Grün
    }

    // Methode zum Zeichnen der X- und Y-Achsen im GUI
    private void drawAxes(Graphics g) {
        int width = getWidth();  // Breite des Panels
        int height = getHeight(); // Höhe des Panels
        int arrowSize = 10; // Größe der Pfeilspitzen der Grafik

        // X-Achse: Eine horizontale Linie in der Mitte des Fensters
        g.setColor(Color.BLACK);  // Setze die Linienfarbe auf Schwarz
        g.drawLine(0, height / 2, width, height / 2);  // Zeichne eine Linie für die X-Achse

        // Y-Achse: Eine vertikale Linie in der Mitte des Fensters
        g.drawLine(width / 2, 0, width / 2, height);  // Zeichne eine Linie für die Y-Achse

        // Beschriftung der Achsen
        g.setFont(new Font("Arial", Font.PLAIN, 16)); // Setze die Schriftart für die Beschriftungen

        // X-Achse beschriften (x)
        g.drawString("x", width - 20, height / 2 + 15);  // Platziere "x" am rechten Rand der X-Achse

        // Y-Achse beschriften (y)
        g.drawString("y", width / 2 - 15, 20);  // Platziere "y" oben auf der Y-Achse

        // Zeichne Pfeilspitze für die X-Achse (rechts)
        g.drawLine(width - arrowSize, height / 2 - arrowSize, width, height / 2);  // Linker Schenkel
        g.drawLine(width - arrowSize, height / 2 + arrowSize, width, height / 2);  // Rechter Schenkel

        // Zeichne Pfeilspitze für die Y-Achse (oben)
        g.drawLine(width / 2 - arrowSize, arrowSize, width / 2, 0);  // Linker Schenkel
        g.drawLine(width / 2 + arrowSize, arrowSize, width / 2, 0);  // Rechter Schenkel
    }

    // Methode zum Zeichnen der Funktion (Sinus, Kosinus oder Euler).
    // Die Auswahl, welche Funktion gezeichnet wird, erfolgt über die isSinus und isEuler Flags.
    private void drawFunction(Graphics g, Color color, boolean isSinus, boolean isEuler) {
        g.setColor(color);  // Setze die Farbe, mit der die Funktion gezeichnet wird

        // Skalierungsfaktoren für die Grafik (wie stark X und Y vergrößert werden)
        int width = getWidth();  // Breite des Panels
        int height = getHeight(); // Höhe des Panels
        int scaleX = 50;  // Skalierung in X-Richtung (ein Punkt = 50 Pixel)
        int scaleY = 100; // Skalierung in Y-Richtung (ein Punkt = 100 Pixel)

        // Berechnung und Zeichnung der Punkte
        for (int i = -width / 2; i < width / 2; i++) {
            double x = i / (double) scaleX;  // Berechne den X-Wert des Punktes im realen Bereich
            double y;  // Variable für den berechneten Y-Wert

            // Wähle die entsprechende Funktion für die Berechnung des Y-Wertes (Sinus, Kosinus oder Euler)
            if (isEuler) {
                y = eulerReihe(x, TERME);  // Berechne die Euler-Taylor-Reihe (e^x)
            } else if (isSinus) {
                y = sinusReihe(x, TERME);  // Berechne die Sinus-Taylor-Reihe
            } else {
                y = cosinusReihe(x, TERME);  // Berechne die Kosinus-Taylor-Reihe
            }

            // Skalierung der Koordinaten und Anpassung an die Mitte des Fensters
            int pixelX = i + width / 2;  // Verschiebe X in die Mitte des Fensters
            int pixelY = height / 2 - (int) (y * scaleY);  // Berechne die Y-Koordinate und verschiebe sie in die Mitte

            // Zeichne den berechneten Punkt auf dem Panel
            g.fillOval(pixelX, pixelY, 2, 2);  // Zeichne einen kleinen Punkt (2x2 Pixel)
        }
    }

    // Hauptprogramm zur Ausführung der Berechnungen und zum Erstellen des GUI-Fensters
    public static void main(String[] args) {
        double x = 1.0;  // Der Wert von x, für den die Taylor-Reihen berechnet werden
        int terme = 20;  // Anzahl der Terme, die für die Taylor-Reihen verwendet werden

        // Berechne die Sinusreihe, Kosinusreihe und Eulerreihe für x
        double sinusWerte = sinusReihe(x, terme);
        double cosinusWerte = cosinusReihe(x, terme);
        double eulerWerte = eulerReihe(x, terme);

        // Ausgabe der berechneten Werte und der Vergleichswerte aus der Java Math-Bibliothek
        System.out.println("Taylorreihe für sin(" + x + "): " + sinusWerte);
        System.out.println("Vergleichswert aus Math.sin(" + x + "): " + Math.sin(x));
        System.out.println("Taylorreihe für cos(" + x + "): " + cosinusWerte);
        System.out.println("Vergleichswert aus Math.cos(" + x + "): " + Math.cos(x));
        System.out.println("Taylorreihe für e^x: " + eulerWerte);
        System.out.println("Vergleichswert aus Math.exp(" + x + "): " + Math.exp(x));

        // Erstelle ein JFrame-Fenster für die grafische Darstellung der Funktionen
        JFrame frame = new JFrame("Taylor-Reihen: Sinus, Kosinus und Euler");

        // Erstelle das Panel, auf dem die Funktionen gezeichnet werden, und füge es dem Fenster hinzu
        Taylorreihe graphPanel = new Taylorreihe();
        frame.add(graphPanel);

        // Setze die Größe des Fensters und einige grundlegende Einstellungen
        frame.setSize(800, 600);  // Setze die Fenstergröße
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Beende das Programm, wenn das Fenster geschlossen wird
        frame.setLocationRelativeTo(null);  // Zentriere das Fenster auf dem Bildschirm
        frame.setVisible(true);  // Zeige das Fenster an
    }
}