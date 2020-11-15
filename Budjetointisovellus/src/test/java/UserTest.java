
import java.util.ArrayList;
import katja.budjetointisovellus.AppLogic;
import katja.budjetointisovellus.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    public UserTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void userCreatedSuccesfully() {
        AppLogic app = new AppLogic();
        app.newUser("kissa", "mau");
        assertEquals(1, app.getUsers().size());
    }

    @Test
    public void userSignedInReturnsTrue() {
        AppLogic app = new AppLogic(); 
        app.newUser("kissa", "mau");
        assertEquals(true, app.signIn("kissa", "mau"));
    }
    
    @Test
    public void passwordIsCorrect() {
        AppLogic app = new AppLogic(); 
        app.newUser("kissa", "mau");
        assertEquals(false, app.signIn("kissa", "mou"));
    }
}
