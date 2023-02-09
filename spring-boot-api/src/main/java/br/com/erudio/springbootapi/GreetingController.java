package br.com.erudio.springbootapi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.springbootapi.Greeting;
import com.fasterxml.jackson.core.sym.Name;

@RestController
public class GreetingController {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")
    String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
