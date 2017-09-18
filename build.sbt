name := "Graph"


version := "1.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.3.1" ,
  "org.apache.spark" %% "spark-sql" % "1.3.1" ,
  "org.apache.spark" %% "spark-graphx" % "1.3.1"
)