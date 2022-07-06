package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableDouble implements NodeWritable<Double> {
    @Override
    public Double readNodeData(DataInputStream din) throws IOException {
        return din.readDouble();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Double aDouble) throws IOException {
        dos.writeDouble(aDouble);
    }
}
