package io.github.tessellator.fnrun;

import io.github.tessellator.fnrun.protobufs.Fnrun;

import java.io.DataInputStream;
import java.io.IOException;

class Event {

    static String readFrom(DataInputStream inputStream) throws IOException {
        Fnrun.Event req = readRawRequestFrom(inputStream);
        return new String(req.getData().toByteArray());
    }

    private static Fnrun.Event readRawRequestFrom(DataInputStream inputStream) throws IOException {
        int length = inputStream.readInt();

        byte[] arr = new byte[length];
        inputStream.readFully(arr);

        return Fnrun.Event.parseFrom(arr);
    }
}
