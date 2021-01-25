public class RunGit extends Git {

    // main secuence of command execution
    public void run(String remote, String branch, String gitRepo) {
        gitInit();
        gitBranch(branch);
        gitCheckout(branch);
        gitAddAll();
        gitCommit();
        gitAddRemote(remote, gitRepo);
        gitPush(remote, branch);
        Utils.clearScreen();
        gitStatus();
    }

    public void run(String fileName, String remote, String branch, String gitRepo) {
        gitInit();
        gitBranch(branch);
        gitCheckout(branch);
        gitAdd(fileName);
        gitCommit();
        gitAddRemote(remote, gitRepo);
        gitPush(remote, branch);
        Utils.clearScreen();
        gitStatus();

    }

    public void run(String[] fileNames, String remote, String branch, String gitRepo) {
        gitInit();
        gitBranch(branch);
        gitCheckout(branch);
        gitAdd(fileNames);
        gitCommit();
        gitAddRemote(remote, gitRepo);
        gitPush(remote, branch);
        Utils.clearScreen();
        gitStatus();

    }

}
