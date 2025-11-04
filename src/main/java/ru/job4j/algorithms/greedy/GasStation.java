package ru.job4j.algorithms.greedy;

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel;
        int point;

        for (int start = 0; start < gas.length; start++) {
            fuel = 0;

            for (int i = 0; i < gas.length; i++) {
                point = (start + i) % gas.length;
                fuel = fuel + gas[point] - cost[point];

                if (fuel < 0) {
                    break;
                }

                if (i == gas.length - 1) {
                    return start;
                }
            }
        }

        return -1;
    }
}
