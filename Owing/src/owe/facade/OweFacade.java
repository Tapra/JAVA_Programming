package owe.facade;

import owe.model.*;
import java.util.*;

/**
 * 
 * @author Darrell THOONEN
 * @version V3.0
 * 
 * @description This an application layer to create the SYSTEM.
 * It should be responsible for:
 * 1) creating CLIENT array
 * 2) 
 */

public class OweFacade implements OweModel {

   public OweFacade() {
   }
   
   public boolean add_loan(String clientID) {
      client.add_loan(clientID);
   }
}
