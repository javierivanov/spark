package org.apache.spark.sql.hive.thriftserver


import org.apache.spark.SparkConf
import org.apache.spark.deploy.SparkHadoopUtil
import org.apache.spark.internal.Logging
import org.apache.spark.sql.hive.HiveUtils




private[hive] object SparkSQLCLIDriver2 extends Logging {
    def main(args: Array[String]): Unit = {
        val sparkSQLArgs = SparkSQLCLIArguments(args)
        sparkSQLArgs.parse()

        val sparkConf = new SparkConf(loadDefaults = true)
        sparkConf.setAll(sparkSQLArgs.getSparkConfs)
        val hadoopConf = SparkHadoopUtil.get.newConfiguration(sparkConf)
        val extraConfigs = HiveUtils.formatTimeVarsForHiveClient(hadoopConf)

    }
}

private[hive] class SparkSQLCLIDriver2 extends Logging {

}