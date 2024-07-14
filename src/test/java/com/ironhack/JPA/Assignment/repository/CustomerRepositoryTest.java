package com.ironhack.JPA.Assignment.repository;

import com.ironhack.JPA.Assignment.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Roman Diaz","Silver",7656);
        customerRepository.save(customer);

//        System.out.println(customer);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteById(customer.getCustomerId());
    }

    @Test
        public void findAll_customers_customerList() {

            List<Customer> customerList = customerRepository.findAll();
            System.out.println(customerList);

            assertEquals(6, customerList.size());
        }

        @Test
        public void findById_validId_correctCustomer() {
           Optional<Customer> customerOptional = customerRepository.findById(1);
           assertTrue(customerOptional.isPresent());

           System.out.println(customerOptional.get());
           assertEquals("Agustine Riviera", customerOptional.get().getCustomerName());
        }

        @Test
        public void findById_invalidId_customerNotPresent() {
            Optional<Customer> customerOptional = customerRepository.findById(19);
            assertTrue(customerOptional.isEmpty());
        }

        @Test
        public void findByStatus_validStatus_correctCustomer() {
            Optional<Customer> customerOptional = customerRepository.findByCustomerStatus("Gold");
            assertTrue(customerOptional.isPresent());
            System.out.println(customerOptional.get());
            assertEquals("Tom Jones", customerOptional.get().getCustomerName());

        }

        @Test
        public void findAllByCustomerStatus_validStatus_customerList() {
            List<Customer> customerList = customerRepository.findAllByCustomerStatus("Silver");
            System.out.println(customerList);
            assertEquals(3, customerList.size());
        }

        @Test
        public void findByCustomerName_validName_correctCustomer() {
            Optional<Customer> customerOptional = customerRepository.findByCustomerName("Roman Diaz");
            assertTrue(customerOptional.isPresent());
            System.out.println(customerOptional.get());
        }

        @Test
        public void findAllByCustomerName_validName_correctCustomerList() {
            List<Customer> customerList = customerRepository.findAllByCustomerNameContaining("Jones");
            System.out.println(customerList);
            assertEquals(2, customerList.size());
        }




}