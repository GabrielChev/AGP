package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import buisness.model.Offer;

@ManagedBean
@RequestScoped
public class ResultsBean {
	private EntryBean entryBean;
	private ArrayList<Offer> offersList;
	
	public ResultsBean() {
	}

	public EntryBean getEntryBean() {
		return entryBean;
	}

	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}

	public ArrayList<Offer> getOffersList() {
		return offersList;
	}

	public void setOffersList(ArrayList<Offer> offersList) {
		this.offersList = offersList;
	}


	


	
	
	
	
	
	


}
