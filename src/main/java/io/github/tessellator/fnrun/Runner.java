package io.github.tessellator.fnrun;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Runner {

    public static void run(EventHandler<String, Result> handler) throws IOException {
        DataInputStream inputStream = new DataInputStream(System.in);
        DataOutputStream outputStream = new DataOutputStream(System.out);

        while(true) {
            String event = Event.readFrom(inputStream);
            ExecutionContext ctx = ExecutionContext.readFrom(inputStream);

            Result result = handler.handle(event, ctx);
            result.writeTo(outputStream);
        }
    }
}
