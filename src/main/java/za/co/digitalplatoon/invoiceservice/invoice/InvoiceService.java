package za.co.digitalplatoon.invoiceservice.invoice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eljoenai
 */
@Service
public class InvoiceService {
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
    
    public List<Invoice> viewAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach(invoices::add);
        return invoices;
    }
    
    public Invoice viewInvoice(long id) {
        return invoiceRepository.findById(id);
    }
    
}
