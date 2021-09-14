package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    private static final Logger Log = LoggerFactory.getLogger(SpringApplication.DEFAULT_CONTEXT_CLASS);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StateRepository stateRepository, GameRepository gameRepository, PrizeRepository prizeRepository) {
        return (args) -> {
            Log.info("It's Working");
            State MN = new State("Minnesota");
            State WI = new State("Wisconsin");
            stateRepository.save(MN);
            stateRepository.save(WI);
            stateRepository.save(new State("South Dakota"));
            stateRepository.save(new State("Michigan"));

            Game game = new Game();
            game.setGameName("Powerball");
            List<State> stateList = new ArrayList<>();
            stateList.add(MN);
            stateList.add(WI);
            game.setStateList(stateList);
            gameRepository.save(game);

            Prize prize = new Prize();
            prize.setWinningNumbers("13424");
            prize.setPrizeAmount("$1000");
            prize.setOdds("1 in 3125");
            prize.setGame(game);
            prizeRepository.save(prize);

            System.out.println("States");
            for(State state : stateRepository.findAll()) {
                System.out.println(state.getStateName());
            }
            System.out.println("");

            System.out.println("Games");
            for(Game g : gameRepository.findAll()) {
                System.out.println(g.getGameName());
            }
            System.out.println("");

            System.out.println("Drawings");
            for (Prize p : prizeRepository.findAll()) {
                System.out.println(p.getGame().getGameName() + ": " + p.getOdds() + " " + p.getPrizeAmount());
            }


        };
    }
}
