package com.lynas.swaggereditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class SwaggerEditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerEditorApplication.class, args);
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("book store", "sample desc", "1.0", "", "some@mail", "MIT", "");
	}

	@Bean
	public Docket docket() {
		Parameter parameter = new ParameterBuilder()
				.name("Auth")
				.description("auth desc")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false)
				.build();
		List<Parameter> parameterList = new ArrayList<>();
		parameterList.add(parameter);
		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(parameterList)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
}


@Controller
@ApiIgnore
class HomeController {
	@RequestMapping("/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}