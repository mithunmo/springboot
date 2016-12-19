package com.f9g4.businesscore.aggregation;

import java.io.Serializable;
import java.util.Collection;

import commonj.work.Work;
import commonj.work.WorkManager;

/**
 * An interface defining an Aggregation Service. An Aggregatoin Service is a
 * utility service that takes advantage of the CommonJ APIs to provide
 * parallel task execution inside a JEE container. This service hides the
 * implementation details of CommonJ, provides code reuse, and implements a
 * common way to aggregate data from multiple sources. It is used in the ER
 * framework to aggregate data from multiple Adapter method and web service calls.
 */
public interface AggregationService extends Serializable
{
    void executeWork(Collection<Work> workCollection);
    
    Object executeWork(Collection<Work> workCollection, IAggregateMapper mapper);
    
    void setWorkManager(WorkManager workManager);
    
    void setTimeout(long timeout);
}
