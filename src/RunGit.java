public class RunGit extends Git {

    // main secuence of command execution
    public void run(String remote, String branch, String repository) {
        gitInit();
        gitBranch(branch);
        gitCheckout(branch);
        gitAddAll();
        gitCommit();
        gitAddRemote(remote, repository);
        gitPush(remote, branch);
        Utils.clearScreen();
        gitStatus();
    }

}
