public class RunGit extends Git {

    /**
     * Initiate git, switch to specified branch, ckeckout to specified branch Adds
     * all tracked files to commit the changes using AutoCommit comment
     * 
     * @param remote
     * @param branch
     * @param gitRepo
     */
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

    /**
     * Initiate git, switch to specified branch, ckeckout to specified branch Adds
     * specified file to commits the changes using AutoCommit comment
     * 
     * @param fileName
     * @param remote
     * @param branch
     * @param gitRepo
     */
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

    /**
     * Initiate git, switch to specified branch, ckeckout to specified branch Adds
     * an array of specified files commits the changes using AutoCommit comment
     * 
     * 
     * @param fileNames
     * @param remote
     * @param branch
     * @param gitRepo
     */
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
