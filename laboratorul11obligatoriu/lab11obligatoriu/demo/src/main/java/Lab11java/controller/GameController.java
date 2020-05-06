package Lab11java.controller;

import Lab11java.model.Game;
import Lab11java.service.PlayerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab11")
public class GameController {
    @RequestMapping(path = "/games", method = RequestMethod.POST)
    public ResponseEntity<Game> createOrUpdateUser() {
        PlayerService service = null;
        Game newUser = service.createGame();
        return new ResponseEntity<Game>(newUser, new HttpHeaders(), HttpStatus.CREATED);
    }
//read

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getUsers() {
        PlayerService service = null;
        List<Game> games = service.getAllGame();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<List<Game>>(games, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(path = "/games/{id}", method = RequestMethod.GET)
    public ResponseEntity<Game> getUserById(@PathVariable String id) {
        PlayerService service = null;
        Game game = service.getPlayerById();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<Game>(game, httpHeaders, HttpStatus.OK);
    }

    //update
    @RequestMapping(path = "/games/move", method = RequestMethod.PUT)
    public ResponseEntity<String> putMove(@RequestBody Game move) {
        GameController service = null;
        ResponseEntity<String> s = service.putMove(move);
        return new ResponseEntity<>(s, new HttpHeaders(), HttpStatus.OK);
    }
    }
}
