package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import buisness.model.Offers;

@ManagedBean
@RequestScoped
public class ResultsBean {
	private EntryBean entryBean;
	private ArrayList<Offers> offersList;
	
	public ResultsBean() {
	}

	public EntryBean getEntryBean() {
		return entryBean;
	}

	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}

	public ArrayList<Offers> getOffersList() {
		return offersList;
	}

	public void setOffersList(ArrayList<Offers> offersList) {
		this.offersList = offersList;
	}


	


	
	
	
	
	
	


}
