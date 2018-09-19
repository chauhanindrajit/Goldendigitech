package dotcom.com.sam.SingaltonsClasses;



import java.io.Serializable;
import java.util.ArrayList;

import dotcom.com.sam.Response.ProductListResponse;

/**
 * Created by Dotcom on 2/23/2017.
 */

public class ProductSinglton implements Serializable {
    private static ProductSinglton ourInstance = new ProductSinglton();

    public static ProductSinglton getInstance() {
        return ourInstance;
    }

//    public ProductListResponse getProductListResponse() {
//        return productListResponse;
//    }

    public void setProductListResponse(ProductListResponse productListResponse) {
        this.productListResponse = productListResponse;
    }

    ProductListResponse productListResponse;

    public ArrayList<ProductListResponse.ResponseBean> getProductListFinal() {
        return productListFinal;
    }

    public void setProductListFinal(ArrayList<ProductListResponse.ResponseBean> productListFinal) {
        this.productListFinal = productListFinal;
    }

    ArrayList<ProductListResponse.ResponseBean> productListFinal = new ArrayList<>();

}
