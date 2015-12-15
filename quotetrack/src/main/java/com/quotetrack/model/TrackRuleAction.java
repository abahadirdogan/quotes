package com.quotetrack.model;

public abstract class TrackRuleAction {
    
    private TrackRuleActionType trackRuleActionType;

    public TrackRuleActionType getTrackRuleActionType() {
        return trackRuleActionType;
    }

    public void setTrackRuleActionType(TrackRuleActionType trackRuleActionType) {
        this.trackRuleActionType = trackRuleActionType;
    }
    
    abstract public void  perform();
    
}
