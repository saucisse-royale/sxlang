package fr.delthas.sxlang.types;

public enum Primitive {
  Boolean(1, false, true),
  Byte(8, false, true),
  UInt16(16, false, true),
  UInt32(32, false, true),
  UInt64(64, false, true),
  Int16(16, false, false),
  Int32(32, false, false),
  Int64(64, false, false),
  Float32(32, true, false),
  Float64(64, true, false);
  
  public final int bits;
  public final boolean floating;
  public final boolean unsigned;
  
  Primitive(int bits, boolean floating, boolean unsigned) {
    this.bits = bits;
    this.floating = floating;
    this.unsigned = unsigned;
  }
}
