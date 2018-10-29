package com.model.shopping;

public class Feedback {
private int feedbackid;
private String Customername;
private String Review;

public Feedback() {
	super();
}
public int getFeedbackid() {
	return feedbackid;
}
public void setFeedbackid(int feedbackid) {
	this.feedbackid = feedbackid;
}
public String getCustomername() {
	return Customername;
}
public void setCustomername(String customername) {
	Customername = customername;
}
public String getReview() {
	return Review;
}
public void setReview(String review) {
	Review = review;
}

}
