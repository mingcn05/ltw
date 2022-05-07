package ltw.model;

import java.text.NumberFormat;

import lombok.Data;

@Data
public class Product  {

    private String code;
    private String description;
    private float price;

    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    public Product(String code, String description, float price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getFormat() {
    	NumberFormat nf = NumberFormat.getCurrencyInstance();
    	return nf.format(this.price);
    }

}
