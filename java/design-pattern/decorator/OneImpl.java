package decorator;

import java.io.*;

public class OneImpl extends Base {
    // 持有 Base 类型的属性
    private Base base;

    public OneImpl(Base base) {
        this.base = base;
    }

    @Override
    public void base() {
        // 对原始的 base 做一个增强
        base.base();
        System.out.println("one");
    }

    public static void main(String[] args) throws IOException {
        InputStream i = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\majexh\\Desktop\\test.txt")));
        int c;
        while ((c = i.read()) != -1) {
            System.out.println(c);
        }
    }}
