package meituan;

import java.io.*;
import java.util.*;

public class Restaurant {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        for (; t > 0; t--) {
            int n = Integer.parseInt(reader.readLine());
            String[] originTables = reader.readLine().split("");

            List<PriorityQueue<Integer>> emptyList = new ArrayList<>(3);
            for (int i = 0; i < 2; i++) {
                emptyList.add(new PriorityQueue<>());
            }
            for (int i = 0; i < originTables.length; i++) {
                int table = Integer.parseInt(originTables[i]);
                if (table < 2) emptyList.get(table).add(i);
            }


            int m = Integer.parseInt(reader.readLine());
            String[] peoples = reader.readLine().split("");

            for (String people : peoples) {
                int table;
                switch (people) {
                    case "M":
                        // 没有一人坐的
                        if (emptyList.get(1).size() == 0) {
                            // 坐 0 人的
                            table = emptyList.get(0).poll();
                            // 加入 1 人的
                            emptyList.get(1).add(table);
                        } else {
                            // 坐一人的
                            table = emptyList.get(1).poll();
                        }

                        break;
                    case "F":
                        // 没有 0 人做的
                        if (emptyList.get(0).size() == 0) {
                            // 坐一人的
                            table = emptyList.get(1).poll();
                        } else {
                            // 坐 0 人的
                            table = emptyList.get(0).poll();
                            // 加入 1 人的
                            emptyList.get(1).add(table);
                        }
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + people);
                }
                writer.write(Integer.toString(table + 1));
                writer.newLine();
            }
            writer.flush();
        }
    }
}
