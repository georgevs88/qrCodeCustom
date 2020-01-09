package pmcg.fcn.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Cus", sequence = "seqcus")
public class CusVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Integer iddcus; //iddcus
	private String nomcus; //nomcus
	private String codcus; //codcus
	private String meicus; //meicus
	private String menor_igual_360m; //  menor_igual_360m
	private String d360a1000; //  d360a1000
	private String menor_igual_500m; //  menor_igual_500m
	private String d500a1000; //  d500a1000
	private String menor_igual_720m; //  menor_igual_720m
	private String maior_720m; //  maior_720m
	private String d720a2500; //  d720a2500
	private String menor_igual_1000m; //  menor_igual_1000m
	private String maior_1000m; //  maior_1000m
	private String d1000a5000; //  d1000a5000
	private String menor_igual_2500m; //  menor_igual_2500m
	private String d2500a5000; //  d2500a5000
	private String menor_igual_5000m; //  menor_igual_5000m
	private String maior_5000m; //  maior_5000m
	private String d5000a10000; //  d5000a10000
	private String maior_10000m; //  maior_10000m
	private String qq_porte; //  qq_porte
	private String catcus; //catcus
	private String clacus; //clacus
	private String cnacus; //cnacus
	private String usualt; //usualt
	private Date datalt; //datalt
	
	public Integer getIddcus() {
		return iddcus;
	}
	public void setIddcus(Integer iddcus) {
		this.iddcus = iddcus;
	}
	public String getNomcus() {
		return nomcus;
	}
	public void setNomcus(String nomcus) {
		this.nomcus = nomcus;
	}
	public String getCodcus() {
		return codcus;
	}
	public void setCodcus(String codcus) {
		this.codcus = codcus;
	}
	public String getMeicus() {
		return meicus;
	}
	public void setMeicus(String meicus) {
		this.meicus = meicus;
	}
	public String getMenor_igual_360m() {
		return menor_igual_360m;
	}
	public void setMenor_igual_360m(String menor_igual_360m) {
		this.menor_igual_360m = menor_igual_360m;
	}
	public String getD360a1000() {
		return d360a1000;
	}
	public void setD360a1000(String d360a1000) {
		this.d360a1000 = d360a1000;
	}
	public String getMenor_igual_500m() {
		return menor_igual_500m;
	}
	public void setMenor_igual_500m(String menor_igual_500m) {
		this.menor_igual_500m = menor_igual_500m;
	}
	public String getD500a1000() {
		return d500a1000;
	}
	public void setD500a1000(String d500a1000) {
		this.d500a1000 = d500a1000;
	}
	public String getMenor_igual_720m() {
		return menor_igual_720m;
	}
	public void setMenor_igual_720m(String menor_igual_720m) {
		this.menor_igual_720m = menor_igual_720m;
	}
	public String getMaior_720m() {
		return maior_720m;
	}
	public void setMaior_720m(String maior_720m) {
		this.maior_720m = maior_720m;
	}
	public String getD720a2500() {
		return d720a2500;
	}
	public void setD720a2500(String d720a2500) {
		this.d720a2500 = d720a2500;
	}
	public String getMenor_igual_1000m() {
		return menor_igual_1000m;
	}
	public void setMenor_igual_1000m(String menor_igual_1000m) {
		this.menor_igual_1000m = menor_igual_1000m;
	}
	public String getMaior_1000m() {
		return maior_1000m;
	}
	public void setMaior_1000m(String maior_1000m) {
		this.maior_1000m = maior_1000m;
	}
	public String getD1000a5000() {
		return d1000a5000;
	}
	public void setD1000a5000(String d1000a5000) {
		this.d1000a5000 = d1000a5000;
	}
	public String getMenor_igual_2500m() {
		return menor_igual_2500m;
	}
	public void setMenor_igual_2500m(String menor_igual_2500m) {
		this.menor_igual_2500m = menor_igual_2500m;
	}
	public String getD2500a5000() {
		return d2500a5000;
	}
	public void setD2500a5000(String d2500a5000) {
		this.d2500a5000 = d2500a5000;
	}
	public String getMenor_igual_5000m() {
		return menor_igual_5000m;
	}
	public void setMenor_igual_5000m(String menor_igual_5000m) {
		this.menor_igual_5000m = menor_igual_5000m;
	}
	public String getMaior_5000m() {
		return maior_5000m;
	}
	public void setMaior_5000m(String maior_5000m) {
		this.maior_5000m = maior_5000m;
	}
	public String getD5000a10000() {
		return d5000a10000;
	}
	public void setD5000a10000(String d5000a10000) {
		this.d5000a10000 = d5000a10000;
	}
	public String getMaior_10000m() {
		return maior_10000m;
	}
	public void setMaior_10000m(String maior_10000m) {
		this.maior_10000m = maior_10000m;
	}
	public String getQq_porte() {
		return qq_porte;
	}
	public void setQq_porte(String qq_porte) {
		this.qq_porte = qq_porte;
	}
	public String getCatcus() {
		return catcus;
	}
	public void setCatcus(String catcus) {
		this.catcus = catcus;
	}
	public String getClacus() {
		return clacus;
	}
	public void setClacus(String clacus) {
		this.clacus = clacus;
	}
	public String getCnacus() {
		return cnacus;
	}
	public void setCnacus(String cnacus) {
		this.cnacus = cnacus;
	}
	public String getUsualt() {
		return usualt;
	}
	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}
	public Date getDatalt() {
		return datalt;
	}
	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}
	public String getUsudatalt(){
		if(usualt != null && datalt != null){
			return usualt + " - " + new SimpleDateFormat("dd/MM/yyyy").format(datalt);
		} else {
			return "";
		}
	}
	
}
