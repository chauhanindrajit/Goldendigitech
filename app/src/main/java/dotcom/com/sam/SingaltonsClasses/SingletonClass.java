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
        return brand;
    }
    public ArrayList<Integer> getCatidlist() {
        return catidlist;
    }
    public ArrayList<Integer> getBreedidlist() {
        return breedidlist;
    }
    public ArrayList<String> getPricename() {
        return pricename;
    }
    public ArrayList<String> getAgename() {
        return Agename;
    }


    public void setBrandIdList(ArrayList<Integer> brandIdList) {
        this.brand = brandIdList;
    }

    ArrayList<Integer> brand = new ArrayList<>();
    ArrayList<Integer> catidlist = new ArrayList<>();
    ArrayList<Integer> breedidlist = new ArrayList<>();
    ArrayList<String> pricename = new ArrayList<>();
    ArrayList<String> Agename = new ArrayList<>();



    public boolean isFilterApply() {
        return isFilterApply;
    }

    public void setFilterApply(boolean filterApply) {
        isFilterApply = filterApply;
    }
    private String Date;
    private String Time;
    private String Activityname;
    private String Centername;
    private String Message;
    private String SRID;
    boolean isFilterApply;

    //-----------------brand filter

    public boolean addcatId(int id) {
        Log.e(TAG, "brand size : " + catidlist.size());
        check = false;
        int a = catidlist.size();
        if (catidlist.size() > 0) {
            for (int i = 0; i < a; i++) {
                if (id == catidlist.get(i)) {
                    catidlist.set(i, id);
                    check = true;
                    return a == catidlist.size();
                }
            }
        }
        if (!check) {
            catidlist.add(id);
            check = false;
            return a < catidlist.size();
        }
        return false;
    }

    public void removecatId(int brand_id) {
        if (catidlist.size() > 0) {
            for (int i = 0; i < catidlist.size(); i++) {
                if (brand_id == catidlist.get(i)) {
                    catidlist.remove(i);
                }
            }
        }
    }

    public boolean addBrand(int id) {
        Log.e(TAG, "brand size : " + brand.size());
        check = false;
        int a = brand.size();
        if (brand.size() > 0) {
            for (int i = 0; i < a; i++) {
                if (id == brand.get(i)) {
                    brand.set(i, id);
                    check = true;
                    return a == brand.size();
                }
            }
        }
        if (!check) {
            brand.add(id);
            check = false;
            return a < brand.size();
        }
        return false;
    }

    public void removeBrand(int brand_id) {
        if (brand.size() > 0) {
            for (int i = 0; i < brand.size(); i++) {
                if (brand_id == brand.get(i)) {
                    brand.remove(i);
                }
            }
        }
    }
    public boolean addBreedId(int id) {
        Log.e(TAG, "brand size : " + breedidlist.size());
        check = false;
        int a = breedidlist.size();
        if (breedidlist.size() > 0) {
            for (int i = 0; i < a; i++) {
                if (id == breedidlist.get(i)) {
                    breedidlist.set(i, id);
                    check = true;
                    return a == breedidlist.size();
                }
            }
        }
        if (!check) {
            breedidlist.add(id);
            check = false;
            return a < breedidlist.size();
        }
        return false;
    }

    public void removeBreedId(int brand_id) {
        if (breedidlist.size() > 0) {
            for (int i = 0; i < breedidlist.size(); i++) {
                if (brand_id == breedidlist.get(i)) {
                    breedidlist.remove(i);
                }
            }
        }
    }


    public boolean addPricename(String name) {
        check = false;
        int a = pricename.size();
        if (pricename.size() > 0) {
            for (int i = 0; i < a; i++) {
                if (name == pricename.get(i)) {
                    pricename.set(i, name);
                    check = true;
                    return a == pricename.size();
                }
            }
        }
        if (!check) {
            pricename.add(name);
            check = false;
            return a < pricename.size();
        }
        return false;


    }

    public void removepricename(String name) {
        check = false;
        if (pricename.size() > 0) {
            for (int i = 0; i < pricename.size(); i++) {
                if (name == pricename.get(i)) {
                    pricename.remove(i);
                }
            }
        }
    }

    public boolean addAgename(String name) {
        check = false;
        int a = Agename.size();
        if (Agename.size() > 0) {
            for (int i = 0; i < a; i++) {
                if (name == Agename.get(i)) {
                    Agename.set(i, name);
                    check = true;
                    return a == Agename.size();
                }
            }
        }
        if (!check) {
            Agename.add(name);
            check = false;
            return a < Agename.size();
        }
        return false;


    }

    public void removeAgename(String name) {
        check = false;
        if (Agename.size() > 0) {
            for (int i = 0; i < Agename.size(); i++) {
                if (name == Agename.get(i)) {
                    Agename.remove(i);
                }
            }
        }
    }

    public boolean clearReport() {
        brand.clear();
        return brand.size() == 0;
    }

    public String getBrandFilter() {
        String str = null;
        for (int i = 0; i < brand.size(); i++) {
            if (i == 0)
                str = String.valueOf(brand.get(i));
            else
                str = str + "," + brand.get(i);
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


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getActivityname() {
        return Activityname;
    }

    public void setActivityname(String activityname) {
        Activityname = activityname;
    }

    public String getSRID() {
        return SRID;
    }

    public void setSRID(String SRID) {
        this.SRID = SRID;
    }

    public String getCentername() {
        return Centername;
    }

    public void setCentername(String centername) {
        Centername = centername;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
