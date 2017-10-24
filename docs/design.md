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
Notast verður við Test-Driven Development við forritun á bakenda. Hér verða listaðar upp Java og almennar reglur.
* Klasaheiti verða í PascalCasing.
* Lýsandi heiti á föllum og breytum frekar en mikið af athugasemdum.
* Fallaheiti verða í camelCasing.
* Docblocks fyrir framan öll föll og klasa fyrir Javadoc.
* Fastar verði skilgreindir í hástöfum.
* Private klasabreytur eru skrifaðar í lágstöfum.
* Public klasabreytur byrja á stórum staf.
* Slaufusvigar skulu ekki opnast í sér línu.

HTML reglur
* Notast skal við HTML5.
* Tög skulu alltaf vera umkringd hornsviga (stærra en/minna en)

CSS reglur
* Allur CSS kóði verður skrifaður í sér skrá
* Litir skulu vera skilgreindir í...
* Klasar og ID skulu hafa nöfn sem eru lýsandi

JavaScript reglur
* Allur JavaScript kóði verður skrifaður í sér skrá