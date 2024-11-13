package guru.springframework.spring_6_rest_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import guru.springframework.spring_6_rest_api.mappers.CustomerMapper;
import guru.springframework.spring_6_rest_api.model.CustomerDTO;
import guru.springframework.spring_6_rest_api.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@Primary
@AllArgsConstructor
public class CustomerServiceJPA implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomers() {
        return customerRepository.findAll().stream()
            .map(customerMapper::customerToCustomerDto)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.ofNullable(customerMapper.customerToCustomerDto(
           customerRepository.findById(id).orElse(null) 
        ));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }

    @Override
    public void patchById(UUID customerId, CustomerDTO customer) {

    }
    
}