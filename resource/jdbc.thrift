
namespace java com.tencent.supersql.gen

exception InvalidOperation {
  1: i32 errorCode,
  2: string message
}

struct SupersqlConnection
{
  1: i32 id
}

struct SupersqlStatement
{
  1: i32 id, 
  2: string sql
  3: i32 id_connection
}

struct SupersqlProperty
{
  1: string key,
  2: string value
}

union RawVal {
  1: i64 bigint_val,
  2: i32 integer_val,
  3: i16 smallint_val,
  4: double double_val,
  5: bool bool_val,
  6: string string_val
}

struct SupersqlValue
{
  1: bool isnull,
  2: RawVal val
}

  
struct SupersqlRow
{
  1: list<SupersqlValue> values
}

struct SupersqlResultSetMetaDataPart 
{
  1:  string catalogName,
  2:  string columnClassName,
  3:  i32 columnDisplaySize,
  4:  string columnLabel,
  5:  string columnName,
  6:  i32 columnType,
  7:  string columnTypeName,
  8:  i32 precision,
  9:  i32 scale,
  10:  string schemaName,
  11:  string tableName,
  12:  bool autoIncrement,
  13:  bool caseSensitive,
  14:  bool currency,
  15:  bool definitelyWritable,
  16:  i32 nullable,
  17:  bool readOnly,
  18:  bool searchable,
  19:  bool signed,
  20:  bool writable
}

struct SupersqlResultSetMetaData
{
  1: list<SupersqlResultSetMetaDataPart> parts
}

struct SupersqlResultSet
{
  1: i32 id,
  2: list<SupersqlRow> rows,
  3: SupersqlResultSetMetaData metadata
}

struct SupersqlStaticMetaData
{
  1: i32 databaseMajorVersion,
  2: i32 databaseMinorVersion,
  3: string databaseProductName,
  4: string databaseProductVersion,
  5: i32 defaultTransactionIsolation,
  6: string identifierQuoteString,
  7: bool supportsCatalogsInTableDefinitions,
  8: bool supportsSavepoints,
  9: bool supportsSchemasInDataManipulation,
  10: bool supportsSchemasInTableDefinitions
}

struct SupersqlWarning {
  1: string reason
  2: string state
  3: i32 vendorCode
}

struct statement_getWarnings_return {
  1: list<SupersqlWarning> warnings
}

exception SupersqlException {
  1: string reason
  2: string sqlState
  3: i32 vendorCode
}

service SupersqlConnectionService {

   i32 createLink(1:string driverurl, 2:string linkname, 3:string username, 4:string password),
   string useLink(1:string linkName),
   list<string> showLinks(),

   SupersqlConnection createConnection(1:string url, 2:map<string,string> properties),
   
   SupersqlStatement createStatement(1:SupersqlConnection connection),
   
   SupersqlStaticMetaData connection_getstaticmetadata(1:SupersqlConnection connection),
   bool connection_isvalid(1:SupersqlConnection connection, 2:i32 timeout),
   
   void connection_setAutoCommit(1:SupersqlConnection connection, 2:bool autoCommit) throws (1:SupersqlException ouch)
   bool connection_getAutoCommit(1:SupersqlConnection connection) throws (1:SupersqlException ouch)
   void connection_setTransactionIsolation(1:SupersqlConnection connection, 2:i32 level) throws (1:SupersqlException ouch)
   i32 connection_getTransactionIsolation(1:SupersqlConnection connection) throws (1:SupersqlException ouch)
   void connection_setReadOnly(1:SupersqlConnection connection, 2:bool readOnly) throws (1:SupersqlException ouch)
   bool connection_getReadOnly(1:SupersqlConnection connection) throws (1:SupersqlException ouch)
   
   void connection_setCatalog(1:SupersqlConnection connection, 2:string catalog) throws (1:SupersqlException ouch)
   string connection_getCatalog(1:SupersqlConnection connection) throws (1:SupersqlException ouch)
   void connection_setSchema(1:SupersqlConnection connection, 2:string schema) throws (1:SupersqlException ouch)
   string connection_getSchema(1:SupersqlConnection connection) throws (1:SupersqlException ouch)
   
   string connection_getCatalogSeparator(1:SupersqlConnection connection),
   string connection_getCatalogTerm(1:SupersqlConnection connection),
   string connection_getSchemaTerm(1:SupersqlConnection connection),
   
   SupersqlResultSet connection_getCatalogs(1:SupersqlConnection connection),
   SupersqlResultSet connection_getSchemas(1:SupersqlConnection connection, 2:string catalog, 3:string schemaPattern) throws (1:SupersqlException ouch)
   SupersqlResultSet connection_getTables(1:SupersqlConnection connection, 2:string catalog, 3:string schemaPattern, 4:string tableNamePattern, 5:list<string> types),
   SupersqlResultSet connection_getColumns(1:SupersqlConnection connection, 2:string catalog, 3:string schemaPattern, 4:string tableNamePattern, 5:string columnNamePattern),
   string connection_getSQLKeywords(1:SupersqlConnection connection),
   SupersqlResultSet connection_getTableTypes(1:SupersqlConnection connection),
   
   SupersqlResultSet connection_getTypeInfo(1:SupersqlConnection connection) throws (1:SupersqlException ouch)

   void closeConnection(1:SupersqlConnection connection) throws (1:SupersqlException ouch)
   
   void statement_close(1:SupersqlStatement statement) throws (1:SupersqlException ouch)
   bool statement_execute(1:SupersqlStatement statement, 2:string sql) throws (1:SupersqlException ouch)
   SupersqlResultSet statement_executeQuery(1:SupersqlStatement statement, 2:string sql) throws (1:SupersqlException ouch)
   SupersqlResultSet statement_getResultSet(1:SupersqlStatement statement) throws (1:SupersqlException ouch)
   i32 statement_getUpdateCount(1:SupersqlStatement statement),
   i32 statement_getResultSetType(1:SupersqlStatement statement)
   void statement_cancel(1:SupersqlStatement statement) throws (1:SupersqlException ouch)
   
   statement_getWarnings_return statement_getWarnings(1:SupersqlStatement statement) throws (1:SupersqlException ouch)
   void statement_clearWarnings(1:SupersqlStatement statement) throws (1:SupersqlException ouch)
   
   i32 statement_getMaxRows(1:SupersqlStatement statement) throws (1:SupersqlException ouch)
   void statement_setMaxRows(1:SupersqlStatement statement, 2:i32 max) throws (1:SupersqlException ouch)
   i32 statement_getQueryTimeout(1:SupersqlStatement statement) throws (1:SupersqlException ouch)
   void statement_setQueryTimeout(1:SupersqlStatement statement, 2:i32 seconds) throws (1:SupersqlException ouch)
}