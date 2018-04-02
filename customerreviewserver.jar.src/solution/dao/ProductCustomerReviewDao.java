package solution.dao;

import java.util.List;

import de.hybris.platform.customerreview.dao.CustomerReviewDao;
import de.hybris.platform.customerreview.dao.CustomerReviewModel;
import de.hybris.platform.customerreview.dao.LanguageModel;
import de.hybris.platform.customerreview.dao.ProductModel;

public interface ProductCustomerReviewDao extends CustomerReviewDao {
	
	public abstract List<CustomerReviewModel> getReviewsForProductByRatingRange(ProductModel paramProductModel, Double ratingFrom, Double ratingTo);
	  
	public abstract List<CustomerReviewModel> getReviewsForProductAndLanguageByRatingRange(ProductModel paramProductModel, LanguageModel paramLanguageModel, Double ratingFrom, Double ratingTo);

}
