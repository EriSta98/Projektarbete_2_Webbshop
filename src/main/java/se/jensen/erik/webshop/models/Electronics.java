package se.jensen.erik.webshop.models;

public class Electronics extends ProductAbstract{

    public Electronics(String articleNumber, String title, String description, int price){
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
