package id.teambantu.bcmodel.helper;

import id.teambantu.bcmodel.type.InvoiceStatusType;

public class Invoice {
    private String id = "";
    private long month = 0;
    private long amount = 0;
    private InvoiceStatusType status = InvoiceStatusType.NONE;
    private long payAt = 0;
    private long amountThisMonth = 0;
    private int uniqueCode = 0;
    private String invoiceImage = "";
    private long createdAt = System.currentTimeMillis();

    public Invoice() {
    }

    public Invoice(String id, long month, long amount, InvoiceStatusType status, long payAt, long amountThisMonth, int uniqueCode, String invoiceImage, long createdAt) {
        this.id = id;
        this.month = month;
        this.amount = amount;
        this.status = status;
        this.payAt = payAt;
        this.amountThisMonth = amountThisMonth;
        this.uniqueCode = uniqueCode;
        this.invoiceImage = invoiceImage;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public InvoiceStatusType getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatusType status) {
        this.status = status;
    }

    public long getPayAt() {
        return payAt;
    }

    public void setPayAt(long payAt) {
        this.payAt = payAt;
    }

    public long getAmountThisMonth() {
        return amountThisMonth;
    }

    public void setAmountThisMonth(long amountThisMonth) {
        this.amountThisMonth = amountThisMonth;
    }

    public int getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(int uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getInvoiceImage() {
        return invoiceImage;
    }

    public void setInvoiceImage(String invoiceImage) {
        this.invoiceImage = invoiceImage;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", month=" + month +
                ", amount=" + amount +
                ", status=" + status +
                ", payAt=" + payAt +
                ", amountThisMonth=" + amountThisMonth +
                ", uniqueCode=" + uniqueCode +
                ", invoiceImage='" + invoiceImage + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
