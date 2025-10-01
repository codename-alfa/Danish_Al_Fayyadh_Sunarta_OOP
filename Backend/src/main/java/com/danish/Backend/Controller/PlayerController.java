package com.danish.Backend.Controller;

import com.danish.Backend.Model.Player;
import com.danish.Backend.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<List<Player>> getPlayerById(@PathVariable UUID playerId){
        Optional<Player>players = playerService.getPlayerById(playerId);
        if(players.isPresent()){
            return ResponseEntity.ok(player.get());
        } else {
            return new ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<Player>> getPlayerByUsername(@PathVariable String username){
        Optional<Player>players = playerService.getPlayerByUsername(username);
        if(players.isPresent()){
            return ResponseEntity.ok(player.get());
        } else {
            return new ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Player>> checkUsername(@PathVariable String username){
        return playerService.isUsernameExists(username);
    }

    @PostMapping
    public ResponseEntity<List<Player>> createPlayer(@RequestBody Player player){

    }

}
