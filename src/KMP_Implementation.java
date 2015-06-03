public class KMP_Implementation {
	public int[] preProcessPattern(char[] ptrn) {
		int i = 0, j = -1;
		int ptrnLen = ptrn.length;
		int[] b = new int[ptrnLen + 1];

		b[i] = j;
		while (i < ptrnLen) {
			while (j >= 0 && ptrn[i] != ptrn[j]) {
				// if there is mismatch consider next widest border
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
		// print pattern, partial match table and index
//		System.out
//				.println("printing pattern, partial match table, and its index");
//		System.out.print(" ");
//		for (char c : ptrn) {
//			System.out.print(c + "   ");
//		}
//		System.out.println(" ");
//		for (int tmp : b) {
//			System.out.print(tmp + "   ");
//		}
//		System.out.print("\n ");
//		for (int l = 0; l < ptrn.length; l++) {
//			System.out.print(l + "   ");
//		}
//		System.out.println();
		return b;
	}

	public void searchSubString(char[] text, char[] ptrn) {
		int i = 0, j = 0;
		// pattern and text lengths
		int ptrnLen = ptrn.length;
		int txtLen = text.length;

		// initialize new array and preprocess the pattern
		int[] b = preProcessPattern(ptrn);

		while (i < txtLen) {
			while (j >= 0 && text[i] != ptrn[j]) {
				/*
				 * System.out.println("Mismatch happened, between text char " +
				 * text[i] + " and pattern char " + ptrn[j] +
				 * ", \nhence jumping the value of " + "j from " + j + " to " +
				 * b[j] + " at text index i at " + i +
				 * " based on partial match table");
				 */
				j = b[j];
			}
			i++;
			j++;

			// a match is found
			if (j == ptrnLen) {
				// System.out.println("FOUND SUBSTRING AT i " + i +
				// " and index:"
				// + (i - ptrnLen));
//				System.out
//						.println("Found substring at index: " + (i - ptrnLen));
				// System.out.println("Setting j from " + j + " to " + b[j]);
				j = b[j];
			}
		}
	}

	public static void main(String[] args) {
		KMP_Implementation stm = new KMP_Implementation();
		// pattern
		char[] ptrn = "abd".toCharArray();
		char[] text = "ahxztmbzgsiobkukpmrboaudftqpikfamgrfwrhvtfjwqerexcbkoyndylyebfbsuepywyncolvorrzkmvupqbcddkkwjiplehpdiyvopzmeoweotamtjlzrpbnaasjrdllaywylsddhdjmpxtuhkpfltfjhgapduacmquktchhhjaxfknvcegwnicpilpwxkhkoimdihhgvsxgihohnshetzwpeytuymvfdioxpkxbebrnqywqlkpdhnewufmzumkalrqgfifbxvhlutnzpzzuhyjyteuwntkukrqtwqufhwrekstmnppidthfxvlbqeveluoltzzrlqcwvaihgibuknrvnsokzgrhbkfivzbrwceywjhcoqnmmpwrrsdoxyctxfzouzsitqbkpbntstrwoumounzldnbmymgvzcaxxecgdjdqsslwyqkfgpcfvzqjlnbbevhzhypcvebidtlhxkuwcumfrtipzoynwnyxiobwlixycksijjawlogltasjqnhjvsuhhuyrvwqiwocaesqbqkifdrccqeizipuwbpambdqdumbnkwegcsfbdfzyyqbelhxhataflywbhsnbyhsmkuwkjmauspmyovrgrabgscdtifryfcxdvcvleldptdsknkquawdhfslyabiofsdhgmaddhenhsfsaoukmzqesdlsgauiainqqkbgglwahyzabqmybsremfluvsgztruailftakmvdfurmjjxajsmwhsteaiituebzncjmzywuudiayqwiuvnkougmsgpododvojqgkszvbjmfexrwzfhlaqeocvonbhsgyrinezerlcogymrfytyvffrikahrtberhbnneirbfzrlyhxitbkcalvrivnmhgfyuwjcinowoigspivijfwytrhfjcbzbrgeljlkxdldqxpqkbqiganqptujdaiuqpuumusxvxgzpburijndsficdhzdttaoamlqnzyddfgfhqmskcgqdcpfdmlgqfdfegcnipsqzjvjwxeyyjmshraxmpmhhhfcpanbbdrwdshjqtubtrertencntpfvgepaxftxfcbenrsvqptomxmzaerdapdkslodmfycjnbiwguouwomlopnqawtositdbpjfmnyrgouaagjdmaskxhrisiyishorqeiyqrkezwceancqptbnacfqsnjdajdlsrqeidhxzzoqftjpbxxwuptwijismrxgnqvmfqpuojxgutqhymtdsqcbowedqoxepdohvmhfqptlflodtakuvxeielqyiljohubnlejzentklgjiwobcwfhjlwegqyospqucoqfecelvbptvvbzqlvgclovyuiggtbknzfiycjgxvncxfzcdkqqmicpiujaxsyeyahctnwbzmfueyzjdgzjeresucsgfklywxtshxsczlaewmunulvqiwtfjmrrnynventvsgkwzezisfgiutvdircluibqziwsekyvazomuebmdwirwedpyndynmblhsdlzuskyesnrcnqpggcrtfwtfukrnikqqrwjfghvbeyykdgkseusnenckxxrntifaeltwtmykoasruxcawjwxazjuaudcveqxaevguposmktkmhyewsjxsywuoobztmnkxtygscccqsleqdzgwotkuweoopglyxvbjpvksluddnkxagxtqnkphzgbmntibsmkavqlruyrqcqofzkquenwbhcxpgihvbedctaqagbrjdpwiznckadgrrqumbsjffmgnltnuvwmdhcfmksvmqnwqhuljdwlmcdcpclbpjxgihiuxjvnitlqjbhcrcmunvzztkpfuwwjvykihczehddbedohiywcatqakyyxlwodmbcxzrperltcfojsqcnlstphwbnalmzmwjmksdjkxzhjewgoskcqbriuqvevaendbbxofeltlhdnldkruvlcuulbkjdnhqxzzdsbfpalcxynvxthrifynmcoygkmhymcyqhmkkhoqtsixklrhfizbhhfvvhkrosparuqqzwsgusukvqjivjvvfgstdsnnjzbxhotqmzvfyzgnfukyjrtgaxkfxeyhjojvhqqwwduzyxzjixozwafxfgktclfoddnyxmuzdcpydvfafjocnswnotgzwiofctvyypkhssauqzpnvynxzsnzleqbisijbidrbeqxdagvtnzzamijhfcsohxtlnejnosalvnzoxlbnzsnzfzmhnrvhbctuvdxkgktpsweattmmzvzmfgemdsoxsnhffsblxthfcxvhqdbgtbemnkqllxneklmfetqebwkagtfjaddjgdgszhwyckpgshmywkhjklnaqywyqngkjvybzpdqhjahhwussspzzmcnttigrwlptuxnklmrgcqxvomvbmscksorffetrkhcqeyhhvrzpzgasdrwdrfvtxcyfjdlixukoiwtaxvdnyojejtdbczdfhcrayrbzqpurdzptzpuvjhsidbfnrddfviuwigpfpasitxvgtpuwwwhrbmuptxkxhquuyhvkotqwjvnugphapwmxrwuhhrqtjsqedrmmkchaifgchpfzfaleywybfyiapuacfpbpntvddzoqsztihhdvsrulgrgmaalrulckduirugduvscgruqybnrmvrizfwsoxkqqgplegkxforujckadmcfugvuodeqngibdzsgskqmchqlnkyvqxytgagawyfgblrmvknmgevhfdapcanfhwvsxydrnjnzviyfprczrdiygjilcleemuiwdoyfvlvipfrvllpqgcpbxomanyovvtmepnjqxcfbwqidpqayhzaubszesjauxdrhsedadmafidurhytjulcvdnrhltgnrmqasxexupsnkdclfwecjlkmxviwzbnhybiwhdxwvbjrlnpuhyaeiyvabjxjnnlrfkrestatexcgyqoblolczuglucydziobnpiqabwibqzwulkwthorhbxvodilizfgepbvfoxbkehgssocblcoyrompcxrhrccfsimyfisomgivpehbexwztiikdboyynjcerabxyebbwwomjsbyvtvdieoqyzvmzwlorwueghfqfjbwxlkuaqitpkdbixvwvvxaqwhazmobqnapfrqwpujixufxkvloqbgixbmdeiuktjmvpbrmlfulvitnistghbnnkotogcdbzjtbkzwfcibndcoprfponiehzopzsxwzqreounulwnaocbinhyavvfjerirwjfjaejcqcmbnckrdunxfcczgxwptozaqspuwmwteiynnjaavukuzzavqtmfszpmyklxgeustxdivhewcrsxwumaderbjqfdfvezczijsgxptvkqdkxkqurmsoxhxtqceisjozluugqfpkzblqiaznlykhoeiipdbjurbfmcvwikgoebpwjvugkvfremwqjjnpwwdrtmzbrsniswhjbypthjgjsgrhiljwjwsxhxlqmuyguihofasixwedqeqchnxlwfxnrbonphkutiywomqtgqcloyvgzqnnkcwnaaraexazphqlrbdisjywvvadtgyflqzvbirmgcxbvafqigrzrhepucarqgmychirvfcrowlzrwvvmlbaedajdzrimwlzrfybfdjrwkyxlnbrdspxsepnhgtquhplsxilhjffvnivzrsorotaxlbyogcjnuabnnhgqzyjjvibzcjhxxasziodixzrwrksxdbfxyzaccopzzmiuzaacdbtzytacxttsmleanflbbkpgvkhqypqzmphidaktyrjttasgmixgnlajnoxawqzjexlhqeruuqxlaojznjlazzsmpvsulnnyshfyqdxdqkolvxylppsyigwrjhcbwiyqlkwjxndiptyqydlwnkrpfbsjvqibnphkjdmmedvxcveyyyhegrdummmcxixtslikmwgsstgczzzgmlskqrrpkptfxnsongwzauzxpnygiscoifqydkkftfzhcesknmtibwfubeqlbyzcikfzwrjgpalsmqjtnarbvnrkweiwospcxtvyintyioyrmziwjuozplhazzqstkcrypqobifvbcoalqlfeeohpsylvmafrhnvlpmajdtkjkhxpjtiuvdqubbbcxiuustgwttsodkhqqpfpfcxtlxxbsntsesdzyrytlbpgwawiuqndvfgqkvtulpxnsqcpvmrrbcafvsfusadbgazbnpnoiqnebaycwzstawmevcatehurbacreyjjcfqalciycvexiyoihnyvmbtpsbsxzssvykjhmskqbezjrwcviwukhmhtfyflzhrirsshxqxxyrmywxntqmexidhubeppmmuihpwnjkejyeabrezsnsnocnebzawjijklzidkriklcirgqfucilmpyiwhevosardlchosjfqecxklqhixikzhdxomrgqkantkonbbqdpymkyijjnsecnbagdmoeabqvbcuctvhbjyzpxefbybralnwocgooclwryajjfbcizuktbittjhvfrvarucifmgmvaukwtitwsaeksuflntecfsmqrvirjklbztjcxcdujqupewdfvhzsjsepkoymjwqfhsmqknchbuczgonzzgcgnqvqgrdxtobfrlxvfegvoytxerevmxvuyqnxodxiisqzswugcipgjfiwomxdheqpaivyhcewlpdnwiamaptewbjdajbllnouzvdtfgcidliitcuyihtnfzrrzxggdpuwtjnwryvcumejykuhcqldyovbpibjqjdhozxhbvhfjelalprcjndmtcjepubcnvtqdghwlcsjknzkotrbvlebtyoaecmqsbntoigbnzwrprxrojjrnokjmtranycxmictvptznejsakhhnmiaeeeahdckhtblebapgfmmafpvwzgrcidfxucnjsgrerjvraeylrtzyssrjlcdhotuiaauyzqxdqvjqmtjriuqcjxhkbxsryawsmluhbjxsvnupovwqcxettoawosyhcntbfrhdgdgjlqyfinnezfjrczgctxlhjaudaqsvvwbyoujfemdlvsqzxjrrgcrmygpunopaowieidfrlbipdhoydvgdsbkhoszagfkrtubjcieyoegvmajhsbnjhcyvlmxuqkflootxoniiphmjqfhbjiujrajzbnaolawmfalgzogwzesoclgpqjevtguchofiazlfyrkeztacvsbrgeiutzhijnlxqmzmwjuraenkebvbvtdfkcpgclekeursbdhqfwbuyaiwnopmrpqvzdjwprcyosegcwjfngcntszzdemngxtlhzxxkpgbzmsyfkyhucryfkzoqmfztyckxhaaiunjztachtaezskposvicoatevnuvekgodagcnsrpicykmgtxdqkscwoushdbuwdbxwzbuzbbyuzrpzloagiupkhkcbewbnofrskxzebtfnhetgxioercrimakovzjjeqpdprwrfuebxhhlnesxfdseucyhfsmhudsiorpgdlgrtazxhksoikfwithujjpzhctqhsvjcojptozwcdzntnwqxoialnhtrukgchcgqiuklbnmptwqdqbkmbafrilhhosvfrelfeotvhjnajrueemykxfayzdzganlxxcuaiqpmveetlrzhxuaiaehqglrvvexygwfoiopwftmdmzjmtxwwmcfdjbnpnojsbserdqezrezkbzetsdglbxevlwbsypyutroluezjwoxeciutybcmjnxsxrfrthmufhwlxvlafyxlshwylnjhgtkgvttvvcyctakvprfidxiapoukfqvtafugdwltzyfqaxldfqvgfzmxlyalkqdchrkuiebgftkgiqdgppeyfwidjkfxizjcvdvqwfpnpkqglrkarxwktqlrawfkdxkmvlwaddoetlyyoybisbqrrazabhzaruilzjcqytmevihgugsitkielrxcuwfwhftfghufeewmzsmtnbsfusbzektevbgmvqnjldxlvtofmwquxxdqgdjjenygqvkozocqqnkmlixaamgorjlhzqkgbdqknfizshyvroqqxdvpabxdzxktwlziopaysidhebdllzudtaatlcryllmhkaiccdgcomepvhzftcuzhygjbizziqvknddmnnwpxbaadnortcvjgchqrlhaziltfjjldfgtclgwyxaioxxzzztdxaipifybznxijhulwzvhkxrddqtnefudtwwkfcvdkgzufwigrloqiubbamfjvymejxwptbalsqbojjydztyviefxxistpihhnslhcmwwkeymmsenxqiigrrwxulukortpwmoagprgnghnksucxfnvgsadjlyrsmqsdtagpooptxfukjjxthstvowxilfqcpjfsqqxjbooluwzrllsjrnmqovmjkfzbvyjaovtsjbjylulvpxvppibmototpwnzeqyxehomjsjuttwufwlkwujnwcwdftdudtmaqvfnjraewwhqsghvixohypznfaddgbemkholzaqxhlkyosrqejgfditkafxofbgetjwjdslrkwlqwhhnllyrughtnwirknpgmifgpnnnagbchqljkcrppgzcofyhcuebaynxlzecoqhflmzgisnnygvswjyynmboflxafjhnzkplqvryuweykzwobsogmijnkvyhvydkizzwssmbjeriwlzxyyatlrktjyyyjuevglinhyhvinqjicxdrffiolkfxgdtobwegeeergqeixdevocfflmzvlijonuntgzapcrrczlsynpjozkcuwluxklkrapqsjrbsiqdaxrfvcnfpyssmpaaglodvlrecewnbmccfnvneyhiddlsiyyvzfhonaaqtppdvangcgkaqhjmcrupctbxsoowwjascdcsekdpejiejybprzzloobfnbvqxnqpdyyzvcvuzphrskcteaudyjjvdkiwlentrxelohsjkjylllhdwtvwepizgptnhyxaipqywjzstmeyssgxhyfyzckapcbesvctubrevftuaezvsllilcwehwpsclqlbffgznqkvchdocyijztequgjspefcvzjrdupbuhhhrzxjvlfhytbytxldrrvjchbqwzccaimdpzpipolhlrybamltkqxfdgynatdspcgpobhffvxwlrbxbvyxfkbifvheixvdzoxatpluxqshwpoepnhhgwdmqcymkzvhawmtwxyxnpylaqljrauozsqrftjvjnerlwgchfichlmzgtzggfcdagstaabmjvetmhppxenhvzxecusurpqtnxcgcrjpzevouqgxpewqweziaxqxgeysxfcydiuqqrzqsiuyrhpuswjiipmiypzgcpskvudgvocsdzlwwikhsrukevqfmabagqaprmenzskwhdaqkgwcnsebcbebhrlrnfgnvfzrixrhvfiwitlpszujkvfxilcudhlnrlfwfrsebytnolprihrxdrlpbxdarltvestyclxznrcjnsuohnrxdwoifshunwfornakddaunkcncnybuflogbzbmuwzfnjgymbuuiededlzjzkbwkmmreqqmbxrrjjctagodabysawmowxesstiftlzfpvapyiaqastbrjzgmyduahlrwwruimqzeyzmdwcyugakwtecavnqgirbyeitaibzwmkcbvwmpccoodruvelsdssdxymqwprpugerzzyglfhhllqtewirrbwkqggkkxnikojlxpyqyiuxfoyvxovowmvhvzjnlnvjricovngjtrevdckfeplxgyzhdoimtjumgkvgrhwvpdspdxgrjhtxuuzxcveosguivjbjbaaxhjureqrpbmrwryszwjjtlaefvsdmgofcnladsdrhxlytlaggwhovovynaoebqbjyzepjpyjiivsvyuapfnfzcfrludhwiefghvgdyvvygdgpotjgaodmzehahixumjlnteuattaofqmzsappbboythwetodhkauqvmqmpgodbwtyhwdbaptmzuqjucompmccioqbtcroufckbjtqnqqfokzphivlbfmcoferlutlqkmdlhblgelfgpzlpqympvtdezzsbmetqinfhypdnbphphocccbtxonvtkgjbsqcochovnqrpwjxcdsagszxpxlxzymkszbyjhjxsakpgdwmjxbddhqyfdqilkhtzvvvgdqeyryabmvgtbvlluqpbdgiloweqyyrdvxhklgsrynjovovqpdqhrlorwpvptzbjgzabwqvemrmeweqvzqddqmqtpstwsyryicpoyvruhvtkgpczwldpraejswqslgubuydixjfqgpcjvazmroefydotszegqnlnngsegvlxxqdfufbgbkmpvvmiinnsoglrpxgjdnbquhwoflhdboztqgjxynfggtlkdcjqatkpatfpcjmnybfsxfhbokbtnhruodjownhyyerasvuqeamedqtsndgaxfcrejgldemgdnaojinblaidzisazzalsbhreoxsiytqyxbrbruseeserrhwqkgwkcqtpcqcdmkoftbdzcxymvkrbefcualsopgrxqxowpmkxprldlbguweejrsdeenrhmnypkshftqstypzxabszxlxpqxqnufjqdabiqnwmegibeuofbfdxpeecvbvqewrptrkczdcecwcqsmhqlcupsxrikftfjuecpmfwkwmkiwnnvfxgzkbwfvavhmmlzradvmxhiydoxbkqprlfzbkuwgmwkvetritgkfpgcxxuqgbdqzkmpzgecbcsdmiftymmlmfxyrpqyfiwlbcrzkkdauvqcghmrntrsjqfwuxgpwmycetvohqpfakizuabeskjmbutrrtpvcqthixicwcbhesxialccnqthhkhzkmjunbctvqqjmpgokzmxwewljsbofbioxbhxafpgwszusyotiqrpnbwsiiyjsnjlvitokwhjjzhrnjcvpziavwimfqutltcerpvsfhvmrwrjqlhjaczxdrvbzfnihlakbzoncrxicbdoxztqngwbcpobqyaqjdikyoqasokvgokctjzylzusisqpsuknxscfgojzkhvyzccrdrifagzxcfvbamkncnnbnybmpquosizzeoamfomlydghgrhsurckcvwlytkinqaixdunolzwamownpgmbaabpflukoyvlozwwzdxuhmmwhbqyyyzpwfbhobfpzrmjwcjyefescgdgkowikmjeicvfwlqcwmkwhneoixtknvrtxjymtfgrdiugotzyspsuothpyuaqefyvorpepdvighcrnlqwqutizwloencdnssbjbhzwiysbwfwrhrpteuemgyrtpedostwiybrbsmieaygplgrzauiewyfiyjarobtohmukqdtcxertflfophijigdvwhignlzkwvsxvqsudyzljaqpuukhsqmdicruvrijufzzqhzeimswugcenztqhzjtjjjpuwbfbvqjrgtudbgouxqyfnxchemnivkpmodocqlludphcymmdasemwarslotiyrpjgbvaryjrnrwkucickvytxmhbidelegzoegohxbbbbwhltmsdzhpfxziujrjjqblvykcbcyqqrqhuslpuqezmfwsfomortntmkseulelqhmzqpercixhkqdjafuklmpbavjuecfiagclfldjvxuarngdyymrvprhfdkfoyjjyrinwthabvgsxpltdywhpxckufurdjsjcyzmwkecxsdtxlutzeryqyqirdpykyoxjvbfitoljkqwaytplcwgrahtakyrdzgfjuliogllrpcytvucnjexziugoagxrlsjywngasydevvzktoxyspjcshtveyvpaulzj".toCharArray();
		System.out.println("KMP Algorithm");

		for (char c : text) {
			System.out.print(c + "   ");
		}
		System.out.println();
		// search for pattern in the string
		final long startTime = System.nanoTime();
		stm.searchSubString(text, ptrn);
		final long endTime = System.nanoTime();
		
		System.out.println("Total execution time: " + (endTime - startTime) + " ns");
	}
}
