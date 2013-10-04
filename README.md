fetch-jmx
=========

Command line util to monitor JMX metrics

## Build
1. Install [Leiningen](https://github.com/technomancy/leiningen)
1. Clone the repo and switch to the directory
1. Build an uberjar ```lein uberjar```

## Options
```
 Switches               Default    Desc                                                       
 --------               -------    ----                                                       
 -h, --no-help, --help  false      print this message                                         
 -s, --server           localhost  JMX host to connect to                                     
 -p, --port             7199       JMX port to connect to                                     
 -j, --jmx                         JMX metrics to collect delinated by ';'                    
 -l, --list                        List available beans using supplied pattern (*:*)          
 -f, --file                        Input file containing JMX metrics to collect, one per line 
 -t, --time             1          Total time to run the monitor (seconds)                    
 -i, --interval         60         Intverval between metrics fetch (seconds)   
 ```
 
## Format of the metrics file
 
One line per metric. If you want all attributes of a bean, just name the bean. If you want a specific attribute name the bean, then put a semicolon followed by the attribute to be polled.
 
 ```
java.lang:type=GarbageCollector,name=ConcurrentMarkSweep;CollectionCount
java.lang:type=GarbageCollector,name=ConcurrentMarkSweep;CollectionTime
java.lang:type=GarbageCollector,name=ParNew;CollectionCount
java.lang:type=GarbageCollector,name=ParNew;CollectionTime
java.lang:type=Memory
java.lang:type=OperatingSystem;SystemCpuLoad
```

## Example output

```
╰─$ java -jar target/fetch_jmx-0.1.0-standalone.jar -f example-metrics.txt -t 1 -i 10
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=GarbageCollector,name=ConcurrentMarkSweep;CollectionCount | 5
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=GarbageCollector,name=ConcurrentMarkSweep;CollectionTime | 5352
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=GarbageCollector,name=ParNew;CollectionCount | 2
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=GarbageCollector,name=ParNew;CollectionTime | 131
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=Memory | Verbose | false
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=Memory | ObjectPendingFinalizationCount | 0
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=Memory | HeapMemoryUsage | {"committed":8506048512,"init":8589934592,"max":8506048512,"used":338140048}
2013-10-03T22:54:17PDT | localhost:7199 | java.lang:type=Memory | NonHeapMemoryUsage | {"committed":70938624,"init":24313856,"max":136314880,"used":43911848}
2013-10-03T22:54:18PDT | localhost:7199 | java.lang:type=OperatingSystem;SystemCpuLoad | 0.0647753476346866
```
