package com.quotetrack.model;

public abstract class FeedRuleAction {
    
    private FeedRuleActionType trackRuleActionType;

    public FeedRuleActionType getTrackRuleActionType() {
        return trackRuleActionType;
    }

    public void setTrackRuleActionType(FeedRuleActionType trackRuleActionType) {
        this.trackRuleActionType = trackRuleActionType;
    }
    
    abstract public void  perform();
    
}
