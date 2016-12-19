package com.f9g4.businesscore.aggregation;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import commonj.work.Work;
import commonj.work.WorkItem;
import commonj.work.WorkManager;

/**
 * An implementation of the IAggregationService interface. The class requires a
 * WorkManager object and a timeout value - which can be set using setter
 * methods. The executeWork() method takes a Collection of Work objects and uses
 * the CommonJ API to schedule the work with the WorkManager. After scheduling,
 * it calls waitFor(). This method also uses CommonJ to execute the work and wait
 * for the results based on the timeout value. If no timeout is specified, then the
 * AggregationService will wait indefinitely for the work items to complete. When
 * waitFor() returns, executeWork() uses the AggregateMapper passed which combines the
 * work items appropriately and create the expected return object.
 *
 */
@SuppressWarnings("serial")
public class AggregationServiceImpl implements AggregationService
{	
    private WorkManager workManager;

    private long timeout;

    public AggregationServiceImpl()
    {
        super();
    }
    
    public AggregationServiceImpl(WorkManager workManager)
    {
        this.workManager = workManager;
    }
    
    public void executeWork(Collection<Work> workCollection)
    {
    	process(workCollection); 
    }

    public Object executeWork(Collection<Work> workCollection, IAggregateMapper mapper)
    {
        if (mapper == null)
        {
            throw new IllegalArgumentException("mapper cannot be null");
        }
        Collection<WorkItem> workItems = process(workCollection);

        return mapper.aggregate(workItems);
    }
    
    @SuppressWarnings("unchecked")
    private Collection<WorkItem> process(Collection<Work> workCollection)
    {
        if (workCollection == null)
        {
            throw new IllegalArgumentException("workCollection cannot be null");
        }

        Transformer workItemTransformer = new Transformer()
        {

            public Object transform(Object source)
            {
                WorkItem workItem;
                // assumes workManager is not null!
                workItem = workManager.schedule((Work) source);
              
                return workItem;
            }

        };

        Collection<WorkItem> workItems = CollectionUtils.collect(workCollection, workItemTransformer);
        waitFor(workItems);
        return workItems;
    }

    public void setTimeout(long timeout)
    {
        this.timeout = timeout;
    }

    public void setWorkManager(WorkManager workManager)
    {
        this.workManager = workManager;
    }

    private boolean waitFor(Collection<WorkItem> workItems)
    {
        boolean success = true;
        if (workItems != null && !workItems.isEmpty())
        {
            try
            {
                // assumes workManager is not null!
                success = workManager.waitForAll(workItems, (timeout > 0 ? timeout : WorkManager.INDEFINITE));
            }
            catch (InterruptedException e)
            {
                // handle it
                Thread.currentThread().interrupt();
            }
        }
        return success;
    }

}