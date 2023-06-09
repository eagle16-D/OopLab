package hust.soict.sec.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;


import hust.soict.sec.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

@SuppressWarnings("serial")
public class CartScreen extends JFrame {
	
	private static Cart cart;
	private static CartScreen instance;
	
	@SuppressWarnings("exports")
	public CartScreen(Cart cart) {
		super();
		
		this.setCart(cart);
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		int width = 800;
        int height = 600;
        this.setSize(width, height);
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/sec/aims/screen/cart.fxml"));

					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent rootParent = loader.load();
					fxPanel.setScene(new Scene(rootParent));
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});

	}
	
	public static CartScreen getInstance() {
        if (instance == null) {
            instance = new CartScreen(CartScreen.getCart());
        }
        return instance;
    }
	

	@SuppressWarnings("exports")
	public static Cart getCart() {
		return cart;
	}

	@SuppressWarnings("exports")
	public void setCart(Cart cart) {
		CartScreen.cart = cart;
	}
	
}
