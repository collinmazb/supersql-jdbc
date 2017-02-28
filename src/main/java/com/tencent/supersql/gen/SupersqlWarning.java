/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.tencent.supersql.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-02-28")
public class SupersqlWarning implements org.apache.thrift.TBase<SupersqlWarning, SupersqlWarning._Fields>, java.io.Serializable, Cloneable, Comparable<SupersqlWarning> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SupersqlWarning");

  private static final org.apache.thrift.protocol.TField REASON_FIELD_DESC = new org.apache.thrift.protocol.TField("reason", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("state", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField VENDOR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("vendorCode", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SupersqlWarningStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SupersqlWarningTupleSchemeFactory();

  public java.lang.String reason; // required
  public java.lang.String state; // required
  public int vendorCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    REASON((short)1, "reason"),
    STATE((short)2, "state"),
    VENDOR_CODE((short)3, "vendorCode");

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
        case 1: // REASON
          return REASON;
        case 2: // STATE
          return STATE;
        case 3: // VENDOR_CODE
          return VENDOR_CODE;
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
  private static final int __VENDORCODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.REASON, new org.apache.thrift.meta_data.FieldMetaData("reason", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATE, new org.apache.thrift.meta_data.FieldMetaData("state", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VENDOR_CODE, new org.apache.thrift.meta_data.FieldMetaData("vendorCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SupersqlWarning.class, metaDataMap);
  }

  public SupersqlWarning() {
  }

  public SupersqlWarning(
    java.lang.String reason,
    java.lang.String state,
    int vendorCode)
  {
    this();
    this.reason = reason;
    this.state = state;
    this.vendorCode = vendorCode;
    setVendorCodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SupersqlWarning(SupersqlWarning other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetReason()) {
      this.reason = other.reason;
    }
    if (other.isSetState()) {
      this.state = other.state;
    }
    this.vendorCode = other.vendorCode;
  }

  public SupersqlWarning deepCopy() {
    return new SupersqlWarning(this);
  }

  @Override
  public void clear() {
    this.reason = null;
    this.state = null;
    setVendorCodeIsSet(false);
    this.vendorCode = 0;
  }

  public java.lang.String getReason() {
    return this.reason;
  }

  public SupersqlWarning setReason(java.lang.String reason) {
    this.reason = reason;
    return this;
  }

  public void unsetReason() {
    this.reason = null;
  }

  /** Returns true if field reason is set (has been assigned a value) and false otherwise */
  public boolean isSetReason() {
    return this.reason != null;
  }

  public void setReasonIsSet(boolean value) {
    if (!value) {
      this.reason = null;
    }
  }

  public java.lang.String getState() {
    return this.state;
  }

  public SupersqlWarning setState(java.lang.String state) {
    this.state = state;
    return this;
  }

  public void unsetState() {
    this.state = null;
  }

  /** Returns true if field state is set (has been assigned a value) and false otherwise */
  public boolean isSetState() {
    return this.state != null;
  }

  public void setStateIsSet(boolean value) {
    if (!value) {
      this.state = null;
    }
  }

  public int getVendorCode() {
    return this.vendorCode;
  }

  public SupersqlWarning setVendorCode(int vendorCode) {
    this.vendorCode = vendorCode;
    setVendorCodeIsSet(true);
    return this;
  }

  public void unsetVendorCode() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VENDORCODE_ISSET_ID);
  }

  /** Returns true if field vendorCode is set (has been assigned a value) and false otherwise */
  public boolean isSetVendorCode() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VENDORCODE_ISSET_ID);
  }

  public void setVendorCodeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VENDORCODE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case REASON:
      if (value == null) {
        unsetReason();
      } else {
        setReason((java.lang.String)value);
      }
      break;

    case STATE:
      if (value == null) {
        unsetState();
      } else {
        setState((java.lang.String)value);
      }
      break;

    case VENDOR_CODE:
      if (value == null) {
        unsetVendorCode();
      } else {
        setVendorCode((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case REASON:
      return getReason();

    case STATE:
      return getState();

    case VENDOR_CODE:
      return getVendorCode();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case REASON:
      return isSetReason();
    case STATE:
      return isSetState();
    case VENDOR_CODE:
      return isSetVendorCode();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof SupersqlWarning)
      return this.equals((SupersqlWarning)that);
    return false;
  }

  public boolean equals(SupersqlWarning that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_reason = true && this.isSetReason();
    boolean that_present_reason = true && that.isSetReason();
    if (this_present_reason || that_present_reason) {
      if (!(this_present_reason && that_present_reason))
        return false;
      if (!this.reason.equals(that.reason))
        return false;
    }

    boolean this_present_state = true && this.isSetState();
    boolean that_present_state = true && that.isSetState();
    if (this_present_state || that_present_state) {
      if (!(this_present_state && that_present_state))
        return false;
      if (!this.state.equals(that.state))
        return false;
    }

    boolean this_present_vendorCode = true;
    boolean that_present_vendorCode = true;
    if (this_present_vendorCode || that_present_vendorCode) {
      if (!(this_present_vendorCode && that_present_vendorCode))
        return false;
      if (this.vendorCode != that.vendorCode)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetReason()) ? 131071 : 524287);
    if (isSetReason())
      hashCode = hashCode * 8191 + reason.hashCode();

    hashCode = hashCode * 8191 + ((isSetState()) ? 131071 : 524287);
    if (isSetState())
      hashCode = hashCode * 8191 + state.hashCode();

    hashCode = hashCode * 8191 + vendorCode;

    return hashCode;
  }

  @Override
  public int compareTo(SupersqlWarning other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetReason()).compareTo(other.isSetReason());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReason()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reason, other.reason);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetState()).compareTo(other.isSetState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.state, other.state);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetVendorCode()).compareTo(other.isSetVendorCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVendorCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.vendorCode, other.vendorCode);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SupersqlWarning(");
    boolean first = true;

    sb.append("reason:");
    if (this.reason == null) {
      sb.append("null");
    } else {
      sb.append(this.reason);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("state:");
    if (this.state == null) {
      sb.append("null");
    } else {
      sb.append(this.state);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("vendorCode:");
    sb.append(this.vendorCode);
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

  private static class SupersqlWarningStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SupersqlWarningStandardScheme getScheme() {
      return new SupersqlWarningStandardScheme();
    }
  }

  private static class SupersqlWarningStandardScheme extends org.apache.thrift.scheme.StandardScheme<SupersqlWarning> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SupersqlWarning struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // REASON
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reason = iprot.readString();
              struct.setReasonIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.state = iprot.readString();
              struct.setStateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VENDOR_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.vendorCode = iprot.readI32();
              struct.setVendorCodeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SupersqlWarning struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.reason != null) {
        oprot.writeFieldBegin(REASON_FIELD_DESC);
        oprot.writeString(struct.reason);
        oprot.writeFieldEnd();
      }
      if (struct.state != null) {
        oprot.writeFieldBegin(STATE_FIELD_DESC);
        oprot.writeString(struct.state);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(VENDOR_CODE_FIELD_DESC);
      oprot.writeI32(struct.vendorCode);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SupersqlWarningTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SupersqlWarningTupleScheme getScheme() {
      return new SupersqlWarningTupleScheme();
    }
  }

  private static class SupersqlWarningTupleScheme extends org.apache.thrift.scheme.TupleScheme<SupersqlWarning> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SupersqlWarning struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetReason()) {
        optionals.set(0);
      }
      if (struct.isSetState()) {
        optionals.set(1);
      }
      if (struct.isSetVendorCode()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetReason()) {
        oprot.writeString(struct.reason);
      }
      if (struct.isSetState()) {
        oprot.writeString(struct.state);
      }
      if (struct.isSetVendorCode()) {
        oprot.writeI32(struct.vendorCode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SupersqlWarning struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.reason = iprot.readString();
        struct.setReasonIsSet(true);
      }
      if (incoming.get(1)) {
        struct.state = iprot.readString();
        struct.setStateIsSet(true);
      }
      if (incoming.get(2)) {
        struct.vendorCode = iprot.readI32();
        struct.setVendorCodeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

