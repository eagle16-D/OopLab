/**
 * 
 */
/**
 * 
 */
module GUIProject {
	requires java.desktop;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
    requires javafx.controls;
	exports hust.soict.sec.javafx;
	opens hust.soict.sec.javafx to javafx.fxml;
}