package model;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Service offered by the franchise.
 */
public class Service {
    /**
     * Name the service
     */
    private String name;
    
    /**
     * ID of the service
     */
    private int id;

    /**
     * Start date of the service
     */
    private Date startDate;

    /**
     * End date of the service
     */
    private Date endDate;


    /**
     * Customers allocated to the service
     */
    private List<Customer> customers = new ArrayList<Customer>();

   
    /**
     * Services associated with a franchise
     */
    private Franchise fID;
    
    
    /**
     * Create a new service object.
     * @param name: Name of the service
     * @param id:  Unique id of the service.
     * @param Franchise:  Franchise that offers the service.
     */
    public Service(String name, int id) {
        this.name = name;
        this.id = id;
        
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Customer> getCustomer() {
        return customers;
    }
    
    public Franchise getFranchise() {
        return fID;
    }
    
    public void setFranchise(Franchise fID) {
        this.fID = fID;
    }

    /**
     * Add a new customer to the service
     * @param customer: who is requesting the service 
     * @return true if the customer is successfully enrolled, false otherwise
     */

    public boolean addCustomerToService(Customer customer, Franchise fID) throws IllegalServiceException{
        if (customer.getNumberOfServices() >= 3) {
            return false;
        }

        List<Service> fID_service_list = fID.getServices();
        for (Service srv: fID_service_list){
            List<Customer> franchise_customers = srv.getCustomer();
            if (franchise_customers.size() >= 500) {
                return false;
            }
             
        }

        
        System.out.println("Looping over customer");
        for (Customer curr_customer:getCustomer()){
        	System.out.printf("%d %s\n", customer.getId(), customer.getName());
        	System.out.println(curr_customer.getId());
            if (customer.getId() == curr_customer.getId()){
                throw new IllegalServiceException("Service is already being used by the same customer");
            }
        }

        List<Customer> curr_customers = getCustomer();
        curr_customers.add(customer);
        

        customer.setNumberOfServices(customer.getNumberOfServices() + 1);
        System.out.printf("%d no of services of a customer\n", customer.getNumberOfServices());

        

        if (fID_service_list.contains(this) == false) {
        	fID_service_list.add(this);
        }
     

    	return true;
   
    }




}
