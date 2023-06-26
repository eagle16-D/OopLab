package hust.soict.sec.aims.screen;


import javax.swing.JPanel;

@SuppressWarnings("serial")
public class updateStoreScreen extends StoreScreen{
	
	public updateStoreScreen() {
		super(getStore());
		
		setTitle("Update store");
	}
	@Override
	JPanel createCenter() {
		
		JPanel centerJPanel = new JPanel();
		
		
		
		return centerJPanel;
	}
	
	public static void main(String[] args) {
		new updateStoreScreen();
	}
}
