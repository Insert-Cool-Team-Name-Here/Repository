package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	private String INPUT = "Hello.";
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void setInput(String input) {
		INPUT = input;
	}
	
    public String runExample() {
    	String output1 = "";
        TeeInputStream teeIn = null;
        TeeOutputStream teeOut = null;
         
        try {
            // TeeOutputStream
             
            ByteArrayInputStream in = new ByteArrayInputStream(INPUT.getBytes("US-ASCII"));
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            ByteArrayOutputStream out2 = new ByteArrayOutputStream();
             
            teeOut = new TeeOutputStream(out1, out2);
            teeIn = new TeeInputStream(in, teeOut, true);
            teeIn.read(new byte[INPUT.length()]);
 
            output1 = out1.toString();
            
            //System.out.println("Output stream 1: " + out1.toString());
             
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // No need to close teeOut. When teeIn closes, it will also close its
            // Output stream (which is teeOut), which will in turn close the 2
            // branches (out1, out2).
            try { teeIn.close(); }
            catch (IOException e) { e.printStackTrace(); }
        }
        
        return output1;
    }
    
	@GetMapping("/tobi")
    public String home() { 
		String s = runExample();
        return "Wow Tobi made something appear in a browser!" + System.lineSeparator() +
        	   "Test:" + System.lineSeparator() +
        	   s + System.lineSeparator();
    } 
}