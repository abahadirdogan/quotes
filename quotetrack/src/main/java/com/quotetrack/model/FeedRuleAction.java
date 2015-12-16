package com.quotetrack.model;

import java.time.Duration;

public abstract class FeedRuleAction {
    
    private FeedRuleActionType trackRuleActionType;
    private Duration inactivityDuration;
    
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
    
    protected abstract void task();
    
    public void  perform() {
        task();
        
    }

}
