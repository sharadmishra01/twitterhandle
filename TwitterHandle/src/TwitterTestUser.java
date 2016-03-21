import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
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

	private static StatusListener listener = new StatusListener() {

		public void onException(Exception arg0) {
			// TODO Auto-generated method stub

		}

		public void onDeletionNotice(StatusDeletionNotice arg0) {
			// TODO Auto-generated method stub

		}

		public void onScrubGeo(long arg0, long arg1) {
			// TODO Auto-generated method stub

		}

		public void onStallWarning(StallWarning arg0) {
			// TODO Auto-generated method stub

		}

		public void onStatus(Status arg0) {
			System.out.println(arg0);
		}

		public void onTrackLimitationNotice(int arg0) {
			// TODO Auto-generated method stub

		}

	};

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
		User user = twitterStream.showUser("writetosharad");
		System.out.println(" user has come " + user.getName());

		// }

	}

}
