# BitPack
Palette Data but in bits, not bytes. Essentially it creates a palette for each possible entry using Lists, or Hashes depending on the size of the palette, then writes the palette index in bits based on how many possibilities there are. For example, if you have only 4 possible palette items, We can store each palette index in only 2 bits. This means a single long can store 32 entries each!

[![Latest version of 'BitPack' @ Cloudsmith](https://api-prd.cloudsmith.io/v1/badges/version/arcane/archive/maven/BitPack/latest/a=noarch;xg=art.arcane/?render=true&show_latest=true)](https://cloudsmith.io/~arcane/repos/archive/packages/detail/maven/BitPack/latest/a=noarch;xg=art.arcane/)

```groovy
maven { url "https://dl.cloudsmith.io/public/arcane/archive/maven/" }
```

```groovy
implementation 'art.arcane:BitPack:<VERSION>'
```

## Usage

```java
DataContainer<String> c = new DataContainer<>(new NodeWritable<>() {
    @Override
    public String readNodeData(DataInputStream dataInputStream) throws IOException {
        // read an entry from data input
        return dataInputStream.readUTF();
    }

    @Override
    public void writeNodeData(DataOutputStream dataOutputStream, String s) throws IOException {
        // write an entry to data output
        dataOutputStream.writeUTF(s);
    }
}, 8); // We want 8 entries in this data set

c.set(0, "hello");
c.set(1, "world");
c.set(2, "hello");
c.set(3, "world");
c.set(4, "hello");
c.set(5, "world");
c.set(6, "hello");
c.set(7, "world");

byte[] bytes = c.write();
c.write(stream);
```
