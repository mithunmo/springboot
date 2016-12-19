package com.f9g4.businesscore.aggregation;

import java.lang.reflect.Method;

import commonj.work.Work;

/**
 * The MethodCallWork class implements the CommonJ Work interface and represents a
 * single unit of work for the WorkManager. MethodCallWork allows any method call to be
 * executed inside the WorkManager thread pool.  A Class object, the name of
 * the method to execute, and the methods expected parameter types and values
 * are passed in the constructor. The run() method (which is executed by the WorkManager)
 * makes the method call and stores the result as an instance variable. Once
 * completed, the getResult() method can be used to get the results of the
 * method call. If an exception is encountered, the container will hold the exception 
 * and throw it when a call to WorkItem.getResult() is made.
 */
public class MethodCallWork implements Work
{
    private final Object classObject;

    private final String methodName;

    @SuppressWarnings("unchecked")
    private final Class[] paramTypes;

    private final Object[] paramValues;

    private Object result;

    @SuppressWarnings("unchecked")
    public MethodCallWork(Object classObject, String methodName, Class[] paramTypes, Object[] paramValues)
    {
        this.classObject = classObject;
        this.paramValues = paramValues;
        this.paramTypes = paramTypes;
        this.methodName = methodName;
    }

    @SuppressWarnings("unchecked")
    public MethodCallWork(Object classObject, String methodName, Class paramType, Object paramValue)
    {
        this.classObject = classObject;
        this.paramValues = new Object[]{paramValue};
        this.paramTypes = new Class[]{paramType};
        this.methodName = methodName;
    }

    public boolean isDaemon()
    {
        return false;
    }

    public void release()
    {
        // no-op
    }

    public void run()
    {
        try
        {
            Method methodToExecute = classObject.getClass().getDeclaredMethod(methodName, paramTypes);
            result = methodToExecute.invoke(classObject, paramValues);
        }
        catch (Throwable e)
        {
            throw new WorkException(e);
        }

    }

    public Object getResult()
    {
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer(100);

        buffer.append("MethodCallWork::[");
        buffer.append(" classObject:= ").append(classObject);
        buffer.append(" paramTypes:= ").append(paramTypes);
        buffer.append(" paramValues:= ").append(paramValues);
        buffer.append(" methodName:= ").append(methodName);
        buffer.append("]");

        return buffer.toString();
    }

    public Object[] getParamValues()
    {
        return paramValues;
    }
    
    public Object getParamValue()
    {
        if (paramValues != null)
        {
            return paramValues[0];
        }
        return null;
    }
    
    /**
     * The WorkManager's Work.run() method signature doesn't define any checked exceptions,
     * therefore we have to use a subclass of RuntimeException.
     * Thrown when WorkItem.getResult() is called if the WorkManager container encountered an
     * exception while running a job.
     */
    public final class WorkException extends RuntimeException
    {
        private static final long serialVersionUID = 1L;

        private WorkException(Throwable cause)
        {
            super(cause);
        }
    }

}
