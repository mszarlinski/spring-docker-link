package pl.mszarlinski.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mszarlinski on 2016-11-19.
 */
@RestController
public class ClientController {

    private static final String SERVER_APP_HOST = "server-app"; // injected into /etc/hosts by Docker

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    @RequestMapping("/client")
    public String getInvitation() {
        final String product = restTemplate.getForObject("http://" + SERVER_APP_HOST + ":8080/product", String.class);
        return "product: " + product;
    }
}
