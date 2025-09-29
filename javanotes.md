# LOGGING  

Logging is necessary for debugging and tracking user activities, as real-time debugging is not always possible for web applications. Therefore, debug logging is used.  

In Java web applications, we use the Apache Log4j framework to log information to various destinations, such as databases, consoles, files, etc.  

The Logger class in Log4j provides methods for logging. The common log levels are: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF.   


# JSP  
->stands for java server pages it allows to add dynamic web pages. It allows developer to embed java code directly into the html file.  
->it is compiled 


# JAVA Notes  
The throw keyword in Java is used to explicitly throw an exception. The exception object, once created, is thrown to the calling method. The try-catch block is then used to handle the exception at the appropriate level in the code.  


# DI
Problem with setter based di is that whenever object is created service initiation is not done at that moment whereas, we have to set it. If we don't do that we get null pointer error

# Annotation
@primary:It is used to designate a preferred bean when multiple beans of same type are available for autowiring. 