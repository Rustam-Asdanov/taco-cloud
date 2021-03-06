package tacos.congig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tacos.data.IngredientRepository;
import tacos.model.Ingredient;

import tacos.model.Ingredient.Type;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                repository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                repository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                repository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                repository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                repository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                repository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                repository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                repository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                repository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
            }
        };
    }
}
