package com.quotetrack.model;

public class FeedRule {
    private String ID;
    private User user;
    private Symbol symbol;
    private FeedRuleCriteria feedRuleCriteria;
    private FeedRuleAction feedRuleAction;

    public FeedRule(String ID, User user, Symbol symbol, FeedRuleCriteria feedRuleCriteria, FeedRuleAction feedRuleAction) {
        this.ID = ID;
        this.user = user;
        this.symbol = symbol;
        this.feedRuleCriteria = feedRuleCriteria;
        this.feedRuleAction = feedRuleAction;
    }
    
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

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public FeedRuleCriteria getFeedRuleCriteria() {
        return feedRuleCriteria;
    }

    public void setFeedRuleCriteria(FeedRuleCriteria trackRuleCriteria) {
        this.feedRuleCriteria = trackRuleCriteria;
    }

    public FeedRuleAction getFeedRuleAction() {
        return feedRuleAction;
    }

    public void setFeedRuleAction(FeedRuleAction trackRuleAction) {
        this.feedRuleAction = trackRuleAction;
    }
    
    public boolean match(final Quote quote) {
        if (!quote.getSymbol().equals(symbol.getName()))
            return false;
        if (!feedRuleCriteria.testCriteria(quote))
            return false;
        return true;
        
    }

    @Override
    public String toString() {
        return "FeedRule{" + "ID=" + ID + ", user=" + user + ", symbol=" + symbol + ", feedRuleCriteria=" + feedRuleCriteria + ", feedRuleAction=" + feedRuleAction + '}';
    }
    
}
