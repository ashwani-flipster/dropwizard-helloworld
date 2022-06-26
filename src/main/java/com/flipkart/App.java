package com.flipkart;
import com.flipkart.controller.EmployeeRestController;
import com.flipkart.controller.HelloRestController;
import com.flipkart.controller.StudentRestController;
import com.flipkart.controller.UserRestController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *Application config is a dropwizard config class which contains the initialized and run method in which we need to register all the restful controller
 * inside a jersey container which is running inside the dropwizard container
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new HelloRestController());
        e.jersey().register(new EmployeeRestController(e.getValidator()));
        e.jersey().register(new UserRestController(e.getValidator()));
        e.jersey().register(new StudentRestController(e.getValidator()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}