package dotcom.com.sam.request;

import java.util.List;

/**
 * Created by sanjay on 10/25/2017.
 */

public class ProductfilterdataRequest {


    /**
     * SearchBox : sample string 1
     * PageNumber : 2
     * ProductCount : sample string 3
     * CheckboxPrice : sample string 4
     * CheckboxBrand : [1,1]
     * CheckboxCategory : [1,1]
     * CheckboxBreed : [1,1]
     * CheckboxAge : ["sample string 1","sample string 2"]
     * CheckboxFoodType : ["sample string 1","sample string 2"]
     * CheckboxProductType : ["sample string 1","sample string 2"]
     */

    private String SearchBox;
    private int PageNumber;
    private String ProductCount;
    private String CheckboxPrice;
    private List<Integer> CheckboxBrand;
    private List<Integer> CheckboxCategory;
    private List<Integer> CheckboxBreed;
    private List<String> CheckboxAge;
    private List<String> CheckboxFoodType;
    private List<String> CheckboxProductType;

    public String getSearchBox() {
        return SearchBox;
    }

    public void setSearchBox(String SearchBox) {
        this.SearchBox = SearchBox;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int PageNumber) {
        this.PageNumber = PageNumber;
    }

    public String getProductCount() {
        return ProductCount;
    }

    public void setProductCount(String ProductCount) {
        this.ProductCount = ProductCount;
    }

    public String getCheckboxPrice() {
        return CheckboxPrice;
    }

    public void setCheckboxPrice(String CheckboxPrice) {
        this.CheckboxPrice = CheckboxPrice;
    }

    public List<Integer> getCheckboxBrand() {
        return CheckboxBrand;
    }

    public void setCheckboxBrand(List<Integer> CheckboxBrand) {
        this.CheckboxBrand = CheckboxBrand;
    }

    public List<Integer> getCheckboxCategory() {
        return CheckboxCategory;
    }

    public void setCheckboxCategory(List<Integer> CheckboxCategory) {
        this.CheckboxCategory = CheckboxCategory;
    }

    public List<Integer> getCheckboxBreed() {
        return CheckboxBreed;
    }

    public void setCheckboxBreed(List<Integer> CheckboxBreed) {
        this.CheckboxBreed = CheckboxBreed;
    }

    public List<String> getCheckboxAge() {
        return CheckboxAge;
    }

    public void setCheckboxAge(List<String> CheckboxAge) {
        this.CheckboxAge = CheckboxAge;
    }

    public List<String> getCheckboxFoodType() {
        return CheckboxFoodType;
    }

    public void setCheckboxFoodType(List<String> CheckboxFoodType) {
        this.CheckboxFoodType = CheckboxFoodType;
    }

    public List<String> getCheckboxProductType() {
        return CheckboxProductType;
    }

    public void setCheckboxProductType(List<String> CheckboxProductType) {
        this.CheckboxProductType = CheckboxProductType;
    }
}
