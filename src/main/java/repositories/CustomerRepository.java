package repositories;

import dataaccess.models.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CRUDRepository<Customer, Integer>{

}
