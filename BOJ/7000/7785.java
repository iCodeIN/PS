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
        int n;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            List<String> enterList = new ArrayList<>(n);
            Map<String, Boolean> memberList = new HashMap<>(n);

            for(int i = 0; i < n; i++) {
                String name = in.next();
                if(in.next().charAt(0) == 'e') {
                    memberList.put(name, true);
                    continue;
                }
                memberList.put(name, false);
            }

            for(String name : memberList.keySet()) {
                if(memberList.get(name)) {
                    enterList.add(name);
                }
            }

            enterList.sort(Comparator.reverseOrder());

            for(String name : enterList) {
                out.println(name);
            }
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