package com.quotetrack.model;

import java.time.Duration;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FeedRuleAction {

    private FeedRuleActionType trackRuleActionType;
    private Duration inactivityDuration;
    private Date lastActivityTime;
    private static final Logger LOG = Logger.getLogger(FeedRuleAction.class.getName());

    public FeedRuleAction(FeedRuleActionType trackRuleActionType, Duration inactivityDuration, Date lastActivityTime) {
        this.trackRuleActionType = trackRuleActionType;
        this.inactivityDuration = inactivityDuration;
        this.lastActivityTime = lastActivityTime;
    }

    public FeedRuleActionType getTrackRuleActionType() {
        return trackRuleActionType;
    }

    public void setTrackRuleActionType(FeedRuleActionType trackRuleActionType) {
        this.trackRuleActionType = trackRuleActionType;
    }

    public Duration getInactivityDuration() {
        return inactivityDuration;
    }

    public void setInactivityDuration(Duration inactivityDuration) {
        this.inactivityDuration = inactivityDuration;
    }

    public Date getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Date lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    protected abstract void task(final Quote quote, final FeedRule rule);

    public void perform(final Quote quote, final FeedRule rule) {
        try {
            if (new Date().getTime() - lastActivityTime.getTime() > inactivityDuration.toMillis()) {
                task(quote, rule);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Exception caught", e);
            return;
        }
    }

}
