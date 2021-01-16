package io.kornys.quarkus;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class ApiService {

    public String sayHello(String name) {
        return "hello " + name;
    }

    public String getTime() {
        return new Date().toString();
    }

}
