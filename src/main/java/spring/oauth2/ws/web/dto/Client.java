package spring.oauth2.ws.web.dto;

public class Client {

	private long id;
	
    private String name;
    
    private String status;

	public Client() {
	}

	public Client(long id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
    
	
}
