package org.example.domain;

import java.util.Date;
import java.util.List;

public class Invoice {

    private long invoiceId;
    private long totalPrice;
    private long userId;
    private Date publishDate;
    private String number;
    private Date createDate;
    private int status;
    private List<InvoiceDetail> invoiceDetails;

    public Invoice() {
    }

    public Invoice(long invoiceId, long totalPrice, long userId, Date publishDate, String number, Date createDate, int status) {
        this.invoiceId = invoiceId;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.publishDate = publishDate;
        this.number = number;
        this.createDate = createDate;
        this.status = status;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", totalPrice=" + totalPrice +
                ", userId=" + userId +
                ", publishDate=" + publishDate +
                ", number='" + number + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                ", invoiceDetails=" + invoiceDetails +
                '}';
    }
}
