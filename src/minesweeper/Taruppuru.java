package minesweeper;

public class Taruppuru extends Pokemon{
	public Taruppuru(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"りゅうのはどう","りんごさん","ずつき","のしかかり"};
		String[] attackType = {"通常","通常","通常+ひるみ","通常"};
		int[] attackDamage = {85,80,70,85};
		
		super.setName("タルップル");
		super.setType1("くさ");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(45);
		super.setVitality(140);
	}
}
