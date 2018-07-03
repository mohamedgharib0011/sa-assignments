package webshop;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate retTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters()
				.addAll(Arrays.asList(new MappingJackson2HttpMessageConverter(), new StringHttpMessageConverter()));
		return restTemplate;
	}

}
