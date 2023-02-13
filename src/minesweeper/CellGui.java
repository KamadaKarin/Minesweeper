package minesweeper;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CellGui extends GridPane{
	
	private Gui gui;
	private Pokemon pokemon;
	private Timer timer;
	
	private Stage stage;
	private Button[][] cellBtn;
	private Cell[][] cell;
	private Image[][] flagImg;
	private Image[][] medicineImg;
	private Image[][] openItemImg;
	private Image[][] cureItemImg;
	private ImageView[][] flagImgView;
	private ImageView[][] medicineImgView;
	private ImageView[][] openItemImgView;
	private ImageView[][] cureItemImgView;
	private boolean firstClick = true;
	private boolean ItemJudge = false;
	
	private int cellNum = 9;
	private int bombNum;
	private int medicineNum = 3;
	private int openItemNum = 2;
	private int cureItemNum = 2;
	private int openCount = 0;
	private int clearCount;
	private int num;
	
	
	EventHandler<MouseEvent> mouseClick = ( event ) -> this.mouseClick( event );
	EventHandler<MouseEvent> itemMouseClick = ( event ) -> this.itemMouseClick( event );

	
	public CellGui(Stage stage, Gui gui, int bombNum,int clearCount,Pokemon pokemon) {//9×9のマス
		this.stage = stage;
		this.gui = gui;
		this.pokemon = pokemon;
		this.bombNum = bombNum;
		this.clearCount = clearCount;
		
		
		cellBtn = new Button[cellNum][cellNum];
		cell = new Cell[cellNum][cellNum];
		
		for(int i = 0; i < cellBtn.length; i++) {//行
			for(int j = 0; j < cellBtn[i].length; j++) {//列
				cellBtn[i][j] = new Button();//ボタン生成
				cellBtn[i][j].setPrefWidth(40);
				cellBtn[i][j].setPrefHeight(40);
				cell[i][j] = new Cell();//81個のマス情報を生成
			}
		}
		
		for(int i = 0; i < cellBtn.length; i++){
            for(int j = 0; j < cellBtn[i].length; j++){
            	this.add(this.cellBtn[i][j], i, j);
            	 cellBtn[i][j].addEventHandler( MouseEvent.MOUSE_CLICKED , mouseClick);
            }
        }
		
		cellImage();
		
		if(ItemJudge == false) {
			medicineItem();
			openItem();
			cureItem();
			ItemJudge = true;
		}
	}
	
	public void cellImage() {
		
		//旗の画像
		flagImg = new Image[cellNum][cellNum];
		flagImgView = new ImageView[cellNum][cellNum];
		
		for(int i = 0; i < flagImg.length; i++) {//行
			for(int j = 0; j < flagImg[i].length; j++) {//列
				flagImg[i][j] = new Image("file:C:\\マインスイーパー/flag.png",40,0, true, false);
				flagImgView[i][j] = new ImageView(flagImg[i][j]);
				flagImgView[i][j].setVisible(false);
				this.add(flagImgView[i][j], i, j);
				flagImgView[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseClick);
			}
		}
		
		//くすりの画像
		medicineImg = new Image[cellNum][cellNum];
		medicineImgView = new ImageView[cellNum][cellNum];
		
		for(int i = 0; i < medicineImg.length; i++) {//行
			for(int j = 0; j < medicineImg[i].length; j++) {//列
				medicineImg[i][j] = new Image("file:C:\\マインスイーパー/キズぐすり.png",40,0, true, false);
				medicineImgView[i][j] = new ImageView(medicineImg[i][j]);
				medicineImgView[i][j].setVisible(false);
				this.add(medicineImgView[i][j], i, j);
				medicineImgView[i][j].addEventHandler( MouseEvent.MOUSE_CLICKED , itemMouseClick);
				
			}
		}
		
		//マスを開けるアイテムの画像
		openItemImg = new Image[cellNum][cellNum];
		openItemImgView = new ImageView[cellNum][cellNum];
		
		for(int i = 0; i < openItemImg.length; i++) {//行
			for(int j = 0; j < openItemImg[i].length; j++) {//列
				openItemImg[i][j] = new Image("file:C:\\マインスイーパー/openItem.png",40,0, true, false);
				openItemImgView[i][j] = new ImageView(openItemImg[i][j]);
				openItemImgView[i][j].setVisible(false);
				this.add(openItemImgView[i][j], i, j);
				openItemImgView[i][j].addEventHandler( MouseEvent.MOUSE_CLICKED , itemMouseClick);
			}
		}
		
		//なんでもなおし
		cureItemImg = new Image[cellNum][cellNum];
		cureItemImgView = new ImageView[cellNum][cellNum];
		
		for(int i = 0; i < cureItemImg.length; i++) {//行
			for(int j = 0; j < cureItemImg[i].length; j++) {//列
				cureItemImg[i][j] = new Image("file:C:\\マインスイーパー/なんでもなおし.png",40,0, true, false);
				cureItemImgView[i][j] = new ImageView(cureItemImg[i][j]);
				cureItemImgView[i][j].setVisible(false);
				this.add(cureItemImgView[i][j], i, j);
				cureItemImgView[i][j].addEventHandler( MouseEvent.MOUSE_CLICKED , itemMouseClick);
			}
		}
	}
	

	public void mouseClick(MouseEvent event) {//マウスクリックの処理
		
		if (event.getButton() == MouseButton.SECONDARY) {//右クリックされたら
			
			for(int i = 0; i < cellBtn.length; i++) {
				for(int j = 0; j < cellBtn[i].length; j++) {
					
					if(event.getSource() == cellBtn[i][j]) {//どこが押されたか取得
							settingFlag(i,j);//押された場所をsettingFlagに送る
						
					}
					if(event.getSource() == flagImgView[i][j]) {//どこが押されたか取得
						settingFlag(i,j);//押された場所をsettingFlagに送る
						
					}
						
				}
			}
		}
			
		if(event.getButton() == MouseButton.PRIMARY) {//左クリックされたら
			for(int i = 0; i < cellBtn.length; i++) {
				for(int j = 0; j < cellBtn[i].length; j++) {
						
					if(event.getSource() == cellBtn[i][j]) {//どこが押されたか取得
						
						if(firstClick == true) {//最初のクリックだったら
							putBomb(i,j);//爆弾を設置
							gui.setTimer();
							pokemon.attackTimer();	
						}
							
						
						if(cell[i][j].getBomb() == true) {//爆弾を押したら
							gui.gameOverScreen(stage);
							pokemon.stopTimer();
							gui.lowDamageStop();
						}
					
						else if(cell[i][j].getFlag() == false) {
							openCell(i,j);
							firstClick = false;
							clear();
						}
					}
				}
			}	
		}
	}
	
	
	public void itemMouseClick(MouseEvent itemEvent) {
		for(int i = 0; i < cellBtn.length; i++) {
			for(int j = 0; j < cellBtn[i].length; j++) {
				
				if(itemEvent.getSource() == medicineImgView[i][j]) {//どこが押されたか取得
					itemBox(i,j);	
					gui.setMedicineItem();
				}
				
				if(itemEvent.getSource() == openItemImgView[i][j]) {//どこが押されたか取得
					itemBox(i,j);
					gui.setOpenItem();
				}
				
				if(itemEvent.getSource() == cureItemImgView[i][j]) {//どこが押されたか取得
					itemBox(i,j);
					gui.setCureItem();
				}
			}
		}
	}
	
	
	public void settingFlag(int i,int j) {
		if(cell[i][j].getFlag() == false) {//旗が立っていなかったら
			flagImgView[i][j].setVisible(true);
			cell[i][j].setFlag(true);//立っている
		}
		
		else if(cell[i][j].getFlag() == true) {//旗が立っていたら
			flagImgView[i][j].setVisible(false);
			cell[i][j].setFlag(false);//立っていない
		}
	}
	
	public void putBomb(int x, int y) {
		Random rnd = new Random();
		int bombX;
		int bombY;
		
		while(true) {
			for(int i = 0; i < bombNum; i++) {//10個の爆弾を生成
				bombX = rnd.nextInt(cellNum);//ランダムにx座標指定
				bombY = rnd.nextInt(cellNum);//ランダムにy座標指定
				
				if(cellBtn[x][y] == cellBtn[bombX][bombY]) {//最初にクリックされた場所と爆弾位置が被ったら
					i--;//カウントしない
				}
				else if(cell[bombX][bombY].getBomb() == true) {//爆弾位置が被ったら
					i--;
				}else if(cell[bombX][bombY].getMedicineItem() == true || cell[bombX][bombY].getOpenItem() == true || cell[bombX][bombY].getCureItem() == true) {//アイテムと位置が被ったら
					i--;
				}else {
					cellBtn[bombX][bombY].setText(".");
					cell[bombX][bombY].setBomb(true);
					bombCount(bombX,bombY);//爆弾の位置を送る	
				}	
			}
			if(cell[x][y].getBombCount() == 0) {//周りの爆弾数が0だったら
				break;
			}else {//周りに爆弾があったら
				for(int i = 0; i < cellBtn.length; i++) {
					for(int j = 0; j < cellBtn[i].length; j++) {
						cell[i][j].resetBomb();//爆弾をリセット
						
						if(cell[i][j].getMedicineItem() == false && cell[i][j].getOpenItem() == false && cell[i][j].getCureItem() == false) {
							cellBtn[i][j].setText("");
						}
					}
				}
			}
		}
	}
	
	public void medicineItem() {
		Random rnd = new Random();
		int medicineX;
		int medicineY;
		
		for(int i = 0; i < medicineNum; i++) {//キズぐすりを生成
			medicineX = rnd.nextInt(cellNum);//ランダムにx座標指定
			medicineY = rnd.nextInt(cellNum);//ランダムにy座標指定
			
			if(cell[medicineX][medicineY].getMedicineItem() == true){//アイテムの位置が被ったら
				i--;
			}
			if(cell[medicineX][medicineY].getOpenItem() == true){//openItemと位置が被ったら
				i--;
			}
			if(cell[medicineX][medicineY].getCureItem() == true){//なんでもなおしと位置が被ったら
				i--;
			}else {
				cell[medicineX][medicineY].setMedicineItem(true);
			}
		}
	}
	
	public void openItem() {
		Random rnd = new Random();
		int openItemX;
		int openItemY;
		
		for(int i = 0; i < openItemNum; i++) {//キズぐすりを生成
			openItemX = rnd.nextInt(cellNum);//ランダムにx座標指定
			openItemY = rnd.nextInt(cellNum);//ランダムにy座標指定
			
			if(cell[openItemX][openItemY].getOpenItem() == true){//アイテムの位置が被ったら
				i--;
			}
			if(cell[openItemX][openItemY].getMedicineItem() == true){//キズぐすりと位置が被ったら
				i--;
			}
			if(cell[openItemX][openItemY].getCureItem() == true){//なんでもなおしと位置が被ったら
				i--;
			}else {
				cell[openItemX][openItemY].setOpenItem(true);
			}
		}
	}
	
	public void cureItem() {
		Random rnd = new Random();
		int cureItemX;
		int cureItemY;
		
		for(int i = 0; i < cureItemNum; i++) {//キズぐすりを生成
			cureItemX = rnd.nextInt(cellNum);//ランダムにx座標指定
			cureItemY = rnd.nextInt(cellNum);//ランダムにy座標指定
			
			if(cell[cureItemX][cureItemY].getCureItem() == true){//アイテムの位置が被ったら
				i--;
			}
			if(cell[cureItemX][cureItemY].getMedicineItem() == true){//medicineItemと位置が被ったら
				i--;
			}
			if(cell[cureItemX][cureItemY].getOpenItem() == true){//openItemと位置が被ったら
				i--;
			}else {
				cell[cureItemX][cureItemY].setCureItem(true);
			}
		}
	}
	
	public void itemBox(int x,int y) {
		if(cell[x][y].getOpenItem() == true) {
			openItemImgView[x][y].setVisible(false);
			cell[x][y].setOpenItem(false);
		}
		
		if(cell[x][y].getMedicineItem() == true) {
			medicineImgView[x][y].setVisible(false);
			cell[x][y].setMedicineItem(false);
		}
		
		if(cell[x][y].getCureItem() == true) {
			cureItemImgView[x][y].setVisible(false);
			cell[x][y].setCureItem(false);
		}
	}
	
	
	public void bombCount(int bombX,int bombY) {//爆弾数を数える
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				if(bombX+i >= 0 && bombY+j >= 0 && bombX+i < cellNum && bombY+j < cellNum) {//範囲内だったら
					cell[bombX+i][bombY+j].setBombCount();//周りの爆弾数を数える
				}
			}
		}
	}
	
	public void openCell(int x,int y) {//マスを開ける
		cellBtn[x][y].setDisable(true);//押されたボタンを使えなくする
		cell[x][y].setOpenJudge(true);
		openCount++;
		
		if(firstClick == true) {
			num++;
		}
		else {
		gui.hpGauge(openCount,clearCount,num);
		}
		
		if(cell[x][y].getBombCount() != 0) {
			cellBtn[x][y].setText(String.valueOf(cell[x][y].getBombCount()));
		}
		
		if(cell[x][y].getBombCount() == 0) {//爆弾数が0だったら
			for(int i = -1; i < 2; i++) {
				for(int j = -1; j < 2; j++) {
					if(x+i >= 0 && y+j >= 0 && x+i < cellNum && y+j < cellNum) {
						if(cell[x+i][y+j].getOpenJudge() == false) {
							openCell(x+i,y+j);
						}
					}
				}
			}
		}
		if(cell[x][y].getMedicineItem() == true) {
			medicineImgView[x][y].setVisible(true);
		}
		if(cell[x][y].getOpenItem() == true) {
			openItemImgView[x][y].setVisible(true);
		}
		if(cell[x][y].getCureItem() == true) {
			cureItemImgView[x][y].setVisible(true);
		}
	}
	
	public void openItemEffect() {//openItemを使ったときの処理
		Random random = new Random();
		int openX;
		int openY;
		
		while(true) {
			openX = random.nextInt(9);//ランダムにx座標指定
			openY = random.nextInt(9);
			
			if(cell[openX][openY].getOpenJudge() == false){
				if(cell[openX][openY].getFlag() == false && cell[openX][openY].getBomb() == false) {
					openCell(openX,openY);
					clear();
					break;
				}
			}
		}
	}
	
	public void clear() {//クリア処理
		if(openCount == (cellNum * cellNum) - bombNum) {//爆弾以外のマスが空いたら
			this.clearCount++;
			
			timer = new Timer(gui,stage);
			timer.setMoveJudge(false);
			
			pokemon.stopTimer();
			
		switch(clearCount) {
			case 1:
				gui.nextStage(stage,clearCount);
				break;
			case 2:
				gui.nextStage(stage,clearCount);
				break;
			case 3:
				gui.clearScreen(stage);
				break;
			}
		}
	}
}
