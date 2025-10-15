package se.jensen.erik.webshop;
import se.jensen.erik.webshop.models.Books;
import se.jensen.erik.webshop.models.Clothing;
import se.jensen.erik.webshop.models.Electronics;
import se.jensen.erik.webshop.models.ProductAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<ProductAbstract> products = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean running = true;

        while(running){
            System.out.println("\n--- WEBSHOP ---");
            System.out.println("1. Lägg till produkt");
            System.out.println("2. Lista alla produkter");
            System.out.println("3. Visa produktinfo");
            System.out.println("4. Avsluta");
            System.out.println("Välj: ");

            int choice = input.nextInt();
            input.nextLine(); // Töm Scanner

            // -> är en switch syntax, fungerar samma som case + break. Men ser lite renare och snyggare ut.
            switch (choice){
                case 1 -> addProduct(products, input);
                case 2 -> listProducts(products);
                case 3 -> showProductInfo(products, input);
                case 4 -> running = false;
                default -> System.out.println("Ogiltigt val!");
            }
        }
        input.close(); // Stäng scannern
    }

    // ** Metod för att lägga till produkter
    public static void addProduct(List<ProductAbstract> products, Scanner input) {
        System.out.println("Vilken typ av produkt vill du lägga till?");
        System.out.println("1. Bok");
        System.out.println("2. Kläder");
        System.out.println("3. Elektronik");
        System.out.println("Val: ");

        int type = input.nextInt();
        input.nextLine(); // Töm Scanner

        System.out.println("Artikelnummer: ");
        String articleNumber = input.nextLine();

        System.out.println("Titel: ");
        String title = input.nextLine();

        System.out.println("Beskrivning: ");
        String description = input.nextLine();

        System.out.println("Pris: ");
        int price = input.nextInt();
        input.nextLine(); // Töm Scanner

        // Vi sätter null på objektet då användaren inte har bestämt vilken typ av produkt som ska läggas till
        ProductAbstract p = null;


        switch (type) {
            case 1 -> p = new Books(articleNumber, title, description, price);
            case 2 -> p = new Clothing(articleNumber, title, description, price);
            case 3 -> p = new Electronics(articleNumber, title, description, price);
            default -> System.out.println("Felaktig produkttyp!");
        }
         if (p != null) {
            products.add(p);
             System.out.println("Produkt tillagd!");
         }
    }
    // ** Metod för att lista alla produkter
    public static void listProducts(List<ProductAbstract> products){
        if (products.isEmpty()) {
            System.out.println("Inga produkter tillagda ännu.");
            return;
        }

        for(ProductAbstract p : products){
            System.out.println(p.getArticleNumber() + " - " + p.getTitle() + " (" + p.getDescription() + ") " + p.getPrice() + " Kr");
        }
    }

    // ** Metod för att visa produktinfo om artikelnumret finns
    public static void showProductInfo(List<ProductAbstract> products, Scanner input) {
        System.out.println("Ange artikelnummer: ");
        String search = input.nextLine();
        boolean found = false;

        // ** Sök igenom listan för att se om artikelnumret finns.
        for (ProductAbstract p : products) {
            if (p.getArticleNumber().equals(search)) {
                System.out.println("Kategori: " + p.category());
                System.out.println("Titel: " + p.getTitle());
                System.out.println("Beskrivning: " + p.getDescription());
                System.out.println("Pris: " + p.getPrice()+ " Kr");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Ingen produkt hittades med det artikelnumret.");
        }
    }
}
