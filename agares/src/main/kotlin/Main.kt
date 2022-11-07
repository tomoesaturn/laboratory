import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.config.JavalinConfig
import io.javalin.openapi.plugin.OpenApiConfiguration
import io.javalin.openapi.plugin.OpenApiPlugin
import io.javalin.openapi.plugin.swagger.SwaggerConfiguration
import io.javalin.openapi.plugin.swagger.SwaggerPlugin

const val PORT = 7070

fun main() {
    Javalin.create { config: JavalinConfig ->
        val deprecatedDocsPath = "/swagger-docs"
        val openApiConfiguration = OpenApiConfiguration()
        openApiConfiguration.info.title = "AwesomeApp"
        openApiConfiguration.documentationPath = deprecatedDocsPath
        config.plugins.register(OpenApiPlugin(openApiConfiguration))
        val swaggerConfiguration = SwaggerConfiguration()
        swaggerConfiguration.uiPath = "/swagger"
        swaggerConfiguration.documentationPath = deprecatedDocsPath
        config.plugins.register(SwaggerPlugin(swaggerConfiguration))
    }
        .get("/") { ctx ->
            ctx.result("Hello World")
        }
        .routes {
            path("api/v1/users") {
                post(UserController::register)
            }
        }
        .start(PORT)
}
