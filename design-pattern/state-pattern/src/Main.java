public class Main {
    public static void main(String[] args) {
        TVContext tvContext = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();
        tvContext.setTvState(tvStartState);
        tvContext.doAction();
        tvContext.setTvState(tvStopState);
        tvContext.doAction();
    }
}