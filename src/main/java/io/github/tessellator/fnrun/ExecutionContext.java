package io.github.tessellator.fnrun;

import io.github.tessellator.fnrun.protobufs.Fnrun;

import java.io.DataInputStream;
import java.io.IOException;
import java.time.Instant;

public class ExecutionContext {
    private Instant stopTime;

    public static ExecutionContext readFrom(DataInputStream inputStream) throws IOException {
        Fnrun.ExecutionContext ctx = readRawContextFrom(inputStream);

        return new ExecutionContext();
    }

    private static Fnrun.ExecutionContext readRawContextFrom(DataInputStream inputStream) throws IOException {
        int length = inputStream.readInt();

        byte[] arr = new byte[length];
        inputStream.readFully(arr);

        return Fnrun.ExecutionContext.parseFrom(arr);
    }

}
