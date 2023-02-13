package minesweeper;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Pokemon {
	private Gui gui;
	private Timer timer;
	
	public Pokemon(Gui gui,Timer timer) {
		this.gui = gui;
		this.timer = timer;
	}
	
	private String name; 
	private String type1 = null;//タイプ
	private String type2 = null;
	private String[] attack;
	private String[] attackType;
	private int[] damage;
	
	private int vitality = 0;//HP
	private int power = 0;//攻撃力
	private int quickness = 0;
	
	Timeline attackTimer;
	Timeline nullTextTimer;
	
	//Timer timer = new Timer(gui);
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getVitality() {
		return vitality;
	}
	
	public void setVitality(int vitality) {
		this.vitality = vitality;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getQuickness() {
		return quickness;
	}
	
	public void setQuickness(int quickness) {
		this.quickness = quickness;
	}
	
	public String getType1() {
		return type1;
	}
	
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public String getType2() {
		return type2;
	}
	
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public String[] getAttack() {
		return attack;
	}
	
	public void setAttack(String[] attack) {
		this.attack = attack;
	}
	
	public String[] getAttackType() {
		return attackType;
	}

	public void setAttackType(String[] attackType) {
		this.attackType = attackType;
	}
	
	public int[] getAttackDamage() {
		return damage;
	}
	
	public void setAttackDamage(int[] damage) {
		this.damage = damage;
	}
	
	
	public void attackTimer() {
		attackTimer = new Timeline(new KeyFrame(Duration.millis(15000), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Random rnd = new Random();
				int attackNum = rnd.nextInt(4);
				System.out.println(attackNum);
				
				if(attackType[attackNum].equals("通常")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\n" + damage[attackNum] + " のダメージを受けた！");
					timer.loseTime(getPower() + damage[attackNum]);
					nullText();
				}
				
				else if(attackType[attackNum].equals("通常+まひ")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nまひして体が動かない！");
					gui.getConditionLabel().setText("まひ");
					gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.YELLOW , new CornerRadii(5) , Insets.EMPTY  )));
					timer.loseTime(getPower() + damage[attackNum]);
					gui.moveStop("まひ");
					nullText();
				}
				
				else if(attackType[attackNum].equals("通常+こおり")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\n凍ってしまって動けない！");
					gui.getConditionLabel().setText("こおり");
					gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.LIGHTSKYBLUE , new CornerRadii(5) , Insets.EMPTY  )));
					timer.loseTime(getPower() + damage[attackNum]);
					gui.moveStop("こおり");
					nullText();
				}
				
				else if(attackType[attackNum].equals("通常+やけど")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nやけどのダメージを受けた");
					//gui.getConditionLabel().setText("やけど");
					//gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.DARKORANGE , new CornerRadii(5) , Insets.EMPTY  )));
					gui.burnChangeText();
					timer.loseTime(getPower() + damage[attackNum]);
					gui.conditionDamage("やけど");
					nullText();
				}
				
				else if(attackType[attackNum].equals("通常+どく")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nどくのダメージを受けた");
					//gui.getConditionLabel().setText("どく");
					//gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.PLUM , new CornerRadii(5) , Insets.EMPTY  )));
					gui.poisonChangeText();
					timer.loseTime(getPower() + damage[attackNum]);
					gui.conditionDamage("どく");
					nullText();
				}
				
				else if(attackType[attackNum].equals("通常+こんらん")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nこんらんしてわけもわからず自分を攻撃した");
					//gui.getConditionLabel().setText("どく");
					//gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.LIGHTSALMON , new CornerRadii(5) , Insets.EMPTY  )));
					gui.confusionChangeText();
					timer.loseTime(getPower() + damage[attackNum]);
					gui.conditionDamage("こんらん");
					nullText();
				}
				
				else if(attackType[attackNum].equals("まひ")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nまひして体が動かない！");
					gui.getConditionLabel().setText("まひ");
					gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.YELLOW , new CornerRadii(5) , Insets.EMPTY  )));
					//gui.getLabel2().setText("まひして体が動かない！");
					gui.moveStop("まひ");
					nullText();
				}
				
				else if(attackType[attackNum].equals("ねむり")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\n眠気におそわれねむってしまった");
					gui.getConditionLabel().setText("ねむり");
					gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE , new CornerRadii(5) , Insets.EMPTY  )));
					//gui.getLabel2().setText("眠気におそわれねむってしまった");
					gui.moveStop("ねむり");
					nullText();
				}
				
				else if(attackType[attackNum].equals("こおり")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\n凍ってしまって動けない！");
					//gui.getLabel2().setText("凍ってしまって動けない！");
					gui.getConditionLabel().setText("こおり");
					gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.LIGHTSKYBLUE , new CornerRadii(5) , Insets.EMPTY  )));
					gui.moveStop("こおり");
					nullText();
				}
				
				else if(attackType[attackNum].equals("ひるみ")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\n" + damage[attackNum] + " のダメージを受けた\nひるんで動けない！");
					//gui.getLabel2().setText(String.valueOf(damage[attackNum]) + " のダメージをうけた");
					//gui.getLabel1().setText("ひるんで動けない！");
					
					timer.loseTime(getPower() + damage[attackNum]);
					gui.moveStop("");
					nullText();
				}
				
				else if(attackType[attackNum].equals("やけど")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nやけどのダメージを受けた");
					//gui.getLabel2().setText("やけどのダメージを受けた");
					gui.burnChangeText();
					//gui.getConditionLabel().setText("やけど");
					//gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.DARKORANGE , new CornerRadii(5) , Insets.EMPTY  )));
					gui.conditionDamage("やけど");
					nullText();
					//System.out.println("defg");
				}
				
				else if(attackType[attackNum].equals("どく")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nどくのダメージを受けた");
					//gui.getLabel2().setText("どくのダメージを受けた");
					gui.poisonChangeText();
					//gui.getConditionLabel().setText("どく");
					//gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.PLUM , new CornerRadii(5) , Insets.EMPTY  )));
					gui.conditionDamage("どく");
					nullText();
					//System.out.println("defg");
				}
				
				else if(attackType[attackNum].equals("こんらん")) {
					gui.getLabel().setText(getName() + "の" + attack[attackNum] + "攻撃!\nこんらんしてわけもわからず自分を攻撃した");
					//gui.getLabel2().setText("こんらんしてわけもわからず自分を攻撃した");
					gui.confusionChangeText();
					//gui.getConditionLabel().setText("こんらん");
					//gui.getConditionLabel().setBackground(new Background(new BackgroundFill( Color.LIGHTSALMON , new CornerRadii(5) , Insets.EMPTY  )));
					gui.conditionDamage("こんらん");
					nullText();
					//System.out.println("defg");
				}
			}
		}));
		
		attackTimer.setCycleCount(Timeline.INDEFINITE);
        attackTimer.play();
	}
	
	public void nullText() {
		nullTextTimer = new Timeline(new KeyFrame(Duration.millis(8000), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				gui.getLabel().setText(null);
			}
		}));
	
		nullTextTimer.setCycleCount(1);
		nullTextTimer.play();
	}
	
	public void stopTimer() {
		attackTimer.stop();
	}
}