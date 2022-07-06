package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableBoolean implements NodeWritable<Boolean> {
    @Override
    public Boolean readNodeData(DataInputStream din) throws IOException {
        return din.readBoolean();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Boolean aDouble) throws IOException {
        dos.writeBoolean(aDouble);
    }
}
