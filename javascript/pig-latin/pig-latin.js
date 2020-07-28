export class translator {

  static translateUtil(word) {
	//Translates single word  
	var index = 1;
	
	if(word.search(/\b(xr|yt)/i) == 0) 
		return word + 'ay';
	else if(word.search(/\b[aeiou]/i) == 0)
		return word + 'ay';
	else if(word.search(/\b(nth|sch|scr|shr|spl|spr|squ|str|thr)/i) == 0)
		index = 3;
	else if(word.search(/\b(bl|br|ch|ck|cl|cr|dr|fl|fr|gh|gl|gr|ng|ph|pl|pr|qu|sc|sh|sk|sl|sm|sn|sp|st|sw|th|tr|tw|wh|wr|rh)/i) == 0)
		index = 2;
	
	if (word.search(/qu/) == index) //Search if 'qu' is there after consonant cluster if so increase index by 2
		index += 2;
	
	return word.substring(index) + word.substring(0, index) + 'ay';
  }
  
  static translate(phrase) {
	//Phrase is splitted into words and each words are translated. Translated words are combined and returned.
    return phrase.split(' ').map(translator.translateUtil).join(' ');
  }
  
}
