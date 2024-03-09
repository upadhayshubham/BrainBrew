# Prologue
This is to show that why writing password in String is not safe.
Since, String is immutable and stays in heap memory, anyone with access to deployment
environment will be able to access the strings stored in heap.

# Code
The following code is pretty simple. I have just stored a String. The reason why you are seeing a Thread sleep is, so that it gives me sufficient time to take heap dump.

# Process
1. Run the code 
```
javac PlainStringPassword.java
java PlainStringPassword
>>>>Starting<<<<
```
<br>
2. Identify the PID which is required for taking heap.
jps -v

```
shubham@shubhamvm:~/Documents/home_work/code_repository/test$ jps -v
5814 Jps -Dapplication.home=/home/shubham/Documents/home_work/software/jdk-21.0.2 -Xms8m -Djdk.module.main=jdk.jcmd
5789 PasswordInString
```

> 5789 is the one we are looking for.

<br>
3. Take a heap dump now

```
jmap -dump:format=b,file=heapDump 5789
Dumping heap to /home/shubham/Documents/home_work/code_repository/test/heapDump ...
Heap dump file created [4427695 bytes in 0.014 secs]
```
<br>

4. Now open the binary file, and just search for 
`String pass`
Or
`InMemoryCharPass`

you will find them in the file.
![Screenshot from 2024-03-09 19-17-51](https://github.com/upadhayshubham/BrainBrew/assets/147260383/750d70e5-c42e-485e-8b3b-9968e7b764b3)

All of these passwords are easily visible in heap memory.
- InMemoryCharPass
- ArrayPassword
- String pass


However, the one as char array is not readable - `toCharArray�()[C��`


This shows that the storing password as String is a bad choice. It is beter to store them in char array,


***Cheers****
