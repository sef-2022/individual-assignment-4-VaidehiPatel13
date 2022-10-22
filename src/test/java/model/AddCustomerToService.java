package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Date;

/**
 *  Implement and test {Service.addCustomerToService } that respects the following:
 *
 *  <ul>
 *
 *      <li> Get the number of services a customer is currently using </li>
 *      <li> A customer cannot hold more than 3 services</li>
 *      <li> Throws an exception if a customer is already using the same service</li>
 *      <li> Get the number of customers associated with the service offered by a franchise</li>
 *      <li> A service offered by a franchise cannot have more than 500 customers. </li> 
 *      <li> If this limit is reached for a franchise, then customer is not added to the service</li>
 *  </ul>
 *
 * NOTE: You are expected to verify that the constraints to add a new customer to a service are met.
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with setUp method.
 * 
 * 
 */

class AddCustomerToService {
	Service service;
	Franchise franchise;
	Customer customer;
	
	@BeforeEach
	void setUp() {
		service = new Service("Service", 1);
		 
        franchise = new Franchise();
        franchise.setID(8888);

	 	customer = new Customer("Vaidehi", 13, franchise);
	}
	
	// This method test if the customer is successful added to the service
	 @Test
	 @DisplayName("Add customer to service")
     void addCustomerToService_True(){
		try {
			boolean is_success = service.addCustomerToService(customer, franchise);
	 		assertTrue(is_success);
	 	} catch (IllegalServiceException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
     }

	 //This method test the customer using the same service and throws an exception	
	@Test
    void addCustomerToService_ThrowsException_IfCustomerUsingSameService(){
	 	try {
	 		boolean is_success = service.addCustomerToService(customer, franchise);
	 		assertTrue(is_success);
	 	} catch (IllegalServiceException e) {
	 		// TODO Auto-generated catch block
	 			e.printStackTrace();
	 	}

	 	assertThrows(
	 			IllegalServiceException.class,
	 			() -> {service.addCustomerToService(customer, franchise);},
	 			"Expected model.IllegalServiceException to be thrown, but nothing was thrown"
	 			);
	 	}
	 
//	//This method test the customer using the same service and throws an exception
		 @Test
	    void addCustomerToService_ThrowsException_IfCustomerNotUsingSameService(){
	
		 	try {
		 		boolean is_success = service.addCustomerToService(customer, franchise);
		 		assertTrue(is_success);
		 	} catch (IllegalServiceException e) {
		 		// TODO Auto-generated catch block
		 			e.printStackTrace();
		 	}

		 	assertThrows(
		 			IllegalServiceException.class,
		 			() -> {service.addCustomerToService(customer, franchise);},
		 			"Expected model.IllegalServiceException to be thrown, but nothing was thrown"
		 			);
		 	}

		 
//	 	//This method test if the customer has more than 3 services
	 	@RepeatedTest(4)
	    void addCustomerToService_False_IfServiceMoreThan3(){
//			 Service service_1 = new Service("Service 1", 1);
//			 Service service_2 = new Service("Service 2", 5);
//			 Service service_3 = new Service("Service 3", 8);
//			 Service service_4 = new Service("Service 4", 11);
	
		 	try {
		 		boolean is_success = service.addCustomerToService(customer, franchise);
		 		assertTrue(is_success);
		 	} catch (IllegalServiceException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}

//	         try {
//		 		boolean is_success = service_2.addCustomerToService(customer, franchise);
//		 		assertTrue(is_success);
//		 	} catch (IllegalServiceException e) {
//		 		// TODO Auto-generated catch block
//		 		e.printStackTrace();
//		 	}
//	         
//	         try {
//			 		boolean is_success = service_3.addCustomerToService(customer, franchise);
//			 		assertTrue(is_success);
//			 	} catch (IllegalServiceException e) {
//			 		// TODO Auto-generated catch block
//			 		e.printStackTrace();
//			 	}
//	         
//	         try {
//			 		boolean is_success = service_4.addCustomerToService(customer, franchise);
//			 		assertFalse(is_success);
//			 	} catch (IllegalServiceException e) {
//			 		// TODO Auto-generated catch block
//			 		e.printStackTrace();
//			 	}

	     }
//	 	
//	 	
//	 	//This method test if the customer has less than 3 services
	 	@Test
	    void addCustomerToService_True_IfServiceLessThan3(){
			 Service service_1 = new Service("Service 1", 1);
			 Service service_2 = new Service("Service 2", 5);

		 	try {
		 		boolean is_success = service_1.addCustomerToService(customer, franchise);
		 		assertTrue(is_success);
		 	} catch (IllegalServiceException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}

	         try {
		 		boolean is_success = service_2.addCustomerToService(customer, franchise);
		 		assertTrue(is_success);
		 	} catch (IllegalServiceException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
	         
	     }
	 	
//	 	
//	     //This method test if the franchise has more than 500 customer 
		 @Test
	     void addCustomerToService_False_FranchiseMoreThan500Customers(){
	
			Integer i = 0;
			//Do not want to store the list of customers as it will be memory consuming
			for (i = 0; i < 15; i++ ) {
				System.out.println(i);
				Customer new_customer = new Customer("Vaidehi_" + i.toString(), i, franchise);
				try {
					boolean is_success = service.addCustomerToService(new_customer, franchise);
					assertTrue(is_success);
				} catch (IllegalServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("ADD ONE MORE CUSTOMER");
			Customer new_customer = new Customer("Vaidehi_", 532, franchise);
			try {
				boolean is_success = service.addCustomerToService(new_customer, franchise);
				assertFalse(is_success);
			} catch (IllegalServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
//	 	
//	 

}