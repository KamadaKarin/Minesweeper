package minesweeper;

public class Dorameshiya extends Pokemon{
	public Dorameshiya(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"おどろかす","かみつく","でんこうせっか","あやしいひかり"};
		String[] attackType = {"通常","ひるみ","通常","こんらん"};
		int[] attackDamage = {30,60,40,0};
		
		super.setName("ドラメシヤ");
		super.setType1("ドラゴン");
		super.setType2("ゴースト");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(20);
		super.setVitality(15);
	}
}
