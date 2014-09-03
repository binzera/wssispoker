package br.gms.sispoker.wssispoker.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.frameworkdemoiselle.util.Reflections;

/**
 * Classe utilitária para trabalho com codificação e decodificação de String.
 */
public abstract class EncodeUtil {

	public static Map<Character, Integer> mapaHtmlCode;

	static {

		EncodeUtil.mapaHtmlCode = new HashMap<Character, Integer>();

		// Referência:
		// http://webdesign.about.com/library/bl_htmlcodes.htm
		EncodeUtil.mapaHtmlCode.put('À', 192);
		EncodeUtil.mapaHtmlCode.put('à', 224);
		EncodeUtil.mapaHtmlCode.put('Á', 193);
		EncodeUtil.mapaHtmlCode.put('á', 225);
		EncodeUtil.mapaHtmlCode.put('Â', 194);
		EncodeUtil.mapaHtmlCode.put('â', 226);
		EncodeUtil.mapaHtmlCode.put('Ã', 195);
		EncodeUtil.mapaHtmlCode.put('ã', 227);
		EncodeUtil.mapaHtmlCode.put('Ä', 196);
		EncodeUtil.mapaHtmlCode.put('ä', 228);
		EncodeUtil.mapaHtmlCode.put('Å', 197);
		EncodeUtil.mapaHtmlCode.put('å', 229);
		EncodeUtil.mapaHtmlCode.put('Ā', 256);
		EncodeUtil.mapaHtmlCode.put('ā', 257);
		EncodeUtil.mapaHtmlCode.put('Ă', 258);
		EncodeUtil.mapaHtmlCode.put('ă', 259);
		EncodeUtil.mapaHtmlCode.put('Ą', 260);
		EncodeUtil.mapaHtmlCode.put('ą', 261);
		EncodeUtil.mapaHtmlCode.put('Ǟ', 478);
		EncodeUtil.mapaHtmlCode.put('ǟ', 479);
		EncodeUtil.mapaHtmlCode.put('Ǻ', 506);
		EncodeUtil.mapaHtmlCode.put('ǻ', 507);
		EncodeUtil.mapaHtmlCode.put('Æ', 198);
		EncodeUtil.mapaHtmlCode.put('æ', 230);
		EncodeUtil.mapaHtmlCode.put('Ǽ', 508);
		EncodeUtil.mapaHtmlCode.put('ǽ', 509);

		EncodeUtil.mapaHtmlCode.put('Ḃ', 7682);

		EncodeUtil.mapaHtmlCode.put('Ć', 262);
		EncodeUtil.mapaHtmlCode.put('ć', 263);
		EncodeUtil.mapaHtmlCode.put('Ç', 199);
		EncodeUtil.mapaHtmlCode.put('ç', 231);
		EncodeUtil.mapaHtmlCode.put('Č', 268);
		EncodeUtil.mapaHtmlCode.put('č', 269);
		EncodeUtil.mapaHtmlCode.put('Ĉ', 264);
		EncodeUtil.mapaHtmlCode.put('ĉ', 265);
		EncodeUtil.mapaHtmlCode.put('Ċ', 266);
		EncodeUtil.mapaHtmlCode.put('ċ', 267);

		EncodeUtil.mapaHtmlCode.put('Ḑ', 7696);
		EncodeUtil.mapaHtmlCode.put('ḑ', 7697);
		EncodeUtil.mapaHtmlCode.put('Ď', 270);
		EncodeUtil.mapaHtmlCode.put('ď', 271);
		EncodeUtil.mapaHtmlCode.put('Ḋ', 7690);
		EncodeUtil.mapaHtmlCode.put('ḋ', 7691);
		EncodeUtil.mapaHtmlCode.put('Đ', 272);
		EncodeUtil.mapaHtmlCode.put('đ', 273);
		EncodeUtil.mapaHtmlCode.put('Ð', 208);
		EncodeUtil.mapaHtmlCode.put('ð', 240);

		EncodeUtil.mapaHtmlCode.put('Ǳ', 497);
		EncodeUtil.mapaHtmlCode.put('ǲ', 498);
		EncodeUtil.mapaHtmlCode.put('ǳ', 499);
		EncodeUtil.mapaHtmlCode.put('Ǆ', 452);
		EncodeUtil.mapaHtmlCode.put('ǅ', 453);
		EncodeUtil.mapaHtmlCode.put('ǆ', 454);

		EncodeUtil.mapaHtmlCode.put('È', 200);
		EncodeUtil.mapaHtmlCode.put('è', 232);
		EncodeUtil.mapaHtmlCode.put('É', 201);
		EncodeUtil.mapaHtmlCode.put('é', 233);
		EncodeUtil.mapaHtmlCode.put('Ě', 282);
		EncodeUtil.mapaHtmlCode.put('ě', 283);
		EncodeUtil.mapaHtmlCode.put('Ê', 202);
		EncodeUtil.mapaHtmlCode.put('ê', 234);
		EncodeUtil.mapaHtmlCode.put('Ë', 203);
		EncodeUtil.mapaHtmlCode.put('ë', 235);
		EncodeUtil.mapaHtmlCode.put('Ē', 274);
		EncodeUtil.mapaHtmlCode.put('ē', 275);
		EncodeUtil.mapaHtmlCode.put('Ĕ', 276);
		EncodeUtil.mapaHtmlCode.put('ĕ', 277);
		EncodeUtil.mapaHtmlCode.put('Ę', 280);
		EncodeUtil.mapaHtmlCode.put('ę', 281);
		EncodeUtil.mapaHtmlCode.put('Ė', 278);
		EncodeUtil.mapaHtmlCode.put('ė', 279);
		EncodeUtil.mapaHtmlCode.put('Ʒ', 439);
		EncodeUtil.mapaHtmlCode.put('ʒ', 658);
		EncodeUtil.mapaHtmlCode.put('Ǯ', 494);
		EncodeUtil.mapaHtmlCode.put('ǯ', 495);

		EncodeUtil.mapaHtmlCode.put('Ḟ', 7710);
		EncodeUtil.mapaHtmlCode.put('ḟ', 7711);
		EncodeUtil.mapaHtmlCode.put('ƒ', 402);
		EncodeUtil.mapaHtmlCode.put('ﬀ', 64256);
		EncodeUtil.mapaHtmlCode.put('ﬁ', 64257);
		EncodeUtil.mapaHtmlCode.put('ﬂ', 64258);
		EncodeUtil.mapaHtmlCode.put('ﬃ', 64259);
		EncodeUtil.mapaHtmlCode.put('ﬄ', 64260);
		EncodeUtil.mapaHtmlCode.put('ﬅ', 64261);

		EncodeUtil.mapaHtmlCode.put('Ǵ', 500);
		EncodeUtil.mapaHtmlCode.put('ǵ', 501);
		EncodeUtil.mapaHtmlCode.put('Ģ', 290);
		EncodeUtil.mapaHtmlCode.put('ģ', 291);
		EncodeUtil.mapaHtmlCode.put('Ǧ', 486);
		EncodeUtil.mapaHtmlCode.put('ǧ', 487);
		EncodeUtil.mapaHtmlCode.put('Ĝ', 284);
		EncodeUtil.mapaHtmlCode.put('ĝ', 285);
		EncodeUtil.mapaHtmlCode.put('Ğ', 286);
		EncodeUtil.mapaHtmlCode.put('ğ', 287);
		EncodeUtil.mapaHtmlCode.put('Ġ', 288);
		EncodeUtil.mapaHtmlCode.put('ġ', 289);
		EncodeUtil.mapaHtmlCode.put('Ǥ', 484);
		EncodeUtil.mapaHtmlCode.put('ǥ', 485);

		EncodeUtil.mapaHtmlCode.put('Ĥ', 292);
		EncodeUtil.mapaHtmlCode.put('ĥ', 293);
		EncodeUtil.mapaHtmlCode.put('Ħ', 294);
		EncodeUtil.mapaHtmlCode.put('ħ', 295);

		EncodeUtil.mapaHtmlCode.put('Ì', 204);
		EncodeUtil.mapaHtmlCode.put('ì', 236);
		EncodeUtil.mapaHtmlCode.put('Í', 205);
		EncodeUtil.mapaHtmlCode.put('í', 237);
		EncodeUtil.mapaHtmlCode.put('Î', 206);
		EncodeUtil.mapaHtmlCode.put('î', 238);
		EncodeUtil.mapaHtmlCode.put('Ĩ', 296);
		EncodeUtil.mapaHtmlCode.put('ĩ', 297);
		EncodeUtil.mapaHtmlCode.put('Ï', 207);
		EncodeUtil.mapaHtmlCode.put('ï', 239);
		EncodeUtil.mapaHtmlCode.put('Ī', 298);
		EncodeUtil.mapaHtmlCode.put('ī', 299);
		EncodeUtil.mapaHtmlCode.put('Ĭ', 300);
		EncodeUtil.mapaHtmlCode.put('ĭ', 301);
		EncodeUtil.mapaHtmlCode.put('Į', 302);
		EncodeUtil.mapaHtmlCode.put('į', 303);
		EncodeUtil.mapaHtmlCode.put('İ', 304);
		EncodeUtil.mapaHtmlCode.put('ı', 305);
		EncodeUtil.mapaHtmlCode.put('Ĳ', 306);
		EncodeUtil.mapaHtmlCode.put('ĳ', 307);

		EncodeUtil.mapaHtmlCode.put('Ĵ', 308);
		EncodeUtil.mapaHtmlCode.put('ĵ', 309);

		EncodeUtil.mapaHtmlCode.put('Ḱ', 7728);
		EncodeUtil.mapaHtmlCode.put('ḱ', 7729);
		EncodeUtil.mapaHtmlCode.put('Ķ', 310);
		EncodeUtil.mapaHtmlCode.put('ķ', 311);
		EncodeUtil.mapaHtmlCode.put('Ǩ', 488);
		EncodeUtil.mapaHtmlCode.put('ǩ', 489);
		EncodeUtil.mapaHtmlCode.put('ĸ', 312);

		EncodeUtil.mapaHtmlCode.put('Ĺ', 313);
		EncodeUtil.mapaHtmlCode.put('ĺ', 314);
		EncodeUtil.mapaHtmlCode.put('Ļ', 315);
		EncodeUtil.mapaHtmlCode.put('ļ', 316);
		EncodeUtil.mapaHtmlCode.put('Ľ', 317);
		EncodeUtil.mapaHtmlCode.put('ľ', 318);
		EncodeUtil.mapaHtmlCode.put('Ŀ', 319);
		EncodeUtil.mapaHtmlCode.put('ŀ', 320);
		EncodeUtil.mapaHtmlCode.put('Ł', 321);
		EncodeUtil.mapaHtmlCode.put('ł', 322);
		EncodeUtil.mapaHtmlCode.put('Ǉ', 455);
		EncodeUtil.mapaHtmlCode.put('ǈ', 456);
		EncodeUtil.mapaHtmlCode.put('ǉ', 457);

		EncodeUtil.mapaHtmlCode.put('Ṁ', 7744);
		EncodeUtil.mapaHtmlCode.put('ṁ', 7745);

		EncodeUtil.mapaHtmlCode.put('Ń', 323);
		EncodeUtil.mapaHtmlCode.put('ń', 324);
		EncodeUtil.mapaHtmlCode.put('Ņ', 325);
		EncodeUtil.mapaHtmlCode.put('ņ', 326);
		EncodeUtil.mapaHtmlCode.put('Ň', 327);
		EncodeUtil.mapaHtmlCode.put('ň', 328);
		EncodeUtil.mapaHtmlCode.put('Ñ', 209);
		EncodeUtil.mapaHtmlCode.put('ñ', 241);
		EncodeUtil.mapaHtmlCode.put('ŉ', 329);
		EncodeUtil.mapaHtmlCode.put('Ŋ', 330);
		EncodeUtil.mapaHtmlCode.put('ŋ', 331);
		EncodeUtil.mapaHtmlCode.put('Ǌ', 458);
		EncodeUtil.mapaHtmlCode.put('ǋ', 459);
		EncodeUtil.mapaHtmlCode.put('ǌ', 460);

		EncodeUtil.mapaHtmlCode.put('Ò', 210);
		EncodeUtil.mapaHtmlCode.put('ò', 242);
		EncodeUtil.mapaHtmlCode.put('Ó', 211);
		EncodeUtil.mapaHtmlCode.put('ó', 243);
		EncodeUtil.mapaHtmlCode.put('Ô', 212);
		EncodeUtil.mapaHtmlCode.put('ô', 244);
		EncodeUtil.mapaHtmlCode.put('Õ', 213);
		EncodeUtil.mapaHtmlCode.put('õ', 245);
		EncodeUtil.mapaHtmlCode.put('Ö', 214);
		EncodeUtil.mapaHtmlCode.put('ö', 246);
		EncodeUtil.mapaHtmlCode.put('Ō', 332);
		EncodeUtil.mapaHtmlCode.put('ō', 333);
		EncodeUtil.mapaHtmlCode.put('Ŏ', 334);
		EncodeUtil.mapaHtmlCode.put('ŏ', 335);
		EncodeUtil.mapaHtmlCode.put('Ø', 216);
		EncodeUtil.mapaHtmlCode.put('ø', 248);
		EncodeUtil.mapaHtmlCode.put('Ő', 336);
		EncodeUtil.mapaHtmlCode.put('ő', 337);
		EncodeUtil.mapaHtmlCode.put('Ǿ', 510);
		EncodeUtil.mapaHtmlCode.put('ǿ', 511);
		EncodeUtil.mapaHtmlCode.put('Œ', 338);
		EncodeUtil.mapaHtmlCode.put('œ', 339);

		EncodeUtil.mapaHtmlCode.put('Ṗ', 7766);
		EncodeUtil.mapaHtmlCode.put('ṗ', 7767);

		EncodeUtil.mapaHtmlCode.put('Ŕ', 340);
		EncodeUtil.mapaHtmlCode.put('ŕ', 341);
		EncodeUtil.mapaHtmlCode.put('Ŗ', 342);
		EncodeUtil.mapaHtmlCode.put('ŗ', 343);
		EncodeUtil.mapaHtmlCode.put('Ř', 344);
		EncodeUtil.mapaHtmlCode.put('ř', 345);
		EncodeUtil.mapaHtmlCode.put('ɼ', 636);

		EncodeUtil.mapaHtmlCode.put('Ś', 346);
		EncodeUtil.mapaHtmlCode.put('ś', 347);
		EncodeUtil.mapaHtmlCode.put('Ş', 350);
		EncodeUtil.mapaHtmlCode.put('ş', 351);
		EncodeUtil.mapaHtmlCode.put('Š', 352);
		EncodeUtil.mapaHtmlCode.put('š', 353);
		EncodeUtil.mapaHtmlCode.put('Ŝ', 348);
		EncodeUtil.mapaHtmlCode.put('ŝ', 349);
		EncodeUtil.mapaHtmlCode.put('Ṡ', 7776);
		EncodeUtil.mapaHtmlCode.put('ṡ', 7777);
		EncodeUtil.mapaHtmlCode.put('ſ', 383);
		EncodeUtil.mapaHtmlCode.put('ß', 223);

		EncodeUtil.mapaHtmlCode.put('Ţ', 354);
		EncodeUtil.mapaHtmlCode.put('ţ', 355);
		EncodeUtil.mapaHtmlCode.put('Ť', 356);
		EncodeUtil.mapaHtmlCode.put('ť', 357);
		EncodeUtil.mapaHtmlCode.put('Ṫ', 7786);
		EncodeUtil.mapaHtmlCode.put('ṫ', 7787);
		EncodeUtil.mapaHtmlCode.put('Ŧ', 358);
		EncodeUtil.mapaHtmlCode.put('ŧ', 359);
		EncodeUtil.mapaHtmlCode.put('Þ', 222);
		EncodeUtil.mapaHtmlCode.put('þ', 254);

		EncodeUtil.mapaHtmlCode.put('Ù', 217);
		EncodeUtil.mapaHtmlCode.put('ù', 249);
		EncodeUtil.mapaHtmlCode.put('Ú', 218);
		EncodeUtil.mapaHtmlCode.put('ú', 250);
		EncodeUtil.mapaHtmlCode.put('Û', 219);
		EncodeUtil.mapaHtmlCode.put('û', 251);
		EncodeUtil.mapaHtmlCode.put('Ũ', 360);
		EncodeUtil.mapaHtmlCode.put('ũ', 361);
		EncodeUtil.mapaHtmlCode.put('Ü', 220);
		EncodeUtil.mapaHtmlCode.put('ü', 252);
		EncodeUtil.mapaHtmlCode.put('Ů', 366);
		EncodeUtil.mapaHtmlCode.put('ů', 367);
		EncodeUtil.mapaHtmlCode.put('Ū', 362);
		EncodeUtil.mapaHtmlCode.put('ū', 363);
		EncodeUtil.mapaHtmlCode.put('Ŭ', 364);
		EncodeUtil.mapaHtmlCode.put('ŭ', 365);
		EncodeUtil.mapaHtmlCode.put('Ų', 370);
		EncodeUtil.mapaHtmlCode.put('ų', 371);
		EncodeUtil.mapaHtmlCode.put('Ű', 368);
		EncodeUtil.mapaHtmlCode.put('ű', 369);

		EncodeUtil.mapaHtmlCode.put('Ẁ', 7808);
		EncodeUtil.mapaHtmlCode.put('ẁ', 7809);
		EncodeUtil.mapaHtmlCode.put('Ẃ', 7810);
		EncodeUtil.mapaHtmlCode.put('ẃ', 7811);
		EncodeUtil.mapaHtmlCode.put('Ŵ', 372);
		EncodeUtil.mapaHtmlCode.put('ŵ', 373);
		EncodeUtil.mapaHtmlCode.put('Ẅ', 7812);
		EncodeUtil.mapaHtmlCode.put('ẅ', 7813);

		EncodeUtil.mapaHtmlCode.put('Ỳ', 7922);
		EncodeUtil.mapaHtmlCode.put('ỳ', 7923);
		EncodeUtil.mapaHtmlCode.put('Ý', 221);
		EncodeUtil.mapaHtmlCode.put('ý', 253);
		EncodeUtil.mapaHtmlCode.put('Ŷ', 374);
		EncodeUtil.mapaHtmlCode.put('ŷ', 375);
		EncodeUtil.mapaHtmlCode.put('Ÿ', 159);
		EncodeUtil.mapaHtmlCode.put('ÿ', 255);

		EncodeUtil.mapaHtmlCode.put('Ź', 377);
		EncodeUtil.mapaHtmlCode.put('ź', 378);
		EncodeUtil.mapaHtmlCode.put('Ž', 381);
		EncodeUtil.mapaHtmlCode.put('ž', 382);
		EncodeUtil.mapaHtmlCode.put('Ż', 379);
		EncodeUtil.mapaHtmlCode.put('ż', 380);

	}

	/**
	 * Codifica uma Lista para o formato Unicode, percorrendo os atributos q são
	 * do tipo String.
	 */
	public static <E> List<E> convertToUnicode(List<E> lista) {

		for (E e : lista) {
			for (Field campo : e.getClass().getDeclaredFields()) {
				if (campo.getType() == String.class) {
					String s = (String) Reflections.getFieldValue(campo, e);
					Reflections.setFieldValue(campo, e,
							EncodeUtil.convertToUnicode(s));
				}
			}
		}
		return lista;
	}

	/**
	 * Codifica uma String para formato Unicode.
	 */
	public static String convertToUnicode(String str) {
		StringBuffer ostr = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			/* caracter precisa ser convertido para unicode? */
			if (ch >= 0x0020 && ch <= 0x007e) {
				/* não */
				ostr.append(ch);
			} else {
				/* sim */
				ostr.append("\\u"); /* formato de unicode padrão */
				/* pega o valor hexadecimal do caracter */
				String hex = Integer.toHexString(str.charAt(i) & 0xFFFF);
				for (int j = 0; j < 4 - hex.length(); j++) {
					/* concatena o zero porque o unicode requer 4 digitos */
					ostr.append("0");
				}
				ostr.append(hex.toLowerCase());
			}
		}
		return new String(ostr);
	}

	/**
	 * Percorre uma List transformando caracteres especiais dos atributos que
	 * são String para o formato HTML codificado.
	 * 
	 * @see EncodeUtil#escapeHTMLCode(String).
	 */
	public static <E> List<E> escapeHTMLCode(List<E> lista) {

		for (E e : lista) {
			for (Field campo : e.getClass().getDeclaredFields()) {
				if (campo.getType() == String.class) {
					String s = (String) Reflections.getFieldValue(campo, e);
					Reflections.setFieldValue(campo, e,
							EncodeUtil.escapeHTMLCode(s));
				}
			}
		}
		return lista;
	}

	/**
	 * Converte uma String num formato HTML codificado (ie., caracteres
	 * especiais são convertidos em &#<numero>;).
	 */
	public static String escapeHTMLCode(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			Integer i = EncodeUtil.mapaHtmlCode.get(new Character(c));
			if (i != null) {
				sb.append("&#");
				sb.append(i);
				sb.append(";");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
