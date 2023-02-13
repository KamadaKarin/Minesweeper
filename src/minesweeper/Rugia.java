package minesweeper;

public class Rugia extends Pokemon{
	public Rugia(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"ドラゴンダイブ","ハイドロポンプ","ふぶき","でんじほう"};
		String[] attackType = {"通常","通常","通常+こおり","通常+まひ"};
		int[] attackDamage = {100,110,110,120};
		
		super.setName("ルギア");
		super.setType1("ドラゴン");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(80);
		super.setVitality(140);
	}
}
