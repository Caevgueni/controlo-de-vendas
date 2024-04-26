
package projeto.model;


public class Vendas {
    
    
    //atrebutos
    private int id;
    private Clientes cliente;
    private String data_venda;
    private double total_veda;
    private String obs;
    
    
    // gettrs e stters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public double getTotal_veda() {
        return total_veda;
    }

    public void setTotal_veda(double total_veda) {
        this.total_veda = total_veda;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
