package dotcom.com.sam.SingaltonsClasses;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dotcom.com.sam.request.PlaceOrderRequest;

import static dotcom.com.sam.extras.Utilss.TAG;

/**
 * Created by Dotcom on 2/25/2017.
 */

public class PlaceOrderService implements Serializable {

    private static PlaceOrderService ourInstance = new PlaceOrderService();

    public static PlaceOrderService getInstance() {
        return ourInstance;
    }

    private Long User_id;
    private int Quantity;
    private Double sub_total;
    private Double delivery_Charge;
    private Double Coupan_discount;
    private Double payable_amount;
    private int ref_id;
    private int payment_type;
    private int payment_status;
    private int address_id;
    private String isWallet;
    private int Product_id;

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }

    public String getIsWallet() {
        return isWallet;
    }

    public void setIsWallet(String isWallet) {
        this.isWallet = isWallet;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }

    public int getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(int payment_type) {
        this.payment_type = payment_type;
    }

    public int getRef_id() {
        return ref_id;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    public Double getPayable_amount() {
        return payable_amount;
    }

    public void setPayable_amount(Double payable_amount) {
        this.payable_amount = payable_amount;
    }

    public Double getCoupan_discount() {
        return Coupan_discount;
    }

    public void setCoupan_discount(Double coupan_discount) {
        Coupan_discount = coupan_discount;
    }

    public Double getDelivery_Charge() {
        return delivery_Charge;
    }

    public void setDelivery_Charge(Double delivery_Charge) {
        this.delivery_Charge = delivery_Charge;
    }

    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double sub_total) {
        this.sub_total = sub_total;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Long getUser_id() {
        return User_id;
    }

    public void setUser_id(Long user_id) {
        User_id = user_id;
    }

    @SerializedName("tbl_orders")
    private List<PlaceOrderRequest> tbl_orders=new ArrayList<>();


    public List<PlaceOrderRequest> getTbl_orders() {
        return tbl_orders;
    }

    public void setTbl_orders(List<PlaceOrderRequest> tbl_orders) {
        this.tbl_orders = tbl_orders;
    }

    public boolean addReport(PlaceOrderRequest item) {
        Log.e(TAG, "addReport: " + tbl_orders.size());
        int a = tbl_orders.size();
        tbl_orders.add(item);
        return a < tbl_orders.size();
    }


}
