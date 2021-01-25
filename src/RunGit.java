public class RunGit extends Git {

    public void run(String remote, String branch, String repository) {
        Utils.clearScreen();
        gitInit();
        gitBranch(branch);
        gitCheckout(branch);
        gitAddAll();
        gitCommit();
        gitAddRemote(remote, repository);
        gitPush(remote, branch);
        // Utils.clearScreen();
        gitStatus();
    }

}
