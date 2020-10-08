package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.junit.*;

public class ApplicationTest{
	Application a = new Application();
	
	@Test
    public void runExampleTEST() {
        String output = a.runExample();
        Assert.assertEquals("Hello.", output);
    }
	
	@Test
    public void runExampleTEST2() {
		a.setInput("Hiya.");
        String output = a.runExample();
        Assert.assertEquals("Hiya.", output);
    }
}
