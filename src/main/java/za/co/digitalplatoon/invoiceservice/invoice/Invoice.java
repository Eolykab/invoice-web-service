package za.co.digitalplatoon.invoiceservice.invoice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author eljoenai
 */
@Entity
public class Invoice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id")
    private long id;
    private String client;
    private long vatRate;
    private Date invoiceDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    private List<LineItem> lineItems;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getClient() {
        return client;
    }
    
    public void setClient(String client) {
        this.client = client;
    }
    
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
    
    public long getVatRate() {
        return vatRate;
    }
    
    public void setVatRate(long vatRate) {
        this.vatRate = vatRate;
    }
    
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    
    public BigDecimal getSubTotal() {
        
        double total = 0;
        for (LineItem item : getLineItems()) {
            total += item.getQuantity() * item.getUnitPrice().doubleValue();
        }
        return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        
    }
    
    public BigDecimal getVat() {
        return new BigDecimal(getVatRate() * getSubTotal().doubleValue()).setScale(2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getTotal() {
        return new BigDecimal(getSubTotal().doubleValue() + getVat().doubleValue()).setScale(2, RoundingMode.HALF_UP);
    }
    
}
