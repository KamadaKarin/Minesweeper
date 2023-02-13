package minesweeper;

import javafx.application.Platform;
import javafx.stage.Stage;

public class Timer extends Thread{
	
	private Gui gui;
	private Stage stage;
	
	private int sec = 3000;
	private int count = 3000;
	
	private boolean moveJudge = true;
	
	public Timer(Gui gui,Stage stage) {
		this.gui = gui;
		this.stage = stage;
	}
	
	public void run() {
		while (moveJudge) {
			if(count > 0) {
				try {
					Thread.sleep(100);
				}
				catch (InterruptedException ex) {
					System.err.println(ex);
				}
				count--;
			
				Platform.runLater( () ->
				{
					// GUI操作処理
					gui.timeGauge(sec, count);
				});
			}
			else {
				Platform.runLater( () ->
				{
					gui.gameOverScreen(stage);
					gui.timeOver();
					gui.lowDamageStop();
				});
			}
		}
	}
	
	
	public int getTime() {
		return count;
	}
	
	public void moreTime() {
		count = count + 300;
	}
	
	public void loseTime(int damage) {
		count = count - damage;
	}
	
	public void setMoveJudge(boolean moveJudge) {
		this.moveJudge = moveJudge;
	}

	public void lowLoseTime(int lowDamage) {
		count = count - lowDamage;
	}
}
