import java.io.*;
import java.util.*;

public class Needle {
	public static int count(String needle, InputStream haystack)
			throws Exception {

		if (needle == null) {
			return 0;
		}

		if (!(needle instanceof String)) {
			return 0;
		}

		if (haystack == null) {
			return 0;
		}

		String line = null;

		try {

			Map<String, Integer> map = new HashMap<String, Integer>();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(haystack));

			if (bufferedReader != null)
				while ((line = bufferedReader.readLine()) != null) {

					if (line != null && line.length() > 0) {
						String[] split = line.split(" ");

						if (split != null && split.length > 0) {
							for (String string : split) {

								if (string != null) {
									string = string
											.replaceAll("[^a-zA-Z]+", "");
									if (map.containsKey(string.toUpperCase())) {
										Integer integer = map.get(string
												.toUpperCase());
										map.put(string.toUpperCase(),
												integer + 1);
									} else {
										string = string.replaceAll(
												"[^a-zA-Z]+", "");
										map.put(string.toUpperCase(), 1);
									}
								}
							}
						}
					}
				}

			Integer integer = map.get(needle.toUpperCase());

			if (integer == null) {
				return 0;
			}
			return integer;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UnsupportedOperationException(
					"Waiting to be implemented.");
		}
	}

	public static void main(String[] args) throws Exception {
		String inMessage = "";

		try (InputStream inStream = new ByteArrayInputStream(
				inMessage.getBytes())) {
			System.out.println(Needle.count("there", inStream));
		}
	}
}