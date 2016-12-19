package com.f9g4.businesscore.aggregation;

import java.io.Serializable;
import java.util.Collection;

import commonj.work.Work;
import commonj.work.WorkEvent;
import commonj.work.WorkItem;
import commonj.work.WorkListener;
import commonj.work.WorkManager;

/**
 * Dummy implementation of {@link WorkManager} interface for use when working outside of a
 * Java Application Server (such as when unit testing).
 */
public class MockWorkManager implements WorkManager, Serializable
{
    private int workItemStatus = WorkEvent.WORK_COMPLETED;

    public WorkItem schedule(Work arg0)
    {
        WorkItem item = new MockWorkItem(arg0);
        arg0.run();
        return item;
    }

    public WorkItem schedule(Work arg0, WorkListener arg1)
    {
        WorkItem item = new MockWorkItem(arg0);
        arg0.run();
        return item;
    }

    @SuppressWarnings("unchecked")
    public boolean waitForAll(Collection arg0, long arg1) throws InterruptedException
    {
        return true;
    }

    @SuppressWarnings("unchecked")
    public Collection waitForAny(Collection arg0, long arg1) throws InterruptedException
    {
        return arg0;
    }

    /**
     * Dummy implementation of {@link WorkItem} interface used by {@link MockWorkManager}.
     *
     */
    public class MockWorkItem implements WorkItem
    {

        private final Work item;

        MockWorkItem(Work item)
        {
            this.item = item;
        }

        public Work getResult()
        {
            return item;
        }

        public int getStatus()
        {
            return workItemStatus;
        }

        public int compareTo(Object obj)
        {
            return 0;
        }

    }

    /**
     * @return Returns the workEventStatus.
     */
    public int getWorkEventStatus()
    {
        return workItemStatus;
    }

    /**
     * @param workEventStatus
     *            The workEventStatus to set.
     */
    public void setWorkEventStatus(int workEventStatus)
    {
        this.workItemStatus = workEventStatus;
    }
}
