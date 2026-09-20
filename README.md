# Logistics App — Factory Method & Abstract Factory

Console Java app demonstrating two design patterns:
- **Factory Method** — creates Truck (road) or Ship (sea) transport.
- **Abstract Factory** — creates matching Windows or macOS UI (Button + Checkbox).

## Requirements
- JDK 17+

## Build & Run

javac -d out $(find src -name "*.java")
java -cp out com.logistics.Main

Or run `Main.main()` in IntelliJ IDEA.

## Inputs
- Delivery mode: ROAD or SEA
- UI platform: WINDOWS or MACOS
- Case-insensitive; invalid or empty input stops the program with a message.

## Sample Run

Enter delivery mode (ROAD/SEA): ROAD
Enter UI platform (WINDOWS/MACOS): WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse

## Verification

| # | Input | Result | Status |
|---|-------|--------|--------|
| 1 | ROAD + WINDOWS | Truck, Windows UI | PASS |
| 2 | SEA + WINDOWS | Ship, Windows UI | PASS |
| 3 | ROAD + MACOS | Truck, macOS UI | PASS |
| 4 | SEA + MACOS | Ship, macOS UI | PASS |
| 5 | FLY + WINDOWS | Error, stops | PASS |
| 6 | ROAD + LINUX | Error, stops | PASS |
| 7 | empty input | Error, stops | PASS |

## Submitted Commit

730695c