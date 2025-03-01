package AndrewWebServices;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database /* should there be something here? */ {
    // Implement your fake database here
    private String accountName;
    private int password;
    
    public InMemoryDatabase(String accountName, int password) {
        this.accountName = accountName;
        this.password = password;
    }
    
    @Override
    public int getPassword(String accountName) {
        if (accountName.equals(this.accountName)) {
            return this.password;
        } else {
            return 0;
        }
    }
}