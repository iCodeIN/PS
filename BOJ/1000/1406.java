import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

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
        final char P = 'P';
        final char B = 'B';
        final char D = 'D';
        final char L = 'L';
        int n;
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        public void run(InputReader in, PrintWriter out) {
            char[] input = in.next().toCharArray();
            for(char c : input) {
                left.push(c);
            }
            n = in.nextInt();

            for(int i = 0; i < n; i++) {
                char op = in.next().charAt(0);

                if(op == P) {
                    left.push(in.next().charAt(0));
                } else if(op == B) {
                    if(!left.empty()) {
                        left.pop();
                    }
                } else if(op == D) {
                    if(!right.empty()) {
                        left.push(right.pop());
                    }
                } else {
                    if(!left.empty()) {
                        right.push(left.pop());
                    }
                }
            }

            StringBuilder sb = new StringBuilder(left.size() + right.size());
            while(!left.empty()) {
                sb.append(left.pop());
            }
            
            sb.reverse();

            while(!right.empty()) {
                sb.append(right.pop());
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
            } catch (Exception e) {
                return "";
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