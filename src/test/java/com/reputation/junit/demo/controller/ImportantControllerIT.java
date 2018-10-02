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

        ResponseEntity<String> response = restTemplate
                .exchange("http://localhost:8090/api/", HttpMethod.GET, entity, String.class);

        System.out.println("Body: " + response.getBody());

        assertEquals("Hello World!", response.getBody());

        //assertTrue("getIndexTest",2 == 2);
    }

    @Test
    public void getIndexTest2() {
        assertTrue("getIndexTest",3 == 3);
    }
}