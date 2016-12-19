package com.f9g4.businesscore.aggregation;

import java.io.Serializable;
import java.util.Collection;

import commonj.work.WorkItem;

/**
 * A class implementing the IAggregateMapper interface takes a collection of
 * WorkItem objects, iterates through them, and builds the application-specific
 * return object expected by the user of the AggregationService.
 */
public interface IAggregateMapper extends Serializable
{
    Object aggregate(Collection<WorkItem> workItems);
}