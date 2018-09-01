package dotcom.com.sam.SingaltonsClasses;

import android.util.Log;



import java.util.ArrayList;

import dotcom.com.sam.Response.ProductResponse;

import static android.content.ContentValues.TAG;

/**
 * Created by admin on 2/17/2017.
 */
public class SingletonClass {
    private boolean check;

    public ProductResponse getProductResponse() {
        return productResponse;
    }

    public void setProductResponse(ProductResponse productResponse) {
        this.productResponse = productResponse;
    }

    ProductResponse productResponse;
    private static SingletonClass ourInstance = new SingletonClass();

    public static SingletonClass getInstance() {
        return ourInstance;
    }

    public ArrayList<Integer> getBrandIdList() {
        return brandIdList;
    }
    public ArrayList<String> getBrandname() {
        return brandname;
    }

    public void setBrandIdList(ArrayList<Integer> brandIdList) {
        this.brandIdList = brandIdList;
    }

    ArrayList<Integer> brandIdList = new ArrayList<>();
    ArrayList<String> brandname = new ArrayList<>();


    public boolean isFilterApply() {
        return isFilterApply;
    }

    public void setFilterApply(boolean filterApply) {
        isFilterApply = filterApply;
    }

    boolean isFilterApply;

    //-----------------brand filter

    public boolean addBrandId(int id) {
        Log.e(TAG, "brand size : " + brandIdList.size());
        check = false;
        int a = brandIdList.size();
        if (brandIdList.size() > 0) {
            for (int i = 0; i < a; i++) {
                if (id == brandIdList.get(i)) {
                    brandIdList.set(i, id);
                    check = true;
                    return a == brandIdList.size();
                }
            }
        }
        if (!check) {
            brandIdList.add(id);
            check = false;
            return a < brandIdList.size();
        }
        return false;
    }

    public void removeBrandId(int brand_id) {
        if (brandIdList.size() > 0) {
            for (int i = 0; i < brandIdList.size(); i++) {
                if (brand_id == brandIdList.get(i)) {
                    brandIdList.remove(i);
                }
            }
        }
    }

    public boolean addBrandname(String name) {
        check = false;
        int a = brandname.size();
        if (brandname.size() > 0) {
            for (int i = 0; i < a; i++) {
                if (name == brandname.get(i)) {
                    brandname.set(i, name);
                    check = true;
                    return a == brandname.size();
                }
            }
        }
        if (!check) {
            brandname.add(name);
            check = false;
            return a < brandname.size();
        }
        return false;


    }

    public void removeBrandname(String name) {
        check = false;
        if (brandname.size() > 0) {
            for (int i = 0; i < brandname.size(); i++) {
                if (name == brandname.get(i)) {
                    brandname.remove(i);
                }
            }
        }
    }

    public boolean clearReport() {
        brandIdList.clear();
        return brandIdList.size() == 0;
    }

    public String getBrandFilter() {
        String str = null;
        for (int i = 0; i < brandIdList.size(); i++) {
            if (i == 0)
                str = String.valueOf(brandIdList.get(i));
            else
                str = str + "," + brandIdList.get(i);
        }
        return str;
    }

    //---------------price filter
    int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    int max;

    public boolean clearPriceF() {
        setMax(5000);
        setMin(0);
        return true;
    }


    //---------------sort by price
    String sortBy="";

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean clearSortBy() {
        sortBy = "0";
        return true;
    }


    private SingletonClass() {
    }


}
