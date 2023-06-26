/**
 * 
 */
/**
 * @author Nguyễn Hữu Duẩn
 *
 */
module AimsProject {
	requires java.desktop;
	requires javafx.swing;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	requires java.naming;
	opens hust.soict.sec.aims.screen to javafx.fxml;
	opens hust.soict.sec.aims.media to javafx.base;
	exports hust.soict.sec.aims.media;
	exports hust.soict.sec.aims.screen;
}