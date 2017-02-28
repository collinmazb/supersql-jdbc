/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.tencent.supersql.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-02-28")
public class SupersqlResultSetMetaData implements org.apache.thrift.TBase<SupersqlResultSetMetaData, SupersqlResultSetMetaData._Fields>, java.io.Serializable, Cloneable, Comparable<SupersqlResultSetMetaData> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SupersqlResultSetMetaData");

  private static final org.apache.thrift.protocol.TField PARTS_FIELD_DESC = new org.apache.thrift.protocol.TField("parts", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SupersqlResultSetMetaDataStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SupersqlResultSetMetaDataTupleSchemeFactory();

  public java.util.List<SupersqlResultSetMetaDataPart> parts; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PARTS((short)1, "parts");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PARTS
          return PARTS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PARTS, new org.apache.thrift.meta_data.FieldMetaData("parts", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SupersqlResultSetMetaDataPart.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SupersqlResultSetMetaData.class, metaDataMap);
  }

  public SupersqlResultSetMetaData() {
  }

  public SupersqlResultSetMetaData(
    java.util.List<SupersqlResultSetMetaDataPart> parts)
  {
    this();
    this.parts = parts;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SupersqlResultSetMetaData(SupersqlResultSetMetaData other) {
    if (other.isSetParts()) {
      java.util.List<SupersqlResultSetMetaDataPart> __this__parts = new java.util.ArrayList<SupersqlResultSetMetaDataPart>(other.parts.size());
      for (SupersqlResultSetMetaDataPart other_element : other.parts) {
        __this__parts.add(new SupersqlResultSetMetaDataPart(other_element));
      }
      this.parts = __this__parts;
    }
  }

  public SupersqlResultSetMetaData deepCopy() {
    return new SupersqlResultSetMetaData(this);
  }

  @Override
  public void clear() {
    this.parts = null;
  }

  public int getPartsSize() {
    return (this.parts == null) ? 0 : this.parts.size();
  }

  public java.util.Iterator<SupersqlResultSetMetaDataPart> getPartsIterator() {
    return (this.parts == null) ? null : this.parts.iterator();
  }

  public void addToParts(SupersqlResultSetMetaDataPart elem) {
    if (this.parts == null) {
      this.parts = new java.util.ArrayList<SupersqlResultSetMetaDataPart>();
    }
    this.parts.add(elem);
  }

  public java.util.List<SupersqlResultSetMetaDataPart> getParts() {
    return this.parts;
  }

  public SupersqlResultSetMetaData setParts(java.util.List<SupersqlResultSetMetaDataPart> parts) {
    this.parts = parts;
    return this;
  }

  public void unsetParts() {
    this.parts = null;
  }

  /** Returns true if field parts is set (has been assigned a value) and false otherwise */
  public boolean isSetParts() {
    return this.parts != null;
  }

  public void setPartsIsSet(boolean value) {
    if (!value) {
      this.parts = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case PARTS:
      if (value == null) {
        unsetParts();
      } else {
        setParts((java.util.List<SupersqlResultSetMetaDataPart>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PARTS:
      return getParts();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PARTS:
      return isSetParts();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof SupersqlResultSetMetaData)
      return this.equals((SupersqlResultSetMetaData)that);
    return false;
  }

  public boolean equals(SupersqlResultSetMetaData that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_parts = true && this.isSetParts();
    boolean that_present_parts = true && that.isSetParts();
    if (this_present_parts || that_present_parts) {
      if (!(this_present_parts && that_present_parts))
        return false;
      if (!this.parts.equals(that.parts))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetParts()) ? 131071 : 524287);
    if (isSetParts())
      hashCode = hashCode * 8191 + parts.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(SupersqlResultSetMetaData other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetParts()).compareTo(other.isSetParts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parts, other.parts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SupersqlResultSetMetaData(");
    boolean first = true;

    sb.append("parts:");
    if (this.parts == null) {
      sb.append("null");
    } else {
      sb.append(this.parts);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SupersqlResultSetMetaDataStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SupersqlResultSetMetaDataStandardScheme getScheme() {
      return new SupersqlResultSetMetaDataStandardScheme();
    }
  }

  private static class SupersqlResultSetMetaDataStandardScheme extends org.apache.thrift.scheme.StandardScheme<SupersqlResultSetMetaData> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SupersqlResultSetMetaData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PARTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.parts = new java.util.ArrayList<SupersqlResultSetMetaDataPart>(_list8.size);
                SupersqlResultSetMetaDataPart _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = new SupersqlResultSetMetaDataPart();
                  _elem9.read(iprot);
                  struct.parts.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setPartsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SupersqlResultSetMetaData struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.parts != null) {
        oprot.writeFieldBegin(PARTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.parts.size()));
          for (SupersqlResultSetMetaDataPart _iter11 : struct.parts)
          {
            _iter11.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SupersqlResultSetMetaDataTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SupersqlResultSetMetaDataTupleScheme getScheme() {
      return new SupersqlResultSetMetaDataTupleScheme();
    }
  }

  private static class SupersqlResultSetMetaDataTupleScheme extends org.apache.thrift.scheme.TupleScheme<SupersqlResultSetMetaData> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SupersqlResultSetMetaData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetParts()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetParts()) {
        {
          oprot.writeI32(struct.parts.size());
          for (SupersqlResultSetMetaDataPart _iter12 : struct.parts)
          {
            _iter12.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SupersqlResultSetMetaData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.parts = new java.util.ArrayList<SupersqlResultSetMetaDataPart>(_list13.size);
          SupersqlResultSetMetaDataPart _elem14;
          for (int _i15 = 0; _i15 < _list13.size; ++_i15)
          {
            _elem14 = new SupersqlResultSetMetaDataPart();
            _elem14.read(iprot);
            struct.parts.add(_elem14);
          }
        }
        struct.setPartsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

