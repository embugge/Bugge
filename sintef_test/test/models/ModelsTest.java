package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

//JUnit test class
public class ModelsTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }
    
    //Create and retrive a user
    @Test
    public void createAndRetrieveUser() {
        new User("embugge@hotmail.com", "Bob", "secret").save();
        User bob = User.find.where().eq("email", "embugge@hotmail.com").findUnique();
        assertNotNull(bob);
        assertEquals("Bob", bob.name);
    }
    
    //User authentication test: Checks if email and password authentication works
    @Test
    public void tryAuthenticateUser() {
        new User("embugge@hotmail.com", "Bob", "secret").save();
        
        assertNotNull(User.authenticate("embugge@hotmail.com", "secret"));
        assertNull(User.authenticate("embugge@hotmail.com", "badpassword"));
        assertNull(User.authenticate("wrong@gmail.com", "secret"));
    }
    
    //User activity test: Creates a user, a UA and checks if they're properly connected
    @Test
    public void createAndRetrieveUserActivity() {
    	new User("embugge@hotmail.com", "Bob", "secret").save();
    	User bob = User.find.where().eq("email", "embugge@hotmail.com").findUnique();
        new UserActivity(3, "Erik", bob).save();
        UserActivity uaTest = UserActivity.find.where().eq("id", "3").findUnique();
        assertNotNull(uaTest);
        assertEquals("Erik", uaTest.name);
    }
}