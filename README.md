# Fragen
## Vorteile sowie Nachteile von NoSQL

Vorteile:
  * Flexible, schemalose Struktur (ideal für JSON).
  * Skalierbarkeit über mehrere Server (horizontal).
  * Gute Performance bei großen Datenmengen.
  * Leicht anpassbar bei Strukturänderungen.

Nachteile:
  * Keine ACID-Transaktionen wie in RDBMS.
  * Schwache Konsistenz (eventual consistency).
  * Komplexere Abfragen oft schwieriger umzusetzen.
  * Kein Standard (wie SQL), jeder NoSQL-Typ anders.

## CAP-Theorem
  * C (Consistency): Alle Knoten sehen zur gleichen Zeit dieselben Daten.
  * A (Availability): Jeder Request erhält eine Antwort (auch ohne Konsistenz).
  * P (Partition Tolerance): Das System funktioniert trotz Netzwerkpartitionen.

MongoDB ist ein CP-System (Consistency + Partition Tolerance).