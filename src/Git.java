import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

abstract class Git {

    private final String path;

    public Git() {
        path = System.getProperty("user.dir");
        Utils.clearScreen();
        gitVersion();
        javaVersion();
    }

    void gitVersion() {
        Utils.execute("git --version");
    }

    void javaVersion() {
        Utils.execute("java --version");
    }

    void gitCommit() {
        Utils.execute("git commit -m \"" + System.currentTimeMillis() + "\"");
    }

    void gitCommit(String commitComment) {
        Utils.execute("git commit -m \'" + commitComment + "\'");
    }

    void gitAddRemote(String remote, String gitRepo) {
        Utils.execute("git remote add " + remote + " " + gitRepo);
    }

    void gitPush(String remote, String branch) {
        Utils.execute("git push -u " + remote + " " + branch);
    }

    void gitAddAll() {
        Utils.execute("git add .");
    }

    void gitStatus() {
        Utils.execute("git status");
    }

    void gitCheckout(String branchName) {
        Utils.execute("git checkout -b " + branchName);
    }

    void gitBranch(String branchName) {
        Utils.execute("git branch -M " + branchName);
    }

    void gitInit() {
        Path path = Paths.get(this.path + "/.git");
        if (!Files.exists(path)) {
            Utils.execute("git init");
        }
    }

}
