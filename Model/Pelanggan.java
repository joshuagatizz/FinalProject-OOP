
package Model;


public class Pelanggan {
    private String nama;
    private int id;
    
    public Pelanggan(String nama,int id){
        setNama(nama);
        setId(id);
    }
    public Pelanggan(Pelanggan e){
        setNama(e.getNama());
        setId(e.getId());
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNama(){
        return nama;
    }
    public int getId(){
        return id;
    }
    
}
