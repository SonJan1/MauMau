# Mau Mau Automat
Einleitung
Der "Mau Mau Automat" ist eine Java-Konsolenanwendung, die das Kartenspiel "Mau Mau" ermöglicht. Das Spiel verwendet ein Standard-Skatkartenblatt und ermöglicht es, mit bis zu drei Spielern gleichzeitig zu spielen, wobei jeder Spieler entweder ein menschlicher Spieler oder ein computergesteuerter Spieler sein kann.

# Installation
Die Anwendung erfordert eine JDK-Version 11 oder höher.

- Laden Sie das Projekt von GitHub herunter oder klonen Sie es mit Git:
`git clone https://github.com/SonJan1/MauMau.git`
- Öffnen Sie das Projekt in Ihrer bevorzugten Entwicklungsumgebung (z. B. IntelliJ IDEA, Eclipse).
- Stellen Sie sicher, dass Ihre IDE auf JDK 11 oder höher eingestellt ist.
- Führen Sie das Spiel aus der Hauptklasse Main aus.

# Spielanleitung
Es können bis zu drei Spieler teilnehmen:

- Spieler 1: Menschlicher Spieler
- Spieler 2: Kann entweder ein menschlicher Spieler oder ein computergesteuerter Spieler sein
- Spieler 3: Computergesteuerter Spieler
Die Art der Spieler (menschlich oder Computer) wird beim Start des Spiels festgelegt.

# Starten eines Spiels
Um ein Spiel zu starten, müssen Sie die gewünschten Spieler hinzufügen:
- Menschlicher Spieler hinzufügen:
`game.addHumanPlayer("Spielername", true);`

Der zweite Parameter true bedeutet, dass der Spieler menschlich ist.
- Computergesteuerter Spieler hinzufügen:
`game.addHumanPlayer("Spielername", false);`

Der zweite Parameter false bedeutet, dass der Spieler computergesteuert ist.

# Spielablauf
- Mischen: Das Kartendeck wird gemischt, bevor das Spiel beginnt.
- Karten austeilen: Jeder Spieler erhält 5 Karten vom gemischten Deck. Die restlichen Karten bleiben im Stapel, und die oberste Karte wird aufgedeckt.
- Spielregeln: Die Regeln des Spiels finden Sie unter [Mau Mau Regeln](https://www.gamedesign.de/mau-mau).
- Spielstart: Ein Spieler wird zufällig ausgewählt, um das Spiel zu beginnen.
- Spielende: Nachdem ein Spieler gewonnen hat, spielen die verbleibenden Spieler um den zweiten und dritten Platz.

# Verwalten der Spieler
- Spieler entfernen:
`game.removeHumanPlayer("Spielername");`

Entfernt den Spieler mit dem angegebenen Namen aus dem Spiel.

- Spieler ersetzen (z. B. von menschlich zu Computer):
`game.removeHumanPlayer("Spielername");`
`game.addHumanPlayer("Spielername", false);`  _Fügt einen computergesteuerten Spieler hinzu_

# Statistiken
Eine einfache Statistik wird für jeden Spieler geführt, einschließlich Anzahl der Siege und Summe der Punkte der Restkarten beim Verlieren.