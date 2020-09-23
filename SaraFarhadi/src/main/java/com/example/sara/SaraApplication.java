package com.example.sara;

import com.vaadin.external.jsoup.Jsoup;
import com.vaadin.external.jsoup.nodes.Document;
import com.vaadin.external.jsoup.nodes.Element;
import com.vaadin.external.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class SaraApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SaraApplication.class, args);
		Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
		System.out.println(doc.title());
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
			System.out.println(
					headline.attr("title") + ", " + headline.absUrl("href"));
		}
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s from Sara!", name);
	}

}
