import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String artist = request.queryParams("artist");
      String title = request.queryParams("title");
      Organizer newOrganizer = new Organizer(title, artist);

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/albums", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("albums", Organizer.all());
      model.put("template", "templates/albums.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/search-title", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String title = request.queryParams("title-search");
      Organizer album = Organizer.findTitle(title);

      model.put("album", album);
      model.put("template", "templates/found-title.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

}
