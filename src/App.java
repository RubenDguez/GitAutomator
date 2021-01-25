
public class App {

    public static void main(String[] args) throws Exception {

        String remote = "origin";
        String branch = "main";
        String gitRepo = "https://github.com/RubenDguez/GitAutomator.git";
        String fileName = "src/Git.java";
        String[] arrFileName = { "src/Git.java", "src/App.java", "src/RunGit.java" };

        RunGit rg = new RunGit();

        rg.run(remote, branch, gitRepo); // for pushing the entire project to the repository
        // rg.run(fileName, remote, branch, gitRepo); // for pushing an specific file to
        // the repository
        // rg.run(arrFileName, remote, branch, gitRepo); // for pushing and array of
        // files to the repository
    }
}