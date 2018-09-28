package com.reputation.junit.demo.controller;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportantControllerTest {
    @ClassRule
    public static GenericContainer genericContainer = new GenericContainer(new ImageFromDockerfile()
            .withFileFromPath("./Dockerfile", new File("../../../../../../DockerFile").toPath())
    ).withExposedPorts(8090);

    @Test
    public void getIndexTest()
            throws Exception {
        String address = "http://"
                + genericContainer.getContainerIpAddress() + ":" + genericContainer.getMappedPort(8090) + "/api/";
        String response = simpleGetRequest(address);

        assertEquals(response, "Hello World!");
    }

    private String simpleGetRequest(String address) throws Exception {
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }
}