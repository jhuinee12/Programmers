package main.java;

import java.util.*;

public class ALG_P_0_다리를_지나는_트럭 {
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int bridge_length = 5;
        int weight = 5;
        int[] truck_weights = {2, 2, 2, 2, 1, 1, 1, 1, 1};
        int[] truck_weights2 = {10};
        ALG_P_0_다리를_지나는_트럭 sol = new ALG_P_0_다리를_지나는_트럭();
        System.out.println(sol.solution(bridge_length, weight, truck_weights));
        //System.out.println(sol.solution(100, 100, truck_weights2));
    }

}