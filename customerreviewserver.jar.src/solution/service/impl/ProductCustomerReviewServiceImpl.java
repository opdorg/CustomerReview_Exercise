package solution.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants;
import de.hybris.platform.customerreview.impl.DefaultCustomerReviewService;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import solution.common.RatingValidator;
import solution.dao.ProductCustomerReviewDao;
import solution.dao.impl.JaloInvalidParameterException;
import solution.service.ProductCustomerReviewService;

public class ProductCustomerReviewServiceImpl extends DefaultCustomerReviewService implements ProductCustomerReviewService {
	
	@Value("#{'${customer.review.cursewords}'.split(',')}")
	private List<String> customerReviewUnacceptableWords;
	
	private ProductCustomerReviewDao productCustomerReviewDao;
	   
	protected ProductCustomerReviewDao getProductCustomerReviewDao() {
		return this.productCustomerReviewDao;
	}
	   
	@Required
	public void setProductCustomerReviewDao(ProductCustomerReviewDao productCustomerReviewDao) {
		this.productCustomerReviewDao = productCustomerReviewDao;
	}
	
	
	public List<CustomerReviewModel> getReviewsForProductByRatingRange(ProductModel paramProductModel, Double ratingFrom, Double ratingTo) throws JaloInvalidParameterException {
		
		RatingValidator.validateRatingRange ( ratingFrom,  ratingTo);
		return getProductCustomerReviewDao().getReviewsForProductByRatingRange(paramProductModel, ratingFrom, ratingTo);
	}

	public List<CustomerReviewModel> getReviewsForProductAndLanguageByRatingRange(ProductModel paramProductModel, LanguageModel paramLanguageModel, Double ratingFrom, Double ratingTo) throws JaloInvalidParameterException {
		
		RatingValidator.validateRatingRange ( ratingFrom,  ratingTo);		
		return getProductCustomerReviewDao().getReviewsForProductAndLanguageByRatingRange(paramProductModel, paramLanguageModel, ratingFrom, ratingTo);
	}
	
	public CustomerReviewModel createAcceptableCustomerReview(Double rating, String headline, String comment, UserModel user, ProductModel product) throws JaloInvalidParameterException {
	    
		Boolean hasUnacceptableWords = customerReviewUnacceptableWords.stream().anyMatch(comment::contains);
		
		if(hasUnacceptableWords) {
			Optional<String> unacceptableWord = customerReviewUnacceptableWords.stream().filter(comment::contains).findAny();
			throw new JaloInvalidParameterException("Your review was not submitted due to existence of unacceptable word '" + unacceptableWord.get() + "' in the field " + GeneratedCustomerReviewConstants.Attributes.User.CUSTOMERREVIEWS , 0);
		}
		RatingValidator.validateRating ( rating);	
		
		return super.createCustomerReview(rating, headline, comment, user, product);
	 }
	


}
