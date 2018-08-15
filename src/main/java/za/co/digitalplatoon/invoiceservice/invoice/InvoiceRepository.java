package za.co.digitalplatoon.invoiceservice.invoice;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author eljoenai
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    Invoice findById(long id);
}
