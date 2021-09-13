package org.example.domain;

import org.example.bean.ConsumerProduct;
import org.example.bean.IndustrialProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeFair {


    private IndustrialProduct industrialProduct;

    private ConsumerProduct consumerProduct;


    public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
        this.industrialProduct = industrialProduct;
        this.consumerProduct = consumerProduct;
    }

    //@Autowired
    public void setIndustrialProduct(IndustrialProduct industrialProduct) {
        this.industrialProduct = industrialProduct;
    }

    //@Autowired
    public void setConsumerProduct(ConsumerProduct consumerProduct) {
        this.consumerProduct = consumerProduct;
    }

    public int getIndustrialProductPrice() {
        return industrialProduct.getQualifiedPrice();
    }

    public int getConsumerProductPrice() {
        return consumerProduct.getQualifiedPrice();
    }

    public String getQualifiedProductPrice() {

        return "IndustrialProduct with price " + getIndustrialProductPrice() + " IRR and" +
                "ConsumerProduct with price " + getConsumerProductPrice() + " IRR";
    }
}
