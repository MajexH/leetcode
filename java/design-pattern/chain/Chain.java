package chain;

import shopee.Third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chain {

    List<Process> handlers;
    int index;

    public Chain() {
        this.index = -1;
        this.handlers = new ArrayList<>();
    }

    public void register(Process ...processes) {
        this.handlers.addAll(Arrays.asList(processes));
    }

    public void next() {
        this.index++;
        // 为了保证链式函数中没有被显式调用 .next() 的地方也能够被执行
        while (this.index < this.handlers.size()) {
            this.handlers.get(this.index).process(this);
            this.index++;
        }
    }

    public static void main(String[] args) {
        Process p1 = (c) -> {
            System.out.println("first start");
            c.next();
            System.out.println("first end");
        };

        Process p2 = (c) -> {
            System.out.println("second start");
            c.next();
            System.out.println("second end");
        };

        Chain c = new Chain();
        c.register(p1);
        c.register(p2, (chain) -> {
            System.out.println("Third");
            System.out.println("Third");
        });

        c.next();
    }
}
