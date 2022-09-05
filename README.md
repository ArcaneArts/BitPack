# BitPack
Palette Data but in bits, not bytes. Essentially it creates a palette for each possible entry using Lists, or Hashes depending on the size of the palette, then writes the palette index in bits based on how many possibilities there are. For example, if you have only 4 possible palette items, We can store each palette index in only 2 bits. This means a single long can store 32 entries each!

![](https://img.shields.io/github/v/release/ArcaneArts/BitPack?color=%236f24f0&display_name=tag&label=BitPack&sort=semver&style=for-the-badge)

```groovy
maven { url "https://arcanearts.jfrog.io/artifactory/archives" }
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
