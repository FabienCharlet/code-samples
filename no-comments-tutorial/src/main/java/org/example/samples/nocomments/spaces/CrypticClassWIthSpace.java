package org.example.samples.nocomments.spaces;

import java.util.ArrayList;
import java.util.HashMap;

public class CrypticClassWIthSpace {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList process(String s) {
		
		ArrayList l = new ArrayList();
		l.add(s.substring(0, s.indexOf(':')));
		ArrayList<String> l2 = new ArrayList<String>();
		
		boolean b = false, p = false;
		int i = s.indexOf(':') + 3;
		
		while (!b) {
			int i1 = s.indexOf('.', i), i2 = s.indexOf(':', i), i3 = s.indexOf(
					'/', i), i4 = i1;
			if (i2 < i4 || i4 == -1)
				i4 = i2;
			if (i3 < i4)
				i4 = i3;
			if (i1 == i4) {
				l2.add(s.substring(i, i4));
				i = i4 + 1;
			}
			if (i2 == i4) {
				b = true;
				l.add(l2);
				l.add(s.substring(i, i4));
				p = true;
				i = i4 + 1;
			}
			if (i3 == i4) {
				b = true;
				l.add(l2);
				l.add(s.substring(i, i4));
				i = i4 + 1;
			}
		}
		if (p) {
			int i2 = s.indexOf('/', i);
			l.add(s.substring(i, i2));
			i = i2 + 1;
		}
		b = false;
		HashMap<String, String> hm = new HashMap<String, String>();
		while (!b) {
			int i1 = s.indexOf('/', i), i2 = s.indexOf('?', i), i3 = s.indexOf(
					'&', i), i4 = i1;
			if (i2 < i4 || i4 == -1)
				i4 = i2;
			if (i3 < i4 || i4 == -1)
				i4 = i3;
			if (i4 == -1) {
				hm.put(s.substring(i, s.length()).split("=")[0],
						s.substring(i, s.length()).split("=")[1]);
				l.add(hm);
				break;
			}
			if (i1 == i4) {
				l.add(s.substring(i, i4));
				i = i4 + 1;
			}
			if (i2 == i4) {
				l.add(s.substring(i, i4));
				i = i4 + 1;
			}
			if (i3 == i4) {
				hm.put(s.substring(i, i4).split("=")[0], s.substring(i, i4)
						.split("=")[1]);
				i = i4 + 1;
			}
		}
		return l;
	}
}
