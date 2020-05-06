package Lab11java.repo;
import Lab11java.model.Game;
import ch.qos.logback.core.db.dialect.MySQLDialect;

public interface GameRepository extends MySQLDialect<Game, String> {
    Game findGameById(String id);


}
