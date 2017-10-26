# Hönnunarskýrsla

## Inngangur
Tilgangur þessarar skýrslu er að skýra uppbyggingu leiksins TicTacToe sem verið er að hanna. Skýrslan inniheldur lýsingu á rekstrar- og þróunarumhverfi og forritunarreglur við gerð TicTacToe.

## Rekstrarumhverfi ##
Leikurinn er þróaður af nemendum í Háskólanum í Reykjavík og er seinni hluti af námskeiðinu Hugbúnaðarfræði. Leikurinn verður forritaður í java með Spark frameworkinu og mun notendaviðmót vera veflægt sem skrifað er í HTML, CSS og javaScript. JQuery verður notað til þess að senda AJAX-köll á bakenda.

## Þróunarumhverfi ##
Verkefnið er unnið í sjö fartölvum, sex sem keyra á Windows og eina sem keyrir á iOS stýrikerfi. Hér förum við yfir þróunarumhverfi sem notuð eru við gerð leiksins.
* Notast er verður við Git-Flow vinnuflæði í Git
* Verkefnið verður hýst á Heroku
* Travis verður notað við samfellda samþáttun
* Það verður að búa til Pull Request á GitHub áður en pushað er á master
* Trello er notað til að skipuleggja verkþætti og fylgjast með stöðu verkefnisins

## Kóðareglur

:#Nafngiftir
Notast verður við Test-Driven Development við forritun á bakenda. Hér verða listaðar upp Java og almennar reglur.
* Öll breytunöfn skulu vera á ensku.
* Nafngiftir á klösum, breytum og föllum skulu vera lýsandi frekar en mikið af athugasemdum, leitast skal við að gera nafngiftir sem skiljanlegastar. Forðast skal nögn eins og "number" eða "temp" og notast frekar við lýsandi nöfn líkt og "numberOfElements" eða "counterPlaceholder".
* Klasaheiti skulu vera í "Pascal Casing". Nafngift getur þá orðið sem dæmi MethodName eða GetValueOfCounter, með öðrum orðum fyrstu stafir í orðum eru hástafir og aðrir stafir skulu vera lágstafir.
* Falla og breytu heiti skulu vera í "camel Casing". Nafngift getur þá orðið sem dæmi numberOfElements, með öðrum orðum, fyrstu stafir í orðum eru hástafir og aðrir lágstafir nema í fyrsta orðinu, þá mun fyrsti stafur vera lágstafur.
* Föll sem skila gildi eiga að hafa nafn sem lýsir vel því sem er skilað.
* Docblocks skal vera fyrir framan öll föll og klasa fyrir Javadoc.
* Fastar skulu vera skilgreindir í hástöfum.
* Private klasabreytur skulu vera skrifaðar í lágstöfum.
* Public klasabreytur skulu byrja á stórum staf.
* Slaufusvigar skulu ekki opnast í sér línu.

inndráttur og bil
* Bil skal setja á milli allra breytunafna, virkja (e. Operators) og gilda.
* Inndráttur skal vera fjögur bil
* Eitt línubil skal aðskilja breytu skilgreiningar og falla skilgreiningu eða falla-köll.
* Eitt línubil skal aðskilja föll sem koma hvort á eftir öðru.
* Alla jafna skal ekki setja meira en eitt línubil á milli atriða í kóðanum.

Klasar
* Klasabreytur skulu vera skilgreindar efst í klasanum og eitt línubil skal aðskilja breytulistann og falla skilgreiningar.

Athugasemdir
* Athugasemdir við kóða skulu vera með sama inndrátt og kóðinn sem athugasemd á við.
* Alla jafna skulu athugasemdir koma fyrir ofan það sem að athugasemd á við um.
* Leitast skal eftir því að hafa lýsandi nöfn á klasa, breytu og falla heitum í stað athugasemda. Ef athugasemd er þörf og er mjög stutt og á bara við eina línu má setja hana í sömu línu og kóðinn.
* Fyrir ofan alla klasa skal vera sett stutt lýsing um tilgang og virkni klasans.

Staðsetning slaufusviga
* Slaufusvigar skulu alla jafna ekki opnast í sér línu og loka skal slaufusvigum á línubilinu eftir síðustu línu í kóða.

HTML
* Öll tög og eigindi skulu vera rituð í lágstöfum.
* Öllum töfum skal vera lokað á viðeigandi hátt.
* Öll eigindi skulu vera umlukin tvöföldum gæsalöppum.
* Öllum útlits stillingum skal komið fyrir í CSS skrám en ekki í HTML tögum. 
* Notast skal við HTML5.

CSS
* Allur CSS kóði verður skrifaður í sér skrá.
* Litir skulu vera skilgreindir í RGB formi.

JavaScript
* Allur JavaScript kóði verður skrifaður í sér skrá.
