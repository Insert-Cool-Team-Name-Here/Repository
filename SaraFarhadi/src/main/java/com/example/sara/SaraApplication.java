package com.example.sara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;

@SpringBootApplication
@RestController
public class SaraApplication {

	static String myTitle;
	static String myPage;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SaraApplication.class, args);

		Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
		System.out.println(doc.title());
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
			System.out.println(
					headline.attr("title") + ", " + headline.absUrl("href"));
		}
		String htmlString = "<html><head><title>Welcome</title></head>"
				+ "<body>I am using Jsoup library!</body></html>";
		Document docc = Jsoup.parse(htmlString);
		String title = docc.title();
		String body = docc.body().text();
		System.out.printf("Title: %s%n", title);
		System.out.printf("Body: %s", body);
		myTitle = title;
		myPage = body;
	}
	@GetMapping("/sara")
	public String home() {
		String s = "Hello world from Sara! \n" + myTitle + "\n" + myPage;
		return s;
	}
}
