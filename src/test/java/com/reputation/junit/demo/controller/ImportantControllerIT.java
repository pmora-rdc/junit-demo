package com.reputation.junit.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportantControllerIT {
    TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void getIndexTest1() {
        HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());

        System.out.println("Body1... ");
        String response = restTemplate.getForObject("http://localhost:8090/api/", String.class);

        System.out.println("Body2... ");
        System.out.println("Body: " + response);

        assertEquals("Hello World!", response);

        //assertTrue("getIndexTest",2 == 2);
    }

    @Test
    public void getIndexTest2() {
        assertTrue("getIndexTest",3 == 3);
    }
}