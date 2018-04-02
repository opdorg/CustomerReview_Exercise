package solution.service;

import java.util.List;

import de.hybris.platform.customerreview.CustomerReviewModel;
import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.LanguageModel;
import de.hybris.platform.customerreview.ProductModel;
import de.hybris.platform.customerreview.UserModel;
import solution.service.impl.JaloInvalidParameterException;

public interface ProductCustomerReviewService extends CustomerReviewService {
	
	public abstract List<CustomerReviewModel> getReviewsForProductByRatingRange(ProductModel paramProductModel, Double ratingFrom, Double ratingTo) throws JaloInvalidParameterException;
	  
	public abstract List<CustomerReviewModel> getReviewsForProductAndLanguageByRatingRange(ProductModel paramProductModel, LanguageModel paramLanguageModel, Double ratingFrom, Double ratingTo) throws JaloInvalidParameterException;
	
	public abstract CustomerReviewModel createAcceptableCustomerReview(Double paramDouble, String paramString1, String paramString2, UserModel paramUserModel, ProductModel paramProductModel)throws JaloInvalidParameterException;
	  
}
