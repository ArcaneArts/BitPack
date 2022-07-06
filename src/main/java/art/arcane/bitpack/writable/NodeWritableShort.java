package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableShort implements NodeWritable<Short> {
    @Override
    public Short readNodeData(DataInputStream din) throws IOException {
        return din.readShort();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Short aDouble) throws IOException {
        dos.writeShort(aDouble);
    }
}
