
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        get("/hello", (req, res) -> "Hello World");

        get("/tarea4", (req, res) -> {
            List<ClassInfo> data;
            String salida = "<p><br>";
            data = AnalizeClass.loadClassInfo("lista1.txt");
            salida += String.format(" Pueba %d<br><table border=\"1\">", 1);
            ObjectType result = AnalizeClass.calculateSizeRange(data);
            salida += String.format("<p>VS = %.5g%n LOC/Method<br>S =  %.5g%n LOC/Method<br>M = %.4g%n LOC/Method<br>L = %.4g%n LOC/Method<br>VL = %.4g%n LOC/Method<br></p>", result.getVerySmall(), result.getSmall(), result.getMedium(), result.getLarge(), result.getVeryLarge());
            data = AnalizeClass.loadClassInfo("lista2.txt");
            salida += String.format("Prueba %d<br><table border=\"1\">", 2);
            salida += String.format("<p>VS = %.5g%n pages/Chapter<br>S =  %.5g%n pages/Chapter<br>M = %.4g%n pages/Chapter<br>L = %.4g%n pages/Chapter<br>VL = %.4g%n pages/Chapter<br></p>", result.getVerySmall(), result.getSmall(), result.getMedium(), result.getLarge(), result.getVeryLarge());
            return salida;
        });

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        get("/db", (req, res) -> {
            Connection connection = null;
            Map<String, Object> attributes = new HashMap<>();
            try {
                connection = DatabaseUrl.extract().getConnection();

                Statement stmt = connection.createStatement();
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
                stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
                ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

                ArrayList<String> output = new ArrayList<String>();
                while (rs.next()) {
                    output.add("Read from DB: " + rs.getTimestamp("tick"));
                }

                attributes.put("results", output);
                return new ModelAndView(attributes, "db.ftl");
            } catch (Exception e) {
                attributes.put("message", "There was an error: " + e);
                return new ModelAndView(attributes, "error.ftl");
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }, new FreeMarkerEngine());

    }

}
