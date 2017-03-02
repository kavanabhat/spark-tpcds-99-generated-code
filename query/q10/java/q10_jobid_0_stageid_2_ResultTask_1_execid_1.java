/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private UnsafeRow scan_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 027 */   private UnsafeRow filter_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 030 */   private UnsafeRow project_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     wholestagecodegen_init_0();
/* 042 */     wholestagecodegen_init_1();
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */   private void wholestagecodegen_init_0() {
/* 047 */     scan_input = inputs[0];
/* 048 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 049 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     scan_scanTime1 = 0;
/* 051 */     scan_batch = null;
/* 052 */     scan_batchIdx = 0;
/* 053 */     scan_colInstance0 = null;
/* 054 */     scan_colInstance1 = null;
/* 055 */     scan_colInstance2 = null;
/* 056 */     scan_colInstance3 = null;
/* 057 */     scan_colInstance4 = null;
/* 058 */     scan_colInstance5 = null;
/* 059 */     scan_colInstance6 = null;
/* 060 */     scan_colInstance7 = null;
/* 061 */     scan_colInstance8 = null;
/* 062 */     scan_result = new UnsafeRow(9);
/* 063 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 128);
/* 064 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 9);
/* 065 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 066 */     filter_result = new UnsafeRow(9);
/* 067 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 128);
/* 068 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 069 */
/* 070 */   }
/* 071 */
/* 072 */   private void scan_nextBatch() throws java.io.IOException {
/* 073 */     long getBatchStart = System.nanoTime();
/* 074 */     if (scan_input.hasNext()) {
/* 075 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 076 */       scan_numOutputRows.add(scan_batch.numRows());
/* 077 */       scan_batchIdx = 0;
/* 078 */       scan_colInstance0 = scan_batch.column(0);
/* 079 */       scan_colInstance1 = scan_batch.column(1);
/* 080 */       scan_colInstance2 = scan_batch.column(2);
/* 081 */       scan_colInstance3 = scan_batch.column(3);
/* 082 */       scan_colInstance4 = scan_batch.column(4);
/* 083 */       scan_colInstance5 = scan_batch.column(5);
/* 084 */       scan_colInstance6 = scan_batch.column(6);
/* 085 */       scan_colInstance7 = scan_batch.column(7);
/* 086 */       scan_colInstance8 = scan_batch.column(8);
/* 087 */
/* 088 */     }
/* 089 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 090 */   }
/* 091 */
/* 092 */   private void wholestagecodegen_init_1() {
/* 093 */     project_result = new UnsafeRow(9);
/* 094 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 095 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 096 */
/* 097 */   }
/* 098 */
/* 099 */   protected void processNext() throws java.io.IOException {
/* 100 */     if (scan_batch == null) {
/* 101 */       scan_nextBatch();
/* 102 */     }
/* 103 */     while (scan_batch != null) {
/* 104 */       int numRows = scan_batch.numRows();
/* 105 */       while (scan_batchIdx < numRows) {
/* 106 */         int scan_rowIdx = scan_batchIdx++;
/* 107 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 108 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 109 */
/* 110 */         if (!(!(scan_isNull))) continue;
/* 111 */
/* 112 */         filter_numOutputRows.add(1);
/* 113 */
/* 114 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 115 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 116 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 117 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 118 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 119 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 120 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 121 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 122 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 123 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 124 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 125 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 126 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 127 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 128 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 129 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 130 */         project_holder.reset();
/* 131 */
/* 132 */         project_rowWriter.zeroOutNullBytes();
/* 133 */
/* 134 */         project_rowWriter.write(0, scan_value);
/* 135 */
/* 136 */         if (scan_isNull1) {
/* 137 */           project_rowWriter.setNullAt(1);
/* 138 */         } else {
/* 139 */           project_rowWriter.write(1, scan_value1);
/* 140 */         }
/* 141 */
/* 142 */         if (scan_isNull2) {
/* 143 */           project_rowWriter.setNullAt(2);
/* 144 */         } else {
/* 145 */           project_rowWriter.write(2, scan_value2);
/* 146 */         }
/* 147 */
/* 148 */         if (scan_isNull3) {
/* 149 */           project_rowWriter.setNullAt(3);
/* 150 */         } else {
/* 151 */           project_rowWriter.write(3, scan_value3);
/* 152 */         }
/* 153 */
/* 154 */         if (scan_isNull4) {
/* 155 */           project_rowWriter.setNullAt(4);
/* 156 */         } else {
/* 157 */           project_rowWriter.write(4, scan_value4);
/* 158 */         }
/* 159 */
/* 160 */         if (scan_isNull5) {
/* 161 */           project_rowWriter.setNullAt(5);
/* 162 */         } else {
/* 163 */           project_rowWriter.write(5, scan_value5);
/* 164 */         }
/* 165 */
/* 166 */         if (scan_isNull6) {
/* 167 */           project_rowWriter.setNullAt(6);
/* 168 */         } else {
/* 169 */           project_rowWriter.write(6, scan_value6);
/* 170 */         }
/* 171 */
/* 172 */         if (scan_isNull7) {
/* 173 */           project_rowWriter.setNullAt(7);
/* 174 */         } else {
/* 175 */           project_rowWriter.write(7, scan_value7);
/* 176 */         }
/* 177 */
/* 178 */         if (scan_isNull8) {
/* 179 */           project_rowWriter.setNullAt(8);
/* 180 */         } else {
/* 181 */           project_rowWriter.write(8, scan_value8);
/* 182 */         }
/* 183 */         project_result.setTotalSize(project_holder.totalSize());
/* 184 */         append(project_result);
/* 185 */         if (shouldStop()) return;
/* 186 */       }
/* 187 */       scan_batch = null;
/* 188 */       scan_nextBatch();
/* 189 */     }
/* 190 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 191 */     scan_scanTime1 = 0;
/* 192 */   }
/* 193 */ }
