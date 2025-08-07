
import controller.LoginController;
import controller.UsuarioController;
import service.UsuarioService;
import Enum.Keys;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        int porta = 7000;

        // Criação do app
        Javalin app = Javalin.create(config -> {
            TemplateEngine templateEngine = configurarThymeleaf();

            config.staticFiles.add(staticFileConfig -> {
                staticFileConfig.directory = "/public";
                staticFileConfig.location = Location.CLASSPATH;
            });

            config.fileRenderer(new JavalinThymeleaf(templateEngine));
        });

        // Injeção de dependências no app
        app.attribute(Keys.USUARIO_SERVICE.key(), new UsuarioService());

        // Controllers
        LoginController loginController = new LoginController();
        UsuarioController usuarioController = new UsuarioController();

        // Rotas
        app.get("/", ctx -> ctx.redirect("/login"));
        app.get("/login", loginController::mostrarPaginaLogin);
        app.post("/login", loginController::processarLogin);
        app.get("/logout", loginController::logout);

        app.get("/usuarios/signup", usuarioController::mostrarFormulario_signup);
        app.post("/usuarios/cadastrar", usuarioController::cadastrarUsuario);
        app.get("/usuarios", usuarioController::listarUsuarios);
        app.get("/usuarios/novo", usuarioController::mostrarFormularioCadastro);
        app.get("/usuarios/{id}/remover", usuarioController::removerUsuario);

        app.get("/area-interna", ctx -> {
            if (ctx.sessionAttribute("usuario") == null) {
                ctx.redirect("/login");
            } else {
                ctx.render("/login/area_interna.html");
            }
        });

        // Erros personalizados
        app.error(404, ctx -> ctx.render("erro_404.html"));
        app.error(500, ctx -> ctx.render("erro_500.html"));

        app.start(porta);
    }

    private static TemplateEngine configurarThymeleaf() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
}
