package rockets.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class UserUnitTest {
    private User p;

    @Before
    public void setUp() {
        p = new User("abc@example.com");
    }

    @Test(expected = NullPointerException.class)
    public void testNullEmailNotAllowed() {
        p = new User(null);
    }

    @Test
    public void equalEmailMeansSameUser() {
        User p1 = new User("abc@example.com");

        assertEquals("same user", p, p1);
    }

    @Test
    public void differentEmailsMeansDifferentUser() {
        User p1 = new User("def@foo.org");

        assertNotEquals("different users", p, p1);
    }

    @Test
    public void passwordNotNullOrEmpty() {
        try {
            p.setPassword(null);
            fail("Password cannot be null");
        } catch (Exception e) {
            assertTrue("Throws IAE", e instanceof IllegalArgumentException);
            assertTrue("Message contains null", e.getMessage().contains("null"));
        }

        try {
            p.setPassword("");
            fail("Password cannot be empty");
        } catch (Exception e) {
            assertTrue("Throws IAE", e instanceof IllegalArgumentException);
            assertTrue("Message contains empty", e.getMessage().contains("empty"));
        }
    }

    @Test
    public void passwordSucessSet(){
        String newPassword = "password";
        p.setPassword(newPassword);

        assertEquals("password", p.getPassword());
    }

    @Test
    public void testStrongPassword(){
        String newPwd = "P@ssw0rd";
        p.setPassword(newPwd);
        assertEquals(newPwd, p.getPassword());
    }

    @Test
    public void testWeakPassword(){
        String newPwd = "P@ssword";

        // Test no number
        try {
            p.setPassword(newPwd);
            fail("Password not have number.");
        } catch(Exception e) {
            assertTrue("Throws IAE", e instanceof IllegalArgumentException);
            assertTrue("Password not have number.", e.getMessage().contains("strong enough"));
        }

        // Test no special character
        try{
            newPwd = "Passw0rd";
            p.setPassword(newPwd);
            fail("Password not have special character.");
        } catch (Exception e) {
            assertTrue("Throws IAE", e instanceof IllegalArgumentException);
            assertTrue("Password not have special character.", e.getMessage().contains("strong enough"));
        }

        // Test no lower letter
        try{
            newPwd = "P@SSW0RD";
            p.setPassword(newPwd);
            fail("Password not have lower letter.");
        } catch (Exception e) {
            assertTrue("Throws IAE", e instanceof IllegalArgumentException);
            assertTrue("Password not have lower letter.", e.getMessage().contains("strong enough"));
        }

        // Test no upper letter
        try{
            newPwd = "p@ssw0rd";
            p.setPassword(newPwd);
            fail("Password not have upper letter.");
        } catch (Exception e) {
            assertTrue("Throws IAE", e instanceof IllegalArgumentException);
            assertTrue("Password not have upper letter.", e.getMessage().contains("strong enough"));
        }

        // Test less than 8 length
        try{
            newPwd = "P@ssw0r";
            p.setPassword(newPwd);
            fail("Password less than 8 digits.");
        } catch (Exception e) {
            assertTrue("Throws IAE", e instanceof IllegalArgumentException);
            assertTrue("Password less than 8 digits.", e.getMessage().contains("strong enough"));
        }
    }
}