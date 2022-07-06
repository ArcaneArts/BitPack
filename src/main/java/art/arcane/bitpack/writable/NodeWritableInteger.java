package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableInteger implements NodeWritable<Integer> {
    @Override
    public Integer readNodeData(DataInputStream din) throws IOException {
        return din.readInt();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Integer aDouble) throws IOException {
        dos.writeInt(aDouble);
    }
}
