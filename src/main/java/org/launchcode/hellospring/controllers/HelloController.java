package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles requests at path  /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // live at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // live at /hello/hello
    //Handles request of the form /hello?name=LaunchCode
    //@GetMapping("hello")
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    //public String helloWithQueryParam(@RequestParam  String name ) {
       // return "Hello, " + name + "!";
    //}


    //handles request of the form /hello/LaunchCode
    //@GetMapping("hello/{name}")
    //@GetMapping("{name}")
   // public String helloWithPathParam(@PathVariable String name) {
       // return "Hello, " + name + "!";
    //}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);

    }


    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }

    // live at /hello/form
    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name='language'>" +
                            "<option value='english'>English</option>" +
                            "<option value='french' >French</option>" +
                            "<option value='spanish'>Spanish</option>" +
                            "<option value='italian'>Italian</option>" +
                            "<option value='german'>German</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

}
