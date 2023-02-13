package minesweeper;

public class Burakki extends Pokemon{
	public Burakki(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"あくのはどう","かみつく","スピードスター","あやしいひかり"};
		String[] attackType = {"通常","ひるみ","通常","こんらん"};
		int[] attackDamage = {80,60,60,0};
		
		super.setName("ブラッキー");
		super.setType1("あく");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(50);
		super.setVitality(140);
	}
}
