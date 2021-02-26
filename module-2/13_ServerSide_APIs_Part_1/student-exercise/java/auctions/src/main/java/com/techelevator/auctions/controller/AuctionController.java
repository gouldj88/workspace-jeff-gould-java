package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }
    
	
//	  @RequestMapping(path = "/auctions", method = RequestMethod.GET) 
//	  public List<Auction> anAuction() {
//		  System.out.println("This is called with /auctions"); 
//		  return dao.list();
//	  }
	 
    
    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
    	System.out.println("This is called with /auctions/{id}");
    	return dao.get(id);
    }
    
    @RequestMapping(path = "/auctions", method = RequestMethod.POST)
    public Auction createAuction(@RequestBody Auction anAuction) { 
    	System.out.println("This is called with /auctions");
    	return dao.create(anAuction);
    }
    
    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> getTitle(@RequestParam (defaultValue = "") String title_like) {
    	return dao.searchByTitle(title_like);
    	
    }
    
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(value = "title_like", defaultValue = "") String title,
    		@RequestParam(value = "currentBid_lte", defaultValue = "0") double currentBid) {
    	if (!title.isEmpty() && currentBid > 0) {
    		return dao.searchByTitleAndPrice(title, currentBid);
    	}
    	else if(!title.isEmpty()) {
    		return dao.searchByTitle(title);
    	}
    	else if(currentBid > 0) {
    		return dao.searchByPrice(currentBid);
    	}
    	else {
    		return dao.list();
    	}
    }
    
}
