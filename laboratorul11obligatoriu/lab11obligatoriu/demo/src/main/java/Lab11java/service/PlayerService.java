package Lab11java.service;

import Lab11java.model.Game;
import Lab11java.model.Player;
import Lab11java.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerService {
    @Autowired
    private PlayerRepository repository;

    public Player savePlayer(Player player){                    //POST -> salveaza un singur player
        return repository.save(player);
    }
    public List<Player> savePlayers(List<Player> players){      //POST -> salveza mai multi playeri
        return repository.saveAll(players);
    }
    public List<Player> getPlayers(){
        return repository.findAll();
    }
    public Player getPlayerById(int id){                        //GET -> cauta dupa id
        return repository.findPlayerById(id).orElse(null);
    }
    public Game createGame() {
    }
    public Player getPlayerByName(String name){                 //GET -> cauta dupa nume
        return repository.findByName(name);
    }
    public String deletePlayer(int id){
        repository.deleteById(id);
        return "Player-ul cu id-ul "+id+" a fost sters";        //DELETE -> sterge in functie de id
    }
    public Player playerUpdate(Player player){
        Player playerExistent = repository.findPlayerById(player.getId()).orElse(null);
        playerExistent.setName(player.getName());
        return repository.save(playerExistent);
    }

    public List<Game> getAllGame() {
    }
}