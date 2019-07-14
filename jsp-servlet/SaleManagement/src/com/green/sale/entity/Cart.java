package com.green.sale.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private long total;
    private Map<Integer, CartDetail> details;
    
    public Cart() {
        this.total = 0;
        this.details = new HashMap<Integer, CartDetail>();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Map<Integer, CartDetail> getDetails() {
        return details;
    }
    
    public void setDetails(Map<Integer, CartDetail> details) {
        this.details = details;
    }
    
    public void calculate() {
        long total = 0;
        for (Integer key : details.keySet()) {
            total += details.get(key).getTotal();
        }
        
        this.total = total;
    }
}
