package vo;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Controlador {

    private Date data;
    private Time time;
    private Integer numero_serie;
    private int senha_serie; 
    private int numero_lote;
    private int temp;
    private int umid;
    private int temp_ajst;
    private int umid_ajst;
    private int num_falha;
    private String alarme;
    private String ventoinha;
    private String timee;


    public Integer getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(int numero_serie) {
        this.numero_serie = numero_serie;
    }

    public Integer getSenha_serie() {
        return senha_serie;
    }

    public void setSenha_serie(int senha_serie) {
        this.senha_serie = senha_serie;
    }

    public Integer getNumero_lote() {
        return numero_lote;
    }

    public void setNumero_lote(int numero_lote) {
        this.numero_lote = numero_lote;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Integer getUmid() {
        return umid;
    }

    public void setUmid(int umid) {
        this.umid = umid;
    }

    public Integer getTemp_ajst() {
        return temp_ajst;
    }

    public void setTemp_ajst(int temp_ajst) {
        this.temp_ajst = temp_ajst;
    }

    public Integer getUmid_ajst() {
        return umid_ajst;
    }

    public void setUmid_ajst(int umid_ajst) {
        this.umid_ajst = umid_ajst;
    }

    public Integer getNum_falha() {
        return num_falha;
    }

    public void setNum_falha(int num_falha) {
        this.num_falha = num_falha;
    }

    public String getAlarme() {
        return alarme;
    }

    public void setAlarme(String alarme) {
        this.alarme = alarme;
    }

    public String getVentoinha() {
        return ventoinha;
    }

    public void setVentoinha(String ventoinha) {
        this.ventoinha = ventoinha;
    }


    public void setData(Date data) {
        this.data = data;
    }

    public String getData() {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
        //return data;
    }

    public Time getTime() {
        return time;
    }
    
    public String getTimee(){
        return this.timee;
       
    }

    public void setTime(Time time) {
        this.time = time;
        this.timee = time.toString();
        
    }   
}
