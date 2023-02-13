package minesweeper;

public class Tsunbear extends Pokemon{
	public Tsunbear(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"アクアジェット","きりさく","れいとうビーム","つららおとし"};
		String[] attackType = {"通常","通常","通常+こおり","ひるみ"};
		int[] attackDamage = {40,70,90,85};
		
		super.setName("ツンベアー");
		super.setType1("こおり");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(60);
		super.setVitality(140);
	}
}
