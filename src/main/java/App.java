import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/story", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("noun1", request.queryParams("noun1"));
      model.put("place", request.queryParams("place"));
      model.put("noun2", request.queryParams("noun2"));
      model.put("noun3", request.queryParams("noun3"));
      model.put("noun4", request.queryParams("noun4"));
      model.put("adjective1", request.queryParams("adjective1"));
      model.put("number", request.queryParams("number"));
      model.put("bodyPart", request.queryParams("bodyPart"));
      model.put("adjective2", request.queryParams("adjective2"));
      model.put("verb1", request.queryParams("verb1"));
      model.put("verb2", request.queryParams("verb2"));
      model.put("template", "templates/story.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
