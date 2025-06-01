package dev.akibaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("greet")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public GreetResponse greet() {
        return new GreetResponse(
                "Hello man!",
                List.of("Java", "Python", "Javascript"),
                new Person(
                        "Baki",
                        36,
                        29_325
                )
        );
    }

    private record GreetingResponse(String message) {}

    private record Person(String name, int age, double balance) {}

    private class GreetResponse {
        private final String message;
        private final List<String> favProgrammingLanguages;
        private final Person person;

        private GreetResponse(String message, List<String> favProgrammingLanguages, Person person) {
            this.message = message;
            this.favProgrammingLanguages = favProgrammingLanguages;
            this.person = person;
        }

        public String getMessage() {
            return message;
        }

        public List<String> getFavProgrammingLanguages() {
            return favProgrammingLanguages;
        }

        public Person getPerson() {
            return person;
        }

        @Override
        public String toString() {
            return "GreetResponse{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }
}
