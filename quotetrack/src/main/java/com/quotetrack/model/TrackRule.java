package com.quotetrack.model;

public class TrackRule {
    private String ID;
    private User user;
    private String symbol;
    private TrackRuleCriteria trackRuleCriteria;
    private TrackRuleAction trackRuleAction;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public TrackRuleCriteria getTrackRuleCriteria() {
        return trackRuleCriteria;
    }

    public void setTrackRuleCriteria(TrackRuleCriteria trackRuleCriteria) {
        this.trackRuleCriteria = trackRuleCriteria;
    }

    public TrackRuleAction getTrackRuleAction() {
        return trackRuleAction;
    }

    public void setTrackRuleAction(TrackRuleAction trackRuleAction) {
        this.trackRuleAction = trackRuleAction;
    }
    
}
