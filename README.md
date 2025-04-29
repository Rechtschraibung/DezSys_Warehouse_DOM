# Projektdokumentation / Protokoll
**Thema**: Dokumentenorientierte Middleware mit Spring Boot und MongoDB

## 1. Voraussetzungen
  * Java 17 oder höher
  * Docker installiert (für MongoDB)
  * Spring Boot Projekt (gegeben im Repository)
  * Gradle installiert (oder Wrapper benutzen)

## 2. Installation und Setup
MongoDB Container starten:
```shell
docker pull mongo
docker run -d -p 27017:27017 --name mongo mongo
```
Mongo Shell starten (optional, zum Überprüfen):
```shell
docker exec -it mongo bash
mongosh
```
Spring Boot anwendung starten
```shell
gradle clean bootRun
```

## 3. Änderungen und Erweiterungen
Einführung von zwei separaten Entitäten:
  * `ProductData`: Für Produkte
  * `Warehouse`: Für Lagerhäuser

Erstellung von zwei Services:
  * `ProductService`: Verwaltung von Produkten
  * `WarehouseService`: Verwaltung von Lagerhäusern

Anpassung der `Application`-Klasse:
  * `Application` nutzt nur `ProductService` und `WarehouseService`.
  * Beim Start werden automatisch Testdaten erzeugt:
    * 3 Lagerhäuser
    * 10 Produkte

REST API Endpunkte:
  * `/warehouse` für Lagerhäuser
    * `POST`, `GET`, `GET/{id}`, `DELETE/{id}`
  * /product für Produkte
    * `POST`, `GET`, `GET/{id}`, `DELETE/{id}`

## 4. Besonderheiten
* MongoDB generiert die IDs (_id) automatisch.
* ProductData enthält keine separate productID mehr, nur die MongoDB-ID.
* Zugriffe auf Produkte und Lagerhäuser erfolgen über die Mongo-ID (id).

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

## Schwierigkeiten bei der Zusammenführung von Daten:
  * Unterschiedliche Datenformate
  * Zeitverzögerungen bei Datenübertragung
  * Konflikte bei Bestandsänderungen
  * Mehrdeutige oder doppelte IDs

## Arten von NoSQL-Datenbanken:
  * Dokumentenorientiert: MongoDB
  * Key-Value Store: Redis
  * Spaltenorientiert: Apache Cassandra
  * Graphdatenbank: Neo4j

## CAP-Theorem
  * C (Consistency): Alle Knoten sehen zur gleichen Zeit dieselben Daten.
  * A (Availability): Jeder Request erhält eine Antwort (auch ohne Konsistenz).
  * P (Partition Tolerance): Das System funktioniert trotz Netzwerkpartitionen.

MongoDB ist ein CP-System (Consistency + Partition Tolerance).

## Befehl für Lagerbestand eines Produktes über alle Lagerstandorte:
```mongodb-json
db.productData.aggregate([
  { $match: { productName: "Bio Orangensaft Sonne" } },
  { $group: { _id: "$productName", totalQuantity: { $sum: "$productQuantity" } } }
])
```

## Befehl für Lagerbestand eines Produktes an einem bestimmten Lagerstandort:
```mongodb-json
db.productData.find({
  warehouseID: "1",
  productName: "Bio Orangensaft Sonne"
})
```
