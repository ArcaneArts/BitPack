package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableFloat implements NodeWritable<Float> {
    @Override
    public Float readNodeData(DataInputStream din) throws IOException {
        return din.readFloat();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Float aDouble) throws IOException {
        dos.writeFloat(aDouble);
    }
}
