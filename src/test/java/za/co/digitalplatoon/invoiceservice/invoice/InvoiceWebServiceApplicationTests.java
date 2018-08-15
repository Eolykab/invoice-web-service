package za.co.digitalplatoon.invoiceservice.invoice;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceWebServiceApplicationTests {

    @MockBean
    private InvoiceController invoiceController;

    @Test
    public void viewAllInvoices() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setClient("Eljoenai Muninga");
        invoice.setInvoiceDate(new Date());
        List<Invoice> invoices = Collections.singletonList(invoice);
        BDDMockito.given(invoiceController.viewAllInvoices()).willReturn(invoices);
    }

    @Test
    public void viewInvoice() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setClient("Eljoenai Muninga");
        invoice.setInvoiceDate(new Date());
        BDDMockito.given(invoiceController.viewInvoice(invoice.getId())).willReturn(invoice);

    }

    @Test
    public void addInvoice() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setClient("Eljoenai Muninga");
        invoice.setInvoiceDate(new Date());
        BDDMockito.given(invoiceController.addInvoice(invoice)).willReturn(invoice);
    }

}
