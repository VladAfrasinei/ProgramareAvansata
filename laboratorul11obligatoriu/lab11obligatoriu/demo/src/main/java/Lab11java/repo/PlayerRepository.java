package Lab11java.repo;
import Lab11java.model.Player;
import ch.qos.logback.core.db.dialect.MySQLDialect;

import java.util.List;

public interface PlayerRepository extends MySQLDialect<Player, String> {

    Player findPlayerById(String id);

    void deleteById(int id);

    Player save(Player player);

    List<Player> saveAll(List<Player> players);

    List<Player> findAll();

    Player findByName(String name);
}
