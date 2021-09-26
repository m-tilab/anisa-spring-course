package org.example.domain;

public class InvoiceDetail {

    private long invoiceDetailId;
    private long invoiceId;
    private long productId;
    private int quantity;
    private long price;
    private long discountPrice;

    public InvoiceDetail() {
    }

    public InvoiceDetail(long invoiceDetailId, long invoiceId, long productId, int quantity, long price, long discountPrice) {
        this.invoiceDetailId = invoiceDetailId;
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public InvoiceDetail(long productId) {
        this.productId = productId;
    }

    public long getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(long invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(long discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "invoiceDetailId=" + invoiceDetailId +
                ", invoiceId=" + invoiceId +
                ", ProductId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
