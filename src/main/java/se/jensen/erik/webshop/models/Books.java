package se.jensen.erik.webshop.models;

public class Books extends ProductAbstract{

    // ** Ärva från abstrakta klassen
    // ** Använda metoden Category()
    // ** Konstruktor för att sätta fält


    public Books(String articleNumber, String title, String description, int price) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setDescription(description);
        setPrice(price);
    }


    // ** Abstrakt metod, måste användas för att identifiera klassens användningsområde. **
    @Override
    public String category() {
        return "Books";
    }
}
