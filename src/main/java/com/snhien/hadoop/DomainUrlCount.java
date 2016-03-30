package com.snhien.hadoop;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class DomainUrlCount {

	public static class MapperDomain extends MapReduceBase 
		implements Mapper<LongWritable, Text, Text, Text>{
		//Input Key, Input Value, Output Key, Output Value

		public void map(LongWritable key, Text input, OutputCollector<Text, Text> collector, Reporter reporter)
				throws IOException {
			// TODO Auto-generated method stub
			String line = input.toString();
			String[] tokens = line.split("\t");
			if (tokens!=null && tokens.length>1){
				String domain = tokens[0];
				String url = tokens[1];
				collector.collect(new Text(domain), new Text(url));
			}
			
		}
		
	}
	
	public static class ReducerDomain extends MapReduceBase
		implements Reducer<Text, Text, Text, IntWritable>{

		public void reduce(Text domain, Iterator<Text> valueIter, OutputCollector<Text, IntWritable> collector, Reporter arg3)
				throws IOException {
			// TODO Auto-generated method stub
			Set<String> domainUrls = new HashSet<String>();
			while (valueIter.hasNext()){
				Text url = valueIter.next();
				domainUrls.add(url.toString());
			}
			IntWritable uniqueUrls = new IntWritable(domainUrls.size());
			System.out.println(domain + ":" + domainUrls.size());
			collector.collect(domain, uniqueUrls);
		}		
	}
	
	public static void main(String [] args) throws Exception{
	      JobConf conf = new JobConf(DomainUrlCount.class); 
	      
	      conf.setJobName("domainUrlCount"); 
	      conf.setMapOutputKeyClass(Text.class);
	      conf.setMapOutputValueClass(Text.class);
	      conf.setOutputKeyClass(Text.class);
	      conf.setOutputValueClass(IntWritable.class); 
	      conf.setMapperClass(MapperDomain.class); 
	      //conf.setCombinerClass(ReducerDomain.class); 
	      conf.setReducerClass(ReducerDomain.class); 
	      conf.setInputFormat(TextInputFormat.class); 
	      conf.setOutputFormat(TextOutputFormat.class); 
	      
	      FileInputFormat.setInputPaths(conf, new Path(args[0])); 
	      FileOutputFormat.setOutputPath(conf, new Path(args[1])); 
	      
	      JobClient.runJob(conf); 
	}
}
