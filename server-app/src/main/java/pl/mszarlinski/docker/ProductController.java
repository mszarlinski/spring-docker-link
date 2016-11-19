package pl.mszarlinski.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author mszarlinski on 2016-11-18.
 */
@RestController
public class ProductController {

    @GetMapping
    @RequestMapping("/product")
    public String getProduct() {
        return UUID.randomUUID().toString();
    }
}
