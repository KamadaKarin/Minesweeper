package minesweeper;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Gui extends Application{
	
	CellGui cellGui;
	Timer timer;
	Pokemon pokemon;
	
	private Scene startSc;//スタート画面
	private Scene gameSc1;//ゲーム画面
	private Scene gameSc2;//ゲーム画面
	private Scene gameSc3;//ゲーム画面
	private Scene nextSc;//次のステージへ飛ぶ画面
	private Scene clearSc;//クリア画面
	private Scene gameOverSc;//ゲームオーバー画面
	private HBox enemyHb;
	private HBox hpHb;
	private HBox msHb;
	private HBox clearHb1;
	private HBox clearHb2;
	private HBox gameOverHb1;
	private HBox gameOverHb2;
	private HBox timeHb;
	private HBox itemHb;
	private HBox conditionHb;
	private VBox hpVb;
	private VBox msVb;
	private VBox gameScVb;
	private VBox startVb;
	private VBox nextVb;
	private VBox clearVb;
	private VBox gameOverVb;
	private VBox timeVb;
	private Button startBtn;
	private Button nextBtn;
	private Button exitBtn;
	private Button clearExitBtn;
	private Button backBtn;
	private Button clearBackBtn;
	private Label clearLabel;
	private Label gameOverLabel;
	private Label hpLabel;
	private Label textLabel;
	private Label timeLabel;
	private Label conditionLabel;
	private Label[] itemLabel;
	private ProgressBar hpBar;
	private ProgressBar timeBar;
	private Item[] item;
	private int itemCount;
	private int damageCount;
	private boolean itemDisable = false;
	private boolean moveTimerJudge2 = false;
	private boolean moveTimerJudge = false;
	Timeline damageTimer;
	Timeline moveStopTimer;
	
	
	EventHandler<MouseEvent> itemMouseClick = ( event ) -> this.itemEventMouseClick( event );
	
	private ImageView[] firstImgView;
	
	private Image imgC = new Image("file:C:\\マインスイーパー/チュリネ.png",230,0, true, false);
	private Image imgP = new Image("file:C:\\マインスイーパー/ピカチュウ.png",230,0, true, false);
	private Image imgH = new Image("file:C:\\マインスイーパー/ヒコザル.png",230,0, true, false);
	private Image imgN = new Image("file:C:\\マインスイーパー/ベトベター.png",230,0, true, false);
	private Image imgD = new Image("file:C:\\マインスイーパー/ドラメシヤ.png",230,0, true, false);
    
	
    private ImageView[] secondImgView;
	
	private Image imgT = new Image("file:C:\\マインスイーパー/ツンベアー.png",290,0, true, false);
	private Image imgB = new Image("file:C:\\マインスイーパー/ブラッキー.png",240,0, true, false);
	private Image imgG = new Image("file:C:\\マインスイーパー/ゲンガー.png",280,0, true, false);
	private Image imgK = new Image("file:C:\\マインスイーパー/キュウコン.png",280,0, true, false);
	private Image imgTR = new Image("file:C:\\マインスイーパー/タルップル.png",280,0, true, false);
	
    
    private ImageView[] finalImgView;
    
	private Image imgM = new Image("file:C:\\マインスイーパー/ムゲンダイナ.png",320,0, true, false); 
    private Image imgZ = new Image("file:C:\\マインスイーパー/ゼクロム.png",320,0, true, false);
    private Image imgGR = new Image("file:C:\\マインスイーパー/ギラティナ.png",320,0, true, false);
    private Image imgMY = new Image("file:C:\\マインスイーパー/ミュウツー.png",320,0, true, false);
    private Image imgRG = new Image("file:C:\\マインスイーパー/ルギア.png",320,0, true, false);
    
    private Image startImg = new Image("file:C:\\マインスイーパー/start.png",900,650,true,false);
    private BackgroundImage bgStartImg = new BackgroundImage(startImg,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private Background bgStart = new Background(bgStartImg);
    
    private Image backImg1 = new Image("file:C:\\マインスイーパー/背景ステージ1.png",900,650,false,false);
    private BackgroundImage bgImg1 = new BackgroundImage(backImg1,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private Background bGround1 = new Background(bgImg1);
    
    private Image backImg2 = new Image("file:C:\\マインスイーパー/IMG-2039.jpg",900,650,false,false);
    private BackgroundImage bgImg2 = new BackgroundImage(backImg2,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private Background bGround2 = new Background(bgImg2);
    
    private Image backImg3 = new Image("file:C:\\マインスイーパー/背景ステージ3.jpg",900,650,false,false);
    private BackgroundImage bgImg3 = new BackgroundImage(backImg3,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private Background bGround3 = new Background(bgImg3);
    
    private Image nextStageImg1 = new Image("file:C:\\マインスイーパー/nextStage1.jpg",1200,0,true,false);
    private BackgroundImage nextStageBgImg1 = new BackgroundImage(nextStageImg1,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private Background bgNextStage1 = new Background(nextStageBgImg1);
    
    private Image nextStageImg2 = new Image("file:C:\\マインスイーパー/nextStage2.jpg",925,650,false,false);
    private BackgroundImage nextStageBgImg2 = new BackgroundImage(nextStageImg2,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private Background bgNextStage2 = new Background(nextStageBgImg2);
    
    private Image clearImg = new Image("file:C:\\マインスイーパー/clearStage.jpg",1250,700,true,false);
    private BackgroundImage bgClearImg = new BackgroundImage(clearImg,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
    private Background clearStage = new Background(bgClearImg);
    
    private Image gameOverImg = new Image("file:C:\\マインスイーパー/gameOver.png",650,0,true,false);
    private BackgroundImage bgGameOverImg = new BackgroundImage(gameOverImg,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
    private Background gameOverStage = new Background(bgGameOverImg);
    
    private Image medicineImg = new Image("file:C:\\マインスイーパー/キズぐすり.png",40,0, true, false);
    private ImageView[] medicineImgView;
    
    private Image cureItemImg = new Image("file:C:\\マインスイーパー/なんでもなおし.png",40,0, true, false);
    private ImageView[] cureItemImgView;
    
    private Image openItemImg = new Image("file:C:\\マインスイーパー/openItem.png",40,0, true, false);
    private ImageView[] openItemImgView;

	
	public void bigin(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		startupScreen(stage);
		stage.setResizable(false);//画面拡大不可
		stage.setTitle("マインスイーパ");//タイトル
		stage.setScene(startSc);
		stage.show();
	}
	
	public void startupScreen(Stage stage) {
		startVb = new VBox();
		startBtn = new Button();
		startBtn.setPrefWidth(150);//横のサイズ
		startBtn.setPrefHeight(50);//縦のサイズ
		startBtn.setText("S T A R T");
		startBtn.setFont(new Font(20));//文字サイズ
		
		EventHandler<MouseEvent> gameStart = (event) -> gameScreen1(event,stage);//マウスクリックで画面切り替え
		startBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, gameStart);
		
		startVb.getChildren().add(startBtn);
		startVb.setPadding(new Insets(300,0,0,0));
		startVb.setBackground(bgStart);
		startVb.setAlignment(Pos.CENTER);
		
		startSc = new Scene(startVb,900,650);
	}
	
	public void gameScreen1(MouseEvent event,Stage stage) {//ゲーム画面
		int clearCount = 0;
		int bombNum = 10;
		itemCount = 0;
		
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		timer =  new Timer(this,stage);
		
		hpLabel = new Label();
	    hpLabel.setText("HP：");
	    hpLabel.setFont(new Font(15));
	    
	    hpBar = new ProgressBar(1.0);
	    hpBar.setPrefSize(350, 15);
	    
	    hpHb = new HBox();
	    hpHb.setPrefSize(400, 60);
	    hpHb.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
	    hpHb.setBorder(border);
	    hpHb.getChildren().addAll(hpLabel,hpBar);
	    hpHb.setAlignment(Pos.CENTER);
	    
	    hpVb = new VBox();
	    hpVb.setPadding(new Insets(0,25,0,0));
		hpVb.setAlignment(Pos.CENTER);
		hpVb.getChildren().addAll(hpHb);
	    
	    
	    Random rndFirstImg = new Random();
		int firstImgNum = rndFirstImg.nextInt(5);
		
		switch(firstImgNum) {
			case 0:
				pokemon = new Churine(this,timer);
				break;
			case 1:
				pokemon = new Pikachu(this,timer);
				break;
			case 2:
				pokemon = new Hikozaru(this,timer);
				break;
			case 3:
				pokemon = new Betobeta(this,timer);
				break;
			case 4:
				pokemon = new Dorameshiya(this,timer);
				break;
		}
		
		
		firstImgView = new ImageView[5];
		firstImgView[0] = new ImageView(imgC);
		firstImgView[1] = new ImageView(imgP);
		firstImgView[2] = new ImageView(imgH);
		firstImgView[3] = new ImageView(imgN);
		firstImgView[4] = new ImageView(imgD);
	    
		
		enemyHb = new HBox(50);
		enemyHb.setPadding(new Insets(0,0,0,50));
		enemyHb.getChildren().addAll(hpVb,firstImgView[firstImgNum]);

		timeLabel = new Label();
		timeLabel.setText("TIME：");
		timeLabel.setFont(new Font(15));
		
		timeBar = new ProgressBar(1.0);
		timeBar.setPrefSize(340, 15);
		
		timeHb = new HBox();
		timeHb.setPadding(new Insets(0,5,15,5));
		timeHb.getChildren().addAll(timeLabel,timeBar);
		timeHb.setAlignment(Pos.CENTER);
		
		conditionLabel = new Label();
		conditionLabel.setPrefSize(50, 20);
		conditionLabel.setFont(new Font(13));
		conditionLabel.setAlignment(Pos.CENTER);
		
		conditionHb = new HBox();
		conditionHb.setPadding(new Insets(5,20,0,0));
		conditionHb.getChildren().add(conditionLabel);
		conditionHb.setAlignment(Pos.CENTER_RIGHT);
		
		
		timeVb = new VBox();
		timeVb.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
		timeVb.setBorder(border);
		timeVb.getChildren().addAll(conditionHb,timeHb);
		
		textLabel = new Label();
		textLabel.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
		textLabel.setBorder(border);
		textLabel.setFont(new Font(16));
		textLabel.setFont( Font.font( "Meiryo UI" , 20 ) );
		textLabel.setPrefSize(400, 90);
		textLabel.setAlignment(Pos.CENTER);
		

		pokemonNameText();
		nullText();
		
		itemHb = new HBox(1);
		itemLabel = new Label[7];
		item = new Item[7];
		
		medicineImgView = new ImageView[7];
		openItemImgView = new ImageView[7];
		cureItemImgView = new ImageView[7];
		
		
		for(int i = 0; i < 7; i++) {
			medicineImgView[i] = new ImageView(medicineImg);
			openItemImgView[i] = new ImageView(openItemImg);
			cureItemImgView[i] = new ImageView(cureItemImg);
		}
		
		for(int i = 0; i< 7; i++) {
			itemLabel[i] = new Label();
			item[i] = new Item();//5つのアイテム情報を生成
			itemLabel[i].setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
			itemLabel[i].setBorder(border);
			itemLabel[i].setPrefSize(45, 45);
			itemLabel[i].addEventHandler( MouseEvent.MOUSE_CLICKED , itemMouseClick);
			itemHb.getChildren().addAll(itemLabel[i]);
		}
		
		
		cellGui = new CellGui(stage, this, bombNum, clearCount, pokemon);
		cellGui.setOpacity(0.9);
		
	
		msVb = new VBox(50);	
		msVb.getChildren().addAll(timeVb,textLabel,itemHb);
		msVb.setPrefSize(400,400);
		msVb.setAlignment(Pos.CENTER);
		
		msHb = new HBox(50);
		msHb.getChildren().addAll(cellGui,msVb);
		msHb.setPadding(new Insets(20));
		msHb.setAlignment(Pos.CENTER);
		
		gameScVb = new VBox(20);
		gameScVb.setBackground(bGround1);
		gameScVb.getChildren().addAll(enemyHb,msHb);
		gameScVb.setAlignment(Pos.CENTER);
		
		gameSc1 = new Scene(gameScVb,900,650);
		
		stage.setScene(null);
		stage.setScene(gameSc1);//ゲーム画面を貼る
	}
	
	public void gameScreen2(MouseEvent event,Stage stage,int clearCount) {
		timer =  new Timer(this,stage);
		timer.setMoveJudge(true);
		
		int bombNum = 15;
		itemCount = 0;
		
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		
		hpLabel = new Label();
	    hpLabel.setText("HP：");
	    hpLabel.setFont(new Font(15));
	    
	    hpBar = new ProgressBar(1.0);
	    hpBar.setPrefSize(350, 15);
	    
	    hpHb = new HBox();
	    hpHb.setPrefSize(400, 60);
	    hpHb.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
	    hpHb.setBorder(border);
	    hpHb.getChildren().addAll(hpLabel,hpBar);
	    hpHb.setAlignment(Pos.CENTER);
	    
	    hpVb = new VBox();
	    hpVb.setPadding(new Insets(0,25,0,0));
	    hpVb.getChildren().addAll(hpHb);
	    hpVb.setAlignment(Pos.CENTER);
	    
	    
	    Random rndSecondImg = new Random();
		int secondImgNum = rndSecondImg.nextInt(5);	
		
		switch(secondImgNum) {
		case 0:
			pokemon = new Tsunbear(this,timer);
			break;
		case 1:
			pokemon = new Burakki(this,timer);
			break;
		case 2:
			pokemon = new Gengar(this,timer);
			break;
		case 3:
			pokemon = new Kyukon(this,timer);
			break;
		case 4:
			pokemon = new Taruppuru(this,timer);
			break;
	}

		
		secondImgView = new ImageView[5];
		secondImgView[0] = new ImageView(imgT);
		secondImgView[1] = new ImageView(imgB);
		secondImgView[2] = new ImageView(imgG);
		secondImgView[3] = new ImageView(imgK);
		secondImgView[4] = new ImageView(imgTR);
	    
		
		enemyHb = new HBox(70);
		enemyHb.setPadding(new Insets(0,0,0,50));
		enemyHb.getChildren().addAll(hpVb,secondImgView[secondImgNum]);
		
		timeLabel = new Label();
		timeLabel.setText("TIME：");
		timeLabel.setFont(new Font(15));
		
		timeBar = new ProgressBar(1.0);
		timeBar.setPrefSize(340, 15);
		
		timeHb = new HBox();
		timeHb.setPadding(new Insets(0,5,15,5));
		timeHb.getChildren().addAll(timeLabel,timeBar);
		timeHb.setAlignment(Pos.CENTER);
		
		conditionLabel = new Label();
		conditionLabel.setPrefSize(50, 20);
		conditionLabel.setFont(new Font(13));
		conditionLabel.setAlignment(Pos.CENTER);
		
		conditionHb = new HBox();
		conditionHb.setPadding(new Insets(5,20,0,0));
		conditionHb.getChildren().add(conditionLabel);
		conditionHb.setAlignment(Pos.CENTER_RIGHT);
		
		timeVb = new VBox();
		timeVb.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
		timeVb.setBorder(border);
		timeVb.setPrefSize(80, 60);
		timeVb.getChildren().addAll(conditionHb, timeHb);
		timeVb.setAlignment(Pos.CENTER);
		
		textLabel = new Label();
		textLabel.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
		textLabel.setBorder(border);
		textLabel.setFont(new Font(16));
		textLabel.setFont(Font.font("Meiryo UI" , 20));
		textLabel.setPrefSize(400, 90);
		textLabel.setAlignment(Pos.CENTER);
		
		pokemonNameText();
		nullText();
		
		itemHb = new HBox(1);
		itemLabel = new Label[7];
		item = new Item[7];
		
		medicineImgView = new ImageView[7];
		openItemImgView = new ImageView[7];
		cureItemImgView = new ImageView[7];
		
		
		for(int i = 0; i < 7; i++) {
			medicineImgView[i] = new ImageView(medicineImg);
			openItemImgView[i] = new ImageView(openItemImg);
			cureItemImgView[i] = new ImageView(cureItemImg);
		}
		
		
		for(int i = 0; i< 7; i++) {
			itemLabel[i] = new Label();
			item[i] = new Item();//5つのアイテム情報を生成
			itemLabel[i].setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
			itemLabel[i].setBorder(border);
			itemLabel[i].setPrefSize(45, 45);
			itemLabel[i].addEventHandler( MouseEvent.MOUSE_CLICKED , itemMouseClick);
			itemHb.getChildren().addAll(itemLabel[i]);
		}
			
		cellGui = new CellGui(stage, this , bombNum, clearCount, pokemon);
		
		
		msVb = new VBox(50);	
		msVb.getChildren().addAll(timeVb,textLabel,itemHb);
		msVb.setAlignment(Pos.CENTER);
		
		msHb = new HBox(50);
		msHb.getChildren().addAll(cellGui,msVb);
		msHb.setPadding(new Insets(10));
		msHb.setAlignment(Pos.CENTER);
		
		
		gameScVb = new VBox(-30);
		gameScVb.setBackground(bGround2);
		gameScVb.getChildren().addAll(enemyHb,msHb);
		gameScVb.setAlignment(Pos.CENTER);
		
		gameSc2 = new Scene(gameScVb,900,650);
		
		stage.setScene(null);
		stage.setScene(gameSc2);//ゲーム画面を貼る
	}
	
	public void gameScreen3(MouseEvent event,Stage stage,int clearCount) {
		
		timer =  new Timer(this,stage);
		timer.setMoveJudge(true);
		
		int bombNum = 18;
		itemCount = 0;
		
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		
		hpLabel = new Label();
	    hpLabel.setText("HP：");
	    hpLabel.setFont(new Font(15));
	    
	    hpBar = new ProgressBar(1.0);
	    hpBar.setPrefSize(350, 15);
	    
	    hpHb = new HBox();
	    hpHb.setPrefSize(400, 60);
	    hpHb.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
	    hpHb.setBorder(border);
	    hpHb.getChildren().addAll(hpLabel,hpBar);
	    hpHb.setAlignment(Pos.CENTER);
	    
	    hpVb = new VBox();
		hpVb.setAlignment(Pos.CENTER);
		hpVb.getChildren().addAll(hpHb);
	    
	    
		Random rndFinalImg = new Random();
		int finalImgNum = rndFinalImg.nextInt(5);	
		
		switch(finalImgNum) {
		case 0:
			pokemon = new Mugendaina(this,timer);
			break;
		case 1:
			pokemon = new Zekuromu(this,timer);
			break;
		case 2:
			pokemon = new Girathina(this,timer);
			break;
		case 3:
			pokemon = new Myutu(this,timer);
			break;
		case 4:
			pokemon = new Rugia(this,timer);
			break;
	}
		
		
		finalImgView = new ImageView[5];
		finalImgView[0] = new ImageView(imgM);
		finalImgView[1] = new ImageView(imgZ);
		finalImgView[2] = new ImageView(imgGR);
		finalImgView[3] = new ImageView(imgMY);
		finalImgView[4] = new ImageView(imgRG);
		
		enemyHb = new HBox(50);
		enemyHb.setPadding(new Insets(0,0,0,50));
		enemyHb.getChildren().addAll(hpVb,finalImgView[finalImgNum]);
		
		timeLabel = new Label();
		timeLabel.setText("TIME：");
		timeLabel.setFont(new Font(15));

		timeBar = new ProgressBar(1.0);
		timeBar.setPrefSize(340, 15);
		
		timeHb = new HBox();
		timeHb.setPadding(new Insets(0,5,15,5));
		timeHb.getChildren().addAll(timeLabel,timeBar);
		timeHb.setAlignment(Pos.CENTER);
		
		conditionLabel = new Label();
		conditionLabel.setFont(new Font(13));
		conditionLabel.setPrefSize(50, 20);
		conditionLabel.setAlignment(Pos.CENTER);
		
		conditionHb = new HBox();
		conditionHb.setPadding(new Insets(5,20,0,0));
		conditionHb.getChildren().add(conditionLabel);
		conditionHb.setAlignment(Pos.CENTER_RIGHT);
		
		timeVb = new VBox();
		timeVb.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
		timeVb.setBorder(border);
		timeVb.setPrefSize(80, 60);
		timeVb.setAlignment(Pos.CENTER);
		timeVb.getChildren().addAll(conditionHb,timeHb);
		
		textLabel = new Label();
		textLabel.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
		textLabel.setBorder(border);
		textLabel.setFont(new Font(15));
		textLabel.setFont( Font.font( "Meiryo UI" , 20 ) );
		textLabel.setPrefSize(400, 90);
		textLabel.setAlignment(Pos.CENTER);
		
		pokemonNameText();
		nullText();
		
		
		itemHb = new HBox(1);
		itemLabel = new Label[7];
		item = new Item[7];
		
		medicineImgView = new ImageView[7];
		openItemImgView = new ImageView[7];
		cureItemImgView = new ImageView[7];
		
		
		for(int i = 0; i < 7; i++) {
			medicineImgView[i] = new ImageView(medicineImg);
			openItemImgView[i] = new ImageView(openItemImg);
			cureItemImgView[i] = new ImageView(cureItemImg);
		}
		
		for(int i = 0; i< 7; i++) {
			itemLabel[i] = new Label();
			item[i] = new Item();//5つのアイテム情報を生成
			itemLabel[i].setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.6) , new CornerRadii(5) , Insets.EMPTY )));
			itemLabel[i].setBorder(border);
			itemLabel[i].setPrefSize(45, 45);
			itemLabel[i].addEventHandler( MouseEvent.MOUSE_CLICKED , itemMouseClick);
			itemHb.getChildren().addAll(itemLabel[i]);
		}
		
		cellGui = new CellGui(stage, this , bombNum, clearCount, pokemon);
		
		
		msVb = new VBox(50);	
		msVb.getChildren().addAll(timeVb,textLabel,itemHb);
		msVb.setAlignment(Pos.CENTER);
		
		msHb = new HBox(50);
		msHb.getChildren().addAll(cellGui,msVb);
		msHb.setAlignment(Pos.CENTER);
		
		
		gameScVb = new VBox(-40);
		gameScVb.setBackground(bGround3);
		gameScVb.getChildren().addAll(enemyHb,msHb);
		gameScVb.setAlignment(Pos.CENTER);
		
		gameSc3 = new Scene(gameScVb,900,650);
		
		stage.setScene(null);
		stage.setScene(gameSc3);//ゲーム画面を貼る
	}
	
	public void setTimer() {
		timer.start();
	}
	
	public void moveStop(String conditionText) {
		moveTimerJudge2 = true;
		
		itemDisable = true;
		cellGui.setDisable(true);
		
		
		if(conditionText.equals("まひ")) {
			cellGui.setBackground(new Background(new BackgroundFill( Color.YELLOW , new CornerRadii(5) , Insets.EMPTY  )));
		}
		else if(conditionText.equals("ねむり")) {
			cellGui.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE , new CornerRadii(5) , Insets.EMPTY  )));
		}
		else if(conditionText.equals("こおり")) {
			cellGui.setBackground(new Background(new BackgroundFill( Color.LIGHTSKYBLUE , new CornerRadii(5) , Insets.EMPTY  )));
		}
		
		
		moveStopTimer = new Timeline(new KeyFrame(Duration.millis(10000), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				itemDisable = false;
				moveTimerJudge2 = false;
				
				cellGui.setDisable(false);
				cellGui.setBackground(null);
				
				conditionLabel.setText(null);
				conditionLabel.setBackground(null);
			}
		}));
		
		moveStopTimer.setCycleCount(1);
        moveStopTimer.play();
	}
	
	public void conditionDamage(String conditiontext) {//状態異常のダメージ
		
		damageCount = 0;
		
		moveTimerJudge = true;
		
		damageTimer = new Timeline(new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				int lowDamage = 10;
			
				
				timer.lowLoseTime(lowDamage);
				damageCount++;
				
				if(damageCount == 5) {
					moveTimerJudge = false;
					
					cellGui.setBackground(null);
					
					conditionLabel.setText(null);
					conditionLabel.setBackground(null);
				}
			}
		}));
		
		damageTimer.setCycleCount(5);
		damageTimer.play();
	}
	
	public void burnChangeText() {
		cellGui.setBackground(new Background(new BackgroundFill( Color.DARKORANGE , new CornerRadii(5) , Insets.EMPTY  )));
		conditionLabel.setText("やけど");
		conditionLabel.setBackground(new Background(new BackgroundFill( Color.DARKORANGE , new CornerRadii(5) , Insets.EMPTY  )));	
	}
	
	public void poisonChangeText() {
		cellGui.setBackground(new Background(new BackgroundFill( Color.PLUM , new CornerRadii(5) , Insets.EMPTY  )));
		conditionLabel.setText("どく");
		conditionLabel.setBackground(new Background(new BackgroundFill( Color.PLUM , new CornerRadii(5) , Insets.EMPTY  )));
	}
	
	public void confusionChangeText() {
		cellGui.setBackground(new Background(new BackgroundFill( Color.LIGHTSALMON , new CornerRadii(5) , Insets.EMPTY  )));
		conditionLabel.setText("こんらん");
		conditionLabel.setBackground(new Background(new BackgroundFill( Color.LIGHTSALMON , new CornerRadii(5) , Insets.EMPTY  )));
	}
	
	public void setMedicineItem() {
		itemLabel[itemCount].setGraphic(medicineImgView[itemCount]);
		medicineImgView[itemCount].setVisible(true);
		item[itemCount].setMedicineItemJudge(true);
		itemCount++;
	}
	
	public void setOpenItem() {
		itemLabel[itemCount].setGraphic(openItemImgView[itemCount]);
		openItemImgView[itemCount].setVisible(true);
		item[itemCount].setOpenItemJudge(true);
		itemCount++;
	}
	
	public void setCureItem() {
		itemLabel[itemCount].setGraphic(cureItemImgView[itemCount]);
		cureItemImgView[itemCount].setVisible(true);
		item[itemCount].setCureItemJudge(true);
		itemCount++;
	}
	
	public void itemEventMouseClick(MouseEvent itemMouseEvent) {
		
		for(int i = 0; i < itemLabel.length; i++) {
			
				if(itemMouseEvent.getSource() == itemLabel[i]) {
					if(itemDisable == false) {
						if(item[i].getMedicineItemJudge() == true) {
							timer.moreTime();
						
							itemLabel[i].setGraphic(null);
							item[i].setMedicineItemJudge(false);
							itemCount--;
						}
		
						else if(item[i].getOpenItemJudge() == true) {
							cellGui.openItemEffect();
					
							itemLabel[i].setGraphic(null);
							item[i].setOpenItemJudge(false);
							itemCount--;
						}
					}
					
					
					if(item[i].getCureItemJudge() == true) {
						if(moveTimerJudge == true || moveTimerJudge2 == true){
							if(itemDisable == false) {
								if(moveTimerJudge == true) {
									damageTimer.stop();
									moveTimerJudge = false;
								}
							}
							if(moveTimerJudge2 == true) {
								moveStopTimer.stop();
								
								itemDisable = false;
								moveTimerJudge2 = false;
								
								cellGui.setDisable(false);
								cellGui.setBackground(null);
								
								conditionLabel.setText(null);
								conditionLabel.setBackground(null);
						
							}
							cellGui.setBackground(null);
							
							conditionLabel.setText(null);
							conditionLabel.setBackground(null);
					
							itemLabel[i].setGraphic(null);
							item[i].setCureItemJudge(false);
							itemCount--;
						}
					}
					
					
					if(!(item[i].getCureItemJudge() == true && moveTimerJudge == false && moveTimerJudge2 == false)){
						for(int j = i; j < 6; j++) {
							item[j].setMedicineItemJudge(item[j+1].getMedicineItemJudge());
							item[j].setOpenItemJudge(item[j+1].getOpenItemJudge());
							item[j].setCureItemJudge(item[j+1].getCureItemJudge());
						
							if(item[j].getMedicineItemJudge() == true) {
								itemLabel[j].setGraphic(medicineImgView[j]);
								itemLabel[j+1].setGraphic(null);
							}
							else if(item[j].getOpenItemJudge() == true) {
								itemLabel[j].setGraphic(openItemImgView[j]);
								itemLabel[j+1].setGraphic(null);
							}
							else if(item[j].getCureItemJudge() == true) {
								itemLabel[j].setGraphic(cureItemImgView[j]);
								itemLabel[j+1].setGraphic(null);
							}
						}
					
						item[6].setMedicineItemJudge(false);
						item[6].setOpenItemJudge(false);
						item[6].setCureItemJudge(false);
						itemLabel[6].setGraphic(null);
					}
				}
			}
		}
	
	
	public void nextStage(Stage stage,int clearCount) {
		
		timer.setMoveJudge(false);
		
		lowDamageStop();
		
		nextVb = new VBox();
		nextBtn = new Button();
		nextBtn.setPrefHeight(50);//縦のサイズ
		nextBtn.setText("NEXT STAGE  ▷▷▷");
		nextBtn.setFont(new Font(17));//文字サイズ
		
		nextVb.setPadding(new Insets(120,0,0,120));
		nextVb.getChildren().add(nextBtn);
		
		if(clearCount == 1) {
			nextVb.setBackground(bgNextStage1);
			EventHandler<MouseEvent> nextStage = (event) -> gameScreen2(event,stage,clearCount);//マウスクリックで画面切り替え
			nextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, nextStage);
		}
		
		else if(clearCount == 2) {
			nextVb.setBackground(bgNextStage2);
			EventHandler<MouseEvent> nextStage = (event) -> gameScreen3(event,stage,clearCount);//マウスクリックで画面切り替え
			nextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, nextStage);
		}
		
		nextSc = new Scene(nextVb,900,650);
		
		stage.setScene(null);
		stage.setScene(nextSc);
	}
	
	
	
	public void gameOverScreen(Stage stage) {//ゲームオーバー画面
		timer.setMoveJudge(false);
		
		gameOverHb1 = new HBox();
		
		gameOverLabel = new Label();
		gameOverLabel.setText("G A M E   O V E R");
		gameOverLabel.setFont(new Font(40));
		
		gameOverHb1.getChildren().add(gameOverLabel);
		gameOverHb1.setPadding(new Insets(50,0,0,0));
		gameOverHb1.setAlignment(Pos.CENTER);
		
		gameOverHb2 = new HBox(50);
		
		exitBtn = new Button();
		exitBtn.setText("  終了  ");
		exitBtn.setFont(new Font(20));
		
		EventHandler<MouseEvent> gameStop = (event) -> Platform.exit();
		exitBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, gameStop);
		
		backBtn = new Button();
		backBtn.setText("  もう一度プレイ  ");
		backBtn.setFont(new Font(20));
		
		EventHandler<MouseEvent> gameStart = (event) -> gameScreen1(event,stage);//マウスクリックで画面切り替え
		backBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, gameStart);
		
		gameOverHb2.getChildren().addAll(exitBtn,backBtn);
		gameOverHb2.setAlignment(Pos.CENTER);
		
		gameOverVb = new VBox(430);
		gameOverVb.getChildren().addAll(gameOverHb1,gameOverHb2);
		gameOverVb.setBackground(gameOverStage);
		
		gameOverSc = new Scene(gameOverVb,900,650);
		
		stage.setScene(null);
		stage.setScene(gameOverSc);//ゲームオーバー画面を貼る
	}
	
	
	public void clearScreen(Stage stage) {
		timer.setMoveJudge(false);
		
		clearHb1 = new HBox();
		
		clearLabel = new Label();
		clearLabel.setText("  C L E A R !  ");
		clearLabel.setFont(new Font(30));
		
		clearLabel.setBackground(new Background(new BackgroundFill(new Color(1,1,1,0.8) , new CornerRadii(10) , Insets.EMPTY  )));
		
		clearHb1.getChildren().add(clearLabel);
		clearHb1.setAlignment(Pos.CENTER);
		
		clearHb2 = new HBox(30);
		
		clearExitBtn = new Button();
		clearExitBtn.setText("終了");
		clearExitBtn.setPrefWidth(100);
		
		EventHandler<MouseEvent> gameStop = (event) -> Platform.exit();
		clearExitBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, gameStop);
		
		clearBackBtn = new Button();
		clearBackBtn.setText("もう一度プレイ");
		clearBackBtn.setPrefWidth(100);
		
		EventHandler<MouseEvent> gameStart = (event) -> gameScreen1(event,stage);
		clearBackBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, gameStart);
		
		clearHb2.getChildren().addAll(clearExitBtn,clearBackBtn);
		clearHb2.setAlignment(Pos.CENTER);
		
		clearVb = new VBox(50);
		clearVb.getChildren().addAll(clearHb1,clearHb2);
		clearVb.setBackground(clearStage);
		clearVb.setAlignment(Pos.CENTER);
		
		clearSc = new Scene(clearVb,900,650);
		
		stage.setScene(null);
		stage.setScene(clearSc);
	}
	
	public void hpGauge(int openCount, int clearCount, int num) {
		if(clearCount == 0) {
			hpBar.setProgress(1.0 - (((double)openCount - (double)num) / ((double)(81-10) - (double)num)));
		}
		else if(clearCount == 1) {
			hpBar.setProgress(1.0 - (((double)openCount - (double)num) / ((double)(81-15) - (double)num)));
		}
		else if(clearCount == 2) {
			hpBar.setProgress(1.0 - (((double)openCount - (double)num) / ((double)(81-18) - (double)num)));
		}
	}
	
	public void timeGauge(int sec, int count) {
		double time = (double) count / (double) sec;
		
		timeBar.setProgress(time);
		
		if(time < 0.2) {
			timeBar.setStyle("-fx-accent : red");
		}
	}
	
	public void timeOver() {//時間切れ処理(Timerで呼ぶ用)
		pokemon.stopTimer();//ポケモンの攻撃ストップ
	}
	
	public void lowDamageStop() {
		if(damageCount > 0) {
			damageTimer.stop();
		}
	}
	
	public Label getLabel() {
		return this.textLabel;
	}
	
	public Label getConditionLabel() {
		return this.conditionLabel;
	}
	
	public void pokemonNameText() {//現れたポケモンをセット
		Timeline pokemonNameText = new Timeline(new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				textLabel.setText(pokemon.getName() + "が現れた！");
			}
		}));
		
		pokemonNameText.setCycleCount(1);
		pokemonNameText.play();
	}
	
	public void nullText() {//テキストを空にする
		Timeline nullText = new Timeline(new KeyFrame(Duration.millis(9000), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				textLabel.setText(null);
			}
		}));
		
		nullText.setCycleCount(1);
		nullText.play();
	}
}