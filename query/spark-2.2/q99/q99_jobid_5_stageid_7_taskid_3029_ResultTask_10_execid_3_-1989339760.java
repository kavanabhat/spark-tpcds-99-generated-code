/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */     boolean isNull6 = i.isNullAt(2);
/* 028 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 029 */     boolean isNull5 = true;
/* 030 */     java.lang.String value5 = null;
/* 031 */     if (!isNull6) {
/* 032 */
/* 033 */       isNull5 = false;
/* 034 */       if (!isNull5) {
/* 035 */
/* 036 */         Object funcResult2 = null;
/* 037 */         funcResult2 = value6.toString();
/* 038 */         value5 = (java.lang.String) funcResult2;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull5) {
/* 043 */       values[2] = null;
/* 044 */     } else {
/* 045 */       values[2] = value5;
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull7 = i.isNullAt(3);
/* 049 */     long value7 = isNull7 ? -1L : (i.getLong(3));
/* 050 */     if (isNull7) {
/* 051 */       values[3] = null;
/* 052 */     } else {
/* 053 */       values[3] = value7;
/* 054 */     }
/* 055 */
/* 056 */     boolean isNull8 = i.isNullAt(4);
/* 057 */     long value8 = isNull8 ? -1L : (i.getLong(4));
/* 058 */     if (isNull8) {
/* 059 */       values[4] = null;
/* 060 */     } else {
/* 061 */       values[4] = value8;
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull9 = i.isNullAt(5);
/* 065 */     long value9 = isNull9 ? -1L : (i.getLong(5));
/* 066 */     if (isNull9) {
/* 067 */       values[5] = null;
/* 068 */     } else {
/* 069 */       values[5] = value9;
/* 070 */     }
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */
/* 075 */   private void apply_0(InternalRow i) {
/* 076 */
/* 077 */     boolean isNull2 = i.isNullAt(0);
/* 078 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 079 */     boolean isNull1 = true;
/* 080 */     java.lang.String value1 = null;
/* 081 */     if (!isNull2) {
/* 082 */
/* 083 */       isNull1 = false;
/* 084 */       if (!isNull1) {
/* 085 */
/* 086 */         Object funcResult = null;
/* 087 */         funcResult = value2.toString();
/* 088 */         value1 = (java.lang.String) funcResult;
/* 089 */
/* 090 */       }
/* 091 */     }
/* 092 */     if (isNull1) {
/* 093 */       values[0] = null;
/* 094 */     } else {
/* 095 */       values[0] = value1;
/* 096 */     }
/* 097 */
/* 098 */     boolean isNull4 = i.isNullAt(1);
/* 099 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 100 */     boolean isNull3 = true;
/* 101 */     java.lang.String value3 = null;
/* 102 */     if (!isNull4) {
/* 103 */
/* 104 */       isNull3 = false;
/* 105 */       if (!isNull3) {
/* 106 */
/* 107 */         Object funcResult1 = null;
/* 108 */         funcResult1 = value4.toString();
/* 109 */         value3 = (java.lang.String) funcResult1;
/* 110 */
/* 111 */       }
/* 112 */     }
/* 113 */     if (isNull3) {
/* 114 */       values[1] = null;
/* 115 */     } else {
/* 116 */       values[1] = value3;
/* 117 */     }
/* 118 */
/* 119 */   }
/* 120 */
/* 121 */
/* 122 */   private void apply_2(InternalRow i) {
/* 123 */
/* 124 */     boolean isNull10 = i.isNullAt(6);
/* 125 */     long value10 = isNull10 ? -1L : (i.getLong(6));
/* 126 */     if (isNull10) {
/* 127 */       values[6] = null;
/* 128 */     } else {
/* 129 */       values[6] = value10;
/* 130 */     }
/* 131 */
/* 132 */     boolean isNull11 = i.isNullAt(7);
/* 133 */     long value11 = isNull11 ? -1L : (i.getLong(7));
/* 134 */     if (isNull11) {
/* 135 */       values[7] = null;
/* 136 */     } else {
/* 137 */       values[7] = value11;
/* 138 */     }
/* 139 */
/* 140 */   }
/* 141 */
/* 142 */
/* 143 */   public java.lang.Object apply(java.lang.Object _i) {
/* 144 */     InternalRow i = (InternalRow) _i;
/* 145 */
/* 146 */     values = new Object[8];
/* 147 */     apply_0(i);
/* 148 */     apply_1(i);
/* 149 */     apply_2(i);
/* 150 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 151 */     if (false) {
/* 152 */       mutableRow.setNullAt(0);
/* 153 */     } else {
/* 154 */
/* 155 */       mutableRow.update(0, value);
/* 156 */     }
/* 157 */
/* 158 */     return mutableRow;
/* 159 */   }
/* 160 */ }