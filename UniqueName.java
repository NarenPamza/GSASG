import java.util.LinkedHashMap;

public class UniqueName {
	public static String firstUniqueName(String[] names) {

		if (names == null) {
			return null;
		}

		String first = null;
		LinkedHashMap<String, String> set = new LinkedHashMap<String, String>();
		try {

			if (names != null && names.length > 0) {

				for (String string : names) {

					if (string != null) {

						if (set.containsKey(string)) {
							set.remove(string);
						} else {
							set.put(string, string);

						}
					}

				}
			}
		} catch (Exception e) {

			throw new UnsupportedOperationException("Exception Occured.");
		}

		if (set.size() > 0) {
			for (String string : set.keySet()) {
				return string;
			}
		}

		return first;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqueName(new String[] { null, "Adeline",
				"Abbi", "Adalia" }));
	}
}