package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableLong implements NodeWritable<Long> {
    @Override
    public Long readNodeData(DataInputStream din) throws IOException {
        return din.readLong();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Long aDouble) throws IOException {
        dos.writeLong(aDouble);
    }
}
