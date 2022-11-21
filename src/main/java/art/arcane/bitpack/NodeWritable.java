/*
 * Amulet is an extension api for Java
 * Copyright (c) 2022 Arcane Arts
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package art.arcane.bitpack;

import art.arcane.bitpack.writable.NodeWritableBoolean;
import art.arcane.bitpack.writable.NodeWritableByte;
import art.arcane.bitpack.writable.NodeWritableDouble;
import art.arcane.bitpack.writable.NodeWritableFloat;
import art.arcane.bitpack.writable.NodeWritableInteger;
import art.arcane.bitpack.writable.NodeWritableLong;
import art.arcane.bitpack.writable.NodeWritableShort;
import art.arcane.bitpack.writable.NodeWritableString;
import art.arcane.bitpack.writable.NodeWritableUByte;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface NodeWritable<T> {
    T readNodeData(DataInputStream din) throws IOException;

    void writeNodeData(DataOutputStream dos, T t) throws IOException;

    NodeWritable<Boolean> BOOLEAN = new NodeWritableBoolean();
    NodeWritable<Byte> BYTE = new NodeWritableByte();
    NodeWritable<Integer> UBYTE = new NodeWritableUByte();
    NodeWritable<Integer> INTEGER = new NodeWritableInteger();
    NodeWritable<Short> SHORT = new NodeWritableShort();
    NodeWritable<Float> FLOAT = new NodeWritableFloat();
    NodeWritable<Double> DOUBLE = new NodeWritableDouble();
    NodeWritable<Long> LONG = new NodeWritableLong();
    NodeWritable<String> STRING = new NodeWritableString();
}
