package OpenStore.Store;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {


		// 1. FIRST: Load the variables from the .env file
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

		// 2. SECOND: Push them into the system so Spring can see them
		dotenv.entries().forEach((DotenvEntry entry) -> System.setProperty(
				entry.getKey(), entry.getValue()
		));

		// 3. THIRD: Now that the variables are ready, start Spring Boot!
		SpringApplication.run(StoreApplication.class, args);
	}
}