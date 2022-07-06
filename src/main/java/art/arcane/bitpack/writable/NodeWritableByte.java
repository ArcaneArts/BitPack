package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableByte implements NodeWritable<Byte> {
    @Override
    public Byte readNodeData(DataInputStream din) throws IOException {
        return din.readByte();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Byte aDouble) throws IOException {
        dos.writeByte(aDouble);
    }
}
