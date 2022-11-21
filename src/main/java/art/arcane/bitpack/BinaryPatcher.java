package art.arcane.bitpack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinaryPatcher {
    public static byte[] patch(byte[] a, byte[] patch) throws IOException {
        ByteArrayInputStream bin = new ByteArrayInputStream(patch);
        DataInputStream din = new DataInputStream(bin);
        int bLength = Varint.readUnsignedVarInt(din);
        boolean same = a.length == bLength;
        byte[] b = same ? a : new byte[bLength];
        DataContainer<Boolean> changed = new DataContainer<>(din, NodeWritable.BOOLEAN);
        DataContainer<Integer> patchData = new DataContainer<>(din, NodeWritable.UBYTE);

        int r = 0;
        for(int i = 0; i < b.length; i++) {
            Boolean c = changed.get(i);
            if(c != null && c) {
                b[i] = (byte) (patchData.get(r++) + Byte.MAX_VALUE);
            } else if(!same) {
                b[i] = a[i];
            }
        }

        return b;
    }

    public static byte[] diff(byte[] a, byte[] b) throws IOException {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(boas);
        DataContainer<Boolean> changed = new DataContainer<>(NodeWritable.BOOLEAN, Math.max(a.length, b.length));
        List<Integer> changes = new ArrayList<>();

        for(int i = 0; i < Math.min(a.length, b.length); i++) {
            if(a[i] != b[i]) {
                changed.set(i, true);
                changes.add((int) b[i]);
            }
        }

        if(b.length > a.length) {
            for(int i = a.length; i < b.length; i++) {
                changed.set(i, true);
                changes.add((int) b[i]);
            }
        }

        DataContainer<Integer> patch = new DataContainer<>(NodeWritable.UBYTE, changes.size());

        for(int i = 0; i < changes.size(); i++) {
            patch.set(i, changes.get(i));
        }

        Varint.writeUnsignedVarInt(b.length, dos);
        changed.writeDos(dos);
        patch.writeDos(dos);
        return boas.toByteArray();
    }
}
