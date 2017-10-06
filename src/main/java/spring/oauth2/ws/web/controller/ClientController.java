package spring.oauth2.ws.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import spring.oauth2.ws.web.dto.Client;

@Controller
public class ClientController {
	
	private List<Client> list = new ArrayList<Client>();
	
	
	public ClientController() {
		list.add(new Client(1, "First Client", "Active"));
    }

    @PreAuthorize("#oauth2.hasScope('client') and #oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/clients/{id}")
    @ResponseBody
    public Client findById(@PathVariable final long id) {
        return list.stream().filter(p -> p.getId()==id).findAny().orElse(new Client(0, "Dummy client", "Inactive"));
    }
    
    @PreAuthorize("#oauth2.hasScope('client') and #oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/clients")
    @ResponseBody
    public List<Client> findAll() {
        return list;
    }

    @PreAuthorize("#oauth2.hasScope('client') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, value = "/clients")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Client create(@RequestBody final Client client) {
    	//client.setId(Long.parseLong(randomNumeric(2)));
    	list.add(client);
        return client;
    }

}
