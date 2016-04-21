package com.snhien.clearslide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
	List<Player> players;
	Board board;
	
	
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isPlayerFinished(Player player){
		return (player.pos >= board.getEndPos() );
	}
	
	public void play(){
		boolean cont = true;
		int round = 0;
		while(cont){
			round++;
			for(Player player: players){
				int dice = (int)((Math.random() * 6) + 1);
				int next = player.getPos() + dice;
				
				if (board.getSnakeLadders().containsKey(next)){
					BaseSnake snakeLadder = board.getSnakeLadders().get(next);
					System.out.println("[Round=" + round + "] - Player " + player.getId() + " hit a snake/ladder " + snakeLadder.getStart() + " - " + snakeLadder.getEnd());
					next = snakeLadder.getEnd();

				}
				System.out.println("[Round=" + round + "] - Player " + player.getId() + " move from " + player.getPos() + " to " + next );
				player.setPos(next);
				if (isPlayerFinished(player)){
					cont = false;
					System.out.println("Player " + player.getId() + " won");
					break;
				}
			}
		}
	}
	
	public static void main(String args[]){
		Map<Integer, BaseSnake> snakeLadders = new HashMap<Integer, BaseSnake>();
		BaseSnake ladder = new BaseSnake(1, 5);
		BaseSnake snake = new BaseSnake(13, 7);
		snakeLadders.put(1, ladder);
		snakeLadders.put(13, snake);
		Board board = new Board(16, snakeLadders);
		List<Player> players = new ArrayList<Player>();
		for (int u=0; u<3; u++){
			Player player = new Player(u);
			players.add(player);
		}
		Game game = new Game();
		game.setBoard(board);
		game.setPlayers(players);
		game.play();
	}
}
