public class RunGit extends Git {

    private final String remote = "origin";
    private final String branch = "main";
    private final String repository = "https://github.com/RubenDguez/GitAutomator.git";

    public void run() {
        Utils.clearScreen();
        gitInit();
        gitBranch(branch);
        gitCheckout(branch);
        gitAddAll();
        gitCommit();
        gitAddRemote(remote, repository);
        gitPush(remote, branch);
    }

}
