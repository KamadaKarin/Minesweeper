package minesweeper;

public class Gengar extends Pokemon{
	public Gengar(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"シャドーボール","あくのはどう","どくどく","サイコキネシス"};
		String[] attackType = {"通常","通常","どく","通常攻撃"};
		int[] attackDamage = {80,80,0,90};
		
		super.setName("ゲンガー");
		super.setType1("どく");
		super.setType2("ゴースト");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(60);
		super.setVitality(140);
	}
}
