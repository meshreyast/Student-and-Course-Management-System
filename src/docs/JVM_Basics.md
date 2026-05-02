What is JDK?

Java Development Kit (JDK) is a development kit that provides
tools and libraries needed to build Java based applications. 

JDK includes JRE (Java Runtime Environment) and additional development
tools like interpreter/loader, debugger and compiler.

What is JRE?

Java Runtime Environment (JRE) is a main component of JDK. It provides
the environment required to run Java. Java source code is first compiled
into Java bytecode. To run this bytecode on any platform, JRE is needed.

JRE handles tasks such as loading classes, checking memory access and
accessing system resources.

What is JVM?

The Java virtual machine is a component of JRE which allows Java 
programs to run on nay platform. JVM is unique for every platform.

JVM loads the bytecode, interprets it. It also uses Just in time (JIT)
compilation to convert "hot" code into machine native code.

Garbage collection runs in JVM to reclaim memory from unused objects.

JVM also has Class loader subsystem which provide the functionalities 
like loading class, linking and initialization.

What is bytecode?

Bytecode is an intermediate, platform-independent code generated when
a .java file is compiled into a .class file.This bytecode is executed
by the JVM. Bytecode can only be run by a JVM.

What is Java’s Write Once, Run Anywhere principle?

JVM acts as a Runtime engine to run Java applications. JVM is a part
of JRE. JVM is the one that actually calls the main method present
in java code.

In Java unlike other languages, program is not converted to code directly
understood by hardware. It is converted to bytecode which is 
interpreted by JVM, so once compiled it generates bytecode file, which
can be run anywhere (on any machine) which has JVM.

This is called Write Once and Run Anywhere.