<<<<<<< HEAD
package lab1;
=======
package lab01;
>>>>>>> 5b8f20e33920b944e220cf0f81058f92b741fdae
import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		JOptionPane.showMessageDialog(null,"You've chosen: "
				+ (option==JOptionPane.YES_OPTION?"Yes" : "No"));
		System.exit(0);
	}
}
