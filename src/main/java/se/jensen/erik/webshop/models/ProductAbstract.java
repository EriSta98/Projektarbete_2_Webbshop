package se.jensen.erik.webshop.models;

public abstract class ProductAbstract {

    //  *** Denna klass är en abstrakt klass som agerar som en mall för alla produkter, KAN EJ SKAPAS BARA ÄRVAS!! *** //

    // Fält
    private String articleNumber;
    private String title;
    private String description;
    private int price;




    // ** Getters **
    public String getArticleNumber() { return articleNumber; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }

    // ** Setters **
    public void setArticleNumber(String articleNumber) { this.articleNumber = articleNumber; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(int price) { this.price = price; }





    // ** Abstrakt metod, varje subklass ska använda den. **
    public abstract String category();
}
