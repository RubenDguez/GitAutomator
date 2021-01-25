
public class App {

    public static void main(String[] args) throws Exception {
        RunGit rg = new RunGit();
        rg.run("origin", "main", "https://github.com/RubenDguez/GitAutomator.git");
    }

}
