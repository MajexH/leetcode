public class Interpret_1678 {

    public String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(') {
                if (i + 1 < command.length() && command.charAt(i + 1) == ')') {
                    builder.append('o');
                    i++;
                    continue;
                }
                if (i + 4 <= command.length() && command.startsWith("(al)", i)) {
                    builder.append("al");
                    i += 3;
                    continue;
                }

            }
            builder.append(command.charAt(i));
        }
        return builder.toString();
    }

    public String interpretBruteForce(String command) {
        command = command.replaceAll("\\(al\\)", "al");
        command = command.replaceAll("\\(\\)", "o");
        return command;
    }
}
