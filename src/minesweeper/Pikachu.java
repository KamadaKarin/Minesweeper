package minesweeper;

public class Pikachu extends Pokemon{
	public Pikachu(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"10まんボルト","でんきショック","でんこうせっか","でんじは"};
		String[] attackType = {"通常","通常","通常","まひ"};
		int[] attackDamage = {90,40,40,0};
		
		super.setName("ピカチュウ");
		super.setType1("でんき");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(25);
		super.setVitality(18);
	}
}
