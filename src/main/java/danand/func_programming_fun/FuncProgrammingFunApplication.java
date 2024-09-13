package danand.func_programming_fun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FuncProgrammingFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncProgrammingFunApplication.class, args);
		Playground pg = new Playground();
		pg.Lambda1();
		pg.Lambda2();
		pg.Lambda3();
		pg.Lambda4();
		pg.Lambda5();
		pg.Lambda6();
		pg.Lambda7();
		pg.Lambda8();
		pg.Lambda9();
		pg.Lambda10();

	}

}
