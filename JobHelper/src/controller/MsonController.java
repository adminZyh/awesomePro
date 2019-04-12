package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
/***
 * 这是一个控制器，实现了Initializable接口
 * @author 航航
 *
 */
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class MsonController implements Initializable {
	@FXML
	BorderPane rootPane;
	@FXML
	BorderPane topPane;
	@FXML
	BorderPane bottomPane;
	@FXML
	BorderPane CcenterPane;
	@FXML
	TextField modelnum;
	@FXML
	TextField gradename;
	@FXML
	TextField classname;
	@FXML
	BorderPane CtopPane;
	@FXML 
	//退出的标签
	Label labelExit;
	@FXML
	//退出的图片
	ImageView imageExit;
	@FXML
	ListView<String> Viewlist;
	//鼠标相对于窗口内的位置
	double mouseX,mouseY;
	//窗口位置的原值和窗口的大小
	double resetX,resetY,resetWidth,reseHeight;
	@FXML
	//这是控制封装（最大化，最小化，退出）label的hbox
	HBox hboxBar;
	//main里面的舞台
	Stage stage;
	//输入域
	@FXML
	TextArea textArea;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//设置总BorderPane面板的背景
		rootPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
		//设置BorderPane面板上部分的背景
		topPane.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));
		//设置3张图片（最小化，最大化，退出）
		imageExit.setImage(new Image("resource/img/topandbottom/CloseDark.png"));
		//设置hbox的内边距
		hboxBar.setPadding(new Insets(15,5,5,10));//上右下左
		bottomPane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
		CcenterPane.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, null, null)));
		CtopPane.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
	}
	
	/***
	 * 鼠标移动时退出的图片替换为黑色
	 * @param event
	 */
	@FXML
	public void imgExitToWhite(MouseEvent event) {
		imageExit.setImage(new Image("resource/img/topandbottom/Close.png"));
		labelExit.setBackground(new Background(new BackgroundFill(Color.rgb(255, 10, 10), null, null)));
	}
	/***
	 * 鼠标移动时退出的图片替换为白色
	 * @param event
	 */
	@FXML
	public void imgExitToBlack(MouseEvent event) {
		imageExit.setImage(new Image("resource/img/topandbottom/CloseDark.png"));
		labelExit.setBackground(new Background(new BackgroundFill(Color.AZURE, null, null)));
	}
	/***
	 * 获取来自Main的stage
	 */
	/***
	 * 将Main里面的舞台传过来
	 * @param primaryStage
	 */
	public void setPrimary(Stage stage) {
		this.stage = stage;
	}
	/***
	 * 退出程序，也就是关闭窗口
	 * @param event
	 */
	@FXML
	public void exitWindow(MouseEvent event) {
		System.exit(0);
	}
	/***
	 * 计算鼠标按下时距离我们写的窗口内的距离
	 * @param event
	 */
	@FXML
	public void culateSpace(MouseEvent event) {
		//记录按下的时候的坐标
		this.mouseX = event.getSceneX();
		this.mouseY = event.getSceneY();
	}
	/***
	 * 记录鼠标拖拽时距离windows窗口的距离
	 * @param event
	 */
	@FXML
	public void caculateLocation(MouseEvent event) {
		//设置新的x,y
		this.stage.setX(event.getScreenX()-mouseX);
		this.stage.setY(event.getScreenY()-mouseY);
	}
	
}
