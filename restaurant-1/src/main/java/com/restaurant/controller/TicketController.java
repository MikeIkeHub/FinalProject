package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.entity.Ticket;
import com.restaurant.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  @Autowired
  private TicketService ticketService;
  
  //CREATE - HTTP POST
  @RequestMapping(value = "/addTicket", method = RequestMethod.POST)
  public ResponseEntity<Object> addTicket(@RequestBody Ticket ticket){
    try {
      return new ResponseEntity<Object>(ticketService.addTicket(ticket), HttpStatus.CREATED);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  
  //READ - HTTP GET all tickets
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Object> getTickets(){
    return new ResponseEntity<Object>(ticketService.getTickets(), HttpStatus.OK);
  }
  
  //READ - HTTP GET single ticket
  @RequestMapping(value = "/{ticketPk}", method = RequestMethod.GET)
  public ResponseEntity<Object> getTicket(@RequestBody Ticket ticket, @PathVariable Long ticketPk){
    try {
      return new ResponseEntity<Object>(ticketService.findByTicketPk(ticketPk), HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
  //UPDATE - HTTP PUT
  @RequestMapping(value = "/updateTicket/{ticketPK}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateTable(@RequestBody Ticket ticket, @PathVariable Long ticketPk){
    try {
      return new ResponseEntity<Object>(ticketService.updateTicket(ticket, ticketPk), HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
  //DELETE - HTTP DELETE
  @RequestMapping(value = "/deleteTicket/{PK}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteTicket(@PathVariable Long PK){
    try {
      ticketService.deleteTicket(PK);
      return new ResponseEntity<Object>("Successfully removed ticket", HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }  
}
