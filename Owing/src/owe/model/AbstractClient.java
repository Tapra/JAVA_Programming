package owe.model;

import java.util.*;

/**
 * @author Darth Venom
 * This is the super class for a client that will setup the default
 * parameters to hold a name, clientID, a set of linked lists for loans borrowed
 * and repayments made.
 */
public abstract class AbstractClient implements Client {
   
   public boolean add_loan(String clientID){
      return false;      
   }
}
