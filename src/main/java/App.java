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
      model.put("color", request.queryParams("color"));
      model.put("superlative", request.queryParams("superlative"));
      model.put("bodyPart", request.queryParams("bodyPart"));
      model.put("bodyPart2", request.queryParams("bodyPart2"));
      model.put("noun", request.queryParams("noun"));
      model.put("animals", request.queryParams("animals"));
      model.put("adjective", request.queryParams("adjective"));
      model.put("adjective2", request.queryParams("adjective2"));
      model.put("adjective3", request.queryParams("adjective3"));
      model.put("adjective4", request.queryParams("adjective4"));
      model.put("template", "templates/story.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
