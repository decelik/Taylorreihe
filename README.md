# Taylor-Reihe Berechnungen und Visualisierung

Dieses Java-Programm berechnet und visualisiert die Taylor-Reihen für die Funktionen Sinus, Kosinus und die Exponentialfunktion \( e^x \). Es bietet sowohl eine numerische Berechnung der Reihen als auch eine grafische Darstellung der Funktionen.

## Funktionen

Das Programm beinhaltet folgende Taylor-Reihen:

- **Sinusreihe:**  
  sin(x) = x - (x^3) / 3! + (x^5) / 5! - (x^7) / 7! + ...

- **Kosinusreihe:**  
  cos(x) = 1 - (x^2) / 2! + (x^4) / 4! - (x^6) / 6! + ...

- **Exponentialreihe (Euler-Reihe):**  
  e^x = 1 + x + (x^2) / 2! + (x^3) / 3! + ...

## Funktionsweise

1. **Numerische Berechnungen**:
   - Berechnet für eine gegebene Anzahl an Termen die Werte der Taylor-Reihen für Sinus, Kosinus und e^x.
   - Vergleicht die berechneten Werte mit den Standardwerten der Java `Math`-Bibliothek (`Math.sin()`, `Math.cos()`, `Math.exp()`).

2. **Grafische Darstellung**:
   - Zeigt die berechneten Taylor-Reihen grafisch in einem Fenster an.
   - Es werden die Sinus-, Kosinus- und Exponentialreihen in verschiedenen Farben auf einem Koordinatensystem dargestellt.

## Verwendung

1. Beim Start des Programms werden die Werte der Taylor-Reihen für x = 1.0 mit 20 Termen berechnet und ausgegeben.
2. Ein GUI-Fenster öffnet sich, das die grafische Darstellung der Funktionen zeigt.

## Systemanforderungen

- Java Development Kit (JDK)
- Eine Entwicklungsumgebung oder eine Konsole zur Ausführung des Programms

## Start des Programms

Führe die `main()`-Methode in einer Java-Umgebung aus, um das Programm zu starten.
