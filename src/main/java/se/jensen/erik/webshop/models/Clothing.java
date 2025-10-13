package se.jensen.erik.webshop.models;

public class Clothing extends ProductAbstract{

    public Clothing(String articleNumber, String title, String description, int price){
        setArticleNumber(articleNumber);
        setTitle(title);
        setDescription(description);
        setPrice(price);
    }

    @Override
    public String category() {
        return "Clothing";
    }
}
