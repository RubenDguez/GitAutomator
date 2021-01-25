import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

abstract class Git {

    private final String path;
    private boolean executeCommands = false;

    public Git() {
        path = System.getProperty("user.dir");
        Utils.clearScreen();
        if (Utils.compareStrings("git --version", "git version") && Utils.compareStrings("java --version", "java"))
            executeCommands = true;
    }

    void gitCommit() {
        if (executeCommands)
            Utils.execute("git commit -m \"" + System.currentTimeMillis() + "\"");
    }

    void gitCommit(String commitComment) {
        if (executeCommands)
            Utils.execute("git commit -m \'" + commitComment + "\'");
    }

    void gitAddRemote(String remote, String gitRepo) {
        if (executeCommands)
            Utils.execute("git remote add " + remote + " " + gitRepo);
    }

    void gitPush(String remote, String branch) {
        if (executeCommands)
            Utils.execute("git push -u " + remote + " " + branch);
    }

    void gitAddAll() {
        if (executeCommands)
            Utils.execute("git add .");
    }

    void gitStatus() {
        if (executeCommands)
            Utils.execute("git status");
    }

    void gitCheckout(String branchName) {
        if (executeCommands)
            Utils.execute("git checkout -b " + branchName);
    }

    void gitBranch(String branchName) {
        if (executeCommands)
            Utils.execute("git branch -M " + branchName);
    }

    void gitInit() {
        if (executeCommands) {
            Path path = Paths.get(this.path + "/.git");
            if (!Files.exists(path)) {
                Utils.execute("git init");
            }
        }
    }

}
