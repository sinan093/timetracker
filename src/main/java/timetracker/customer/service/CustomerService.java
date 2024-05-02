package timetracker.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetracker.customer.dto.CustomerDto;
import timetracker.customer.entity.CustomerEntity;
import timetracker.customer.mapper.CustomerMapper;
import timetracker.customer.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public List<CustomerDto> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerMapper.mapToCustomerDtos(customerEntities);
    }

    public void createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMapper.mapToCustomerEntity(customerDto);
        customerRepository.save(customerEntity);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    

}
