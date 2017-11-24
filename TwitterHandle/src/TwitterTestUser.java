import excelsaver.UserDataFileSaver;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTestUser {

	/**
	 * @param args
	 */

	private static String consumerKey = "Qy5b24hTUlM9PchKyp1rbnDOz";
	private static String consumerSecret = "GL78gicHGxZiBde4X02AMQOtj5uWQXCjQNLIR6h9A8zc7rhWA0";
	private static String accessToken = "3377235640-RPd7LvAHyV1RxtfKAkQjc7o8jXXFH0ocUa1Gym6";
	private static String accessTokenSecret = "5IHfMLjU5OOHRWUiZsu3gKPJDwD5rBePH85AXZDFN78TF";

	public static void main(String args[]) throws TwitterException {

		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(consumerKey);
		builder.setOAuthConsumerSecret(consumerSecret);
		builder.setJSONStoreEnabled(true);

		Twitter twitterStream = new TwitterFactory(builder.build())
				.getInstance();

		AccessToken token = new AccessToken(accessToken, accessTokenSecret);
		//
		//

		// Twitter twitter = new TwitterFactory().getInstance();
		// twitter.setOAuthConsumer(consumerKey, consumerSecret);

		twitterStream.setOAuthAccessToken(token);
//		twitterStream.s
		User user = twitterStream.showUser("writetosharad");
		System.out.println(" user has name " + user.getName());
		System.out.println(" user has followers " + user.getFollowersCount());

		System.out.println(" user has Location " + user.getLocation());

		System.out.println(" user has URL " + user.getURL());

		System.out.println(" user has status " + user.getStatus());
		model.User modelUser = new model.User();
		modelUser.setUserName(user.getName());
		modelUser.setDescription(user.getDescription());
		modelUser.setStatus(user.getStatus().toString());
		modelUser.setLocation(user.getLocation());
		modelUser.setFollowers(user.getFollowersCount());
		UserDataFileSaver.getFileSaverInstance().insertResultDataToExcel(
				modelUser);

		// }

	}

}
