/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private scala.collection.Iterator inputadapter_input;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 016 */   private UnsafeRow agg_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 019 */
/* 020 */   public GeneratedIterator(Object[] references) {
/* 021 */     this.references = references;
/* 022 */   }
/* 023 */
/* 024 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 025 */     partitionIndex = index;
/* 026 */     this.inputs = inputs;
/* 027 */     agg_initAgg = false;
/* 028 */
/* 029 */     inputadapter_input = inputs[0];
/* 030 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 031 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 032 */     agg_result = new UnsafeRow(1);
/* 033 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 034 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 035 */
/* 036 */   }
/* 037 */
/* 038 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 039 */     // initialize aggregation buffer
/* 040 */     boolean agg_isNull = false;
/* 041 */     double agg_value = -1.0;
/* 042 */     if (!false) {
/* 043 */       agg_value = (double) 0;
/* 044 */     }
/* 045 */     agg_bufIsNull = agg_isNull;
/* 046 */     agg_bufValue = agg_value;
/* 047 */     agg_bufIsNull1 = false;
/* 048 */     agg_bufValue1 = 0L;
/* 049 */
/* 050 */     while (inputadapter_input.hasNext()) {
/* 051 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 052 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 053 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 054 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 055 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 056 */
/* 057 */       // do aggregate
/* 058 */       // common sub-expressions
/* 059 */
/* 060 */       // evaluate aggregate function
/* 061 */       boolean agg_isNull9 = true;
/* 062 */       double agg_value9 = -1.0;
/* 063 */
/* 064 */       if (!agg_bufIsNull) {
/* 065 */         if (!inputadapter_isNull) {
/* 066 */           agg_isNull9 = false; // resultCode could change nullability.
/* 067 */           agg_value9 = agg_bufValue + inputadapter_value;
/* 068 */
/* 069 */         }
/* 070 */
/* 071 */       }
/* 072 */       boolean agg_isNull12 = true;
/* 073 */       long agg_value12 = -1L;
/* 074 */
/* 075 */       if (!agg_bufIsNull1) {
/* 076 */         if (!inputadapter_isNull1) {
/* 077 */           agg_isNull12 = false; // resultCode could change nullability.
/* 078 */           agg_value12 = agg_bufValue1 + inputadapter_value1;
/* 079 */
/* 080 */         }
/* 081 */
/* 082 */       }
/* 083 */       // update aggregation buffer
/* 084 */       agg_bufIsNull = agg_isNull9;
/* 085 */       agg_bufValue = agg_value9;
/* 086 */
/* 087 */       agg_bufIsNull1 = agg_isNull12;
/* 088 */       agg_bufValue1 = agg_value12;
/* 089 */       if (shouldStop()) return;
/* 090 */     }
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   protected void processNext() throws java.io.IOException {
/* 095 */     while (!agg_initAgg) {
/* 096 */       agg_initAgg = true;
/* 097 */       long agg_beforeAgg = System.nanoTime();
/* 098 */       agg_doAggregateWithoutKey();
/* 099 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 100 */
/* 101 */       // output the result
/* 102 */       boolean agg_isNull6 = agg_bufIsNull1;
/* 103 */       double agg_value6 = -1.0;
/* 104 */       if (!agg_bufIsNull1) {
/* 105 */         agg_value6 = (double) agg_bufValue1;
/* 106 */       }
/* 107 */       boolean agg_isNull3 = false;
/* 108 */       double agg_value3 = -1.0;
/* 109 */       if (agg_isNull6 || agg_value6 == 0) {
/* 110 */         agg_isNull3 = true;
/* 111 */       } else {
/* 112 */         boolean agg_isNull4 = agg_bufIsNull;
/* 113 */         double agg_value4 = -1.0;
/* 114 */         if (!agg_bufIsNull) {
/* 115 */           agg_value4 = agg_bufValue;
/* 116 */         }
/* 117 */         if (agg_isNull4) {
/* 118 */           agg_isNull3 = true;
/* 119 */         } else {
/* 120 */           agg_value3 = (double)(agg_value4 / agg_value6);
/* 121 */         }
/* 122 */       }
/* 123 */
/* 124 */       agg_numOutputRows.add(1);
/* 125 */       agg_rowWriter.zeroOutNullBytes();
/* 126 */
/* 127 */       if (agg_isNull3) {
/* 128 */         agg_rowWriter.setNullAt(0);
/* 129 */       } else {
/* 130 */         agg_rowWriter.write(0, agg_value3);
/* 131 */       }
/* 132 */       append(agg_result);
/* 133 */     }
/* 134 */   }
/* 135 */ }
