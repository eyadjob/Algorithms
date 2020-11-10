//public int read(char[] buf, int n) {
//        int count = 0;
//        int innerTotal = 0;
//        if (!eof) {
//        count = read4(prevChar);
//        charsTotal+= count;
//        eof = count < 4;
//        } else {   count = prevChar.length;  }
//
//        if ( count == 0 ) { count =4; }
//        System.out.println(count);
//        count = Math.min(count, n);
//        int i = 0;
//        while (i < count &&  i < prevChar.length && readingIndex < prevChar.length ) {
//        if ( prevChar[i + readingIndex] == '\u0000' ) break;
//        buf[i] = prevChar[i + readingIndex];
//        i++;
//        innerTotal = i;
//        }
//        readingIndex += innerTotal;
//        return innerTotal;
//        }