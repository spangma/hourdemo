package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;

@RestController
public class HourDemoController {
	
	 private static final String template = "Hello, %s!";
	  private final AtomicLong counter = new AtomicLong();

	  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
	  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	    return new Greeting(counter.incrementAndGet(),
	              String.format(template, name));
	  }
}
