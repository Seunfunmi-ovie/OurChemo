package ng.ourChemo.data.models;

import java.util.ArrayList;
import java.util.List;

public class Drug {

    private int id;
    private String name;
    private List<Batch> batches = new ArrayList<>();
    private String brand;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }
}
