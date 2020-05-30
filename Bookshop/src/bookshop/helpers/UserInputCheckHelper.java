package bookshop.helpers;

public class UserInputCheckHelper {
	public static boolean attributesOrAttributeEmpty(String... attributes) {
		boolean emptyFound = false;
		for (String attribute : attributes) {
			if(attribute.isBlank()) {
				emptyFound = true;
				break;
			}
		}
		return emptyFound;
	}
}
