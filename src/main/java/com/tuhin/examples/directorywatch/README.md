# Directory Watch Example

### Objective
1. Given you have a **Source** folder, where files will be placed either automatically or manually. Consider a stream of files placed into the folder
2. As a software developer, you have to watch the directory for any new file gets added
3. And then parse the file to extract the timestamp based on a specified date-time format(configurable)
4. And then move the file to directory called **Archive** as follows:
     1. Based on timestamp, extract Year, Month and Day
     2. Create sub-directory for Year, Month and Day if not already exists
     3. Move to the appropriate sub-directory
4. Example, 
   1. if file name at Source is FILE_20210714102730046.raw
   1. the move the file name to **Archive/2021/07/14/FILE_20210714102730046.raw**

### How it has been implemented
1. I have used **WatchService** class from java.nio API
2. I registered for newly CREATED files into Source directory
3. I am reading all the **configs** from a **json** which is placed as same location as class files
4. I am using Object Mapper to convert json into a Pojo. You need to **add jackson dependency** into library for this.
5. I am using Files and Path API from same nio API library to move files to Archive directory
6. In case, file name can't be parsed, moving file to **Failed** folder

### Build Note
1. This code is built on Java 11
2. If you need library for jackson, please download from lib folder