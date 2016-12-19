package com.f9g4.businesscore.aggregation;

public class AggregationException extends Exception
{
    private static final long serialVersionUID = 4962673661949361739L;

    public AggregationException(String message)
    {
        super(message);
    }

    public AggregationException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
