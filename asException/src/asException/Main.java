package asException;

public class Main {

	public static void main(String[] args) {
		String out = null;

		do {

			try {

				String id = JOptionPane.showInputDialog("Enter Id");
				validateId(id);
				out = "Validated id: " + id + "\n";
				JOptionPane.showMessageDialog(null, out);
				break;

			}
			catch (IdNotWholeNumberException e) {
				String msg = e.getMessage();
				System.out.println(msg);
				// e.printStackTrace();
			}
			catch (IdOutOfRangeException e) {
				String msg = e.getMessage();
				System.out.println(msg);
				// e.printStackTrace();
			}
		} while (true);
		do {
			try {
				String name = JOptionPane.showInputDialog("Enter name");
				validateName(name);
				out = "Validated Name: " + name + "\n";
				JOptionPane.showMessageDialog(null, out);
				break;
			}
			catch (NotAlphabeticException e) {
				String msg = e.getMessage();
				System.out.println(msg);
				// e.printStackTrace();
			}
			catch (NotSpecifiedException e) {
				String msg = e.getMessage();
				System.out.println(msg);
				// e.printStackTrace();
			}
		} while (true);
	}
}
