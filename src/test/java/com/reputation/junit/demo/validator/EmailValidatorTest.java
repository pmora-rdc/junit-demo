package com.reputation.junit.demo.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailValidatorTest {
    @Autowired
    EmailValidator emailValidator;

    @Test
    public void checkValidEmail_1() {
        boolean result = emailValidator.isValid("pmora@reputation.com");
        assertTrue("Valid email failed", result );
    }

    @Test
    public void checkValidEmail_2() {
        boolean result = emailValidator.isValid("p.mora@reputation.com");
        assertTrue("Valid email failed", result );
    }

    @Test
    public void checkValidEmail_3() {
        boolean result = emailValidator.isValid("pmora123@reputation.com");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_4() {
        boolean result = emailValidator.isValid("123pmora@reputation.com");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_5() {
        boolean result = emailValidator.isValid("pmora@university.reputation.com");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_6() {
        boolean result = emailValidator.isValid("pablo+mora@reputation.com");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_7() {
        boolean result = emailValidator.isValid("pmora@reputation-university.com");
        assertFalse("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_8() {
        boolean result = emailValidator.isValid("tsukamoto@reputation.co.jp");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_9() {
        boolean result = emailValidator.isValid("pablo-mora@reputation.com");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_10() {
        boolean result = emailValidator.isValid("1234567890@reputation.com");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkValidEmail_11() {
        boolean result = emailValidator.isValid("_foo@reputation.com");
        assertTrue("Valid email failed", result);
    }

    @Test
    public void checkInvalidEmail_1() {
        boolean result = emailValidator.isValid("pmora\\123@reputation.com");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_2() {
        boolean result = emailValidator.isValid("pmora\\@reputation.com");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_3() {
        boolean result = emailValidator.isValid("@reputation.com");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_4() {
        boolean result = emailValidator.isValid("\\@reputation.com");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_5() {
        boolean result = emailValidator.isValid(".@.");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_6() {
        boolean result = emailValidator.isValid("pmora@reputation.");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_7() {
        boolean result = emailValidator.isValid("123@reputation");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_8() {
        boolean result = emailValidator.isValid(".@reputation.com");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_9() {
        boolean result = emailValidator.isValid("abc...123@example.com");
        assertFalse("Invalid email passed", result);
    }

    @Test
    public void checkInvalidEmail_10() {
        boolean result = emailValidator.isValid("reputation.com");
        assertFalse("Invalid email passed", result);
    }
}