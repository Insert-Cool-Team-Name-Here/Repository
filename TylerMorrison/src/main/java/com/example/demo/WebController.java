package com.example.demo;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/jsoup")
	public String jsoup(@RequestParam(value = "name", defaultValue = "https://en.wikipedia.org/wiki/Java_(programming_language)") String webpage) throws IOException
	{
		Document doc = Jsoup.connect(webpage).get();
		Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
		String src = "<html>\r\n" + 
				"    <body>\r\n" + 
				"        <p>\r\n";
		for(Element image : images)
		{
			src += "<img src = \"" + image.attr("src") + "\">\n<br>\n";
		}
		src += "</p>\r\n" + 
				"    </body>\r\n" + 
				"</html>";
		return src;
	}

}