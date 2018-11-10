package ovh.spajste.langusta;

import ovh.spajste.langusta.facebook.FacebookContestHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.NoSuchElementException;

public class ContestHandlerFactory {
     public static ContestHandler getInstance(String handler) {
         if(handler.equals("facebook")) {
             return new FacebookContestHandler();
         } else if(handler.equals("youtube")) {
             throw new NotImplementedException();
         } else {
             throw new NoSuchElementException("Unknown contest type.");
         }
     }
}
