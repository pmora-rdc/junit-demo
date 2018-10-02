package com.reputation.junit.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportantControllerIT {
    private TestRestTemplate restTemplate;
    private String serviceUrl;

    @Before
    public void setUp() {
        restTemplate = new TestRestTemplate();
        serviceUrl = "http://localhost:8090";
    }

    @Test
    public void getIndexTest1() {
        HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());

        String response = restTemplate.getForObject(this.serviceUrl, String.class);

        assertEquals("Hello World!", response);
    }

    @Test
    public void getIndexTest2() {
        assertTrue("getIndexTest",3 == 3);
    }

    @Test
    public void getIndexTest3() {
        String response = restTemplate.getForObject(this.serviceUrl, String.class);

        assertEquals("Hello World!", response);
    }

    @Test
    public void getIndexTest4() {
        String response = restTemplate.getForObject(this.serviceUrl, String.class);

        assertEquals("Hello World!", response);
    }


    @Test
    public void getIndexTest5() {
        String response = restTemplate.getForObject(this.serviceUrl, String.class);

        assertEquals("Hello World!", response);
    }

    @Test
    public void getIndexTest6() {
        String response = restTemplate.getForObject(this.serviceUrl, String.class);

        assertEquals("Hello World!", response);
    }

    @Test
    public void getIndexTest7() {
        String response = restTemplate.getForObject(this.serviceUrl, String.class);

        assertEquals("Hello World!", response);
    }

    @Test
    public void getIndexTest8() {
        HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());

        ResponseEntity<String> response = restTemplate.exchange(this.serviceUrl, HttpMethod.GET, entity, String.class);

        System.out.println("Response Code: " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}