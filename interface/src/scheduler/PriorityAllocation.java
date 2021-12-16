package scheduler;

public class PriorityAllocation implements Scheduler{
    @Override
    public void getNextCall() {
        System.out.println("상담 전화를 고객 등급이 높은 순서대로 대기열에서 가져옵니다.");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("업무능력이 우수한 상담원에게 먼저 배분합니다.");
    }
}
