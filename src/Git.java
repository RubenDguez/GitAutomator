import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

abstract class Git {

    private final String path;
    private boolean executeCommands = false;

    public Git() {
        path = System.getProperty("user.dir");
        Utils.clearScreen();

        // Determines if Git is installed in system
        // Determines if Java is installed in system
        if (Utils.compareStrings("git --version", "git version") && Utils.compareStrings("java --version", "java"))
            executeCommands = true;
    }

    // Automatic git commit, will give current time in milliseconds as commit
    // comment
    void gitCommit() {
        if (executeCommands)
            Utils.execute("git commit -m \"" + System.currentTimeMillis() + "\"");
    }

    // Git commit with a pre-defined commit comment
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

    void gitAdd(String fileName) {
        if (executeCommands)
            Utils.execute("git add " + fileName);

    }

    void gitAdd(String[] fileNames) {
        for (String s : fileNames) {
            Utils.execute("git add " + s);
        }
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

    // determines if folder .git exists,
    // if does not exists, execute git init
    // otherwise will skip this command
    void gitInit() {
        if (executeCommands) {
            Path path = Paths.get(this.path + "/.git");
            if (!Files.exists(path)) {
                Utils.execute("git init");
            }
        }
    }

}
