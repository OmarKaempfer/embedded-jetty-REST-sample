package webapp;

import webapp.resources.RestResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class AppResourceConfig extends Application {

    Set<Class<?>> classes = new HashSet<Class<?>>();

    /*
        Add the classes of each resource we want to have in the context of the
        web app
     */

    public AppResourceConfig() {
        classes.add(RestResource.class);
    }

    public Set<Class<?>> getClasses() {
        return classes;
    }
}