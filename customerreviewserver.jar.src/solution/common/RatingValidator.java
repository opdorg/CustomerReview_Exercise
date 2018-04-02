package solution.common;

import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
import solution.dao.impl.JaloInvalidParameterException;

public class RatingValidator {
	
	public static void validateRatingRange(Double ratingFrom, Double ratingTo) {
		/* 
		 * Assuming that both upper and lower limits of range are mandatory.
		 * Check if ratings range limits are valid else throw exception.
		 */
		
		if (ratingFrom == null || ratingTo == null ||
			(ratingFrom.doubleValue() < CustomerReviewConstants.getInstance().MINRATING) || 
			(ratingTo.doubleValue() > CustomerReviewConstants.getInstance().MAXRATING) || 
			(ratingFrom > ratingTo)) {
			
			  throw new JaloInvalidParameterException(Localization.getLocalizedString("error.customerreview.invalidrating", 						  
				new Object[] { rating, new Double(CustomerReviewConstants.getInstance().MINRATING), 
				new Double(CustomerReviewConstants.getInstance().MAXRATING) }), 0);
		}
	}
	
	public static void validateRating(Double rating) {
		if (rating == null ||
				(rating.doubleValue() < CustomerReviewConstants.getInstance().MINRATING) || 
				(rating.doubleValue() > CustomerReviewConstants.getInstance().MAXRATING) ) {
					
					  throw new JaloInvalidParameterException(Localization.getLocalizedString("error.customerreview.invalidrating", 						  
						new Object[] { rating, new Double(CustomerReviewConstants.getInstance().MINRATING), 
						new Double(CustomerReviewConstants.getInstance().MAXRATING) }), 0);
				}
	}
}
