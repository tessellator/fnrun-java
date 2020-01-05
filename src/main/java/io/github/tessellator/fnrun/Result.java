package io.github.tessellator.fnrun;

import io.github.tessellator.fnrun.protobufs.Fnrun;

import java.io.DataOutputStream;
import java.io.IOException;

import com.google.protobuf.ByteString;

public class Result {

    private int status;
    private String data;

    public Result(int status, String body) {
        this.status = status;
        this.data = body;
    }

    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return this.data;
    }
    public void setData(String body) {
        this.data = body;
    }

    void writeTo(DataOutputStream outputStream) throws IOException {
        Fnrun.Result resp = Fnrun.Result.newBuilder()
                .setStatus(this.status)
                .setData(ByteString.copyFromUtf8(this.getData()))
                .build();

        outputStream.writeInt(resp.getSerializedSize());
        resp.writeTo(outputStream);
        outputStream.flush();
    }
}
