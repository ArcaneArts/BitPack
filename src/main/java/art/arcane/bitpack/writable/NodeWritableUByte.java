package art.arcane.bitpack.writable;

import art.arcane.bitpack.NodeWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NodeWritableUByte implements NodeWritable<Integer> {
    @Override
    public Integer readNodeData(DataInputStream din) throws IOException {
        return din.readUnsignedByte();
    }

    @Override
    public void writeNodeData(DataOutputStream dos, Integer aInt) throws IOException {
        dos.writeByte(aInt - Byte.MAX_VALUE);
    }
}
