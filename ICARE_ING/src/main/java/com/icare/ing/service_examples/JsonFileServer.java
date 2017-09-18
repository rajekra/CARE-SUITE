package com.icare.ing.service_examples;

import java.io.*; // wildcard import for brevity in tutorial
import java.net.*;
import java.util.Random;
import java.util.concurrent.*;

public class JsonFileServer {
    private static final Executor SERVER_EXECUTOR = Executors.newSingleThreadExecutor();
    private static final int PORT = 9999;
    private static final String DELIMITER = ":";
    private static final long EVENT_PERIOD_SECONDS = 1;
    private static final Random random = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {
        BlockingQueue<String> eventQueue = new ArrayBlockingQueue<>(100);
        SERVER_EXECUTOR.execute(new SteamingServer(eventQueue));
        while (true) {
            eventQueue.put(generateEvent());
            Thread.sleep(TimeUnit.SECONDS.toMillis(EVENT_PERIOD_SECONDS));
        }
    }

    private static String generateEvent() {
        int userNumber = random.nextInt(10);
        String event = random.nextBoolean() ? "login" : "purchase";
        // In production use a real schema like JSON or protocol buffers
        return String.format("user-%s", userNumber) + DELIMITER + event;
    }

    private static class SteamingServer implements Runnable {
        private final BlockingQueue<String> eventQueue;

        public SteamingServer(BlockingQueue<String> eventQueue) {
            this.eventQueue = eventQueue;
        }

        @Override
        public void run() {
            try (ServerSocket serverSocket = new ServerSocket(PORT);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            ) {
                while (true) {
                 StringBuilder jsoncontent = new StringBuilder();
                	BufferedReader br = null;
            		FileReader fr = null;

            		try {

            			//br = new BufferedReader(new FileReader(FILENAME));
            			fr = new FileReader("C:\\Testing\\Output\\JSON\\CLAIM_5010_PROFESSIONAL_A1\\20170906\\16\\Output_Claim_1_20170906_160815546.json");
            			br = new BufferedReader(fr);

            			String sCurrentLine;

            			while ((sCurrentLine = br.readLine()) != null) {
            				jsoncontent.append(sCurrentLine);
            			}
            			 out.println(jsoncontent);
            			 jsoncontent.setLength(0);
            			 Thread.sleep(120000000);

            		} catch (IOException e) {

            			e.printStackTrace();

            		} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                   
                }
            } catch (IOException e) {
                throw new RuntimeException("Server error", e);
            }
        }
    }
}
