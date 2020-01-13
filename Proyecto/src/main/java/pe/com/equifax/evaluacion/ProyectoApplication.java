package pe.com.equifax.evaluacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ProyectoApplication.class);

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Iniciando.....");
		inicio();
	}

	void inicio() {
		template.execute("DROP TABLE user IF EXISTS");
		template.execute("CREATE TABLE user(id INTEGER(11) PRIMARY KEY auto_increment, name VARCHAR(255),age NUMERIC(3),email VARCHAR(255),phone VARCHAR(9), year NUMERIC(4))");
		for (int i = 1; i < 5; i++) {
			template.update("INSERT INTO user(id,name,age,email,phone,year)values(" + i + ",'Petuel" + i + "',2"+i+",'example@gmail.com','988253450',1992)");
		}
	}

}
