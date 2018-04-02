package solution.dao.impl;


import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.customerreview.dao.CustomerReviewDao;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import java.util.Collections;
import java.util.List;
import solution.dao.ProductCustomerReviewDao;



public class ProductCustomerReviewDaoImpl extends DefaultCustomerReviewDao implements ProductCustomerReviewDao {

	
	public List<CustomerReviewModel> getReviewsForProductByRatingRange(ProductModel paramProductModel, Double ratingFrom, Double ratingTo) {
				
		String query = "SELECT {" + Item.PK + "} FROM {" + "CustomerReview" + "} WHERE {" + "product" + "}=?product and rating between ?ratingFrom and ?ratingTo ORDER BY {" + "creationtime" + "} DESC";
	     FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(query);
	     fsQuery.addQueryParameter("product", product);
	     fsQuery.addQueryParameter("ratingFrom", ratingFrom);
	     fsQuery.addQueryParameter("ratingTo", ratingTo);
	     fsQuery.setResultClassList(Collections.singletonList(CustomerReviewModel.class));
	  
	     SearchResult<CustomerReviewModel> searchResult = getFlexibleSearchService().search(fsQuery);
	     return searchResult.getResult();

	}

	public List<CustomerReviewModel> getReviewsForProductAndLanguageByRatingRange(ProductModel paramProductModel,
			LanguageModel paramLanguageModel, Double ratingFrom, Double ratingTo) {
				
		String query = "SELECT {" + Item.PK + "} FROM {" + "CustomerReview" + "} WHERE {" + "product" + "}=?product and rating between ?ratingFrom and ?ratingTo AND {" + "language" + "}=?language ORDER BY {" + "creationtime" + "} DESC";
	     FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(query);
	    fsQuery.addQueryParameter("product", product);
	    fsQuery.addQueryParameter("ratingFrom", ratingFrom);
	     fsQuery.addQueryParameter("ratingTo", ratingTo);
	     fsQuery.addQueryParameter("language", language);
	    fsQuery.setResultClassList(Collections.singletonList(CustomerReviewModel.class));
	  
	    SearchResult<CustomerReviewModel> searchResult = getFlexibleSearchService().search(fsQuery);
	     return searchResult.getResult();
	}

}
