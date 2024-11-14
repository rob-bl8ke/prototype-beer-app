package guru.springframework.spring_6_rest_api.services;

import guru.springframework.spring_6_rest_api.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> listCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);
    CustomerDTO saveNewCustomer(CustomerDTO customer);
    Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer);
    Boolean deleteById(UUID customerId);
    Optional<CustomerDTO> patchById(UUID customerId, CustomerDTO customer);
}
