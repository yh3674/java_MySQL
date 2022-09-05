public class   TeamProjectDemo {
    public static void main (String[] args) {
        System.out.print("선택");
        
        TeamProjectPolls polls = new TeamProjectPolls();
        int val = polls.PollFunction();

        TeamProjectStatistics statics = new TeamProjectStatistics();
        val = statics.StatisticFunction();
        return;
    }
}
