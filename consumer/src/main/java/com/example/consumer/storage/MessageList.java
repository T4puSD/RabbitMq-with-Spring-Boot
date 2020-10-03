package com.example.consumer.storage;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageList {
   public ArrayList<String> myList = new ArrayList<>();

   public String getMessage() {
      if(myList.size()>0){
         return myList.remove(0);
      }
      else return "No Message Pending";
   }

   public void appendMessage(String message) {
      this.myList.add(message);
   }
}
