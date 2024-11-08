package cat.uvic.teknos.coursemanagement.services;

import cat.uvic.teknos.coursemanagement.models.ModelFactory;
import cat.uvic.teknos.coursemanagement.repositories.RepositoryFactory;
import cat.uvic.teknos.coursemanagement.services.controllers.Controller;
import cat.uvic.teknos.coursemanagement.services.controllers.CourseController;
import cat.uvic.teknos.coursemanagement.services.controllers.StudentController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var properties = new Properties();
        properties.load(App.class.getResourceAsStream("/app.properties"));

        RepositoryFactory repositoryFactory = (RepositoryFactory) Class.forName(properties.getProperty("repositoryFactory")).getConstructor().newInstance();
        ModelFactory modelFactory = (ModelFactory) Class.forName(properties.getProperty("modelFactory")).getConstructor().newInstance();

        var controllers = new HashMap<String, Controller>();

        // TODO: review how to deserialize json objects
        controllers.put("students", new StudentController(repositoryFactory, modelFactory));
        controllers.put("courses", new CourseController(repositoryFactory, modelFactory));

        var requestRouter = new RequestRouterImpl(controllers);
        new Server(requestRouter)
                .start();
    }
}
