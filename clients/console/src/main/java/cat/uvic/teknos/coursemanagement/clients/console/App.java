package cat.uvic.teknos.coursemanagement.clients.console;

import cat.uvic.teknos.coursemanagement.clients.console.dto.CourseDto;
import cat.uvic.teknos.coursemanagement.clients.console.exceptions.ConsoleClientException;
import cat.uvic.teknos.coursemanagement.clients.console.exceptions.RequestException;
import cat.uvic.teknos.coursemanagement.clients.console.utils.Mappers;
import cat.uvic.teknos.coursemanagement.clients.console.utils.RestClient;
import cat.uvic.teknos.coursemanagement.clients.console.utils.RestClientImpl;
import cat.uvic.teknos.coursemanagement.cryptoutils.CryptoUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.stream.Collectors;

public class App {
    private static  final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static  final PrintStream out = new PrintStream(System.out);
    private static RestClient restClient = new RestClientImpl("localhost", 88888);

    public static void main(String[] args) {
        showBanner();
        showMainMenu();

        var command = "";
        do {
            showMainMenu();
            command = readLine(in);

            switch (command) {
                case "2" -> manageCourses();
            }

        } while (!command.equals("exit"));

        out.println("Bye!");
    }

    private static void manageCourses() {
        var command = "";
        do {
            command = readLine(in);

            switch (command) {
                case "1" -> {
                    try {
                        var clients = restClient.getAll("/courses", CourseDto[].class, null);
                    } catch (RequestException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    var courseId = readLine(in);
                    var secretKey = CryptoUtils.createSecretKey();
                    try {
                        var client = restClient.get(
                                "/courses/" + courseId,
                                CourseDto.class,
                                (b) -> {
                                    return CryptoUtils.decrypt(b, secretKey);
                                });
                    } catch (RequestException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "3" -> {
                    var course = new CourseDto();

                    course.setName(readLine(in));

                    try {
                        var body = Mappers.get().writeValueAsString(course);
                        var bodyHash = CryptoUtils.getHash(body);
                        var secretKey = CryptoUtils.createSecretKey();

                        restClient.post(
                                "/courses",
                                Mappers.get().writeValueAsString(course),
                                (b) -> {
                                    return CryptoUtils.decrypt(b, secretKey);
                                },
                                new RestClient.HeaderEntry("Secret-key", CryptoUtils.toBase64(secretKey.getEncoded())),
                                new RestClient.HeaderEntry("Body-hash", bodyHash));
                    } catch (RequestException | JsonProcessingException e) {
                        out.println(e.getMessage());
                    }

                }
            }

        } while (!command.equals("exit"));
    }

    private static void showBanner() {
        var bannerStream = App.class.getResourceAsStream("/banner.txt");

        var banner = new BufferedReader(new InputStreamReader(bannerStream))
                .lines().collect(Collectors.joining("\n"));

        System.out.println(banner);
    }

    private static void showMainMenu() {
        out.println("1. Student");
        out.println("2. Course");
        out.println("3. Genre");
    }

    private static String readLine(BufferedReader in) {
        String command;
        try {
            command = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the menu option", e);
        }
        return command;
    }
}
