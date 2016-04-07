package app.portfolio.ordering.Model;

/**
 * Created by dione on 04/04/2016.
 */
public class Products {
    public Products(String productName, int productImage){
        this.productName = productName;
        this.productImage = productImage;
    }
    private String productName;
    private int productImage;

    public String getProductName() {
        return productName;
    }

    public int getProductImage() {
        return productImage;
    }
}
