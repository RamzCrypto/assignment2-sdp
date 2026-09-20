package com.logistics;

import com.logistics.transport.Logistics;
import com.logistics.transport.RoadLogistics;
import com.logistics.transport.SeaLogistics;
import com.logistics.ui.GUIFactory;
import com.logistics.ui.MacOSFactory;
import com.logistics.ui.WindowsFactory;

import java.util.Scanner;

public class Main {

    private static final String SAMPLE_CARGO = "laboratory equipment";
    private static final String SAMPLE_DESTINATION = "Aktau warehouse";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Logistics logistics = readLogistics(scanner);
        if (logistics == null) {
            System.out.println("Stopping: invalid delivery mode.");
            return;
        }

        GUIFactory guiFactory = readGUIFactory(scanner);
        if (guiFactory == null) {
            System.out.println("Stopping: invalid UI platform.");
            return;
        }

        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);
        app.run(SAMPLE_CARGO, SAMPLE_DESTINATION);

        scanner.close();
    }

    private static Logistics readLogistics(Scanner scanner) {
        System.out.print("Enter delivery mode (ROAD/SEA): ");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equals("ROAD")) {
            return new RoadLogistics();
        } else if (input.equals("SEA")) {
            return new SeaLogistics();
        } else {
            System.out.println("Unsupported delivery mode: " + input);
            return null;
        }
    }

    private static GUIFactory readGUIFactory(Scanner scanner) {
        System.out.print("Enter UI platform (WINDOWS/MACOS): ");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equals("WINDOWS")) {
            return new WindowsFactory();
        } else if (input.equals("MACOS")) {
            return new MacOSFactory();
        } else {
            System.out.println("Unsupported UI platform: " + input);
            return null;
        }
    }
}