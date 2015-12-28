/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.quotetrack.model.FeedRule;
import com.quotetrack.model.FeedRuleAction;
import com.quotetrack.model.FeedRuleActionType;
import com.quotetrack.model.FeedRuleCollection;
import com.quotetrack.model.FeedRuleCriteria;
import com.quotetrack.model.FeedRuleInBandCriteria;
import com.quotetrack.model.FeedRuleLogAction;
import com.quotetrack.model.Quote;
import com.quotetrack.model.Side;
import com.quotetrack.model.Symbol;
import com.quotetrack.model.User;
import com.quotetrack.server.BasicFeedActionListener;
import com.quotetrack.server.FeedActionListener;
import com.quotetrack.server.FeedManager;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bd
 */
public class ActionTest {
    
    public ActionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ruleMatch() {
        CountDownLatch latch = new CountDownLatch(1);
        Symbol eurusd = new Symbol("EURUSD", 5, "EUR", "USD");
        FeedRuleCriteria rc = new FeedRuleInBandCriteria(1.2, 1.3, Side.BUY);
        FeedRuleTestAction rrr = new FeedRuleTestAction(latch, FeedRuleActionType.NONE, Duration.ofSeconds(60), Date.from(Instant.now().minusSeconds(120)));
        User u = new User("ali", "veli", "TR");
        FeedRule r = new FeedRule("R1", u, eurusd, rc, rrr);
        FeedRuleCollection frc = new FeedRuleCollection();
        frc.addRule(r);
        FeedManager fm = new FeedManager(frc);
        fm.addFeedActionListener(new BasicFeedActionListener());
        Quote q = new Quote("EURUSD", 1.1, 1.25, System.currentTimeMillis());
        fm.putFeed(q);
        fm.checkRules(q);
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(ActionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(rrr.counter.getCount(), 0);
        
        fm.putFeed(q);
        fm.checkRules(q);
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(ActionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(rrr.counter.getCount(), 0);
    }
    
    @Test
    public void ruleMatch2() {
        CountDownLatch latch = new CountDownLatch(1);
        Symbol eurusd = new Symbol("EURUSD", 5, "EUR", "USD");
        FeedRuleCriteria rc = new FeedRuleInBandCriteria(1.2, 1.3, Side.SELL);
        FeedRuleTestAction rrr = new FeedRuleTestAction(latch, FeedRuleActionType.NONE, Duration.ofSeconds(60), Date.from(Instant.now().minusSeconds(120)));
        User u = new User("ali", "veli", "TR");
        FeedRule r = new FeedRule("R1", u, eurusd, rc, rrr);
        FeedRuleCollection frc = new FeedRuleCollection();
        frc.addRule(r);
        FeedManager fm = new FeedManager(frc);
        fm.addFeedActionListener(new BasicFeedActionListener());
        Quote q = new Quote("EURUSD", 1.1, 1.25, System.currentTimeMillis());
        fm.putFeed(q);
        fm.checkRules(q);
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(ActionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(rrr.counter.getCount(), 1);
    }
}
