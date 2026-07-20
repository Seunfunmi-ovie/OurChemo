package ng.ourChemo.dtos.requests;

public class UpdateDrugRequest {
    private String drugName;
    private String drugBrand;
    private int drugPrice;
    private int drugId;
    public String getDrugName(){
        return drugName;
    }
    public void setDrugName(String drugName){
        this.drugName = drugName;
    }
    public String getDrugBrand(){
        return drugBrand;
    }

    public void setDrugBrand(String drugBrand) {
        this.drugBrand = drugBrand;
    }

    public int getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(int drugPrice) {
        this.drugPrice = drugPrice;
    }
    public int getDrugId(){
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }
}
