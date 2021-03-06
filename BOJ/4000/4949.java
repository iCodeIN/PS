import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.run(in, out);
        out.close();
    }

    static class Task {
        public void run(InputReader in, PrintWriter out) {
            StringBuilder sb = new StringBuilder();
            String input;
            while (!(input = in.nextLine()).equals(".")) {
                Stack<Character> stack = new Stack<>();
                boolean isBalanced = true;
                for (char c : input.toCharArray()) {
                    if (c == '.') {
                        isBalanced = stack.isEmpty();
                        break;
                    }
                    if (c != '(' && c != ')' && c != '[' && c != ']') {
                        continue;
                    }
                    if (c == '(' || c == '[') {
                        stack.push(c);
                        continue;
                    }
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char current = stack.peek();
                    if ((c == ')' && current != '(') || (c == ']' && current != '[')) {
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                }
                sb.append(isBalanced ? "yes" : "no").append("\n");
            }
            out.print(sb);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
