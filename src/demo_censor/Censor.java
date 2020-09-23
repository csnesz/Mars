package demo_censor;

public class Censor {

	public static void main(String[] args) {

		
		String ergebnis = censor("Bius szeret fözöcskezni.", "Bius", "Viki");
		System.out.println("Proba "+ergebnis);
	
	
	}

	private static String censor(String text, String wechseln, String neu) {
		text=text.replaceAll(wechseln, neu);
		return text;
	}
	}