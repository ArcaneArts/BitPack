package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableString implements NodeWritable<String> {
    @Override
    public String readNodeData(DataInputStream din) throws IOException {
        return din.readUTF();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, String aDouble) throws IOException {
        dos.writeUTF(aDouble);
    }
}
