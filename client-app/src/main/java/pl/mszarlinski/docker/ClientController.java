package pl.mszarlinski.docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mszarlinski on 2016-11-19.
 */
@RestController
public class ClientController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${example.server-app.host}")
    private String serverAppHost;

    @Value("${example.server-app.port}")
    private int serverAppPort;

    @GetMapping
    @RequestMapping("/client")
    public String getInvitation() {
        final String product = restTemplate.getForObject(getProductEndpoint(), String.class);
        return "product: " + product;
    }

    private String getProductEndpoint() {
        return "http://" + serverAppHost + ":" + serverAppPort + "/product";
    }
}
