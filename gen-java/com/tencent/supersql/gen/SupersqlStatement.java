/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.tencent.supersql.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-02-28")
public class SupersqlStatement implements org.apache.thrift.TBase<SupersqlStatement, SupersqlStatement._Fields>, java.io.Serializable, Cloneable, Comparable<SupersqlStatement> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SupersqlStatement");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SQL_FIELD_DESC = new org.apache.thrift.protocol.TField("sql", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ID_CONNECTION_FIELD_DESC = new org.apache.thrift.protocol.TField("id_connection", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SupersqlStatementStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SupersqlStatementTupleSchemeFactory();

  public int id; // required
  public java.lang.String sql; // required
  public int id_connection; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    SQL((short)2, "sql"),
    ID_CONNECTION((short)3, "id_connection");

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
        case 1: // ID
          return ID;
        case 2: // SQL
          return SQL;
        case 3: // ID_CONNECTION
          return ID_CONNECTION;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __ID_CONNECTION_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SQL, new org.apache.thrift.meta_data.FieldMetaData("sql", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_CONNECTION, new org.apache.thrift.meta_data.FieldMetaData("id_connection", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SupersqlStatement.class, metaDataMap);
  }

  public SupersqlStatement() {
  }

  public SupersqlStatement(
    int id,
    java.lang.String sql,
    int id_connection)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.sql = sql;
    this.id_connection = id_connection;
    setId_connectionIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SupersqlStatement(SupersqlStatement other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetSql()) {
      this.sql = other.sql;
    }
    this.id_connection = other.id_connection;
  }

  public SupersqlStatement deepCopy() {
    return new SupersqlStatement(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.sql = null;
    setId_connectionIsSet(false);
    this.id_connection = 0;
  }

  public int getId() {
    return this.id;
  }

  public SupersqlStatement setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public java.lang.String getSql() {
    return this.sql;
  }

  public SupersqlStatement setSql(java.lang.String sql) {
    this.sql = sql;
    return this;
  }

  public void unsetSql() {
    this.sql = null;
  }

  /** Returns true if field sql is set (has been assigned a value) and false otherwise */
  public boolean isSetSql() {
    return this.sql != null;
  }

  public void setSqlIsSet(boolean value) {
    if (!value) {
      this.sql = null;
    }
  }

  public int getId_connection() {
    return this.id_connection;
  }

  public SupersqlStatement setId_connection(int id_connection) {
    this.id_connection = id_connection;
    setId_connectionIsSet(true);
    return this;
  }

  public void unsetId_connection() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_CONNECTION_ISSET_ID);
  }

  /** Returns true if field id_connection is set (has been assigned a value) and false otherwise */
  public boolean isSetId_connection() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_CONNECTION_ISSET_ID);
  }

  public void setId_connectionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_CONNECTION_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.Integer)value);
      }
      break;

    case SQL:
      if (value == null) {
        unsetSql();
      } else {
        setSql((java.lang.String)value);
      }
      break;

    case ID_CONNECTION:
      if (value == null) {
        unsetId_connection();
      } else {
        setId_connection((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case SQL:
      return getSql();

    case ID_CONNECTION:
      return getId_connection();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case SQL:
      return isSetSql();
    case ID_CONNECTION:
      return isSetId_connection();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof SupersqlStatement)
      return this.equals((SupersqlStatement)that);
    return false;
  }

  public boolean equals(SupersqlStatement that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_sql = true && this.isSetSql();
    boolean that_present_sql = true && that.isSetSql();
    if (this_present_sql || that_present_sql) {
      if (!(this_present_sql && that_present_sql))
        return false;
      if (!this.sql.equals(that.sql))
        return false;
    }

    boolean this_present_id_connection = true;
    boolean that_present_id_connection = true;
    if (this_present_id_connection || that_present_id_connection) {
      if (!(this_present_id_connection && that_present_id_connection))
        return false;
      if (this.id_connection != that.id_connection)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + ((isSetSql()) ? 131071 : 524287);
    if (isSetSql())
      hashCode = hashCode * 8191 + sql.hashCode();

    hashCode = hashCode * 8191 + id_connection;

    return hashCode;
  }

  @Override
  public int compareTo(SupersqlStatement other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetSql()).compareTo(other.isSetSql());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSql()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sql, other.sql);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetId_connection()).compareTo(other.isSetId_connection());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_connection()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id_connection, other.id_connection);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SupersqlStatement(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sql:");
    if (this.sql == null) {
      sb.append("null");
    } else {
      sb.append(this.sql);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id_connection:");
    sb.append(this.id_connection);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SupersqlStatementStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SupersqlStatementStandardScheme getScheme() {
      return new SupersqlStatementStandardScheme();
    }
  }

  private static class SupersqlStatementStandardScheme extends org.apache.thrift.scheme.StandardScheme<SupersqlStatement> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SupersqlStatement struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SQL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sql = iprot.readString();
              struct.setSqlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ID_CONNECTION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id_connection = iprot.readI32();
              struct.setId_connectionIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SupersqlStatement struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      if (struct.sql != null) {
        oprot.writeFieldBegin(SQL_FIELD_DESC);
        oprot.writeString(struct.sql);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ID_CONNECTION_FIELD_DESC);
      oprot.writeI32(struct.id_connection);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SupersqlStatementTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SupersqlStatementTupleScheme getScheme() {
      return new SupersqlStatementTupleScheme();
    }
  }

  private static class SupersqlStatementTupleScheme extends org.apache.thrift.scheme.TupleScheme<SupersqlStatement> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SupersqlStatement struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetSql()) {
        optionals.set(1);
      }
      if (struct.isSetId_connection()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetSql()) {
        oprot.writeString(struct.sql);
      }
      if (struct.isSetId_connection()) {
        oprot.writeI32(struct.id_connection);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SupersqlStatement struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.sql = iprot.readString();
        struct.setSqlIsSet(true);
      }
      if (incoming.get(2)) {
        struct.id_connection = iprot.readI32();
        struct.setId_connectionIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

