package computer;

public class ComputerTest {
    public static void main(String[] args) {
        Computer desktop = new Desktop();
        Computer notebook = new MyNoteBook();
        // Computer computer new Computer(); => x
        desktop.display();
        desktop.typing();

        notebook.display();
        notebook.typing();
    }

}
